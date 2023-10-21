package com.company.project.lesson10.staticmodifier;

public class GAuth implements Auth{

    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public boolean logout() {
        return false;
    }
}
