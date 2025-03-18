package com.example.product.controller;

import com.example.product.model.SubCategoryItem;
import com.example.product.service.SubCategoryItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subcategory-items")
@RequiredArgsConstructor
public class SubCategoryItemController {
    private final SubCategoryItemService subCategoryItemService;

    @GetMapping
    public ResponseEntity<List<SubCategoryItem>> getSubCategoryItems(@RequestParam Long subCategoryId) {
        return ResponseEntity.ok(subCategoryItemService.getSubCategoryItemsBySubCategoryId(subCategoryId));
    }
}
