package com.jda.codehub.services.facade.dto.assembler;

import org.codehaus.jackson.map.util.JSONPObject;
import org.json.JSONObject;

import com.jda.codehub.services.domain.model.Submissions;
import com.jda.codehub.services.domain.model.repositories.criteria.SubmissionsSearchCriteria;
import com.jda.codehub.services.facade.dto.entities.MetadataDTO;
import com.jda.codehub.services.facade.dto.entities.SubmissionsDTO;
import com.jda.codehub.services.facade.dto.entities.SubmissionsSearchDTO;

public class SubmissionsAssembler {
	
	public SubmissionsAssembler(){
		
		
	}
	
	public static void objectDomain2DTO(Submissions obj, SubmissionsDTO dto) {
		
		JSONObject metaJSON = new JSONObject(obj.getMetadata());
		MetadataDTO metadataDTO = new MetadataDTO();
		
		String level = metaJSON.getString("level");
		int rating = (metaJSON.getInt("rating"));
		int users_attempted = (metaJSON.getInt("users_attempted"));
		
		metadataDTO.setLevel(level);
		metadataDTO.setRating(rating);
		metadataDTO.setUsers_attempted(users_attempted);
		
		dto.setId(obj.getId());
		dto.setTitle(obj.getTitle());
		dto.setMetadata(metadataDTO);
		dto.setSource(obj.getSource());
		dto.setStatus(obj.getStatus());
		dto.setLanguage(obj.getLanguage());
		
	}
	
	 public static void objectSearchDTO2SearchCriteria(SubmissionsSearchDTO dto,
	            SubmissionsSearchCriteria criteria) {
		 
		 	
		 	System.out.println(dto.getTitle() + dto.getLanguage() + dto.getMetadata());
		 
	        criteria.setTitle(dto.getTitle());
	        criteria.setLanguage(dto.getLanguage());
	        criteria.setMetadata(dto.getMetadata());
	        criteria.setIsQueryBased(dto.getIsQueryBased());
	        // TO DO Add Criteria	        
	        
	        if (dto.getPageNumber() != null && dto.getPageSize() != null) {
	            criteria.setStartIndex((dto.getPageNumber() - 1)
	                    * dto.getPageSize());
	            criteria.setPageSize(dto.getPageSize());
	        }
	        if (dto.getOrderBy() != null && !"".equals(dto.getOrderBy())) {
	            criteria.setOrderField(dto.getOrderBy());
	        } else {
	            criteria.setOrderField("title");
	        }
	        if (dto.getAscOrDesc() != null && !"".equals(dto.getAscOrDesc())) {
	            criteria.setOrderType(dto.getAscOrDesc());
	        } else {
	            criteria.setOrderType("desc");
	        }
	    }

}
