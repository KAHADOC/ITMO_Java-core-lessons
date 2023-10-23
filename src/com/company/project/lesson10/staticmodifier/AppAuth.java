package com.company.project.lesson10.staticmodifier;

public /*final*/ /*sealed*/ non-sealed class AppAuth implements Auth /*permits FormAuth, TokeanAuth*/{

    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public boolean logout() {
        return false;
    }
}
