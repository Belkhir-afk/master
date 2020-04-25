package com.demo.model.persitent;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "workflow_category", schema="demo")
public class Category implements Serializable {


	public Category() {
		super();
	}




	public Category(String name, String description, String logo, Integer status, List<Workflow> workflows) {
		super();
		this.name = name;
		this.description = description;
		this.logo = logo;
		this.status = status;
		this.workflows = workflows;
	}




	private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "CATEGORY_ID_GENERATOR", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    		parameters = {
            @Parameter(name = "sequence_name", value = "demo.CATEGORY_ID_SEQ")})
    @GeneratedValue(generator = "CATEGORY_ID_GENERATOR")
    private Integer category_id;
    private String name;
    private String description;
    private String logo;
    private Integer status;

    
    

	public Integer getCategory_id() {
		return category_id;
	}




	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}




	public String getLogo() {
		return logo;
	}




	public void setLogo(String logo) {
		this.logo = logo;
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




	public List<Workflow> getWorkflows() {
		return workflows;
	}




	public void setWorkflows(List<Workflow> workflows) {
		this.workflows = workflows;
	}




	@JsonIgnore
	@ManyToMany(mappedBy = "categories")
	private List<Workflow> workflows;

}
