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
import com.demo.repository.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CategoryRepository repository;

	@Test
	public void testFindAll() {
		Category categorie_1 = 
				new Category("process_workflow", "a category for process", "process.png", 1, new ArrayList<Workflow>());
		categorie_1 = this.entityManager.persist(categorie_1);
		List<Category> categories = this.repository.findAll();
		assertThat(categories.get(0).getLogo()).isEqualTo("process.png");

	}
}