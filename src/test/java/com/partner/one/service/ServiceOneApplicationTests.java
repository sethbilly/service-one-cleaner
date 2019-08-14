package com.partner.one.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.partner.one.service.api.OptimizerController;
import com.partner.one.service.models.CleanRequest;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ServiceOneApplicationTests {

	@Autowired
	private OptimizerController controller;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	@Test
	public void testOptimizationOne() throws Exception{
		//Test result for first input to match output
		CleanRequest request = new CleanRequest();
		request.setSenior(10);
		request.setJunior(6);
		List<Integer> rooms = new ArrayList<>();
		rooms.add(35);
		rooms.add(21);
		rooms.add(17);
		rooms.add(28);
		request.setRooms(rooms);

		String inputJson = this.mapToJson(request);
		MvcResult result = this.mockMvc.perform(post("/optimize").contentType(MediaType.APPLICATION_JSON).content(inputJson))
				.andExpect(status().isOk()).andReturn();
		String content = result.getResponse().getContentAsString();
		Assert.assertEquals(content, "[{\"senior\":3,\"junior\":1},{\"senior\":1,\"junior\":2},{\"senior\":2,\"junior\":0},{\"senior\":1,\"junior\":3}]");

	}

	@Test
	public void testOptimizationTwo() throws Exception {
		//Test result for second input to match output
		CleanRequest request = new CleanRequest();
		request.setSenior(11);
		request.setJunior(6);
		List<Integer> rooms = new ArrayList<>();
		rooms.add(24);
		rooms.add(28);
		request.setRooms(rooms);

		String inputJson = this.mapToJson(request);
		MvcResult result = this.mockMvc.perform(post("/optimize").contentType(MediaType.APPLICATION_JSON).content(inputJson))
				.andExpect(status().isOk()).andReturn();
		String content = result.getResponse().getContentAsString();
		Assert.assertEquals(content, "[{\"senior\":2,\"junior\":1},{\"senior\":2,\"junior\":1}]");
	}

}
