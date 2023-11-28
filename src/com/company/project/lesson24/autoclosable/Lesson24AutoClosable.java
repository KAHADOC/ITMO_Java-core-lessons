package com.company.project.lesson24.autoclosable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lesson24AutoClosable {
    public static void main(String[] args) {
        Resource resource01 = null;
        try {
            resource01 = new Resource();
            resource01.resourceVoid();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (resource01 != null) resource01.close();
        }

        // try with resources
        try (Resource resource02 = new Resource()){
            resource02.resourceVoid();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        List<Resource> connections = new ArrayList<>();
        connections.add(new Resource());
        connections.add(new Resource());
        connections.add(new Resource());
        connections.add(new Resource());

        for (Resource connection : connections) {
            if (connection != null) {
                try {
                    connection.resourceVoid();
                } catch (IOException e) {
                    // connections.remove(connection);
                    System.out.println(e.getMessage());
                }
            }
        }








    }
}
