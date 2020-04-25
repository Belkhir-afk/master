package com.demo.business;

import java.util.List;

import javax.transaction.Transactional;

import com.demo.model.persitent.Category;
import com.demo.model.persitent.Workflow;


public interface WorkflowBusiness {
	
	@Transactional()
	public List<Workflow> getworkflowsByFilter(String name, Integer status, Integer category_id);
    
    @Transactional()
    public List<Workflow> getWorkflows();
    
    @Transactional
    public List<Category> getCategories();
    
}
