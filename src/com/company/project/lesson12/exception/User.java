package com.company.project.lesson12.exception;

public class User implements Cloneable{
    private String username;
    private String password;

    public User(String username, String password) throws UserException {
        if (username == null || password == null)
            throw new UserException("Ошибка входящих данных", this);
        this.username = username;
        this.password = password;
    }

    @Override // исключения времени компиляции должны быть обработаны в блоке try catch
            // или проброшены в сигнатуру метода
    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}
