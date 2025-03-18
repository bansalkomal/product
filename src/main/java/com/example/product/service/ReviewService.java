package com.example.product.service;

import com.example.product.dto.ReviewDTO;
import com.example.product.model.Product;
import com.example.product.model.Review;
import com.example.product.model.User;
import com.example.product.repository.ProductRepository;
import com.example.product.repository.ReviewRepository;
import com.example.product.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public Review addReview(Long productId, Long userId, ReviewDTO reviewDTO) {
        Review review = new Review();
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        review.setProduct(product);
        review.setUser(user);
        review.setRating(reviewDTO.getRating());
        review.setComment(reviewDTO.getComment());
        review.setReviewDate(LocalDateTime.now());

        return reviewRepository.save(review);
    }

    public List<Review> getReviewsByProduct(Long productId) {
        return reviewRepository.findByProductId(productId);
    }

    public Optional<Review> getReviewByProductAndUser(Long productId, Long userId) {
        return reviewRepository.findByProductIdAndUserId(productId, userId);
    }
}

