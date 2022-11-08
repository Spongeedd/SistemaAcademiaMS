package com.academia.funcionario;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.academia.db.DBConnector;

public class FuncionariosDAO {
    
    public static FuncionariosDTO inserirFuncionarios(String nome, String cpf, Date datanascimento, String endereco, String telefone, String email, Integer jornada, Integer phora) {
        try(Connection connection = DBConnector.getConexao()) {
        
            String sql = "INSERT INTO funcionario (nome, cpf, nascimento, endereco, telefone, email, jornada, phora, salario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            FuncionariosDTO funcionario = new FuncionariosDTO(nome, endereco, email, cpf, telefone, datanascimento, jornada, phora);

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, funcionario.getNome());
            preparedStatement.setString(2, funcionario.getCpf());
            preparedStatement.setDate(3, funcionario.getDatanascimento());
            preparedStatement.setString(4, funcionario.getEndereco());
            preparedStatement.setString(5, funcionario.getTelefone());
            preparedStatement.setString(6, funcionario.getEmail());
            preparedStatement.setInt(7, funcionario.getJornada());
            preparedStatement.setInt(8, funcionario.getPhora());
            Integer sal = funcionario.getJornada() * funcionario.getPhora();
            preparedStatement.setInt(9, sal);

            preparedStatement.executeUpdate();
            
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                funcionario.setCodigo(id);
            }
            return funcionario;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

   
    public static void removeFuncionario(Integer cdg) {
        try (Connection connection = DBConnector.getConexao()) {
            String sql = "DELETE FROM funcionario WHERE idfuncionario = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cdg);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void atualizaFuncionario(Integer codigo, String nome, String cpf, Date datanascimento, String endereco, String telefone, String email, Integer jornada, Integer phora) {
        try (Connection connection = DBConnector.getConexao()) {
            String sql = "UPDATE funcionario SET nome=?, cpf=?, nascimento=?, endereco=?, telefone=?, email=?, jornada=?, phora=?, salario=? WHERE idfuncionario=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,nome);
            preparedStatement.setString(2, cpf);
            preparedStatement.setDate(3, datanascimento);
            preparedStatement.setString(4, endereco);
            preparedStatement.setString(5, telefone);
            preparedStatement.setString(6, email);
            preparedStatement.setInt(7, jornada);
            preparedStatement.setInt(8, phora);
            Integer sal = jornada * phora;
            preparedStatement.setInt(9, sal);
            preparedStatement.setInt(10, codigo);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String consultaPorNome(String nome) {
        try (Connection connection = DBConnector.getConexao()) {
            String sql = "SELECT * FROM funcionario WHERE nome = "+ nome+"";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getString("nome");
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Integer consultaPorID(Integer codigo) {
        try (Connection connection = DBConnector.getConexao()) {
            String sql = "SELECT * FROM funcionario WHERE idfuncionario = "+ codigo +"";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt("idfuncionario");
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String consultaPorCPF(String cpf) {
        try (Connection connection = DBConnector.getConexao()) {
            String sql = "SELECT * FROM funcionario WHERE cpf = "+ cpf +"";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getString("cpf");
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String consultaPorNumero(String telefone) {
        try (Connection connection = DBConnector.getConexao()) {
            String sql = "SELECT * FROM funcionario WHERE telefone = "+ telefone +"";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getString("telefone");
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}