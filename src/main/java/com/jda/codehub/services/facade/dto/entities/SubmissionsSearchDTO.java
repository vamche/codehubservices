package com.jda.codehub.services.facade.dto.entities;

public class SubmissionsSearchDTO {
	
	private Integer id;
	private String title;
	private String metadata;
	private String source;
	private String status;
	private String language;
		
	private String orderBy = "title";
    private String ascOrDesc = "asc";
    private Integer pageNumber;
    private Integer pageSize;
    
    private Boolean isQueryBased = false;
    
    
	public Boolean getIsQueryBased() {
		return isQueryBased;
	}
	public void setIsQueryBased(Boolean isQueryBased) {
		this.isQueryBased = isQueryBased;
	}
	
	
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
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getAscOrDesc() {
		return ascOrDesc;
	}
	public void setAscOrDesc(String ascOrDesc) {
		this.ascOrDesc = ascOrDesc;
	}
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
    
    
    


}
