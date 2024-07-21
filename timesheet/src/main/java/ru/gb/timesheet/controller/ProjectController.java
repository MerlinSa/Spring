package ru.gb.timesheet.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.timesheet.model.Project;
import ru.gb.timesheet.model.Timesheet;
import ru.gb.timesheet.service.ProjectService;
import ru.gb.timesheet.service.TimesheetService;

import java.util.List;
import java.util.Optional;

/**
 * 3. Создать отдельный контроллер для проектов (поле Timesheet.project)
 *    * 3.1 Создать класс Project с полями id, name
 *    * 3.2 Создать CRUD-контроллер для класса Project, сервис и репозиторий
 *    * 3.3 В ресурсе Timesheet поле project изменить на projectId
 *    * 3.4 При создании Timesheet проверять, что project с идентификатором projectId существует
 */
@RestController
@RequestMapping("/projects")
public class ProjectController {
   private final ProjectService projectService;
   private final TimesheetService timesheetService;

    public ProjectController(ProjectService projectService, TimesheetService timesheetService) {
        this.projectService = projectService;
        this.timesheetService = timesheetService;
    }

    @GetMapping("/{id}") // получить все
    public ResponseEntity<Project> get(@PathVariable Long id) {
        Optional<Project> ts = projectService.getById(id);


        if (ts.isPresent()) {
//      return ResponseEntity.ok().body(ts.get());
            return ResponseEntity.status(HttpStatus.OK).body(ts.get());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping // получить все
    public ResponseEntity<List<Project>> getAll() {
        return ResponseEntity.ok(projectService.getAll());
    }

    @PostMapping // создание нового ресурса
    public ResponseEntity<Project> create(@RequestBody Project project) {
        project = projectService.create(project);

        // 201 Created
        return ResponseEntity.status(HttpStatus.CREATED).body(project);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        projectService.delete(id);

        // 204 No Content
        return ResponseEntity.noContent().build();
    }
    @PutMapping
    public ResponseEntity<Project> update(@RequestBody Project project) {
        projectService.update(project);

        // 204 No Content
        return ResponseEntity.status(HttpStatus.OK).body(project);
    }

    @GetMapping("/{id}/timesheets")
    public ResponseEntity<List<Timesheet>> getAllByProject(@PathVariable Long id) {
        return ResponseEntity.ok(timesheetService.getAllByProject(id));
    }
}
