INSERT INTO users (username, email, password, role) VALUES
                                                                ('admin1', 'admin1@example.com', 'encrypted_password1', 'ADMIN'),
                                                                ('manager1', 'manager1@example.com', 'encrypted_password2', 'MANAGER'),
                                                                ('user1', 'user1@example.com', 'encrypted_password3', 'USER'),
                                                                ('user2', 'user2@example.com', 'encrypted_password4', 'USER');
INSERT INTO tasks (title, description, deadline, priority, status, assigned_user_id, created_by_id) VALUES
                                                                                                       ('Task 1', 'Description for task 1', '2024-05-20', 'High', 'TODO', 3, 1),
                                                                                                       ('Task 2', 'Description for task 2', '2024-05-21', 'Medium', 'INPROGRESS', 4, 1),
                                                                                                       ('Task 3', 'Description for task 3', '2024-05-22', 'Low', 'TODO', 3, 2),
                                                                                                       ('Task 4', 'Description for task 4', '2024-05-23', 'High', 'TODO', 4, 2);
