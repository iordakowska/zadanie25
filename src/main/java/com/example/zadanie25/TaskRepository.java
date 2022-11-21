package com.example.zadanie25;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository <Task, Long>{

    List<Task> findTaskByStatusOrderByDateDesc(Status status);

    List<Task> findAll();

}
