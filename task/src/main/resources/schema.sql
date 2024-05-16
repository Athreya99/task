CREATE TABLE users (
                       user_id SERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(20)

);

CREATE TABLE tasks (
                      task_id SERIAL PRIMARY KEY,
                      title VARCHAR(100) NOT NULL,
                      description TEXT,
                      deadline DATE,
                      priority VARCHAR(20),
                      status VARCHAR(20) CHECK (status IN ('TODO', 'INPROGRESS', 'COMPLETED')),
                      assigned_user_id INT,
                      created_by_id INT,
                      FOREIGN KEY (assigned_user_id) REFERENCES users(user_id),
                      FOREIGN KEY (created_by_id) REFERENCES users(user_id)
);
