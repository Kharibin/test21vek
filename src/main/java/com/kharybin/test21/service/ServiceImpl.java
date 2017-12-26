package com.kharybin.test21.service;

import com.kharybin.test21.DAO.GeneralRepository;
import com.kharybin.test21.DAO.OrderRepository;
import com.kharybin.test21.model.Order;
import org.aspectj.weaver.ast.Or;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.proxy.HibernateProxyHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;



@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ServiceImpl<T> implements Service<T>{

    private JpaRepository<T, Long> repository;

    public JpaRepository<T, Long> getRepository() {
        return repository;
    }

    public void setRepository(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    @Autowired
    public ServiceImpl(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }


    public void add(T dataObj) {
        repository.save(dataObj);
    }


    public void edit(Long id, T newObj) {
        if (repository.existsById(id)) {
            if (newObj != null)
            repository.save(newObj);
            else System.out.println("no data to save!");
            /*HibernateProxyHelper.getClassWithoutInitializingProxy(repository.getOne(id));
            //if (old.getClass().equals(newObj.getClass())) {
                for (Field x : old.getClass().getDeclaredFields()) {
                    if (!x.getName().equals("id")) {
                        x.setAccessible(true);
                        System.out.println(x.getName());
                        try {
                            newObj.getClass().getDeclaredField(x.getName()).setAccessible(true);
                            x.set(old, newObj.getClass().getDeclaredField(x.getName()).get(newObj));
                        } catch (Exception e) {
                            System.out.println("FAILED FIELD COPYING!");
                        }
                    }
                }
                repository.save(old);
            //} else System.out.println("different class!!");
            System.out.println(old.getClass().toString());
            System.out.println(newObj.getClass().toString());*/
        } else System.out.println("no such object in repository!");
    }


    public void delete(Long id) {
        if (repository.existsById(id)) repository.deleteById(id);
        else System.out.println("FAILED TO DELETE!!! NO SUCH OBJ!  (id = " + id + ")");
    }


    public List<T> getAll() {
        return repository.findAll();
    }


    public List<T> getById(Long id) {
        List<T> newList = new ArrayList<T>();
        if (repository.existsById(id)) {
            newList.add((T)repository.getOne(id));
        } else System.out.println("FAILED TO GET!!! NO SUCH OBJ!  (id = " + id + ")");
        return newList;
    }
}
