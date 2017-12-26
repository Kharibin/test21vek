package com.kharybin.test21.service;

import com.kharybin.test21.DAO.OrderRepository;
import com.kharybin.test21.model.Order;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class ServiceImplTest {

    ByteArrayOutputStream sysoutChecker = new ByteArrayOutputStream();
    List<Order> mockOrderList;

    @Mock
    Order order;
    @Mock
    Order order2;
    @Mock
    Order order3;


    @Mock
    OrderRepository repository;

    @InjectMocks
    ServiceImpl<Order> serviceImpTest;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        System.setOut(new PrintStream(sysoutChecker));

        mockOrderList = new ArrayList<>();
        mockOrderList.add(order);
        mockOrderList.add(order2);
        mockOrderList.add(order3);

        when(order.getId()).thenReturn(1l);
        when(order2.getId()).thenReturn(2l);
        when(order3.getId()).thenReturn(3l);

        when(repository.getOne(1l)).thenReturn(order);
        when(repository.getOne(2l)).thenReturn(order2);
        when(repository.getOne(3l)).thenReturn(order3);

        when(repository.findAll()).thenReturn(mockOrderList);
        when(repository.existsById(1l)).thenReturn(mockOrderList.contains(order));
        when(repository.existsById(2l)).thenReturn(mockOrderList.contains(order2));
        when(repository.existsById(3l)).thenReturn(mockOrderList.contains(order3));
        when(repository.existsById(4l)).thenReturn(false);

        when(repository.getOne(1l)).thenReturn(order);
        when(repository.getOne(2l)).thenReturn(order2);
        when(repository.getOne(3l)).thenReturn(order3);

        doAnswer(new Answer() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                for (Order x: mockOrderList) {
                    if (x.getId() == invocation.getArgument(0)){
                        mockOrderList.remove(x);
                        return null;
                    }
                }
                return null;
            }
        }).when(repository).deleteById(anyLong());

        doAnswer(new Answer() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                if (!mockOrderList.contains(invocation.getArgument(0)))
                mockOrderList.add(invocation.getArgument(0));
                return null;
            }
        }).when(repository).save(any(Order.class));

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add(){
        mockOrderList.clear();
        serviceImpTest.add(order);
        assert(mockOrderList.contains(order));
    }

    @Test
    public void edit() {
        serviceImpTest.edit(2l, order3);
    }

    @Test
    public void editFails(){
        serviceImpTest.edit(35l, order3);
        assertEquals("no such object in repository!\r\n", sysoutChecker.toString());
        sysoutChecker.reset();
        serviceImpTest.edit(2l, null);
        assertEquals("no data to save!\r\n", sysoutChecker.toString());
    }

    @Test
    public void delete() {
        serviceImpTest.delete(1l);
        assertEquals(2, mockOrderList.size());
    }

    @Test
    public void deleteFails() {
        serviceImpTest.delete(4l);
        assertEquals("FAILED TO DELETE!!! NO SUCH OBJ!  (id = 4)\r\n", sysoutChecker.toString());
    }
    @Test
    public void getAll() {
        assertEquals(3, serviceImpTest.getAll().size());
        assertTrue(serviceImpTest.getAll().containsAll(mockOrderList));
    }

    @Test
    public void getById() {
        assertEquals(1, serviceImpTest.getById(1l).size());
        assertEquals(order, serviceImpTest.getById(1l).get(0));
    }

    @Test
    public void getByIdFail(){
        assertEquals(0, serviceImpTest.getById(4l).size());
        assertEquals("FAILED TO GET!!! NO SUCH OBJ!  (id = 4)\r\n", sysoutChecker.toString());
    }
}