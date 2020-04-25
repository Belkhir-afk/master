package com.demo.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.business.WorkflowBusiness;
import com.demo.model.persitent.Category;
import com.demo.model.persitent.Workflow;


/**
 * @author Imene BELKHIR
 *
 */
@RestController
public class WorkflowController {

	static final Logger LOG = LoggerFactory.getLogger(WorkflowController.class);

	WorkflowBusiness workflowBusiness;

	
    
   /**
    *
    * @return web service returns list of all existing categories
    */
	@RequestMapping(value = "/workflowCategories", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<Category>> getWorkflowCatgories() {

		List<Category> categories = workflowBusiness.getCategories();
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}

	/**
	 * 
	 * @return web service returns list of all existing workflows
	 */
	@RequestMapping(value = "/workflows", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<Workflow>> getWorkflows() {
		LOG.info("REST request to get all workfows");
		List<Workflow> workflows = workflowBusiness.getWorkflows();
		return new ResponseEntity<>(workflows, HttpStatus.OK);
	}
	
	
	/**
	 * @param name optional
	 * @param status optional
	 * @param category_id optional
	 * @return web service returns list of workflows filtred by one, two or three criterias
	 */
	@RequestMapping(value = "/workflows/filtres", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<Workflow>> getWorkflowsByFilter(
						@RequestParam(value = "name", required = false) String name,
						@RequestParam(value = "status", required = false) Integer status,
						@RequestParam(value = "id_category", required = false) Integer id_category) {
		LOG.info("REST request to get workfows by using args => {} {} {}", name, status, id_category);
		List<Workflow> workflows = workflowBusiness.getworkflowsByFilter(name, status, id_category);
		return new ResponseEntity<>(workflows, HttpStatus.OK);
	}
	
	
	@Autowired
	public void setWorkflowBusiness(WorkflowBusiness workflowBusiness) {
		this.workflowBusiness = workflowBusiness;
	}

}
