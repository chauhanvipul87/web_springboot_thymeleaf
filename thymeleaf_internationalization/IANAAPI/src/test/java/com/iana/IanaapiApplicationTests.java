package com.iana;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.iana.config.IANAAPIApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = IANAAPIApplication.class)
@WebAppConfiguration
public class IanaapiApplicationTests {

	@Test
	public void contextLoads() {
	}

}
