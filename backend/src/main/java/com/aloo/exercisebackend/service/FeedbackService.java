package com.aloo.exercisebackend.service;

import com.aloo.exercisebackend.data.Feedback;
import com.aloo.exercisebackend.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.aloo.exercisebackend.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public List<Feedback> findAll() {
        return feedbackRepository.findAll();
    }

    public Feedback findById(String id) {
        return feedbackRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Feedback save(Feedback feedback){
        return feedbackRepository.save(feedback);
    }

    public void deleteById(String id){
        feedbackRepository.deleteById(id);
    }

    public void deleteAll() {
        feedbackRepository.deleteAll();
    }
}
