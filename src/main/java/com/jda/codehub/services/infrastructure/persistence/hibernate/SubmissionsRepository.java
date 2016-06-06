package com.jda.codehub.services.infrastructure.persistence.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.jda.codehub.services.domain.model.Submissions;
import com.jda.codehub.services.domain.model.repositories.ISubmissionsRepository;
import com.jda.codehub.services.domain.model.repositories.criteria.BaseSearchCriteria;
import com.jda.codehub.services.domain.model.repositories.criteria.SubmissionsSearchCriteria;
import com.jda.codehub.services.facade.dto.entities.SubmissionsSearchDTO;

@Repository
public class SubmissionsRepository extends  
						BaseRepository<Submissions, SubmissionsSearchCriteria>
						implements ISubmissionsRepository{
	
	

	public List<Submissions> getSubmissions(SubmissionsSearchCriteria criteria) {
		return searchByCriteria(criteria);	
	}

	
	public Long getSearchResultCount(SubmissionsSearchCriteria criteria) {
        return searchByCriteriaCount(criteria);
    }
	
	public List<Submissions> getTop5LanguageSubmissions(){
		CriteriaQuery<Submissions> query = getCriteriaBuilder().createQuery(getEntityClass());
		Root<Submissions> from = query.from(getEntityClass());
        query.select(from);
        List<Order> orders = new ArrayList<Order>();
        //orders.add(getCriteriaBuilder().desc(from.get("language")));
        orders.add(getCriteriaBuilder().desc(getCriteriaBuilder().count(from.get("language"))));
		query.orderBy(orders);		
		query.groupBy(from.get("language"));
		
		ProjectionList projectionList = Projections.projectionList();  
		//ProjectionList projectList = new ;
		
		
		
		return getResultListWithLimit(query,5);		
	}
	
	public List<Submissions> getTop2TitleSubmissions(){
		CriteriaQuery<Submissions> query = getCriteriaBuilder().createQuery(getEntityClass());
		Root<Submissions> from = query.from(getEntityClass());
        query.select(from);
        List<Order> orders = new ArrayList<Order>();
        //orders.add(getCriteriaBuilder().desc(from.get("language")));
        orders.add(getCriteriaBuilder().desc(getCriteriaBuilder().count(from.get("title"))));
		query.orderBy(orders);		
		query.groupBy(from.get("title"));
		
		return getResultListWithLimit(query,2);		
	}
	
	
	@Override
    protected List<Predicate> buildConditions(Root<Submissions> from,
            SubmissionsSearchCriteria criteria) {
        List<Predicate> predicateList = new ArrayList<Predicate>();
        CriteriaBuilder cb = getCriteriaBuilder();
        
  
        
        if (criteria.getTitle() != null && !"".equals(criteria.getTitle())) {
        	String title = new String(criteria.getTitle());
        	if(criteria.IsQueryBased()){
        		predicateList.add(cb.like(from.<String>get("title"), title));
        	}else{
        		predicateList.add(cb.equal(from.get("title"), title));
        	}
        }
        
        if (criteria.getLanguage() != null && !"".equals(criteria.getLanguage())) {
        	
        	String language = new String(criteria.getLanguage());
        	if(criteria.IsQueryBased()){
        		predicateList.add(cb.like(from.<String>get("language"), language));
        	}else{
        		predicateList.add(cb.equal(from.get("language"), language));
        	}       	
        	
        }
        
        if (criteria.getMetadata() != null && !"".equals(criteria.getMetadata())) {
        	String metadata = new String(criteria.getMetadata());
        	predicateList.add(cb.like(from.<String>get("metadata"), metadata));
        }
        
        return predicateList;
    }
	
}
