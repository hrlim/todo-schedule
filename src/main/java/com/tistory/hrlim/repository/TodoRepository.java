package com.tistory.hrlim.repository;

import com.tistory.hrlim.model.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByExpiredMonth(LocalDate localDateTime);
    void deleteAllByExpiredMonth(LocalDate localDateTime);
}
