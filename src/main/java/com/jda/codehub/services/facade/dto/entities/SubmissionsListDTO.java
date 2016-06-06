package com.jda.codehub.services.facade.dto.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonRootName;


@JsonRootName(value = "submissions")
@JsonPropertyOrder({"submissions","count", "pageCount" })
public class SubmissionsListDTO extends AbstractListDTO<SubmissionsDTO> {
	
	private Integer pageCount;
    private String errorCode;
    /**
     * Gets the attendances.
     * 
     * @return the attendances
     */
    public List<SubmissionsDTO> getSubmissions() {
        return getList();
    }

    /**
     * Sets the attendances.
     * 
     * @param attendances
     *            the attendances
     */
    public void setSubmissions(List<SubmissionsDTO> submissions) {
        setList(submissions);
    }

    /**
     * Gets the page count.
     * 
     * @return the page count
     */
    public Integer getPageCount() {
        return pageCount;
    }

    /**
     * Sets the page count.
     * 
     * @param pageCount
     *            the page count
     */
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
