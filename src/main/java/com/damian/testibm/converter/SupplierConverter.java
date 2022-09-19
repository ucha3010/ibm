package com.damian.testibm.converter;

import com.damian.testibm.entity.Supplier;
import com.damian.testibm.model.SupplierModel;
import org.springframework.stereotype.Component;

@Component
public class SupplierConverter {

	public SupplierModel entity2Model(Supplier externObject) {
		SupplierModel localObject = new SupplierModel();
		localObject.setId(externObject.getId());
		localObject.setName(externObject.getName());
		localObject.setAddDate(externObject.getAddDate());
		localObject.setCif(externObject.getCif());
		localObject.setLogo(externObject.getLogo());
		localObject.setStars(externObject.getStars());
		return localObject;
		
	}
	
	public Supplier model2Entity(SupplierModel externObject) {
		Supplier localObject = new Supplier();
		localObject.setId(externObject.getId());
		localObject.setName(externObject.getName());
		localObject.setAddDate(externObject.getAddDate());
		localObject.setCif(externObject.getCif());
		localObject.setLogo(externObject.getLogo());
		localObject.setStars(externObject.getStars());
		return localObject;
	}

}
