package com.company.project.lesson18;

import java.util.function.Predicate;

public interface Notification {

    void send(String message);

    default Notification add(Notification other, Predicate<String> predicate){
        return (message) -> {
            if (predicate.test(message)) other.send(message);
            send(message);
        };
    }
}
