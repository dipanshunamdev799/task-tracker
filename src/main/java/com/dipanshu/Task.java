package com.dipanshu;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {
    private String description = "Add description";
    private TaskStatus status = TaskStatus.TODO;

    public Task(String description) {
        this.description = description;
    }

    @JsonCreator
    public Task(@JsonProperty("status") TaskStatus status,
            @JsonProperty("description") String description) {
        this.status = status;
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return this.status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
