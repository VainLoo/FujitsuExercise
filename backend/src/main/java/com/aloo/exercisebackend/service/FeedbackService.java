package com.aloo.exercisebackend.service;

import com.aloo.exercisebackend.data.Feedback;
import com.aloo.exercisebackend.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.aloo.exercisebackend.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for housing the business logic.
 */
@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    /**
     * Gets all the entries from the database.
     * @return List<Feedback> of entries
     */
    public List<Feedback> findAll() {
        return feedbackRepository.findAll();
    }

    /**
     * Gets feedback with the specified id. Throws EntityNotFoundException if not found.
     * @param id The id of the Feedback we are looking for.
     * @return Feedback object
     */
    public Feedback findById(String id) {
        return feedbackRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    /**
     * Inserts the given Feedback into the database.
     * @param feedback Feedback object to be saved.
     * @return Feedback object that was saved.
     */
    public Feedback save(Feedback feedback){
        return feedbackRepository.save(feedback);
    }

    /**
     * Deletes a entry with the given id from the database.
     * @param id The id of the Feedback we are looking to delete.
     */
    public void deleteById(String id){
        feedbackRepository.deleteById(id);
    }

    /**
     * Deletes all the entries from the database.
     */
    public void deleteAll() {
        feedbackRepository.deleteAll();
    }
}
