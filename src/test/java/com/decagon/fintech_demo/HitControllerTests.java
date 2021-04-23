package com.decagon.fintech_demo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class HitControllerTests extends AbstractTest {

	

	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}



	@Test
	public void getHits() throws Exception {
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("start", "1");
		params.add("limit", "20");
		mvc.perform(MockMvcRequestBuilders.get("/card-scheme/stats").queryParams(params)).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true));
	}

	
	

}
