package com.beehyv.tama.edit;

import org.ektorp.CouchDbConnector;
import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.motechproject.server.pillreminder.api.dao.AllPillRegimens;
import org.motechproject.server.pillreminder.api.domain.Dosage;
import org.motechproject.server.pillreminder.api.domain.PillRegimen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mkyong.persistence.HibernateUtil;
import com.sun.tools.internal.ws.wsdl.document.jaxws.Exception;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/applicationContext.xml" })
public class PillRegimenApp {
	public static Session session = HibernateUtil.getSessionFactory().openSession();
	
	

	
	@Autowired
    CouchDbConnector tamaDbConnector;
	AllPillRegimens allPillRegimens;
	
	@Test
	public void test(){
		allPillRegimens = new AllPillRegimens(tamaDbConnector);
		for(PillRegimen item : allPillRegimens.getAll()){
			for(Dosage dosage : item.getDosages()){
				System.out.println(dosage.getMedicines().size());
				if(dosage.getMedicines().size()> 0){
					System.out.println("\n\n\n");
					throw new RuntimeException();
				}
			}
		}
	}
	
	}