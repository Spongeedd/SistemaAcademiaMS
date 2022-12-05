package com.academia.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.academia.model.db.DBConnector;
import com.academia.model.dto.ExerciciosDTO;
import com.academia.model.service.EmailService;

import java.sql.Types;

public class ExerciciosDAO {
    
    public static void atribuirExercicios (Integer idmatricula, Integer idexercicios) {
        try(Connection connection = DBConnector.getConexao()) {
            
            String sql = "UPDATE matricula SET ficha = (?) WHERE idmatricula = "+ idmatricula +"";
 
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, idexercicios);
            preparedStatement.executeUpdate();
            
            sql = "SELECT * FROM  matricula WHERE idmatricula = "+ idmatricula +"";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                EmailService.enviarEmailExercicio(rs.getString("email"), rs.getString("nome"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
        public static void desatribuirExercicios (Integer idmatricula) {
        try(Connection connection = DBConnector.getConexao()) {
            
            String sql = "UPDATE matricula SET ficha = (?) WHERE idmatricula = "+ idmatricula +"";
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            Integer p = null;
            preparedStatement.setObject(1, p, Types.INTEGER);
            preparedStatement.executeUpdate();
            
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public static ExerciciosDTO inserirExercicios(String plano, String descricao, String serie, String repeticoes) {
        try(Connection connection = DBConnector.getConexao()) {
        
            String sql = "INSERT INTO exercicios (plano, descricao, serie, repeticoes) VALUES (?, ?, ?, ?)";

            ExerciciosDTO exercicios = new ExerciciosDTO(plano, descricao, serie, repeticoes);

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, exercicios.getPlano());
            preparedStatement.setString(2, exercicios.getDescricao());
            preparedStatement.setString(3, exercicios.getSerie());
            preparedStatement.setString(4, exercicios.getRepeticoes());
            preparedStatement.executeUpdate();
            
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                exercicios.setId(id);
            }
            return exercicios;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void removeExercicio(Integer cdg) {
        try (Connection connection = DBConnector.getConexao()) {
            String sql = "DELETE FROM exercicios WHERE idexercicios = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cdg);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
