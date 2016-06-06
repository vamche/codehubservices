package com.jda.codehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


//import com.classroom.services.facade.dto.entities.HomeworkListDTO;
//import com.classroom.services.facade.dto.entities.HomeworkSearchDTO;


@Controller
@RequestMapping("/foos")
public class AppController {
	
	
	//@Autowired
    //TrackingService service;
     
    @Autowired
    MessageSource messageSource;
    
    
    /*
     * This method will list all existing employees.
     
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public List<Tracking>  listEmployees() {
 
        List<Tracking> trackings = service.findAllTrackings();
    
        return trackings;
    }*/
    
 
    @RequestMapping( value = "/yo" ,method = RequestMethod.GET )
    @ResponseBody
    public String findAll(){
    	  	
    	
    	return "Some String!";
    }


}
