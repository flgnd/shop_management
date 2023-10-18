package com.example.shoppingjavaspringserver.services;

import com.example.shoppingjavaspringserver.entities.BrandEntity;
import com.example.shoppingjavaspringserver.entities.CategoryEntity;
import com.example.shoppingjavaspringserver.model.request.BrandRequest;
import com.example.shoppingjavaspringserver.model.request.CategoryRequest;
import com.example.shoppingjavaspringserver.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryEntity create(CategoryRequest categoryRequest) {
        return  categoryRepository.save(categoryRequest.toEntity());
    }

    public CategoryEntity findCategoryByName(String name) {
        return categoryRepository.findCategoryByName(name);
    }

    public CategoryEntity updateCategory(CategoryEntity categoryEntity) {
        return  categoryRepository.save(categoryEntity);
    }

    public List<CategoryEntity> getCategoryByName(String name) {
        return categoryRepository.getCategoryByName(name);
    }

    public boolean deleteCategoryById(int id) {
        try {
            categoryRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
