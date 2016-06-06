package com.jda.codehub.services.facade.dto.interfaces;

import com.jda.codehub.services.facade.dto.entities.SubmissionsDTO;
import com.jda.codehub.services.facade.dto.entities.SubmissionsListDTO;
import com.jda.codehub.services.facade.dto.entities.SubmissionsSearchDTO;
import com.jda.codehub.services.facade.dto.entities.SubmissionsStatsDTO;

public interface ISubmissionsService {
	
	//SubmissionsDTO getSubmissionDetails(SubmissionsSearchDTO searchDTO);
	
	SubmissionsListDTO getSubmissions(SubmissionsSearchDTO searchDTO);	
	
	SubmissionsStatsDTO getStatistics();
	

}
