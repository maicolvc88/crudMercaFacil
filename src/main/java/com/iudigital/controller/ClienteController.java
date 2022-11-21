package com.iudigital.controller;

import com.iudigital.dao.ClienteDao;
import com.iudigital.domain.Cliente;
import java.sql.SQLException;
import java.util.List;

public class ClienteController {

    private ClienteDao clienteDao;

    public ClienteController() {
        clienteDao = new ClienteDao();
    }

    public void crear(Cliente cliente) throws SQLException {
        clienteDao.crear(cliente);
    }

    public List<Cliente> obtenerClientes() throws SQLException {
        return clienteDao.obtenerClientes();
    }

    public Cliente obtenerCliente(int cedula_cliente) throws SQLException {
        return clienteDao.obtenerCliente(cedula_cliente);
    }

    public void actualizarCliente(int cedula_cliente, Cliente cliente) throws SQLException {
        clienteDao.actualizarCliente(cedula_cliente, cliente);
    }

    public void eliminarCliente(int cedula_cliente) throws SQLException {
        clienteDao.eliminarCliente(cedula_cliente);
    }

}
