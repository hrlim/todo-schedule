package com.tistory.hrlim.model.payload;

import com.tistory.hrlim.model.domain.Todo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoResponse {

    private Long id;
    private String title;
    private Boolean completed;
    private LocalDate expiredMonth;
    private int important;
    private String url;

    public TodoResponse(Todo todo){
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.completed = todo.isCompleted();
        this.expiredMonth = todo.getExpiredMonth();
        this.important = todo.getImportant();
        this.url = "http://localhost:8080/" + this.id;
    }
}

