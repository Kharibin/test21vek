package com.kharybin.test21.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl<T> implements Service<T> {

    private JpaRepository<T, Long> repository;

    public JpaRepository<T, Long> getRepository() {
        return repository;
    }

    public void setRepository(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    @Override
    public void add(T dataObj) {
        repository.save(dataObj);
    }

    @Override
    public void edit(Long id, T newObj) {
        if (repository.existsById(id)) {
            T old = repository.getOne(id);
            if (old.getClass().equals(newObj.getClass())) {
                for (Field x : old.getClass().getDeclaredFields()) {
                    if (!x.getName().equals("id")) {
                        x.setAccessible(true);
                        try {
                            newObj.getClass().getDeclaredField(x.getName()).setAccessible(true);
                            x.set(old, newObj.getClass().getDeclaredField(x.getName()).get(newObj));
                        } catch (Exception e) {
                            System.out.println("FAILED FIELD COPYING!");
                        }
                    }
                }
                repository.save(old);
            } else System.out.println("different class!!");
        } else System.out.println("no such object in repository!");
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) repository.deleteById(id);
        else System.out.println("FAILED TO DELETE!!! NO SUCH OBJ!  (id = " + id);
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public List<T> getById(Long id) {
        List<T> newList = new ArrayList<T>();
        if (repository.existsById(id)) {
            newList.add(repository.getOne(id));
        }
        else System.out.println("FAILED TO GET!!! NO SUCH OBJ!  (id = " + id);
        return newList;
    }
}
