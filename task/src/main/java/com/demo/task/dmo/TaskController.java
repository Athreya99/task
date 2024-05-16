package com.demo.task.dmo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody TaskDTO taskDTO) {
        Task createdtask=taskService.createTask(taskDTO);
        return new ResponseEntity<>(createdtask, HttpStatus.CREATED);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks=taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }


}
