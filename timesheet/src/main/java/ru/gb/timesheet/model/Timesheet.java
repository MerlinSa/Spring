package ru.gb.timesheet.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Timesheet {

  private Long id;
  private Long projectId; // todo 3.3 В ресурсе Timesheet поле project изменить на projectId
  private int minutes;
  private LocalDate createdAt;

}
