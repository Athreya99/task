package com.demo.task.demo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long user_id;
    private String username;
    private String email;
    private String password;




@Enumerated(EnumType.STRING)
private UserRole role;
public enum UserRole {
        ADMIN, MANAGER, USER
    }


    // Getters and Setters


}
