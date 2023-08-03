package com.example.todoapp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
    private final TodoRepository repository;

    public Service(TodoRepository repository) {
        this.repository = repository;
    }

    public Todo createTodo(Todo todo) {
        return repository.save(todo);
    }

    public Todo getTodo(long todoId) {
        return repository.findById(todoId).orElseThrow();
    }

    public List<Todo> getTodos(Pageable pageable) {
        return repository.findAll(pageable).getContent();
    }

    @Transactional
    public Todo updateTodo(long todoId, Todo todo) {
        Todo findTodo = repository.findById(todoId).orElseThrow();
        findTodo.setTitle(todo.getTitle());
        findTodo.setTodoOrder(todo.getTodoOrder());
        findTodo.setCompleted(todo.isCompleted());

        return findTodo;
    }

    public void deleteTodo(long todoId) {
        repository.deleteById(todoId);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
