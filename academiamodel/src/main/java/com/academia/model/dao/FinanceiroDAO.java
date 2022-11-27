package com.academia.model.dao;

import com.academia.model.db.DBConnector;
import com.academia.model.dto.FinanceiroDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FinanceiroDAO {

    private static FinanceiroDTO financeiroDTO = new FinanceiroDTO();

    public static FinanceiroDTO caculaDebitos() {
        try(Connection connection = DBConnector.getConexao()) {
            Integer pagamentos;
            String sql = "SELECT SUM(salario) FROM funcionario";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                pagamentos = rs.getInt(1);
                financeiroDTO.setPagamentos(pagamentos);
                return financeiroDTO;
            }
            else {
                return null;
            }
            
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static FinanceiroDTO calculaFaturamento() {
        try(Connection connection = DBConnector.getConexao()) {
            Integer basico = 0, intermediario = 0, premium = 0, faturamento;
            String sql = "SELECT plano,COUNT(*) FROM matricula GROUP BY plano";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                if (rs.getString("plano").equals("Basico")) {
                    basico = rs.getInt("COUNT(*)");
                }
                if (rs.getString("plano").equals("Intermediario")) {
                    intermediario = rs.getInt("COUNT(*)");
                }
                if (rs.getString("plano").equals("Premium")) {
                    premium = rs.getInt("COUNT(*)");
                }
            }
            
            basico = basico * 30;
            intermediario = intermediario * 55;
            premium = premium * 100;
            faturamento = basico + intermediario + premium;

            financeiroDTO.setFaturamento(faturamento);
            financeiroDTO.setBasico(basico);
            financeiroDTO.setIntermediario(intermediario);
            financeiroDTO.setPremimum(premium);

            return financeiroDTO;
           
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void calculaReceita() {
        Integer receita, faturamento, debitos;
        faturamento = getFaturamento();
        debitos = getPagamentos();
        receita = faturamento - debitos;
        financeiroDTO.setReceita(receita);
    }

    public static Integer getFaturamento() {
        return financeiroDTO.getFaturamento();
    }
    public static Integer getPagamentos() {
        return financeiroDTO.getPagamentos();
    }
    public static Integer getReceita() {
        return financeiroDTO.getReceita();
    }

}
