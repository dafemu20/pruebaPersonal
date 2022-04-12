package com.client.client.web.controller;

import com.client.client.persistence.ClienteRepository;
import com.client.client.persistence.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/obtenerTodos")
    public List<Cliente> obtenerClientes(){
        return clienteRepository.obtenerTodos();
    }

    @GetMapping("/obtenerPorId/{id}")
    public Cliente obtenerClientesPorId(@PathVariable("id") Integer id){
        return clienteRepository.obtenerClientePorId(id);
    }

    @PostMapping("/crear")
    public void crear(@RequestBody Cliente cliente){
        clienteRepository.crearCliente(cliente);
    }

    @PutMapping("/actualizar")
    public void actualizar(@RequestBody Cliente cliente){
        clienteRepository.actualizarCliente(cliente);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        clienteRepository.eliminarCliente(id);
    }
}
