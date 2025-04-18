package com.madz.firstJobApp.review;

import com.madz.firstJobApp.company.Company;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId, Review review);
    Review getReviewById(Long companyId, Long reviewId);
    boolean updateReview(Long companyId, Long reviewId,Review review);

    boolean deleteReview(Long reviewsId, Long companyId);
}
