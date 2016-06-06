package com.jda.codehub.services.facade.dto.entities;

import com.jda.codehub.services.facade.dto.entities.MetadataDTO;;

public class SubmissionsDTO extends AbstractDTO<Integer> {
	
	 private Integer id;
	 private String title;
	 private MetadataDTO metadata;
	 private String source;
	 private String status;
	 private String language;
	 
	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public MetadataDTO getMetadata() {
		return metadata;
	}
	public void setMetadata(MetadataDTO metadata) {
		this.metadata = metadata;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	} 
	

}
