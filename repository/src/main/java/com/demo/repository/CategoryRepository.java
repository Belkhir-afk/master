package com.demo.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.persitent.Category;


@Repository
public interface CategoryRepository extends PagingAndSortingRepository< Category, Integer> {

	List<Category> findAll();
}
