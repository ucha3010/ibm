package com.damian.testibm.service;

import com.damian.testibm.model.SupplierModel;

import java.util.List;

public interface SupplierService {

    public abstract List<SupplierModel> listAllOrdered();

    public abstract SupplierModel getSupplier(int idSupplier);

    public abstract void addOrUpdate(SupplierModel supplier) throws Exception;
}
