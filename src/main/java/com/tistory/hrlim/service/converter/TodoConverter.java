package com.tistory.hrlim.service.converter;

import com.tistory.hrlim.model.domain.TodoEntity;
import com.tistory.hrlim.model.payload.TodoRequest;
import com.tistory.hrlim.utils.TimeUtils;

public class TodoConverter {
    public static TodoEntity toTodoEntity(TodoRequest todoRequest){
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setTitle(todoRequest.getTitle());
        todoEntity.setExpiredAt(TimeUtils.toLocalDateTime(todoRequest.getYearMonth()));
        todoEntity.setCompleted(todoRequest.getCompleted());
        todoEntity.setImportant(todoRequest.getImportant());

       return todoEntity;
    }
}
