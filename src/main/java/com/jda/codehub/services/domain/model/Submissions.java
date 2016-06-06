package com.jda.codehub.services.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.map.util.JSONPObject;
import org.dom4j.Text;

import com.jda.codehub.services.domain.model.AbstractEntity;

@Entity
@Table(name = "submissions")
public class Submissions extends AbstractEntity<Integer>{

	
	@Id
	@GeneratedValue
    @Column(name = "submission_id")
    private Integer id;
	
	@Column(name = "title")
    private String title;
	
	@Column(name = "metadata")
    private String metadata;
	
	@Column(name = "source")
    private String source;
	
	@Column(name = "status")
    private String status;
	
	@Column(name = "language")
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

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
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
