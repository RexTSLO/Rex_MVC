package com.mycom.myapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.jayway.jsonpath.JsonPath;

public class TestUsingWebAppContextSetUp extends ApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;
 
	private MockMvc mockMvc;

	@Before
	public void setup() {

		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.build();
	}

	@Test
	public void getDeafultTest() throws Exception {
		//List<String> name = new ArrayList<String>();
		//name.add("Tom");
		//name.add("John");
		String json = "[{name:Tom,address:Taipei,age:18},{name:John,address:Tainan,age:20}]";
		List<String> name = JsonPath.read(json, "$..name");
		//String name = JsonPath.parse(json).read("$.store.book[0].author");
		
		mockMvc.perform(get("/"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$..name").value(name));

	}
	
	@Test
	public void getsomebodyTest() throws Exception {
		String name = "Tom";
		mockMvc.perform(get("/{name}",name))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("name").value(name));
	}

}
