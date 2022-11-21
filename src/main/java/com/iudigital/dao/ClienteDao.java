package com.iudigital.dao;

import com.iudigital.domain.Cliente;
import com.iudigital.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {
    
    private static final String GET_CLIENTES = "select * from tbl_clientes";
    private static final String CREATE_CLIENTE = "insert into tbl_clientes (cedula_cliente, nombre_cliente, direccion_cliente, telefono_cliente) values (?, ?, ?, ?);";
    private static final String GET_CLIENTE_BY_CEDULA = "select * from tbl_clientes where cedula_cliente = ?";
    private static final String UPDATE_CLIENTE = "update tbl_clientes set nombre_cliente = ?, direccion_cliente = ?, telefono_cliente = ? where cedula_cliente = ?";
    private static final String DELETE_CLIENTE = "delete from tbl_clientes where cedula_cliente =?";

    public void crear(Cliente cliente) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_CLIENTE);
            preparedStatement.setInt(1, cliente.getCedula_cliente());
            preparedStatement.setString(2, cliente.getNombre_cliente());
            preparedStatement.setString(3, cliente.getDireccion_cliente());
            preparedStatement.setString(4, cliente.getTelefono_cliente());
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public List<Cliente> obtenerClientes() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_CLIENTES);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setCedula_cliente(resultSet.getInt("cedula_cliente"));
                cliente.setNombre_cliente(resultSet.getString("nombre_cliente"));
                cliente.setDireccion_cliente(resultSet.getString("direccion_cliente"));
                cliente.setTelefono_cliente(resultSet.getString("telefono_cliente"));
                clientes.add(cliente);
            }
            return clientes;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    public Cliente obtenerCliente(int cedula_cliente) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Cliente cliente = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_CLIENTE_BY_CEDULA);
            preparedStatement.setInt(1, cedula_cliente);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                cliente = new Cliente();
                cliente.setCedula_cliente(resultSet.getInt("cedula_cliente"));
                cliente.setNombre_cliente(resultSet.getString("nombre_cliente"));
                cliente.setDireccion_cliente(resultSet.getString("direccion_cliente"));
                cliente.setTelefono_cliente(resultSet.getString("telefono_cliente"));
            }
            return cliente;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    public void actualizarCliente(int cedula_cliente, Cliente cliente) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_CLIENTE);
            preparedStatement.setString(1, cliente.getNombre_cliente());
            preparedStatement.setString(2, cliente.getDireccion_cliente());
            preparedStatement.setString(3, cliente.getTelefono_cliente());
            preparedStatement.setInt(4, cedula_cliente);
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void eliminarCliente(int cedula_cliente) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_CLIENTE);
            preparedStatement.setInt(1, cedula_cliente);
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

    }
    
}
