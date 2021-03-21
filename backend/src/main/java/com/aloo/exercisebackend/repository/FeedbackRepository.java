package com.aloo.exercisebackend.repository;

import com.aloo.exercisebackend.data.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
    MongoDB implementation
 */
public interface FeedbackRepository extends MongoRepository<Feedback, String> {

}
