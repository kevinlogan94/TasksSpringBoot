package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RequestMapping("api/v1/task")
@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping()
    public Page<Task> getTask(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }


    @PostMapping()
    public Task createTask(@Valid @RequestBody Task Task) {
        return taskRepository.save(Task);
    }

    @GetMapping(path = "{id}")
    public Task getTaskById(@PathVariable("id") Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));
    }

    @PutMapping()
    public Task updateTask(@Valid @RequestBody Task taskRequest) {
        Long id = taskRequest.getId();
        return taskRepository.findById(id)
                .map(Task -> {
                    Task.setTaskDescription(taskRequest.getTaskDescription());
                    return taskRepository.save(Task);
                }).orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));
    }


    @DeleteMapping("{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable Long taskId) {
        return taskRepository.findById(taskId)
                .map(Task -> {
                    taskRepository.delete(Task);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + taskId));
    }
}
