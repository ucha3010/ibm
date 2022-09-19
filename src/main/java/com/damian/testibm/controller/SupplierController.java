package com.damian.testibm.controller;

import com.damian.testibm.model.SupplierModel;
import com.damian.testibm.service.SupplierService;
import com.damian.testibm.util.LoggerMapper;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    public SupplierService supplierService;

    @GetMapping()
    public ModelAndView supplierList(ModelAndView modelAndView) {
        modelAndView.setViewName("suppliers");
        modelAndView.addObject("suppliers", supplierService.listAllOrdered());
        LoggerMapper.log(Level.INFO, "supplierList", modelAndView, getClass());
        return modelAndView;
    }

    @GetMapping("/id")
    public ModelAndView supplierDetail(ModelAndView modelAndView, @ModelAttribute("idSupplier") int idSupplier) {
        SupplierModel supplier = supplierService.getSupplier(idSupplier);
        if(supplier == null) {
            modelAndView.setViewName("error/400");
        } else {
            modelAndView.addObject("supplier", supplier);
            modelAndView.setViewName("supplier");
        }
        LoggerMapper.log(Level.INFO, "supplierDetail", modelAndView, getClass());
        return modelAndView;
    }

    @PostMapping("/id")
    public ModelAndView addPunctuation(@ModelAttribute("supplier") SupplierModel supplier) {

        ModelAndView modelAndView = new ModelAndView();
        try {
            supplierService.addOrUpdate(supplier);
            modelAndView.addObject("puntuacionCorrecta", "puntuacionCorrecta");
        } catch (Exception e) {
            modelAndView.addObject("puntuacionError", "puntuacionError");
        }
        LoggerMapper.log(Level.INFO, "addPunctuation", modelAndView, getClass());
        return supplierList(modelAndView);
    }
}
