package com.mkyong.common;





import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.mkyong.extras.CouchEntity;

@Entity
@Table
public class City extends CouchEntity{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
    private String name;
    
    

  

    public City(String id) {
        super();
        this.setId(id);
    }

	protected  City() {
    }

  

    @Override
    public String toString() {
        return this.name;
    }

    public static City newCity(String name) {
        City city = new City();
        city.setName(name);
        return city;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
}
