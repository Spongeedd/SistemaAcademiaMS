package academiawb.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import academiawb.model.db.DBConnector;
import academiawb.model.dto.FinanceiroDTO;

public class FinanceiroDAO {
    public static Integer inserirDebitos(Integer faturamento, Integer receita, Integer pagamentos) {

        try(Connection connection = DBConnector.getConexao()) {
        
            String sql = "SELECT SUM(salario) FROM funcionario";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
               pagamentos = rs.getInt(1);
               return pagamentos;
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
