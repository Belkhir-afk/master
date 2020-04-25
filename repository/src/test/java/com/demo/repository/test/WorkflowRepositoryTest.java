package com.demo.repository.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.model.persitent.Category;
import com.demo.model.persitent.Workflow;
import com.demo.repository.WorkflowRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WorkflowRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private WorkflowRepository repository;

	@Test
	public void testFindAll() {
		Workflow workflow_1 = 
				new Workflow("secret_key", "a workflow for secret key",  1, new ArrayList<Category>());
		Workflow workflow_2 = 
				new Workflow("session_token", "a workflow for session", 2, new ArrayList<Category>());
		this.entityManager.persist(workflow_1);
		this.entityManager.persist(workflow_2);
		
		List<Workflow> workflows = this.repository.findAll();
		assertThat(workflows.size()).isEqualTo(2);

	}
	
	@Test
	public void testFinfByCriteria() {
		Workflow workflow_1 = 
				new Workflow("secret_key", "a workflow for secret key",  3, new ArrayList<>());
		
		Workflow workflow_2 = 
				new Workflow("session_token", "a workflow for session",  1, new ArrayList<Category>());

		this.entityManager.persist(workflow_1);
		this.entityManager.persist(workflow_2);
		
		List<Workflow> wokflows = this.repository.findByCriteria("test", null, null);
		assertThat(wokflows).isEmpty();


	}
}