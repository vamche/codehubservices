package com.jda.codehub.services.facade.dto.entities;

import java.util.List;

public class SubmissionsStatsDTO {
	
	private List<LanguageDTO> top_5_languagues_used;
	private Long total_submissions;
	private List<SubmissionTitleDTO> top_2_submissions_attempted;
	private List<LevelDTO> submissions_per_level;	

	
	public List<LanguageDTO> getTop_5_languagues_used() {
		return top_5_languagues_used;
	}




	public void setTop_5_languagues_used(List<LanguageDTO> languageDTOs) {
		this.top_5_languagues_used = languageDTOs;
	}




	public Long getTotal_submissions() {
		return total_submissions;
	}




	public void setTotal_submissions(Long total_submissions) {
		this.total_submissions = total_submissions;
	}
	
	
	

	public List<SubmissionTitleDTO> getTop_2_submissions_attempted() {
		return top_2_submissions_attempted;
	}




	public void setTop_2_submissions_attempted(List<SubmissionTitleDTO> top_2_submissions_attempted) {
		this.top_2_submissions_attempted = top_2_submissions_attempted;
	}




	public List<LevelDTO> getSubmissions_per_level() {
		return submissions_per_level;
	}




	public void setSubmissions_per_level(List<LevelDTO> submissions_per_level) {
		this.submissions_per_level = submissions_per_level;
	}




	public class LanguageDTO{
		private String languageTitle;
		private Long languageCount;
		
		
		public String getLanguageTitle() {
			return languageTitle;
		}
		public void setLanguageTitle(String languageTitle) {
			this.languageTitle = languageTitle;
		}
		public Long getLanguageCount() {
			return languageCount;
		}
		public void setLanguageCount(Long languageCount) {
			this.languageCount = languageCount;
		}	
		
	}
	
	
	public class LevelDTO{
		private String levelTitle;
		private Long levelCount;
		public String getLevelTitle() {
			return levelTitle;
		}
		public void setLevelTitle(String levelTitle) {
			this.levelTitle = levelTitle;
		}
		public Long getLevelCount() {
			return levelCount;
		}
		public void setLevelCount(Long levelCount) {
			this.levelCount = levelCount;
		}
		
		
		
	}	
	
	
	public class SubmissionTitleDTO{
		private String submissionTitle;
		private Long submissionCount;
		public String getSubmissionTitle() {
			return submissionTitle;
		}
		public void setSubmissionTitle(String submissionTitle) {
			this.submissionTitle = submissionTitle;
		}
		public Long getSubmissionCount() {
			return submissionCount;
		}
		public void setSubmissionCount(Long submissionCount) {
			this.submissionCount = submissionCount;
		}		
		
		
	}
	
	
	
	
	

}



