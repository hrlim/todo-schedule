package com.tistory.hrlim.controller;

import com.tistory.hrlim.model.domain.Todo;
import com.tistory.hrlim.model.payload.TodoRequest;
import com.tistory.hrlim.model.payload.TodoResponse;
import com.tistory.hrlim.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/add")
    public ResponseEntity<?> create(@Valid @RequestBody TodoRequest todoRequest, BindingResult bindingResult){
        if( bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError fieldError = (FieldError) objectError;
                String message = objectError.getDefaultMessage();

                System.out.println("field : " + fieldError.getField());
                System.out.println(message);

                sb.append("field : ").append(fieldError.getField());
                sb.append(", message : ").append(message);
                sb.append(System.lineSeparator());

            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }

        Todo todoEntity = this.todoService.create(todoRequest);
        return ResponseEntity.ok(new TodoResponse(todoEntity));
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<TodoResponse> searchById(@PathVariable long todoId){
        Todo todoEntity = this.todoService.searchById(todoId);
        return ResponseEntity.ok(new TodoResponse(todoEntity));
    }

    @GetMapping("/month/{month}")
    public ResponseEntity<List<TodoResponse>> searchById(@PathVariable String month){
        List<Todo> list = this.todoService.searchByMonth(month);
        List<TodoResponse> responses = list.stream().map(TodoResponse::new).collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }


    @GetMapping("/show-all")
    public ResponseEntity<List<TodoResponse>> searchAll(){
        List<Todo> list = this.todoService.searchAll();
        List<TodoResponse> responses = list.stream().map(TodoResponse::new).collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @PatchMapping("/update/{todoId}")
    public ResponseEntity<TodoResponse> updateById(@PathVariable long todoId, @RequestBody TodoRequest todoRequest){
        Todo todoEntity = this.todoService.updateById(todoId, todoRequest);
        return ResponseEntity.ok(new TodoResponse(todoEntity));
    }

    @DeleteMapping("/delete/{todoId}")
    public ResponseEntity<?> delete(@PathVariable long todoId){
        this.todoService.deleteById(todoId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-month/{yearMonth}")
    public ResponseEntity<?> delete(@PathVariable String yearMonth){
        this.todoService.deleteByMonth(yearMonth);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<?> deleteAll(){
        this.todoService.deleteAll();
        return ResponseEntity.ok().build();
    }

}
