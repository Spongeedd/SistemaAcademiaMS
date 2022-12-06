package com.academia.model.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.academia.model.db.DBConnector;
import com.academia.model.dto.CobrancaDTO;

public class CobrancaDAO {
    private static Date datainicial = new Date(2022,11,5);
    private static CobrancaDTO cobrancaDTO = new CobrancaDTO();

    public static void inserirCobranca () throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("dd");
        String datacomp = formatter.format(datainicial);
        Date dataatual = new Date();
        String dataatualcomp = formatter.format(dataatual);

        if (dataatualcomp.equals(datacomp)) {
            System.out.println("Adicionando Cobrancas");
            try(Connection connection = DBConnector.getConexao()) {
                
                String sql = "SELECT * FROM matricula;";
                PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()){
                    if (verificaBoletos(rs.getInt("idmatricula")) == true) {
                        sql = "UPDATE matricula SET status = 1 WHERE idmatricula = "+ rs.getInt("idmatricula")+"";
                        preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                        preparedStatement.executeUpdate();
                    }
                    sql = "INSERT INTO boletos (valor, vencimento, idaluno) VALUES (?, ?, ?)";
                    preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    preparedStatement.setInt(1, calculaCobranca(rs.getInt("idmatricula")));
                    formatter = new SimpleDateFormat("yyyy/MM/dd");
                    String dataaux = formatter.format(dataatual);
                    Date dateaux = formatter.parse(dataaux);
                    java.sql.Date date = new java.sql.Date(dateaux.getTime());
                    preparedStatement.setDate(2, (java.sql.Date) date);
                    preparedStatement.setInt(3, rs.getInt("idmatricula"));
                    preparedStatement.executeUpdate();
                }
            }catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void removerCobranca (Integer id) {
        try (Connection connection = DBConnector.getConexao()) {
            String sql = "DELETE FROM boletos WHERE idboletos = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            if (verificaBoletos(getUsuario()) == false) {
                sql = "UPDATE matricula SET status = 0 WHERE idmatricula = "+ getUsuario() +"";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static Integer calculaCobranca(Integer id) {
        Integer valor = null;
        try(Connection connection = DBConnector.getConexao()) {
            String sql = "SELECT pacote, plano, COUNT(*) as soma_plano FROM matricula WHERE idmatricula = "+ id +" GROUP BY pacote, plano ORDER BY plano ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                if (rs.getString("pacote").equals("Mensal")) {
                    if (rs.getString("plano").equals("Basico")) {
                        valor = 30;
                    }
                    else if (rs.getString("plano").equals("Intermediario")) {
                        valor = 55;
                    }
                    else {
                        valor = 100;
                    }
                }
                if (rs.getString("pacote").equals("Trimestral")) {
                    if (rs.getString("plano").equals("Basico")) {
                        valor = 80;
                    }
                    else if (rs.getString("plano").equals("Intermediario")) {
                        valor = 150;
                    }
                    else {
                        valor = 270;
                    }
                }
                if (rs.getString("pacote").equals("Anual")) {
                    if (rs.getString("plano").equals("Basico")) {
                        valor = 288;
                    }
                    else if (rs.getString("plano").equals("Intermediario")) {
                        valor = 528;
                    }
                    else {
                        valor = 720;
                    }
                }
            }
        }catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return valor;
    }

    public static Boolean verificaBoletos(Integer id) {
        try (Connection connection = DBConnector.getConexao()) {
            String sql = "SELECT * FROM boletos WHERE idaluno = "+ id +"";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
               return true;                          
            }
            else {
                return false;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static Boolean verificaStatus(Integer id) {
        try (Connection connection = DBConnector.getConexao()) {
            String sql = "SELECT status FROM matricula WHERE idmatricula = "+ id +"";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                if (rs.getInt("status") == 1) {
                    return true;
                }
                else {
                    return false;
                }                
            }
            else {
                return false;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static CobrancaDTO setUsuario(Integer id) {
        cobrancaDTO.setId(id);
        return cobrancaDTO;
    }

    public static Integer getUsuario() {
        return cobrancaDTO.getId();
    }

}
