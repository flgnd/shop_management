package com.example.shoppingjavaspringserver.services;

import com.example.shoppingjavaspringserver.entities.BrandEntity;
import com.example.shoppingjavaspringserver.entities.CategoryEntity;
import com.example.shoppingjavaspringserver.model.request.BrandRequest;
import com.example.shoppingjavaspringserver.model.request.CategoryRequest;
import com.example.shoppingjavaspringserver.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryEntity create(CategoryRequest categoryRequest) {
        return  categoryRepository.save(categoryRequest.toEntity());
    }
}
