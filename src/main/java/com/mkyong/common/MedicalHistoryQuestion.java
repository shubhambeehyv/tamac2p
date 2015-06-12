package com.mkyong.common;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table
public class MedicalHistoryQuestion {
	
	@Id
	@GeneratedValue
	@Getter
	@Setter
	private Integer id;
	

    private String question;

    private boolean historyPresent;

    private boolean requiresComment;

    private String comments;
    @ManyToOne
    private NonHIVMedicalHistory nonHIVMedicalHistory;
    

    public MedicalHistoryQuestion(String question, boolean requiresComment) {
        this.question = question;
        this.requiresComment = requiresComment;
    }

    public MedicalHistoryQuestion() {
    }

    public boolean isRequiresComment() {
        return requiresComment;
    }

    public void setRequiresComment(boolean requiresComment) {
        this.requiresComment = requiresComment;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public boolean isHistoryPresent() {
        return historyPresent;
    }

    public void setHistoryPresent(boolean historyPresent) {
        this.historyPresent = historyPresent;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
