package com.todo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String add(Todo todo) {
        todoRepository.save(todo);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid todo ID: " + id));
        model.addAttribute("todo", todo);
        return "edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, Todo updatedTodo) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid todo ID: " + id));
        todo.setTask(updatedTodo.getTask());
        todo.setCompleted(updatedTodo.isCompleted());
        todoRepository.save(todo);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        todoRepository.deleteById(id);
        return "redirect:/";
    }
}
