package com.tistory.hrlim.model.payload;

import com.tistory.hrlim.model.domain.TodoEntity;
import com.tistory.hrlim.utils.TimeUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoResponse {

    private Long id;
    private String title;
    private Boolean completed;
    private LocalDateTime expiredAt;
    private int important;
    private String url;

    public TodoResponse(TodoEntity todoEntity){
        this.id = todoEntity.getId();
        this.title = todoEntity.getTitle();
        this.completed = todoEntity.getCompleted();
        this.expiredAt = todoEntity.getExpiredAt();
        this.important = todoEntity.getImportant();
        this.url = "http://localhost:8080/" + this.id;
    }
}

