package com.mkyong.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.mkyong.common.Ailment;
import com.mkyong.common.Ailments;
import com.mkyong.common.AllergyHistory;
import com.mkyong.common.City;
import com.mkyong.common.Clinic;
import com.mkyong.common.ClinicianContact;
import com.mkyong.common.Gender;
import com.mkyong.common.HIVMedicalHistory;
import com.mkyong.common.HIVTestReason;
import com.mkyong.common.IVRLanguage;
import com.mkyong.common.MedicalHistory;
import com.mkyong.common.MedicalHistoryQuestion;
import com.mkyong.common.ModeOfTransmission;
import com.mkyong.common.NonHIVMedicalHistory;
import com.mkyong.common.OtherAilment;
import com.mkyong.common.Patient;
import com.mkyong.common.PatientPreferences;
import com.mkyong.common.SystemCategory;
import com.mkyong.extras.TimeOfDay;

public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory()
    {
       try
       {
          if (sessionFactory == null)
          {
        	 
        	 
             Configuration configuration = new Configuration().configure(HibernateUtil.class.getResource("/hibernate.cfg.xml"));
            /* configuration.addAnnotatedClass(Ailment.class);
             configuration.addAnnotatedClass(Ailments.class);
             configuration.addAnnotatedClass(AllergyHistory.class);
             configuration.addAnnotatedClass(City.class);
             configuration.addAnnotatedClass(Clinic.class);
             configuration.addAnnotatedClass(ClinicianContact.class);
             configuration.addAnnotatedClass(Gender.class);
             configuration.addAnnotatedClass(HIVMedicalHistory.class);
             configuration.addAnnotatedClass(HIVTestReason.class);
             configuration.addAnnotatedClass(IVRLanguage.class);
             configuration.addAnnotatedClass(MedicalHistory.class);
             configuration.addAnnotatedClass(MedicalHistoryQuestion.class);
             configuration.addAnnotatedClass(ModeOfTransmission.class);
             configuration.addAnnotatedClass(NonHIVMedicalHistory.class);
             configuration.addAnnotatedClass(OtherAilment.class);
             configuration.addAnnotatedClass(Patient.class);
             configuration.addAnnotatedClass(PatientPreferences.class);
             configuration.addAnnotatedClass(SystemCategory.class);
             configuration.addAnnotatedClass(TimeOfDay.class);*/
             StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
             serviceRegistryBuilder.applySettings(configuration.getProperties());
             ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
             sessionFactory = configuration.buildSessionFactory(serviceRegistry);
          }
          
       } catch (Throwable ex)
       {
          System.err.println("Initial SessionFactory creation failed." + ex);
          throw new ExceptionInInitializerError(ex);
       }
       
       return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void shutdown() {
    	// Close caches and connection pools
    	getSessionFactory().close();
    }

}