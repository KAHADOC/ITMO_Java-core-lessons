package com.company.project.lesson2223.dao;

import java.util.List;
import java.util.function.Predicate;

public class CatDao implements Dao<Cat, Integer>{

    @Override
    public void add(Cat cat) {}

    @Override
    public boolean delete(Cat cat) {
        return false;
    }

    @Override
    public Cat getByUniqueId(Integer integer) {
        return null;
    }

    @Override
    public List<Cat> getByConditions(Predicate<Cat> predicate) {
        return null;
    }

}
