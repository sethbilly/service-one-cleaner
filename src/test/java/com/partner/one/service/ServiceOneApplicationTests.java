package com.partner.one.service;

import static org.assertj.core.api.Assertions.assertThat;
import com.partner.one.service.api.OptimizerController;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ServiceOneApplicationTests {

	@Autowired
	private OptimizerController controller;

	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

	@Test
	public void testOptimizationOne() {
		//Testing optimization for
	}

}
