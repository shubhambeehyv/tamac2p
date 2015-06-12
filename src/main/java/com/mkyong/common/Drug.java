package com.mkyong.common;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.mkyong.extras.CouchEntity;

@Entity
@Table
public class Drug extends CouchEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Brand> brands = new TreeSet<Brand>();

    public Drug() {
    }

    public Drug(String name) {
        this.name = name;
    }

    

    public void addBrand(Brand brand) {
        brands.add(brand);
    }

    public void removeBrand(Brand brand) {
        brands.remove(brand);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Brand> getBrands() {
        return new TreeSet<Brand>(this.brands);
    }

    public void setBrands(Set<Brand> brands) {
        this.brands = brands;
    }

    @Override
    public String toString() {
        return this.name;
    }

   
}
