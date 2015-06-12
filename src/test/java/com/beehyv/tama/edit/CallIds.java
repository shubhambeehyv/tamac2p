package com.beehyv.tama.edit;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.motechproject.tama.facility.repository.AllMonitoringAgents;
import org.motechproject.tama.ivr.repository.AllCallLogs;
import org.motechproject.tama.refdata.objectcache.AllCitiesCache;
import org.motechproject.tama.patient.repository.AllPatients;
import org.motechproject.tama.refdata.objectcache.AllIVRLanguagesCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mkyong.common.Ailment;
import com.mkyong.common.Ailments;
import com.mkyong.common.AllergyHistory;
import com.mkyong.common.HIVTestReason;
import com.mkyong.common.MedicalHistoryQuestion;
import com.mkyong.common.ModeOfTransmission;
import com.mkyong.common.MonitoringAgent;
import com.mkyong.common.NonHIVMedicalHistory;
import com.mkyong.common.OtherAilment;
import com.mkyong.common.Stock;
import com.mkyong.common.SystemCategory;
import com.mkyong.extras.TimeOfDay;
import com.mkyong.persistence.HibernateUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/applicationContext.xml" })
public class CallIds
{
	public static int patientCount =0;
	public static List<com.mkyong.common.Gender> hGenderList = new ArrayList<com.mkyong.common.Gender>();
	public static List<com.mkyong.common.Clinic> hClinicList = new ArrayList<com.mkyong.common.Clinic>();
	public static List<com.mkyong.common.City> hCityList = new ArrayList<com.mkyong.common.City>();
	public static List<com.mkyong.common.IVRLanguage> hIVRLanguageList = new ArrayList<com.mkyong.common.IVRLanguage>();
	public static List<HIVTestReason> hHIVTestReasonList = new ArrayList<HIVTestReason>();
	public static List<ModeOfTransmission> hModeOfTransmissionList  = new ArrayList<ModeOfTransmission>();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static List<Ailments> hAilmentsList = new ArrayList<Ailments>();
	public static Session session = HibernateUtil.getSessionFactory().openSession();
	public static int countEx = 0;
	public static int cPPEx = 0;
	public static int cityEx = 0;
	public static int cMedHis = 0;
	@Autowired
	 AllCallLogs allCallLogs;
	 @Autowired
	 AllPatients allPatients;
	 @Autowired 
	 AllIVRLanguagesCache allIVRLanguages;
	 @Autowired
	 AllCitiesCache allCities;
	 
	 @Autowired
	 AllMonitoringAgents allAgents;

	 

	 @Test
	 public void test(){
		/* System.out.println("Maven + Hibernate + MySQL"+"  "+allCities );
	     session.beginTransaction();
	     setAllMonitoringAgents();
	    System.out.println("All Patients size   "+allPatients.getAll().size()+"\n\n\n");
		 for (org.motechproject.tama.patient.domain.Patient patient: allPatients.getAll()){
			 setSQLPatient(patient, allCities);
		 }
		 System.out.println("Count Patient Exception "+countEx);
		 System.out.println("Count City Exception  "+cityEx);
		 System.out.println("Count PPException "+cPPEx);
		 System.out.println("Count MedHistory Exc   "+cMedHis);
		 session.getTransaction().commit();*/
	 }
	
	
    public static void main1()
    
    {
    	
    	
        System.out.println("Maven + Hibernate + MySQL");
       
        
        session.beginTransaction();
        /*Stock stock = new Stock();
        TimeOfDay time = new TimeOfDay();
        
        stock.setStockCode("4715");
        stock.setStockName("GENM"
        		);
        stock.setBestCallTime(time);
        Department department = new Department("java");
        List<Employee> depEmployees= new ArrayList<Employee>();
        depEmployees.add(new Employee("Jakab Gipsz",department, "dgh"));
        depEmployees.add(new Employee("Captain Nemo",department, "dhgdh"));*/
        
      
       
        //session.save(new Patient("test"));
        
       
        
        
        //session.delete(stock);
        
        session.getTransaction().commit();
        System.out.print("Done");
        
        
        
        
    }
    public static com.mkyong.common.City setSQLCity(org.motechproject.tama.refdata.domain.City city, org.motechproject.tama.facility.domain.Clinic clinic, AllCitiesCache allCities1){
		
	try{
    	for (com.mkyong.common.City item : hCityList){
    		if (item.getId().equals(clinic.getCityId())){
    			return item;
    		}
    	}
    	com.mkyong.common.City hCity = new com.mkyong.common.City(clinic.getCityId());
	System.out.println("city set from Clinic");
	org.motechproject.tama.refdata.domain.City city1 = allCities1.getBy(clinic.getCityId());
    	hCity.setRevision(city1.getRevision());
    	hCity.setType(city1.getDocumentType());
    	hCity.setDocumentType(city1.getDocumentType());
    	hCity.setName(city1.getName());
    	System.out.println("Saving city with ");
    	session.save(hCity);
	hCityList.add(hCity);
    	return hCity;}
	catch(Exception e){
		e.printStackTrace();
	System.out.println("City null");
	cityEx++;
        }
	try{
        for (com.mkyong.common.City item : hCityList){
                if (item.getId().equals(city.getId())){
                        return item;
                }
        }
        com.mkyong.common.City hCity = new com.mkyong.common.City(clinic.getCityId());
	org.motechproject.tama.refdata.domain.City city1 = allCities1.getBy(clinic.getCityId());
        System.out.println("city set from AllCities");
        hCity.setRevision(city1.getRevision());
        hCity.setType(city1.getDocumentType());
        hCity.setDocumentType(city1.getDocumentType());
        hCity.setName(city1.getName());
        session.save(hCity);
        hCityList.add(hCity);
        return hCity;}
        catch(Exception e){
        System.out.println("City null");
        }
	return null;

    	
    			
    }
    public static com.mkyong.common.Gender setSQLGender(org.motechproject.tama.refdata.domain.Gender gender){
    	for (com.mkyong.common.Gender item : hGenderList){
    		if (item.getId().equals(gender.getId())){
    			return item;
    		}
    	}
    	com.mkyong.common.Gender hGender = new com.mkyong.common.Gender();
    	hGender.setId(gender.getId());
    	hGender.setRevision(gender.getRevision());
    	hGender.setType(gender.getType());
    	hGender.setDocumentType(gender.getDocumentType());
    	hGenderList.add(hGender);
    	session.save(hGender);
    	return hGender;
    	
    	
    	
    	
    }
    public static com.mkyong.common.IVRLanguage setSQLIVRLanguage(org.motechproject.tama.refdata.domain.IVRLanguage iVRLanguage){
    	for (com.mkyong.common.IVRLanguage item : hIVRLanguageList){
    		if(item.getId().equals(iVRLanguage.getId())){
    			return item;
    		}
    	}
    	com.mkyong.common.IVRLanguage hIVRLanguage = new com.mkyong.common.IVRLanguage();
    	hIVRLanguage.setId(iVRLanguage.getId());
    	hIVRLanguage.setRevision(iVRLanguage.getRevision());
    	hIVRLanguage.setType(iVRLanguage.getDocumentType());
    	hIVRLanguage.setDocumentType(iVRLanguage.getDocumentType());
    	hIVRLanguage.setCode(iVRLanguage.getCode());
    	hIVRLanguage.setName(iVRLanguage.getName());
    	hIVRLanguageList.add(hIVRLanguage);
    	session.save(hIVRLanguage);
    	return hIVRLanguage;
    	
    }
    
    public static com.mkyong.common.PatientPreferences setSQLPatientPreferences(org.motechproject.tama.patient.domain.PatientPreferences patientPreferences){
    	
    	com.mkyong.common.PatientPreferences hPatientPreferences = new com.mkyong.common.PatientPreferences();
    	
    	hPatientPreferences.setPasscode(patientPreferences.getPasscode());
    	hPatientPreferences.setIvrLanguage(setSQLIVRLanguage(patientPreferences.getIvrLanguage()));
    	hPatientPreferences.setCallPreference(patientPreferences.getCallPreference().toString());
    	try{
    		
    	
    	
    	hPatientPreferences.setDayOfWeeklyCall(patientPreferences.getDayOfWeeklyCall().toString());
    	}catch(Exception e){
    		e.printStackTrace();
    		cPPEx++;
    	}
    
    	
    	com.mkyong.extras.TimeOfDay hBestCallTime = new com.mkyong.extras.TimeOfDay();
    	org.motechproject.tama.common.domain.TimeOfDay bestcallTime = patientPreferences.getBestCallTime();
    	hBestCallTime.setHour(bestcallTime.getHour());
    	hBestCallTime.setMinute(bestcallTime.getMinute());
    	hBestCallTime.setTimeMeridiem(bestcallTime.getTimeMeridiem().toString());
    	session.save(hBestCallTime);
    	hPatientPreferences.setBestCallTime(hBestCallTime);
    	hPatientPreferences.setReceiveOTCAdvice(patientPreferences.getReceiveOTCAdvice());
    	hPatientPreferences.setActivateAppointmentReminders(patientPreferences.getActivateAppointmentReminders());
    	hPatientPreferences.setCallPreferenceTransitionDate(patientPreferences.getCallPreferenceTransitionDate());
    	session.save(hPatientPreferences);
    	System.out.println("Patient P saved");
    	return hPatientPreferences;
    	
    	
    
    
    	
    	
    	
    	
    }
    public void setAllMonitoringAgents(){
    	System.out.println(allAgents.getAll().size()+"\n\n\n");
    	for (org.motechproject.tama.facility.domain.MonitoringAgent item : allAgents.getAll()){
    		MonitoringAgent hMonitoringAgent = new MonitoringAgent();
    		hMonitoringAgent.setId(item.getId());
    		hMonitoringAgent.setRevision(item.getRevision());
    		hMonitoringAgent.setDocumentType(item.getDocumentType());
    		hMonitoringAgent.setType(item.getDocumentType());
    		hMonitoringAgent.setName(item.getName());
    		hMonitoringAgent.setContactNumber(item.getContactNumber());
    		session.save(hMonitoringAgent);
    	}
    }
    public static com.mkyong.common.Clinic setSQLClinic(org.motechproject.tama.facility.domain.Clinic clinic, AllCitiesCache allCities1){
	
	System.out.println("Before For Loop");
		System.out.println(hClinicList.size());
    	for(com.mkyong.common.Clinic item: hClinicList){

    		if (item.getId().equals(clinic.getId())){
    			return item;
    		}
		else{
			System.out.println(item.getId()+"     "+clinic.getId());}

    	}
    	com.mkyong.common.Clinic hClinic = new com.mkyong.common.Clinic(clinic.getId());
    	hClinic.setRevision(clinic.getRevision());
    	hClinic.setType("Clinic");
    	hClinic.setDocumentType(clinic.getDocumentType());
    	hClinic.setName(clinic.getName());
    	hClinic.setGreetingName(clinic.getGreetingName());
    	hClinic.setAddress(clinic.getAddress());
    	hClinic.setPhone(clinic.getPhone());
    	String monitorId = clinic.getMonitoringAgentId();
    	try{
    		monitorId = clinic.getMonitoringAgent().getId();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	MonitoringAgent hMonitoringAgent = (MonitoringAgent)session.get(MonitoringAgent.class,monitorId);
    	hClinic.setMonitoringAgent(hMonitoringAgent);
    	session.save(hClinic);
    	List<com.mkyong.common.ClinicianContact> hClinicianContacts = new ArrayList<com.mkyong.common.ClinicianContact>();
    	List<org.motechproject.tama.facility.domain.Clinic.ClinicianContact> clinicianContacts = clinic.getClinicianContacts();
    	for(org.motechproject.tama.facility.domain.Clinic.ClinicianContact item: clinicianContacts){
    		//Clinician contact changed
    		com.mkyong.common.ClinicianContact hClinicianContact = new com.mkyong.common.ClinicianContact(hClinic);
    		hClinicianContact.setId(item.getId());
    		hClinicianContact.setName(item.getName());
    		hClinicianContact.setPhoneNumber(item.getPhoneNumber());
    		
    		session.save(hClinicianContact);
    		hClinicianContacts.add(hClinicianContact);
    	}
    	hClinic.setClinicianContacts(hClinicianContacts);
    	hClinic.setCity(setSQLCity(clinic.getCity(), clinic, allCities1));
    	hClinicList.add(hClinic);
    	session.save(hClinic);
    	return hClinic;
    	
    	
    	
    }
    
   public static com.mkyong.common.HIVTestReason setSQLHIVTestReason(org.motechproject.tama.refdata.domain.HIVTestReason hivTestReason){
	
	  for(HIVTestReason item: hHIVTestReasonList){
		  if(item.getId().equals(hivTestReason.getId())){
			  return item;
		  }
	  }
	  com.mkyong.common.HIVTestReason hHIVTestReason = new HIVTestReason();
	  hHIVTestReason.setId(hivTestReason.getId());
	  hHIVTestReason.setRevision(hivTestReason.getRevision());
	  hHIVTestReason.setDocumentType(hivTestReason.getDocumentType());
	  hHIVTestReason.setType(hivTestReason.getDocumentType());
	  hHIVTestReason.setName(hivTestReason.getName());
	  hHIVTestReasonList.add(hHIVTestReason);
	  session.save(hHIVTestReason);
	  return hHIVTestReason;
	  
	  
	   
	   
   }
   public static ModeOfTransmission setSQLModeOfTransmission(org.motechproject.tama.refdata.domain.ModeOfTransmission modeOfTransmission){
	   for (ModeOfTransmission item : hModeOfTransmissionList){
		   if(item.getId().equals(modeOfTransmission.getId())){
			   return item;
		   }
	   }
	   ModeOfTransmission hModeOfTransmission = new ModeOfTransmission();
	   hModeOfTransmission.setId(modeOfTransmission.getId());
	   hModeOfTransmission.setRevision(modeOfTransmission.getRevision());
	   hModeOfTransmission.setDocumentType(modeOfTransmission.getDocumentType());
	   hModeOfTransmission.setType(modeOfTransmission.getType());
	   hModeOfTransmissionList.add(hModeOfTransmission);
	   session.save(hModeOfTransmission);
	   return hModeOfTransmission;
   }
   public static com.mkyong.common.HIVMedicalHistory setSQLHIVMedicalHistory(org.motechproject.tama.patient.domain.HIVMedicalHistory hivMedicalHistory){
	   
	   com.mkyong.common.HIVMedicalHistory hHIVMedicalHistory = new com.mkyong.common.HIVMedicalHistory();
	   try{
	   hHIVMedicalHistory.setTestReason(setSQLHIVTestReason(hivMedicalHistory.getTestReason()));
	   hHIVMedicalHistory.setTestReasonId(hivMedicalHistory.getTestReasonId());
	   }catch(Exception e){
		   e.printStackTrace();
		   
		   System.out.println("From HIVMedicalHistory");
	   }
	  
	   hHIVMedicalHistory.setModeOfTransmission(setSQLModeOfTransmission(hivMedicalHistory.getModeOfTransmission()));
	   hHIVMedicalHistory.setModeOfTransmissionId(hivMedicalHistory.getModeOfTransmissionId());
	   session.save(hHIVMedicalHistory);
	   System.out.println(" HIVMedicalHistory Saved");
	   return hHIVMedicalHistory;
	   
	   
	   
   }
   public static NonHIVMedicalHistory setSQLNonHIVMedicalHistory(org.motechproject.tama.patient.domain.NonHIVMedicalHistory nonHIVMedicalHistory){
	  
	   NonHIVMedicalHistory hNonHIVMedicalHistory = new NonHIVMedicalHistory();
	   session.save(hNonHIVMedicalHistory);
	   List<AllergyHistory> hAllergiesHistoryList = new LinkedList<AllergyHistory>();
	   for (org.motechproject.tama.patient.domain.AllergyHistory item : nonHIVMedicalHistory.getAllergiesHistory()){
		   AllergyHistory hAllergyHistory = new AllergyHistory();
		   hAllergyHistory.setDescription(item.getDescription());
		   hAllergyHistory.setDrugAllergy(item.getDrugAllergy().toString());
		   hAllergyHistory.setSpecified(item.isSpecified());
		   hAllergyHistory.setNonHIVMedicalHistory(hNonHIVMedicalHistory);
		   session.save(hAllergyHistory);
		   hAllergiesHistoryList.add(hAllergyHistory);
		   
	   }
	   List<String> hRashes = new ArrayList<String>();
	   for(org.motechproject.tama.common.TAMAConstants.NNRTIRash item : nonHIVMedicalHistory.getRashes()){
		   String hRash = item.toString();
		   hRashes.add(hRash);
		   
	   }
	   hNonHIVMedicalHistory.setAllergiesHistory(hAllergiesHistoryList);
	   hNonHIVMedicalHistory.setRashes(hRashes);
	   List<SystemCategory> hSystemCategoriesList = new ArrayList<SystemCategory>();
	   for(org.motechproject.tama.patient.domain.SystemCategory item : nonHIVMedicalHistory.getSystemCategories()){
		   SystemCategory hSystemCategory = new SystemCategory();
		   hSystemCategory.setNonHIVMedicalHistory(hNonHIVMedicalHistory);
		   hSystemCategory.setAilments(setSQLAilments(item.getAilments()));
		   hSystemCategory.setName(item.getName());
		   session.save(hSystemCategory);
		   hSystemCategoriesList.add(hSystemCategory);
	   }
	   hNonHIVMedicalHistory.setSystemCategories(hSystemCategoriesList);
	   
	   List<MedicalHistoryQuestion> hMedHistoryQuestions = new ArrayList<MedicalHistoryQuestion>();
	   for(org.motechproject.tama.patient.domain.MedicalHistoryQuestion item : nonHIVMedicalHistory.getQuestions()){
		   MedicalHistoryQuestion hMedicalHistoryQuestion = new MedicalHistoryQuestion();
		   hMedicalHistoryQuestion.setComments(item.getComments());
		   hMedicalHistoryQuestion.setHistoryPresent(item.isHistoryPresent());
		   hMedicalHistoryQuestion.setQuestion(item.getQuestion());
		   hMedicalHistoryQuestion.setRequiresComment(item.isRequiresComment());
		   session.save(hMedicalHistoryQuestion);
		   hMedHistoryQuestions.add(hMedicalHistoryQuestion);
   }
	   hNonHIVMedicalHistory.setQuestions(hMedHistoryQuestions);
	   session.save(hNonHIVMedicalHistory);
	   
	   
	
	   return hNonHIVMedicalHistory;
	   
	   
   }
    public static com.mkyong.common.MedicalHistory setSQLMedicalHistory(org.motechproject.tama.patient.domain.MedicalHistory medicalHistory){
    	com.mkyong.common.MedicalHistory hMedicalHistory = new com.mkyong.common.MedicalHistory();
    	if(medicalHistory.getHivMedicalHistory()!=null)
    	hMedicalHistory.setHivMedicalHistory(setSQLHIVMedicalHistory(medicalHistory.getHivMedicalHistory()));
    	if(medicalHistory.getNonHivMedicalHistory()!=null)
    	hMedicalHistory.setNonHivMedicalHistory(setSQLNonHIVMedicalHistory(medicalHistory.getNonHivMedicalHistory()));
    	session.save(hMedicalHistory);
    	return hMedicalHistory;
    	
    	
    	
    	
    	
    	
    	
    }
    public static com.mkyong.common.Ailments setSQLAilments(org.motechproject.tama.patient.domain.Ailments ailments){
    	Ailments hAilments = new Ailments();
    	session.save(hAilments); 
    	List<Ailment> hAilList = new ArrayList<Ailment>();
    	for(org.motechproject.tama.patient.domain.Ailment item: ailments.getAilments()){
    		Ailment hAilment = new Ailment();
    		hAilment.setDefinition(item.getDefinition().toString());
    		hAilment.setState(item.getState().toString());
    		hAilment.setAilments(hAilments);
    		session.save(hAilment);
    		hAilList.add(hAilment);
    		
    	}
    	hAilments.setAilments(hAilList);
    	List<OtherAilment> hOtherAilmentList = new ArrayList<OtherAilment>();
    	for (org.motechproject.tama.patient.domain.OtherAilment item : ailments.getOtherAilments()){
    		OtherAilment hOtherAilment = new OtherAilment();
    		hOtherAilment.setAilments(hAilments);
    		hOtherAilment.setDefinition(item.getDefinition().toString());
    		hOtherAilment.setDescription(item.getDescription());
    		hOtherAilment.setState(item.getState().toString());
    		session.save(hOtherAilment);
    		hOtherAilmentList.add(hOtherAilment);
    		
    	}
    	hAilments.setOtherAilments(hOtherAilmentList);
    	session.save(hAilments);
    	return hAilments;
    	
    
    	
    	
    }
    public static com.mkyong.common.Patient setSQLPatient(org.motechproject.tama.patient.domain.Patient patient, AllCitiesCache allCities){
    	
    	
    	com.mkyong.common.Patient hPatient = new com.mkyong.common.Patient();
        try{
    	hPatient.setId(patient.getId());
    	hPatient.setRevision(patient.getRevision());
    	hPatient.setType("Patient");
    	hPatient.setDocumentType(patient.getDocumentType());
    	hPatient.setPatientId(patient.getPatientId());
    	hPatient.setMobilePhoneNumber(patient.getMobilePhoneNumber());
    	hPatient.setDateOfBirthAsDate(patient.getDateOfBirthAsDate());
    	com.mkyong.common.Gender hGender = setSQLGender(patient.getGender());
    	
    	hPatient.setGender(hGender);
    	
    	hPatient.setClinic(setSQLClinic(patient.getClinic(), allCities));
    	hPatient.setGenderId(patient.getGenderId());
    	hPatient.setClinic_id(patient.getClinic_id());
    	hPatient.setComplete(patient.isComplete());
    	hPatient.setStatus(patient.getStatus().toString());
    	hPatient.setPatientPreferences(setSQLPatientPreferences(patient.getPatientPreferences()));
    	hPatient.setMedicalHistory(setSQLMedicalHistory(patient.getMedicalHistory()));
    	hPatient.setNotes(patient.getNotes());
    	hPatient.setTravelTimeToClinicInDays(patient.getTravelTimeToClinicInDays());
    	hPatient.setTravelTimeToClinicInHours(patient.getTravelTimeToClinicInHours());
    	hPatient.setTravelTimeToClinicInMinutes(patient.getTravelTimeToClinicInMinutes());
    	hPatient.setRegistrationDate(patient.getRegistrationDate());
    	hPatient.setLastDeactivationDate(patient.getLastDeactivationDate());
    	hPatient.setLastSuspendedDate(patient.getLastSuspendedDate());
    	hPatient.setActivationDate(patient.getActivationDate());
    	session.save(hPatient);
    	patientCount++;
    	System.out.println("patient saved count "+patientCount);
    	}catch(Exception e){
	e.printStackTrace();
	System.out.println("Exception Saving patient ");
	countEx++;
	System.out.println("Count Patient Exception "+countEx);
}

    	
    	
    	
    	
    	
    	
    
    	
    	
    	
    	
    	
    	
    	return hPatient;
    }
    
    
    
    
    
}


