package com.madz.firstJobApp.review;


import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReview(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@RequestBody Review review,@PathVariable Long companyId){
        if(reviewService.addReview(companyId,review))
            return new ResponseEntity<>("Review Added Successfully",HttpStatus.OK);
        return new ResponseEntity<>("No Company with that ID",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewsId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId, @PathVariable Long reviewsId){
        Review review = reviewService.getReviewById(companyId,reviewsId);
        if(review!=null){
            return new ResponseEntity<>(review,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/reviews/{reviewsId}")
    public ResponseEntity<String> updateReviews(@PathVariable Long reviewsId,@PathVariable Long companyId,@RequestBody Review review){
        boolean isReviewUpdated = reviewService.updateReview(companyId,reviewsId,review);
        if(isReviewUpdated)
            return new ResponseEntity<>("Review Update Successfully",HttpStatus.OK);
        return new ResponseEntity<>("No Company with that ID",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/review/{reviewId}")
    public ResponseEntity<String> deleteReviews(@PathVariable Long reviewId,@PathVariable Long companyId)
    {
        boolean isDeleted = reviewService.deleteReview(reviewId,companyId);
        if(isDeleted)
            return new ResponseEntity<>("Review Deleted Successfully",HttpStatus.OK);
        return new ResponseEntity<>("No Company with that ID",HttpStatus.NOT_FOUND);
    }

}
