package com.demo.task.dmo;

import com.demo.task.demo.User;
import com.demo.task.demo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository=userRepository;
    }

    public Task createTask(TaskDTO taskDTO,Long currentUserId)
    {
        User currentUser = userRepository.findById(currentUserId)
                .orElseThrow(() -> new IllegalArgumentException("Current user not found"));

        if (currentUser.getRole() != User.UserRole.ADMIN && currentUser.getRole() != User.UserRole.MANAGER) {
            throw new UnauthorizedException("Only ADMIN and MANAGER can create tasks");
        }

        User assignedUser=userRepository.findById(taskDTO.getAssignedUserId()).orElse(null);
        User createdBy = userRepository.findById(taskDTO.getCreatedById()).orElse(null);


        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDeadline(taskDTO.getDeadline());
        task.setPriority(taskDTO.getPriority());
        task.setStatus(taskDTO.getStatus());
        task.setAssigned_user_id(assignedUser);
        task.setCreated_by_id(createdBy);

        return taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
}
