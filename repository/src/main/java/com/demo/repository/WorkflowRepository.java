package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.model.persitent.Workflow;

@Repository
public interface WorkflowRepository extends PagingAndSortingRepository< Workflow, Integer>{
	
	List<Workflow> findAll();
	
	@Query("SELECT w FROM Workflow w left join w.categories cat WHERE (:name is null or w.name = :name) and (:status is null or w.status = :status) and (:category_id is null or cat.category_id = :category_id)")
	List<Workflow> findByCriteria(@Param("name") String name, 
			@Param("status") Integer status, @Param("category_id") Integer category_id);
	
}
