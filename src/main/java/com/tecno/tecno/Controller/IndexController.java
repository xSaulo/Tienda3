package com.tecno.tecno.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tecno.tecno.Service.ArticuloService;

@Controller
public class IndexController {

    private ArticuloService articuloService;

    public IndexController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @GetMapping("/")
    public String inicio(Model model) {

        var articulos = articuloService.listarArticulos();
        model.addAttribute("articulos", articulos);

        return "index";
    }

}
