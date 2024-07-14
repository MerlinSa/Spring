package ru.saikalb.Homework2;
import java.time.LocalDateTime;

public class Ticket {
    String number;
    LocalDateTime createdAt;

    public Ticket(String number, LocalDateTime createdAt) {
        this.number = number;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return number + ", " + "Created Time: " + createdAt;
    }
}
/*
 2. Создать класс Ticket (не бин!!!) с полями:
 2.1. String number - номер тикета
 2.2. LocalDateTime createdAt - дата создания
 2.3. ... (любые другие поля)
 */
