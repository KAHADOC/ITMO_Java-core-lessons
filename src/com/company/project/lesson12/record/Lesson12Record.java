package com.company.project.lesson12.record;

import java.time.LocalDateTime;

public class Lesson12Record {
    public static void main(String[] args) {
        Review review = new Review(1, ".....", LocalDateTime.now());
        ReviewR reviewR = new ReviewR(1, ".....", LocalDateTime.now());
    }
}
