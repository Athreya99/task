package com.demo.task.dmo;

import com.demo.task.demo.User;
import com.demo.task.demo.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository, CommentRepository commentRepository) {
        this.taskRepository = taskRepository;
        this.userRepository=userRepository;
        this.commentRepository = commentRepository;
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
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        taskRepository.delete(task);
    }
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Comment addCommentToTask(Long taskId, String text, Long userId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        Comment comment = new Comment();
        comment.setTask(task);
        comment.setText(text);
        comment.setCreated_at(LocalDateTime.now());
        comment.setUser(user);

        return commentRepository.save(comment);
    }
}
