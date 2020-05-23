package com.uca.capas.controller;

import com.uca.capas.dao.ContribuyenteDAO;
import com.uca.capas.dao.ImportanciaDAO;
import com.uca.capas.domain.Contribuyente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class MainController {

    @Autowired
    private ContribuyenteDAO contribuyenteDAO;

    @Autowired
    private ImportanciaDAO importanciaDAO;

    @GetMapping("/inicio")
    public String initMain(Contribuyente contribuyente, Model model) {
        try {
            model.addAttribute("importancia", importanciaDAO.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

    @GetMapping("/contribuyentes")
    public String contribuyentes(Model model) {
        try {
            model.addAttribute("contribuyentes", contribuyenteDAO.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "listado";
    }

    @PostMapping("/insert")
    public String list(
            @Valid @ModelAttribute Contribuyente contribuyente,
            @RequestParam Integer importancia,
            Model model,
            BindingResult result
    ) {
        if (result.hasErrors()) return "index";

        try {
            Date date = new Date();
            contribuyente.setF_fecha_ingreso(date);

            contribuyente.setC_importancia(importancia);

            contribuyenteDAO.insert(contribuyente);
            model.addAttribute("contribuyentes", contribuyenteDAO.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "listado";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer id, Model model) {
        try {
            model.addAttribute("estudiantes", contribuyenteDAO.findAll());
            contribuyenteDAO.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "listado";
    }
}
