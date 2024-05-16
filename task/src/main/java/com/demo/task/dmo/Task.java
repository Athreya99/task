package com.demo.task.dmo;

import com.demo.task.demo.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long task_id;
    private String title;
    private String description;
    private LocalDate deadline;
    private String priority;




    @ManyToOne
    @JoinColumn(name = "assigned_user_id", referencedColumnName = "user_id")
    private User assigned_user_id;

    @ManyToOne
    @JoinColumn(name = "created_by_id", referencedColumnName = "user_id")
    private User created_by_id;


    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        TODO,INPROGRESS,DONE
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;
    // Getters and Setters

}
