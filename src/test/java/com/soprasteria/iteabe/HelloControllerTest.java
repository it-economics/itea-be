package com.soprasteria.iteabe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Testing {@link HelloController}
 */
@WebMvcTest(HelloController.class)
class HelloControllerTest {

	@Autowired
	private MockMvc mvc;


	//Welcome to itea-be!
	@Test
	void whenIndexThenReturnOK()
			throws Exception {

		  mvc.perform(get("/")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string("Welcome to itea-be!"))
		  ;
	}

	@Test
	void whenUndefinedRouteThenReturnNotFound()
			throws Exception {

		mvc.perform(get("/undefined-route")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
		;
	}

}
