package com.demo.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.business.WorkflowBusiness;
import com.demo.model.persitent.Category;
import com.demo.model.persitent.Workflow;
import com.demo.repository.CategoryRepository;
import com.demo.repository.WorkflowRepository;

/**
 * 
 * @author Imene BELKHIR
 *
 */

@Service
public class WorkflowBusinessImpl implements WorkflowBusiness{
	
	private WorkflowRepository workflowRepository;
	private CategoryRepository categoryRepository;
	

    /**
     * 
     * @param name optional
     * @param status optional
     * @param category_id optional
     * @return a list of workflows that matches the given input criterias: name, status, category_id
     */
    @Override
    @Transactional
	public List<Workflow> getworkflowsByFilter(String name, Integer status, Integer category_id) {
    	List<Workflow> workflows = new ArrayList<Workflow>();
    	
    	Optional<List<Workflow>> result = Optional.of(workflowRepository.findByCriteria(name, status, category_id));
    	if (result.isPresent()) {
    		workflows = result.get();
    	}
    	
    	return workflows;
	}
    
    /**
     * @return a list of all existing workflows 
     */
    @Override
    @Transactional
    public List<Workflow> getWorkflows() {
    	List<Workflow> workflows = new ArrayList<Workflow>();
    	
    	Optional<List<Workflow>> result = Optional.of(workflowRepository.findAll());
    	if (result.isPresent()) {
    		workflows = workflowRepository.findAll();
    	}
    	return workflows;
    }
    
    
    /**
    *
    * @return list of all existing workflows categories
    */
    @Override
    @Transactional
    public List<Category> getCategories(){
    	List<Category> categories = new ArrayList<Category>();
    	
    	Optional<List<Category>> result = Optional.of(categoryRepository.findAll());
    	if (result.isPresent()) {
    		categories = categoryRepository.findAll();
    	}
    	return categories;
    }
    
    
    /**
     * @param workflowRepository the repository to autowire
     * injects the repository in the current Service
     */
    @Autowired
    public void setWorkflowRepository(WorkflowRepository workflowRepository) {
        this.workflowRepository = workflowRepository;
    }
    
    /**
     * @param categoryRepository the repository to autowire
     * injects the repository in the current Service
     */
    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
