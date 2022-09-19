package com.damian.testibm.service.impl;

import com.damian.testibm.converter.SupplierConverter;
import com.damian.testibm.entity.Supplier;
import com.damian.testibm.model.SupplierModel;
import com.damian.testibm.repository.SupplierJpaRepository;
import com.damian.testibm.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service()
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierJpaRepository supplierJpaRepository;

    @Autowired
    private SupplierConverter supplierConverter;

    @Override
    public List<SupplierModel> listAllOrdered() {
        return fillSupplierModel(supplierJpaRepository.findAllByOrderByNameAsc());
    }

    @Override
    public SupplierModel getSupplier(int idSupplier) {
        return supplierConverter.entity2Model(supplierJpaRepository.getById(idSupplier));
    }

    @Override
    public void addOrUpdate(SupplierModel supplier) throws Exception {
        SupplierModel supplierModel = getSupplier(supplier.getId());
        supplierModel.setStars(supplier.getStars());
        supplierConverter.entity2Model(supplierJpaRepository.save(supplierConverter.model2Entity(supplierModel)));
    }

    private List<SupplierModel> fillSupplierModel (List<Supplier> supplierList) {
        List<SupplierModel> supplierModelList = new ArrayList<>();
        for (Supplier supplier: supplierList) {
            supplierModelList.add(supplierConverter.entity2Model(supplier));
        }
        return supplierModelList;
    }
}
