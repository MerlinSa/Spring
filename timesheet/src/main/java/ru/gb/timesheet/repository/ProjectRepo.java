package ru.gb.timesheet.repository;

import org.springframework.stereotype.Repository;
import ru.gb.timesheet.model.Project;
import ru.gb.timesheet.model.Timesheet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

// todo 3.2 Создать CRUD-контроллер для класса Project, сервис и репозиторий
@Repository
public class ProjectRepo{
    private static Long sequence = 1L;
    private final List<Project> projects = new ArrayList<>();
    public Optional<Project> getById(Long id) {
        // select * from timesheets where id = $id
        return projects.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst();
    }

    public List<Project> getAll() {
        return List.copyOf(projects);
    }

    //2. В объект timesheet в поле createdAt должно подставляться текущее время на стороне сервера!
    public Project create(Project project ) {
        project.setId(sequence++);
        projects.add(project);
        return project;
    }

    public void delete(Long id) {
        projects.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .ifPresent(projects::remove); // если нет - иногда посылают 404 Not Found
    }
    public void update(Project project) {
        projects.stream()
                .filter(it -> Objects.equals(it.getId(), project.getId()))
                .findAny()
                .ifPresentOrElse(it -> it.setName(project.getName()),
                        ()->{throw new RuntimeException();}); // если нет - иногда посылают 404 Not Found
    }

}
