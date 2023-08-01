package com.example.todoapp;

import lombok.Getter;

@Getter
public class TodoDto {
    private String title;
    private int todoOrder;
    private boolean completed;
}
