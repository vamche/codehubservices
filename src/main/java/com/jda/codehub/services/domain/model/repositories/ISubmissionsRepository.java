package com.jda.codehub.services.domain.model.repositories;

import java.util.List;

import com.jda.codehub.services.domain.model.Submissions;
import com.jda.codehub.services.domain.model.repositories.IBaseRepository;
import com.jda.codehub.services.domain.model.repositories.criteria.SubmissionsSearchCriteria;
import com.jda.codehub.services.facade.dto.entities.SubmissionsSearchDTO;

public interface ISubmissionsRepository extends IBaseRepository<Submissions>  {

	List<Submissions> getSubmissions(SubmissionsSearchCriteria criteria);
	
	Long getSearchResultCount(SubmissionsSearchCriteria criteria);
	
	List<Submissions> getTop5LanguageSubmissions();
	
	List<Submissions> getTop2TitleSubmissions();
	
	
	
}
