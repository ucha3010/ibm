package com.damian.testibm;

import com.damian.testibm.controller.SupplierController;
import com.damian.testibm.converter.SupplierConverter;
import com.damian.testibm.entity.Supplier;
import com.damian.testibm.model.SupplierModel;
import com.damian.testibm.repository.SupplierJpaRepository;
import com.damian.testibm.service.impl.SupplierServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class TestibmApplicationTests {

	@InjectMocks
	private SupplierController supplierController;

	@Mock
	private SupplierServiceImpl supplierService;

	@Mock
	private SupplierConverter supplierConverter;

	@Mock
	private SupplierJpaRepository supplierJpaRepository;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		cargarMocks();
	}

	private void cargarMocks() {
		Supplier supplier = new Supplier();
		supplier.setId(2);
		SupplierModel supplierModel = new SupplierModel();
		supplierModel.setId(2);
		List<Supplier> supplierList = new ArrayList<>();
		supplierList.add(supplier);
		List<SupplierModel> supplierModelList = new ArrayList<>();
		supplierModelList.add(supplierModel);
		when(supplierJpaRepository.findAllByOrderByNameAsc()).thenReturn(supplierList);
		when(supplierJpaRepository.getById(anyInt())).thenReturn(supplier);
		when(supplierService.listAllOrdered()).thenReturn(supplierModelList);
		when(supplierService.getSupplier(anyInt())).thenReturn(supplierModel);
		when(supplierJpaRepository.save(any())).thenReturn(supplier);
		when(supplierConverter.entity2Model(any())).thenReturn(supplierModel);
		when(supplierConverter.model2Entity(any())).thenReturn(supplier);
	}

	@Test
	public void controllerTest(){
		assertThat(supplierController).isNotNull();
	}

	@Test
	public void listTest() {
		assertThat(supplierController.supplierList(new ModelAndView())).isNotNull();
	}

	@Test
	public void getTest() {
		assertThat(supplierController.supplierDetail(new ModelAndView(),2)).isNotNull();
	}

	@Test
	public void addPunctuationTest() {
		assertThat(supplierController.addPunctuation(new SupplierModel())).isNotNull();
	}

}
