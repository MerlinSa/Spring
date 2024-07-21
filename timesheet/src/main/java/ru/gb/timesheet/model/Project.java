package ru.gb.timesheet.model;

import lombok.Data;

// todo * 3.1 Создать класс Project с полями id, name
@Data
public class Project {
    private Long id;
    private String name;
    // Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
