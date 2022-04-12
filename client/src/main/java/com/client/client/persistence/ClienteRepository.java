package com.client.client.persistence;

import com.client.client.persistence.crud.ClienteCrudRepository;
import com.client.client.persistence.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepository {

    @Autowired
    private ClienteCrudRepository clienteCrudRepository;

    public List<Cliente> obtenerTodos(){
        List<Cliente> clientes = (List<Cliente>) clienteCrudRepository.findAll();
        return clientes;
    }

    public Cliente obtenerClientePorId(Integer id){
        return clienteCrudRepository.findById(id).get();
    }

    public void crearCliente(Cliente cliente){
        clienteCrudRepository.save(cliente);
    }

    public void actualizarCliente(Cliente cliente){
        clienteCrudRepository.deleteById(cliente.getId());
        clienteCrudRepository.save(cliente);
    }

    public void eliminarCliente(Integer id){
        clienteCrudRepository.deleteById(id);
    }
}
