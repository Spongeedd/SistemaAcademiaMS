package academiawb.model.dao;

import academiawb.model.db.DBConnector;
import academiawb.model.dto.ExerciciosDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ExerciciosDAO {
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void removeExercicio(Integer cdg) {
        try (Connection connection = DBConnector.getConexao()) {
            String sql = "DELETE FROM exercicios WHERE idexercicios = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cdg);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
