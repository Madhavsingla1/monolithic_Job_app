package com.madz.firstJobApp.review.impl;

import com.madz.firstJobApp.company.Company;
import com.madz.firstJobApp.company.CompanyService;
import com.madz.firstJobApp.review.Review;
import com.madz.firstJobApp.review.ReviewRepository;
import com.madz.firstJobApp.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;
    private CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.findCompanyById(companyId);
        if(company!=null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReviewById(Long companyId,Long reviewId) {
        List<Review>reviews=reviewRepository.findByCompanyId(companyId);
        return  reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId,Review review) {
        if(companyService.findCompanyById(companyId)!=null){
            review.setCompany(companyService.findCompanyById(companyId));
            review.setId(reviewId);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long reviewsId, Long companyId) {

        if(companyService.findCompanyById(companyId) != null && reviewRepository.existsById(reviewsId)) {
            Review review = reviewRepository.findById(reviewsId).orElse(null);
            Company company = review.getCompany();
            company.getReviews().remove(review);
            review.setCompany(null);
            companyService.updateCompany(company, companyId);
            reviewRepository.deleteById(reviewsId);
            return true;
        }
        return false;
    }
}
