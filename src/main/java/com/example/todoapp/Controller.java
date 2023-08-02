package com.example.todoapp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class Controller {
    private Service service;
    private TodoMapper mapper;

    public Controller(Service service, TodoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postTodo(@RequestBody Todo todo) {
//        Todo todo = mapper.todoDtoToTodo(todoDto);
        Todo resultTodo = service.createTodo(todo);
        return new ResponseEntity(resultTodo, HttpStatus.CREATED);
    }

    @GetMapping("/{todo-id}")
    public ResponseEntity getTodo(@PathVariable("todo-id") long todoId) {
        Todo todo = service.getTodo(todoId);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTodos(Pageable pageable) {
        List<Todo> todos = service.getTodos(pageable);
        return new ResponseEntity(todos, HttpStatus.OK);
    }

    @PatchMapping("/{todo-id}")
    public ResponseEntity patchTodo(@PathVariable("todo-id") long todoId,
                                    @RequestBody Todo todo) {
        Todo patchedTodo = service.updateTodo(todoId, todo);

        return new ResponseEntity(patchedTodo, HttpStatus.OK);
    }

    @DeleteMapping("/{todo-id}")
    public void deleteTodo(@PathVariable("todo-id") long todoId) {
        service.deleteTodo(todoId);
    }

    @DeleteMapping
    public void deleteAll() {
        service.deleteAll();
    }
}
