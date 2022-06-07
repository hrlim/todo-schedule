package com.tistory.hrlim.service;

import com.tistory.hrlim.model.domain.TodoEntity;
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
    public TodoEntity create(TodoRequest todoRequest) {
        TodoEntity todoEntity = TodoConverter.toTodoEntity(todoRequest);
        return this.todoRepository.save(todoEntity);
    }

    // To Do 목록 중 특정 아이템 조회
    public TodoEntity searchById(long todoId) {
        return this.todoRepository.findById(todoId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // To Do 목록 중 특정달 아이템 조회
    public List<TodoEntity> searchByMonth(String yearMonth) {
        return this.todoRepository.findByExpiredAt(TimeUtils.toLocalDateTime(yearMonth));
    }

    // To Do 목록 전체 조회
    public List<TodoEntity> searchAll() {
        return this.todoRepository.findAll();
    }

    // To Do 특정 아이템 수정
    public TodoEntity updateById(long todoId, TodoRequest todoRequest) {
        TodoEntity todoEntity = this.searchById(todoId);
        if (todoRequest.getTitle() != null) {
            todoEntity.setTitle(todoRequest.getTitle());
        }
        if (todoRequest.getYearMonth() != null) {
            todoEntity.setExpiredAt(TimeUtils.toLocalDateTime(todoRequest.getYearMonth()));
        }
        if (todoRequest.getImportant() != 0) {
            todoEntity.setImportant(todoRequest.getImportant());
        }
        if (todoRequest.getCompleted() != null) {
            todoEntity.setCompleted(todoRequest.getCompleted());
        }
        return this.todoRepository.save(todoEntity);
    }

    // To Do 특정 아이템 삭제
    public void deleteById(Long id){
        this.todoRepository.deleteById(id);
    }

    // To Do 특정달 아이템 삭제
    @Transactional
    public void deleteByMonth(String yearMonth){
        this.todoRepository.deleteAllByExpiredAt(TimeUtils.toLocalDateTime(yearMonth));
    }

    // To Do 전체 삭제
    public void deleteAll(){
        this.todoRepository.deleteAll();
    }
}
