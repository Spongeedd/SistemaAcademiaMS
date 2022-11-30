package com.academia.model.dao;

import com.academia.model.db.DBConnector;
import com.academia.model.dto.FinanceiroDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FinanceiroDAO {

    private static FinanceiroDTO financeiroDTO = new FinanceiroDTO();
    private static Date datainicial = new Date(2022,11,28);
    

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
            String sql = "SELECT pacote, plano, COUNT(*) as soma_plano FROM matricula GROUP BY pacote, plano ORDER BY plano";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                if (rs.getString("pacote").equals("Mensal")) {
                    if (rs.getString("plano").equals("Basico")) {
                        basico = rs.getInt("soma_plano") * 30;
                    }
                    else if (rs.getString("plano").equals("Intermediario")) {
                        intermediario = rs.getInt("soma_plano") * 55;
                    }
                    else {
                        premium = rs.getInt("soma_plano") * 100;
                    }
                }
                if (rs.getString("pacote").equals("Trimestral")) {
                    if (rs.getString("plano").equals("Basico")) {
                        basico = rs.getInt("soma_plano") * 80;
                    }
                    else if (rs.getString("plano").equals("Intermediario")) {
                        intermediario = rs.getInt("soma_plano") * 150;
                    }
                    else {
                        premium = rs.getInt("soma_plano") * 270;
                    }
                }
                if (rs.getString("pacote").equals("Anual")) {
                    if (rs.getString("plano").equals("Basico")) {
                        basico = rs.getInt("soma_plano") * 288;
                    }
                    else if (rs.getString("plano").equals("Intermediario")) {
                        intermediario = rs.getInt("soma_plano") * 528;
                    }
                    else {
                        premium = rs.getInt("soma_plano") * 720;
                    }
                }
            }
            
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

    public static void calculaReceita() throws ParseException {
        Integer receita, faturamento, debitos;
        faturamento = getFaturamento();
        debitos = getPagamentos();
        receita = faturamento - debitos;
        financeiroDTO.setReceita(receita);

        SimpleDateFormat formatter = new SimpleDateFormat("dd");
        String datacomp = formatter.format(datainicial);
        Date dataatual = new Date();
        String dataatualcomp = formatter.format(dataatual);
        if (dataatualcomp.equals(datacomp)) {
            try(Connection connection = DBConnector.getConexao()) {
                String sql = "INSERT IGNORE INTO receita (valor, data) VALUES (?, ?)";
    
                PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                formatter = new SimpleDateFormat("yyyy/MM/dd");
                String dataaux = formatter.format(dataatual);
                Date dateaux = formatter.parse(dataaux);
                java.sql.Date date = new java.sql.Date(dateaux.getTime());
                preparedStatement.setInt(1, receita);
                preparedStatement.setDate(2, (java.sql.Date) date);
                preparedStatement.executeUpdate();
            }catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
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
