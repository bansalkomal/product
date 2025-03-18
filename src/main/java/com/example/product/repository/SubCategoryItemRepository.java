package com.example.product.repository;

import com.example.product.model.SubCategoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryItemRepository extends JpaRepository<SubCategoryItem, Long> {
    List<SubCategoryItem> findBySubCategoryId(Long subCategoryId);
}