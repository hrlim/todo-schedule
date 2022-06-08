package com.tistory.hrlim.service.converter;

import com.tistory.hrlim.model.domain.Todo;
import com.tistory.hrlim.model.payload.TodoRequest;
import com.tistory.hrlim.utils.TimeUtils;

public class TodoConverter {
    public static Todo toTodoEntity(TodoRequest todoRequest){
        Todo todoEntity = new Todo();
        todoEntity.setTitle(todoRequest.getTitle());
        todoEntity.setExpiredMonth(TimeUtils.toLocalDate(todoRequest.getYearMonth()));
        todoEntity.setCompleted(todoRequest.getCompleted());
        todoEntity.setImportant(todoRequest.getImportant());

       return todoEntity;
    }
}
