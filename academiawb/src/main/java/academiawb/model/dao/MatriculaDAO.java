package academiawb.model.dao;

import academiawb.model.db.DBConnector;
import academiawb.model.dto.MatriculaDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MatriculaDAO {
    public static MatriculaDTO inserirMatricula(String nome, String cpf, Date datanascimento, String endereco, String telefone, String email, String plano, String pacote) {
        try(Connection connection = DBConnector.getConexao()) {
        
            String sql = "INSERT INTO matricula (nome, cpf, nascimento, endereco, telefone, email, plano, pacote) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            MatriculaDTO funcionario = new MatriculaDTO(nome, endereco, email, cpf, telefone, datanascimento, plano, pacote);

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, funcionario.getNome());
            preparedStatement.setString(2, funcionario.getCpf());
            preparedStatement.setDate(3, funcionario.getDatanascimento());
            preparedStatement.setString(4, funcionario.getEndereco());
            preparedStatement.setString(5, funcionario.getTelefone());
            preparedStatement.setString(6, funcionario.getEmail());
            preparedStatement.setString(7, funcionario.getPlano());
            preparedStatement.setString(8, funcionario.getPacote());

            preparedStatement.executeUpdate();
            
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                funcionario.setCodigo(id);
            }
            return funcionario;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void removeMatricula(Integer cdg) {
        try (Connection connection = DBConnector.getConexao()) {
            String sql = "DELETE FROM matricula WHERE idmatricula = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cdg);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void atualizaMatricula(Integer codigo, String nome, String cpf, Date datanascimento, String endereco, String telefone, String email, String plano, String pacote) {
        try (Connection connection = DBConnector.getConexao()) {
            String sql = "UPDATE funcionario SET nome=?, cpf=?, nascimento=?, endereco=?, telefone=?, email=?, plano=?, pacote=? WHERE idmatricula=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,nome);
            preparedStatement.setString(2, cpf);
            preparedStatement.setDate(3, datanascimento);
            preparedStatement.setString(4, endereco);
            preparedStatement.setString(5, telefone);
            preparedStatement.setString(6, email);
            preparedStatement.setString(7, plano);
            preparedStatement.setString(8, pacote);
            preparedStatement.setInt(9, codigo);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String consultaPorNome(String nome) {
        try (Connection connection = DBConnector.getConexao()) {
            String sql = "SELECT * FROM matricula WHERE nome = "+ nome+"";
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

    public static Integer consultaPorID(Integer codigo) {
        try (Connection connection = DBConnector.getConexao()) {
            String sql = "SELECT * FROM  matricula WHERE idmatricula = "+ codigo +"";
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

    public static String consultaPorCPF(String cpf) {
        try (Connection connection = DBConnector.getConexao()) {
            String sql = "SELECT * FROM matricula WHERE cpf = "+ cpf +"";
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
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String consultaPorNumero(String telefone) {
        try (Connection connection = DBConnector.getConexao()) {
            String sql = "SELECT * FROM matricula WHERE telefone = "+ telefone +"";
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
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    

}
