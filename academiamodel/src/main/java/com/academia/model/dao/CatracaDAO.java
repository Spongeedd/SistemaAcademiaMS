package com.academia.model.dao;

import com.academia.model.db.DBConnector;
import com.academia.model.dto.CatracaDTO;
import com.academia.model.dto.MatriculaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

public class CatracaDAO {
  public static void inserirCatraca(Integer ID) {
        try(Connection connection = DBConnector.getConexao()) {
            String sqlnome = "SELECT * FROM matricula WHERE idmatricula = "+ ID+"";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlnome);
            ResultSet rs = preparedStatement.executeQuery();
            String nome;
            nome = rs.getString("nome");

            String sql = "INSERT INTO acesso-aluno (idaluno, nome, data) VALUES (?, ?, ?)";
            Date aux = new Date();
            Timestamp data = new java.sql.Timestamp(aux.getTime());
            CatracaDTO catraca = new CatracaDTO(nome, data, ID);
            
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, catraca.getID());
            preparedStatement.setString(2, catraca.getNome());
            preparedStatement.setTimestamp(3, catraca.getData());
            preparedStatement.executeUpdate();
            
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
  } 
  public static Integer buscaLogin(String Nome, String CPF) {
        try (Connection connection = DBConnector.getConexao()) {
            String sql = "SELECT * FROM matricula WHERE nome = "+ Nome+" and cpf = "+ CPF +"";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt("idmatricula");
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}