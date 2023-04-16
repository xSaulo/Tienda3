package com.tecno.tecno.Controller;

import com.tecno.tecno.Service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tecno.tecno.Model.Cliente;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        var clientes = clienteService.listarClientes();
        model.addAttribute("clientes", clientes);
        model.addAttribute("totalClientes", clientes.size());

        int totalCredito = 0;

        for (Cliente cliente : clientes) {

            totalCredito += cliente.getCredito().getLimite();

        }
        model.addAttribute("totalCredito", totalCredito);

        return "/cliente/listar";
    }

    @GetMapping("/agregar")
    public String agregarCliente(Cliente cliente) {
        return "/cliente/agregar";
    }

    @PostMapping("/guardar")
    public String guardarCliente(Cliente cliente) {
        clienteService.saveCliente(cliente);
        return "redirect:/cliente/listar";
    }

    @GetMapping("/eliminar/{id_cliente}")
    public String eliminarCliente(Cliente cliente) {
        clienteService.deleteCliente(cliente);
        return "redirect:/cliente/listar";
    }

    @GetMapping("/editar/{id_cliente}")
    public String editarCliente(Cliente cliente, Model model) {
        cliente = clienteService.getCLiente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/agregar";
    }

}
