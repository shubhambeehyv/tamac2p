package com.mkyong.common;

import org.ektorp.support.TypeDiscriminator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mkyong.extras.CouchEntity;

import javax.validation.constraints.NotNull;

@TypeDiscriminator("doc.documentType == 'HealthTipsHistory'")
public class HealthTipsHistory extends CouchEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
    private String audioFilename;

    @NotNull
    private String patientDocumentId;

    @NotNull
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(style="SS")
    private DateTime lastPlayed;

    private Integer playCount = 0;

    public HealthTipsHistory() {
    }

    public HealthTipsHistory(String patientDocumentId, String audioFilename, DateTime lastPlayed) {
        this.audioFilename = audioFilename;
        this.lastPlayed = lastPlayed;
        this.patientDocumentId = patientDocumentId;
        playCount = 1;
    }

    public String getPatientDocumentId() {
        return patientDocumentId;
    }

    public void setPatientDocumentId(String patientDocumentId) {
        this.patientDocumentId = patientDocumentId;
    }

    public String getAudioFilename() {
        return audioFilename;
    }

    public void setAudioFilename(String audioFilename) {
        this.audioFilename = audioFilename;
    }

    public DateTime getLastPlayed() {
        return lastPlayed;
    }

    public void setLastPlayed(DateTime lastPlayed) {
        this.lastPlayed = lastPlayed;
        playCount++;
    }

    public Integer getPlayCount(){
        return playCount;
    }
}
