package com.jda.codehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jda.codehub.services.facade.dto.entities.SubmissionsListDTO;
import com.jda.codehub.services.facade.dto.entities.SubmissionsSearchDTO;
import com.jda.codehub.services.facade.dto.entities.SubmissionsStatsDTO;
import com.jda.codehub.services.facade.dto.interfaces.ISubmissionsService;

@Controller
@RequestMapping("/submissions")
public class SubmissionsController {


	@Autowired
	private ISubmissionsService service;
     
    @Autowired
    MessageSource messageSource;
    
    //@CrossOrigin(origins = "*")
    @RequestMapping( value = "/list/{pageNumber}" ,method = RequestMethod.GET)
    @ResponseBody
    public SubmissionsListDTO getSubmissions(@PathVariable("pageNumber") Integer pageNumber ){
    	System.out.println("page  " + pageNumber);
    	SubmissionsListDTO listDTO = new SubmissionsListDTO(); 	
    	
    	SubmissionsSearchDTO searchDTO = new SubmissionsSearchDTO();
    	searchDTO.setPageNumber(pageNumber);
    	searchDTO.setPageSize(10);
    	
    	listDTO = service.getSubmissions(searchDTO);
    	
    	return listDTO;
    }
    
    //@CrossOrigin(origins = "*")
    @RequestMapping( value = "/stats" ,method = RequestMethod.GET)
    @ResponseBody
    public SubmissionsStatsDTO getStatistics(){
    	
    	SubmissionsStatsDTO statsDTO = new SubmissionsStatsDTO(); 	
    	
    	statsDTO = service.getStatistics();
    	
    	return statsDTO;
    }
    
    //@CrossOrigin(origins = "*")
    @RequestMapping( value = "/search/{query}/{page}" ,method = RequestMethod.GET)
    @ResponseBody
    public SubmissionsListDTO getSubmissionsListByQuery(@PathVariable String query,@PathVariable Integer page){
    	
    	SubmissionsListDTO listDTO = new SubmissionsListDTO(); 	
    	
    	SubmissionsSearchDTO searchDTO = new SubmissionsSearchDTO();
    	
    	searchDTO.setIsQueryBased(true);
    	searchDTO.setTitle(query);
    	searchDTO.setMetadata(query);
    	searchDTO.setLanguage(query);
    	searchDTO.setPageNumber(page);
    	searchDTO.setPageSize(10);
    	
    	listDTO = service.getSubmissions(searchDTO);
    	
    	return listDTO;
    }
    
    @RequestMapping( value = "/list100?page={num}" ,method = RequestMethod.GET)
    @ResponseBody
    public SubmissionsListDTO getSubmits(@PathVariable Integer num){
    	
    	SubmissionsListDTO listDTO = new SubmissionsListDTO(); 	
    	
    	SubmissionsSearchDTO searchDTO = new SubmissionsSearchDTO();
    	searchDTO.setPageNumber(num);
    	searchDTO.setPageSize(10);
    	
    	listDTO = service.getSubmissions(searchDTO);
    	
    	return listDTO;
    }
    
}
