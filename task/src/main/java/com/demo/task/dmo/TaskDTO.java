package com.demo.task.dmo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    private String title;
    private String description;
    private LocalDate deadline;
    private String priority;
    private Task.Status status;
    private Long assignedUserId;
    private Long createdById;
}
