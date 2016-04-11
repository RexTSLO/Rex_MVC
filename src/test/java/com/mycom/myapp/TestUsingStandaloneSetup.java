package com.mycom.myapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

//Not working
public class TestUsingStandaloneSetup {
	private final MockMvc mockMvc = standaloneSetup(new HomeController()).build();

    @Test
    public void validate_get_address() throws Exception {
    	String name = "Tom";
        mockMvc.perform(get("/{name}",name).accept(MediaType.APPLICATION_JSON))
        		.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("name").value(name));
        

        //.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        //.andExpect(content().contentTypeCompatibleWith("application/json"))
    }

}
