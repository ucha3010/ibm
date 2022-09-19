package com.damian.testibm.repository;

import com.damian.testibm.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("supplierJpaRepository")
public interface SupplierJpaRepository extends JpaRepository<Supplier, Serializable>{

    public abstract List<Supplier> findAllByOrderByNameAsc();
}
