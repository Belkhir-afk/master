package com.demo.rest.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.business.WorkflowBusiness;
import com.demo.model.persitent.Category;
import com.demo.model.persitent.Workflow;
import com.demo.repository.CategoryRepository;
import com.demo.repository.WorkflowRepository;
import com.demo.rest.WorkflowController;


@RunWith(SpringRunner.class)
@WebMvcTest(WorkflowController.class)
@AutoConfigureMockMvc
public class WorkflowControllerTest {
    @Inject
    private MockMvc mvc;

    @MockBean
    private WorkflowBusiness workflowBusiness;
    
    @MockBean
    private WorkflowRepository workflowRepository;
    
    @MockBean
    private CategoryRepository categoryRepository;


    @Test
    public void getWorkflowCatgoriesTest() throws Exception {
        when(workflowBusiness.getCategories()).thenReturn(new ArrayList<>());
        mvc.perform(get("/workflowCategories").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getWorkflowsTest() throws Exception {
    	List<Workflow> workflows = new ArrayList<Workflow>();
    	workflows.add(new Workflow("Access_key_id", "a workflow for access",  1, new ArrayList<Category>()));
        when(workflowBusiness.getWorkflows()).thenReturn(workflows);
        mvc.perform(get("/workflows").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }

    
    @Test
    public void getWorkflowsByFilterTest() throws Exception {
    	List<Workflow> workflows = new ArrayList<Workflow>();
    	workflows.add(new Workflow("session_token", "a workflow for session",  1, new ArrayList<Category>()));
        when(workflowBusiness.getworkflowsByFilter(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(workflows);
        mvc.perform(get("/workflows/filtres").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }

}
