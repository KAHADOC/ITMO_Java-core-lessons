package com.company.project.lesson2223.dao;

import java.util.List;
import java.util.function.Predicate;

public class UserDao implements Dao<User, String> {

    @Override
    public void add(User user) {}

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public User getByUniqueId(String s) {
        return null;
    }

    @Override
    public List<User> getByConditions(Predicate<User> predicate) {
        return null;
    }

}
