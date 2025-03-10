

package com.soprasteria.iteabe;

import org.junit.jupiter.api.Test;
import org.springframework.boot.builder.SpringApplicationBuilder;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class ServletInitializerTest {

	@Test
	void testConfigure() {
		ServletInitializer servletInitializer = new ServletInitializer();
		SpringApplicationBuilder builder = mock(SpringApplicationBuilder.class);
		when(builder.sources(DemoApplication.class)).thenReturn(builder);

		SpringApplicationBuilder result = servletInitializer.configure(builder);

		assertNotNull(result);
		verify(builder).sources(DemoApplication.class);
	}
}