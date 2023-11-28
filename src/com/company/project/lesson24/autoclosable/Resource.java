package com.company.project.lesson24.autoclosable;

import java.io.IOException;

public class Resource implements AutoCloseable{

    public void resourceVoid() throws IOException {
        throw new IOException();
    }

    @Override
    public void close(){
        System.out.println("логика связанная с закрытием ресурса");
    }
}
