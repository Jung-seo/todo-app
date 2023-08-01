package com.example.todoapp;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    TodoDto todoToTodoDto(Todo todo);

    Todo todoDtoToTodo(TodoDto todoDto);
}
