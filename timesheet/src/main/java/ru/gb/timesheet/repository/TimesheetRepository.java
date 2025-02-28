package ru.gb.timesheet.repository;

import org.springframework.stereotype.Repository;
import ru.gb.timesheet.model.Timesheet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository // @Component для классов, работающих с данными
public class TimesheetRepository {

  private static Long sequence = 1L;
  private final List<Timesheet> timesheets = new ArrayList<>();

  public Optional<Timesheet> getById(Long id) {
    // select * from timesheets where id = $id
    return timesheets.stream()
      .filter(it -> Objects.equals(it.getId(), id))
      .findFirst();
  }

  public List<Timesheet> getAll() {
    return List.copyOf(timesheets);
  }

  //2. В объект timesheet в поле createdAt должно подставляться текущее время на стороне сервера!
  public Timesheet create(Timesheet timesheet) {
    timesheet.setId(sequence++);
    timesheet.setCreatedAt(LocalDate.now()); //2. должно подставляться текущее время на стороне сервера!
    timesheets.add(timesheet);
    return timesheet;
  }

  public void delete(Long id) {
    timesheets.stream()
      .filter(it -> Objects.equals(it.getId(), id))
      .findFirst()
      .ifPresent(timesheets::remove); // если нет - иногда посылают 404 Not Found
  }

  public List<Timesheet> getAllByProject(Long projectId) {
    ArrayList<Timesheet> timesheetsByProject = new ArrayList<>();
    for (Timesheet t:
            timesheets) {
      if(t.getProjectId() == projectId){
        timesheetsByProject.add(t);
      }
    }
    return timesheetsByProject;
  }
}
