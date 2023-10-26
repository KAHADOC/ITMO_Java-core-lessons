package com.company.project.lesson12.record;

import java.time.LocalDateTime;
// ReviewR - название
// (long id, String text, LocalDateTime createdAt) - заголовок (header)
// со списком компонентов
public record ReviewR(long id, String text, LocalDateTime createdAt) {
    // тело записи

    // нельзя объявлять не static поля

    // можно написать реализацию канонического (canonical) конструктора
    // или написать реализацию компактного (compact) конструктора
    // public ReviewR(long id, String text, LocalDateTime createdAt){}
    // их модификатор доступа не может быть ниже модификатора самой записи
    public ReviewR/* (по умолчанию принимает компоненты записи) */{
        if (id < 0 || text.trim().length() < 5 || createdAt == null)
            throw new IllegalArgumentException("Переданы невалидные данные");
        // по умолчанию инициализирует значения всех свойств
    }
    // можно перегрузить конструкторы,
    // но в них необходимо вызвать один из объявленных
    public ReviewR(String text){
        this(0, text);
    }
    public ReviewR(long id, String text) {
        this(id, text, null);
    }
    // можно объявлять собственные методы (статические и нет)
    // можно написать собственную логику геттеров,
    // equals, hashCode и toString
    @Override
    public String text() {
        return text.toUpperCase();
    }
}
// не могут наследоваться
// не могут иметь наследников (final)
// могут имплементировать интерфейсы, включая sealed
// могут быть вложенными и могут иметь вложенные записи
// могут объявляться с generic типами

// 1. private final поля - названия и типы, как у компонентов заголовка
// 2. канонический (canonical) конструктор - принимает и инициализирует
// значения всех свойств
// 3. одноименные (с компонентами) геттеры
// 4. equals, hashCode, toString
