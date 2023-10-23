package com.company.project.lesson10.staticmodifier;

public final class GAuth implements Auth, Runnable{

    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public void run() {

    }
}
