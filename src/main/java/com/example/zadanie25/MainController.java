package com.example.zadanie25;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {

    private TaskRepository taskRepository;

    public MainController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Task> allTasks = taskRepository.findAll();
        model.addAttribute("tasks", allTasks);
        model.addAttribute("taskToAdd", new Task());
        return "home";
    }

    @GetMapping("/done")
    public String done(Model model) {
        List<Task> allTasks = taskRepository.findTaskByStatusOrderByDateDesc(Status.DONE);
        model.addAttribute("tasks", allTasks);
        return "done";
    }

    @GetMapping("/ready")
    public String ready(Model model) {
        List<Task> allTasks = taskRepository.findTaskByStatusOrderByDateDesc(Status.READY);
        model.addAttribute("tasks", allTasks);
        return "ready";
    }

    @GetMapping("form")
    public String form(Model model) {
        model.addAttribute("taskToAdd", new Task());
        return "form";
    }

    @PostMapping("/add")
    public String addTask(Task task) {
        taskRepository.save(task);
        return "redicect:/";
    }
}
