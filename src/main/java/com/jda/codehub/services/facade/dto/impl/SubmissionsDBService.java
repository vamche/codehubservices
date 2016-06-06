package com.jda.codehub.services.facade.dto.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jda.codehub.services.domain.model.Submissions;
import com.jda.codehub.services.domain.model.repositories.ISubmissionsRepository;
import com.jda.codehub.services.domain.model.repositories.criteria.SubmissionsSearchCriteria;
import com.jda.codehub.services.facade.dto.assembler.SubmissionsAssembler;
import com.jda.codehub.services.facade.dto.entities.SubmissionsDTO;
import com.jda.codehub.services.facade.dto.entities.SubmissionsListDTO;
import com.jda.codehub.services.facade.dto.entities.SubmissionsSearchDTO;
import com.jda.codehub.services.facade.dto.entities.SubmissionsStatsDTO;
import com.jda.codehub.services.facade.dto.entities.SubmissionsStatsDTO.LanguageDTO;
import com.jda.codehub.services.facade.dto.entities.SubmissionsStatsDTO.LevelDTO;
import com.jda.codehub.services.facade.dto.entities.SubmissionsStatsDTO.SubmissionTitleDTO;
import com.jda.codehub.services.facade.dto.interfaces.ISubmissionsService;




@Service
@Transactional
public class SubmissionsDBService implements ISubmissionsService{
	
	@Autowired
	private ISubmissionsRepository submissionsRepository;
	
	 public SubmissionsListDTO getSubmissions(
			 		SubmissionsSearchDTO searchDTO) {
		 
		 
		 	SubmissionsListDTO listDTO = new SubmissionsListDTO();
	        SubmissionsSearchCriteria criteria = new SubmissionsSearchCriteria();
	        SubmissionsAssembler.objectSearchDTO2SearchCriteria(searchDTO, criteria);
	        List<Submissions> submissions = submissionsRepository.getSubmissions(criteria);
	        Long resultCount = submissionsRepository.getSearchResultCount(criteria);
	        
	        List<SubmissionsDTO> submissionsDTOs = new ArrayList<SubmissionsDTO>();
	        for (Submissions submission : submissions) {
	            SubmissionsDTO submissionsDTO = new SubmissionsDTO();
	            SubmissionsAssembler.objectDomain2DTO(submission, submissionsDTO);
	            submissionsDTOs.add(submissionsDTO);
	        }
	        listDTO.setCount(resultCount);
	        listDTO.setPageCount(submissionsDTOs.size());
	        listDTO.setSubmissions(submissionsDTOs);
	        return listDTO;		 
		 
	    }

	 
	 
	 public SubmissionsStatsDTO getStatistics(){
		
		SubmissionsStatsDTO submissionStatsDTO = new SubmissionsStatsDTO(); 
		SubmissionsSearchCriteria criteria = new SubmissionsSearchCriteria();
		SubmissionsSearchDTO searchDTO = new SubmissionsSearchDTO();
		SubmissionsAssembler.objectSearchDTO2SearchCriteria(searchDTO, criteria);
		Long resultCount = submissionsRepository.getSearchResultCount(criteria);
		submissionStatsDTO.setTotal_submissions(resultCount);
		
		List<Submissions> submissions = submissionsRepository.getTop5LanguageSubmissions();
		
		
		List<LanguageDTO> languageDTOs = new ArrayList<LanguageDTO>();
		 for (Submissions submission : submissions) {
		    	 LanguageDTO languageDTO = submissionStatsDTO.new LanguageDTO();
		    	 String languageTitle = submission.getLanguage();
		    	 languageDTO.setLanguageTitle(languageTitle);
		    	 SubmissionsSearchCriteria criteria1 = new SubmissionsSearchCriteria();
		    	 SubmissionsSearchDTO searchDTO1 = new SubmissionsSearchDTO();
		    	 searchDTO1.setLanguage(languageTitle);
		    	 SubmissionsAssembler.objectSearchDTO2SearchCriteria(searchDTO1, criteria1);
		    	 //criteria1 = criteria1.setLanguage(languageTitle);
		    	 Long languageResultCount = submissionsRepository.getSearchResultCount(criteria1);
		    	 
		    	 
		    	 languageDTO.setLanguageCount(languageResultCount);
		    	 //SubmissionsAssembler.objectDomain2DTO(submission, submissionsDTO);
		         languageDTOs.add(languageDTO);
		 }
		 
		 submissionStatsDTO.setTop_5_languagues_used(languageDTOs);
		 
		 		 
		 List<Submissions> titleSubmissions = submissionsRepository.getTop2TitleSubmissions();
		 
		 List<SubmissionTitleDTO> titleDTOs = new ArrayList<SubmissionTitleDTO>();
		 for (Submissions submission : titleSubmissions) {
			 SubmissionTitleDTO titleDTO = submissionStatsDTO.new SubmissionTitleDTO();
	    	 String submissionTitle = submission.getTitle();
	    	 titleDTO.setSubmissionTitle(submissionTitle);
	    	 
	    	 SubmissionsSearchCriteria criteria2 = new SubmissionsSearchCriteria();
	    	 SubmissionsSearchDTO searchDTO2 = new SubmissionsSearchDTO();
	    	 searchDTO2.setTitle(submissionTitle);
	    	 SubmissionsAssembler.objectSearchDTO2SearchCriteria(searchDTO2, criteria2);
	    	 Long titleResultCount = submissionsRepository.getSearchResultCount(criteria2);
	    	 
	    	 
	    	 titleDTO.setSubmissionCount(titleResultCount);
	    	 //SubmissionsAssembler.objectDomain2DTO(submission, submissionsDTO);
	    	 titleDTOs.add(titleDTO);
		 }
		 
		 
		submissionStatsDTO.setTop_2_submissions_attempted(titleDTOs);
		
		
		List<LevelDTO> levelDTOs = new ArrayList<LevelDTO>();
		
		SubmissionsSearchCriteria criteria3 = new SubmissionsSearchCriteria();
   	 	SubmissionsSearchDTO searchDTO3 = new SubmissionsSearchDTO();
   	 	
   	 	
		
		for(int i=1;i<=3;i++){
			LevelDTO levelDTO = submissionStatsDTO.new LevelDTO();
			if(i == 1){
				searchDTO3.setMetadata("%hard%");	
				levelDTO.setLevelTitle("Hard");
			}else if(i == 2){
				searchDTO3.setMetadata("%medium%");	
				levelDTO.setLevelTitle("Medium");
			}else if(i == 3){
				searchDTO3.setMetadata("%easy%");	
				levelDTO.setLevelTitle("Easy");
			}
			
			
			SubmissionsAssembler.objectSearchDTO2SearchCriteria(searchDTO3, criteria3);
	   	 	Long levelResultCount = submissionsRepository.getSearchResultCount(criteria3);
	   	 	levelDTO.setLevelCount(levelResultCount);
	   	 	levelDTOs.add(levelDTO);
		}
		
		
		submissionStatsDTO.setSubmissions_per_level(levelDTOs);		 
		
		
		return submissionStatsDTO;
		 		 
	 }
}
