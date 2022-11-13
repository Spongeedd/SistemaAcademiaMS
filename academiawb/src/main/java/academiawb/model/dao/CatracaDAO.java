package academiawb.model.dao;

import academiawb.model.db.DBConnector;
import academiawb.model.dto.CatracaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

public class CatracaDAO {

    private static Integer acessos;
    static {
        acessos = 0;
    }
    public static void inserirCatraca(Integer ID) {
        try(Connection connection = DBConnector.getConexao()) {
            String sqlnome = "SELECT * FROM matricula WHERE idmatricula = "+ ID +"";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlnome);
            ResultSet rs = preparedStatement.executeQuery();
            String nome;
            if (rs.next()) {
                nome = rs.getString("nome");
                String sql = "INSERT INTO acessoaluno (idaluno, nome, data) VALUES (?, ?, ?)";
                Date aux = new Date();
                Timestamp data = new java.sql.Timestamp(aux.getTime());
                CatracaDTO catraca = new CatracaDTO(ID, nome, data);
                
                preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setInt(1, catraca.getID());
                preparedStatement.setString(2, catraca.getNome());
                preparedStatement.setTimestamp(3, catraca.getData());
                preparedStatement.executeUpdate();
                acessos++;
            }   
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    } 

    public static Integer buscaLogin(String Nome, String CPF) {
        try (Connection connection = DBConnector.getConexao()) {
            String sql = "SELECT * FROM matricula WHERE nome =? and cpf =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,Nome);
            preparedStatement.setString(2, CPF);
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

    public static String getNome(Integer id) {
        try (Connection connection = DBConnector.getConexao()) {
            String sql = "SELECT * FROM matricula WHERE idmatricula = "+ id +"";
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
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getPlano(Integer id) {
        try (Connection connection = DBConnector.getConexao()) {
            String sql = "SELECT * FROM matricula WHERE idmatricula = "+ id +"";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getString("plano");
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

    public static Integer getAcessos() {
        return acessos;
    }
}