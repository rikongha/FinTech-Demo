package com.decagon.fintech_demo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class CardControllerTests extends AbstractTest {

	

	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}



	@Test
	public void cardNotFound() throws Exception {
		
		mvc.perform(MockMvcRequestBuilders.get("/card-scheme/verify/123456xxx")).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(false));
	}

	@Test
	public void cardFound() throws Exception {
		
		mvc.perform(MockMvcRequestBuilders.get("/card-scheme/verify/45717360")).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true));
	}
	

}
