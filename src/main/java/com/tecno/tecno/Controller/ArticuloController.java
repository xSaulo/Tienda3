package com.tecno.tecno.Controller;

import com.tecno.tecno.Service.ArticuloService;
import com.tecno.tecno.Model.Articulo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@Controller
@RequestMapping("/articulo")
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var articulos = articuloService.listarArticulos();
        model.addAttribute("articulos", articulos);
        return "/articulo/listado";
    }

    @GetMapping("/nuevo")
    public String articuloNuevo(Articulo articulo) {
        return "/articulo/modificar";
    }

    @PostMapping("/guardar")
    public String articuloGuardar(Articulo articulo) {
        articuloService.saveArticulo(articulo);
        return "redirect:/articulo/listado";
    }

    @GetMapping("/eliminar/{idArticulo}")
    public String articuloEliminar(Articulo articulo) {
        articuloService.deleteArticulo(articulo);
        return "redirect:/articulo/listado";
    }

    @GetMapping("/modificar/{idArticulo}")
    public String articuloModificar(Model model, Articulo articulo) {
        articulo = articuloService.getArticulo(articulo);
        model.addAttribute("articulo", articulo);
        return "/articulo/modificar";
    }

}
