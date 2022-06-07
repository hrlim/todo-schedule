package com.tistory.hrlim.repository;

import com.tistory.hrlim.model.domain.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
    List<TodoEntity> findByExpiredAt(LocalDateTime localDateTime);
    void deleteAllByExpiredAt(LocalDateTime localDateTime);
}
