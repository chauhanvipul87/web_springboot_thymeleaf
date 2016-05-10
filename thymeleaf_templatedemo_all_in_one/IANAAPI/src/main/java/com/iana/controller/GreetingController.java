package com.iana.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iana.config.DBConnectionProperiesToBean;
import com.iana.model.Greeting;
import com.iana.services.GreetingService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class GreetingController {
 
	/*http://www.codeproject.com/Articles/820877/Support-Both-Json-and-XML-Serializations-in-Spring*/ 
	
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    private static final Logger log = LoggerFactory.getLogger(GreetingController.class);
 
    @Autowired
	private DBConnectionProperiesToBean dbbean;
    
    @Value("${projectName}")
	private String projectName;
	
	@Value("${application.message:Hello Vipul}")
	private String message;
	
    
    @Autowired
    private GreetingService greetingService;
    
    @ApiOperation(value = "getGreeting", nickname = "getGreeting")
    @RequestMapping(method = RequestMethod.GET, path="/greeting", produces={"application/json", "application/xml"})
    @ApiImplicitParams({
        @ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query", defaultValue="Niklas")
      })
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Greeting.class),
            @ApiResponse(code = 401, message = "Unauthorized")
    }) 
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) throws Exception{
    	
    	  	log.error("Message logged at ERROR level");
    	    log.warn("Message logged at WARN level");
    	    log.info("Message logged at INFO level");
    	    log.debug("Message logged at DEBUG level");
    	    
    	    log.info("UIIA datasrouce :: "+greetingService.getConnectedDatabaseProductName());
    	    log.info("UIIA datasrouce :: "+greetingService.getUserDetailsFromUIIA());
    	    log.info("EQUIP datasrouce :: "+greetingService.getUserDetailsFromEquipReturn());
    	    log.info("GIER datasrouce :: "+greetingService.getUserDetailsFromGIER());
    	    
    	    
    	  //Read Database connection properties value
    		System.out.println("Class Name         :"+dbbean.getClassName());
    		System.out.println("getAcquireIncrement:"+dbbean.getAcquireIncrement());
    		System.out.println("getMaxPoolSize     :"+dbbean.getMaxPoolSize());
    		System.out.println("getMinPoolSize     :"+dbbean.getMinPoolSize());
    		System.out.println("getMaxStatements   :"+dbbean.getMaxStatements());
    		//important to fetch list,map from properties file
    		System.out.println("getListProp		   :"+dbbean.getListProp());
    		System.out.println("getMapProp		   :"+dbbean.getMapProp());
    		
    		//Variable Value
    		System.out.println("projectName		   :"+projectName);
    		System.out.println("message		   :"+message);
    	
        return new Greeting(counter.incrementAndGet(),String.format(template, greetingService.getConnectedDatabaseProductName()));
    }
}