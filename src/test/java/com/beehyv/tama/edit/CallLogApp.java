package com.beehyv.tama.edit;

import static org.apache.commons.lang.StringUtils.join;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ektorp.CouchDbConnector;
import org.hibernate.Session;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.motechproject.appointments.api.model.AppointmentCalendar;
import org.motechproject.appointments.api.model.Visit;
import org.motechproject.appointments.api.repository.AllAppointmentCalendars;
import org.motechproject.tama.ivr.repository.AllCallLogs;
import org.motechproject.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mkyong.common.CallLogH.CallEvent;
import com.mkyong.common.CallLogH.CallLog;
import com.mkyong.common.CallLogH.DataMap;
import com.mkyong.common.CallLogH.DataMapId;
import com.mkyong.persistence.HibernateUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/applicationContext.xml" })
public class CallLogApp {

	public static Session session = HibernateUtil.getSessionFactory()
			.openSession();
	@Autowired
	private AllCallLogs allCallLogs;

	@Autowired
	CouchDbConnector tamaDbConnector;

	@Test
	 public void test(){
		 AllAppointmentCalendars allAppointmentCalendars = new AllAppointmentCalendars(tamaDbConnector);
		 for (AppointmentCalendar item : allAppointmentCalendars.getAll()){
			for (Visit visit: item.visits()){
				Map<String, Object> map = visit.getData();
				for(String key: map.keySet()){
					try{
						String className = map.get(key).getClass().getName();
						if(className.equals("java.util.ArrayList")){
							List arrayList = (List)map.get(key);
							System.out.println(arrayList.get(0).getClass().getName());
						}
					System.out.println();}
					
					catch(Exception e){
						System.out.println("Exception");
					}
				}
			
			}
		 }
		 LocalDate start = new LocalDate(2013, 1, 1);
		 LocalDate end = new LocalDate(2014, 1, 1);
		 DateTime startkey = DateUtil.newDateTime(start);
		 DateTime endkey = DateUtil.newDateTime(end);
		 System.out.println("Maven + Hibernate + MySQL" );
		 List<org.motechproject.tama.ivr.domain.CallLog> listCallLog = allCallLogs.findAllCallLogsForDateRange(startkey, endkey, 100000, null);
	     session.beginTransaction();
	     System.out.println(listCallLog.size()+"\n\n");
	     for (org.motechproject.tama.ivr.domain.CallLog item : listCallLog ){
	    	 setSQLCallLog(item);
	     }
	     session.getTransaction().commit();
	     session.close();
	     
	     
}

	public List<CallEvent> setSQLCallEvent(
			List<org.motechproject.ivr.event.CallEvent> callEvents) {
		List<CallEvent> hCallEvents = new ArrayList<CallEvent>();
		for (org.motechproject.ivr.event.CallEvent item : callEvents) {
			CallEvent hCallEvent = new CallEvent();
			hCallEvent.setName(item.getName());
			hCallEvent.setTimeStamp(item.getTimeStamp());
			session.save(hCallEvent);
			Set<String> keys = item.getData().getData().keySet();

			for (String key : keys) {
				DataMap hMap = new DataMap();
				DataMapId hMapId = new DataMapId();
				hMapId.setKey(key);
				hMap.setValue(join(item.getData().getAll(key), ", "));
				hMap.setId(hMapId);

				hMapId.setCallEvent(hCallEvent);
				session.save(hMap);
			}

			hCallEvents.add(hCallEvent);

		}
		return hCallEvents;

	}

	public void setSQLCallLog(org.motechproject.tama.ivr.domain.CallLog callLog) {
		CallLog hCallLog = new CallLog();
		hCallLog.setId(callLog.getId());
		hCallLog.setRevision(callLog.getRevision());
		hCallLog.setType(callLog.getDocumentType());
		hCallLog.setCallDirection(callLog.getCallDirection().toString());
		hCallLog.setCallId(callLog.getCallId());
		hCallLog.setCallLanguage(callLog.callLanguage());
		hCallLog.setEndTime(callLog.getEndTime());
		hCallLog.setLikelyPatientIds(join(callLog.getLikelyPatientIds(), ", "));
		hCallLog.setPatientDocumentId(callLog.getPatientDocumentId());
		hCallLog.setPatientId(callLog.patientId());
		hCallLog.setPhoneNumber(callLog.getPhoneNumber());
		hCallLog.setStartTime(callLog.getStartTime());
		session.save(hCallLog);
		hCallLog.setCallEvents(setSQLCallEvent(callLog.getCallEvents()));
		session.save(hCallLog);

	}

}