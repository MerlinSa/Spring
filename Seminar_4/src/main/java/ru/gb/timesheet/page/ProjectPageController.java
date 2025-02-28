package ru.gb.timesheet.page;

import ru.gb.timesheet.service.ProjectPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Controller
@RequestMapping("/home/projects")
@RequiredArgsConstructor
public class ProjectPageController {
    private final ProjectPageService service;
    @GetMapping
    public String getAllTimesheets(Model model) {
        List<ProjectPageDto> projects = service.findAll();
        model.addAttribute("projects", projects);
        return "projects-page.html";
    }

    // GET /home/timesheets/{id}
    @GetMapping("/{id}")
    public String getTimesheetPage(@PathVariable Long id, Model model) {
        Optional<ProjectPageDto> projectOpt = service.findById(id);
        if (projectOpt.isEmpty()) {
            throw new NoSuchElementException();
        }

        model.addAttribute("project", projectOpt.get());
        return "project-page.html";
    }

}
