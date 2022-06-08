package com.tistory.hrlim.service;

import com.tistory.hrlim.model.domain.Todo;
import com.tistory.hrlim.model.payload.TodoRequest;
import com.tistory.hrlim.repository.TodoRepository;
import com.tistory.hrlim.service.converter.TodoConverter;
import com.tistory.hrlim.utils.TimeUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    // To Do 아이템 등록
    public Todo create(TodoRequest todoRequest) {
        Todo todoEntity = TodoConverter.toTodoEntity(todoRequest);
        return this.todoRepository.save(todoEntity);
    }

    // To Do 목록 중 특정 아이템 조회
    public Todo searchById(long todoId) {
        return this.todoRepository.findById(todoId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // To Do 목록 중 특정달 아이템 조회
    public List<Todo> searchByMonth(String yearMonth) {
        return this.todoRepository.findByExpiredMonth(TimeUtils.toLocalDate(yearMonth));
    }

    // To Do 목록 전체 조회
    public List<Todo> searchAll() {
        return this.todoRepository.findAll();
    }

    // To Do 특정 아이템 수정
    public Todo updateById(long todoId, TodoRequest todoRequest) {
        Todo todo = this.searchById(todoId);
        if (todoRequest.getTitle() != null) {
            todo.setTitle(todoRequest.getTitle());
        }
        if (todoRequest.getYearMonth() != null) {
            todo.setExpiredMonth(TimeUtils.toLocalDate(todoRequest.getYearMonth()));
        }
        if (todoRequest.getImportant() != 0) {
            todo.setImportant(todoRequest.getImportant());
        }
        if (todoRequest.getCompleted() != null) {
            todo.setCompleted(todoRequest.getCompleted());
        }
        return this.todoRepository.save(todo);
    }

    // To Do 특정 아이템 삭제
    public void deleteById(Long id){
        this.todoRepository.deleteById(id);
    }

    // To Do 특정달 아이템 삭제
    @Transactional
    public void deleteByMonth(String yearMonth){
        this.todoRepository.deleteAllByExpiredMonth(TimeUtils.toLocalDate(yearMonth));
    }

    // To Do 전체 삭제
    public void deleteAll(){
        this.todoRepository.deleteAll();
    }
}
