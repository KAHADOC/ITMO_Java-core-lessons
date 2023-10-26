package com.company.project.lesson12.record;

import java.time.LocalDateTime;
import java.util.Objects;

public class Review {
    private final long id;
    private final String text;
    private final LocalDateTime cratedAt;

    public Review(long id, String text, LocalDateTime cratedAt) {
        this.id = id;
        this.text = text;
        this.cratedAt = cratedAt;
    }

    public long id() {
        return id;
    }

    public String text() {
        return text;
    }

    public LocalDateTime cratedAt() {
        return cratedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review review)) return false;

        if (id != review.id) return false;
        if (!Objects.equals(text, review.text)) return false;
        return Objects.equals(cratedAt, review.cratedAt);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (cratedAt != null ? cratedAt.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", cratedAt=" + cratedAt +
                '}';
    }
}
