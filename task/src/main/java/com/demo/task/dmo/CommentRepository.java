package com.demo.task.dmo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends ListCrudRepository<Comment, Long> {
}