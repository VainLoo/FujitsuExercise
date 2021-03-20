package com.aloo.exercisebackend.controller;

import com.aloo.exercisebackend.data.Feedback;
import com.aloo.exercisebackend.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public List<Feedback> findAll() {
        return feedbackService.findAll();
    }

    @GetMapping("/{id}")
    public Feedback findById(@PathVariable String id) {
        return feedbackService.findById(id);
    }

    @PostMapping
    public Feedback create(@RequestBody Feedback feedback) {
        return feedbackService.save(feedback);
    }

    @PutMapping("/{id}")
    public Feedback update(@RequestBody Feedback feedback) {
        return feedbackService.save(feedback);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        feedbackService.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll() {
        feedbackService.deleteAll();
    }
}
