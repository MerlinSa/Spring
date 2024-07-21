package ru.gb.timesheet.service;

import org.springframework.stereotype.Service;
import ru.gb.timesheet.model.Project;
import ru.gb.timesheet.repository.ProjectRepo;

import java.util.List;
import java.util.Optional;
@Service
public class ProjectService {
    private ProjectRepo projectRepo;
    public ProjectService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }
    // тут можно добавлять логику работы с проектами
    public Optional<Project> getById(Long id) {
        return projectRepo.getById(id);
    }
    public List<Project> getAll() {
        return projectRepo.getAll();}
    public Project create(Project project) {
        return projectRepo.create(project);
    }
    public void delete(Long id) {
        projectRepo.delete(id);
    }

    public void update(Project project){
        projectRepo.update(project); //обновляем проект в БД
    }
}
