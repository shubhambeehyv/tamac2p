package com.mkyong.common;



import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.mkyong.extras.CouchEntity;




@Table
@Entity
public class MealAdviceType extends CouchEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected MealAdviceType() {
    }

    public MealAdviceType(String type) {
        this.type = type;
    }
}
 
