package com.academia.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import com.academia.model.db.DBConnector;
import com.academia.model.dto.LogDTO;

public class LogDAO {

    private static LogDTO logDTO = new LogDTO();

    public static void inserirLog (String acao) {
        try(Connection connection = DBConnector.getConexao()) {
            
            String sql = "INSERT INTO log (acao, usuario, hora) VALUES (?, ?, ?)";

            Date aux = new Date();
            Timestamp data = new java.sql.Timestamp(aux.getTime());
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, acao);
            preparedStatement.setString(2, logDTO.getUsuario());
            preparedStatement.setTimestamp(3,data);
            preparedStatement.executeUpdate();
            
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static LogDTO setUsuario(String usuario) {
        logDTO.setUsuario(usuario);
        return logDTO;
    }

    public static String getUsuario() {
        return logDTO.getUsuario();
    }
}
