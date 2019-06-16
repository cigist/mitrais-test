package com.irwan.mitrais.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.irwan.mitrais.MitraisApplicationTests;
import com.irwan.mitrais.model.Register;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.sql.Date;

/**
 * Created by cigist on 16/06/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes=MitraisApplicationTests.class)
public class RegisterControllerTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    @Test
    public void getList() throws Exception {
        String uri = "/api/register/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Register[] reglist = super.mapFromJson(content, Register[].class);
        assertTrue(reglist.length > 0);
        System.out.println("Test Get List");
    }
    @Test
    public void doCreate() throws Exception {
        String uri = "/api/register/";
        Register register = new Register();
        register.setPhoneNumber("08858760343");
        register.setFirstname("testing");
        register.setLastname("coba");
        register.setDateOfBirth(Date.valueOf("1990-07-10"));
        register.setGender("M");
        register.setEmail("unitest@gmail.com");
        String inputJson = super.mapToJson(register);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();
    }
}
