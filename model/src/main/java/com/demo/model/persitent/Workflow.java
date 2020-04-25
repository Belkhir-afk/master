package com.demo.model.persitent;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name = "workflow", schema = "demo")
public class Workflow implements Serializable {
	
	
	public Workflow() {
		super();
	}


	public Workflow(String name, String description, Integer status, List<Category> categories) {
		super();
		this.name = name;
		this.description = description;
		this.status = status;
		this.categories = categories;
	}


	private static final long serialVersionUID = 1L;
	

    @Id
    @GenericGenerator(name = "WORKFLOW_ID_GENERATOR", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    		parameters = {
            @Parameter(name = "sequence_name", value = "demo.WORKFLOW_ID_SEQ")})
    @GeneratedValue(generator = "WORKFLOW_ID_GENERATOR")
	private Integer workflow_id;

	private String name;

	private String description;

	private Integer status;


	 public Integer getWorkflow_id() {
		return workflow_id;
	}


	public void setWorkflow_id(Integer workflow_id) {
		this.workflow_id = workflow_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public List<Category> getCategories() {
		return categories;
	}


	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}


	@ManyToMany() @JoinTable(name = "work_cat", schema = "demo", joinColumns = {
	 @JoinColumn(name = "workflow_id") }, inverseJoinColumns = { @JoinColumn(name
	                   = "category_id") }) 
	 private List<Category> categories;
	 


}
