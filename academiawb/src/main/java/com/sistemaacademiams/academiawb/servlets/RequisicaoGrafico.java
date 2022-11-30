package com.sistemaacademiams.academiawb.servlets;

import com.academia.model.db.DBConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(name = "RequisicaoGrafico", urlPatterns = {"/RequisicaoGrafico"})
public class RequisicaoGrafico extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
                response.setContentType("text/html;charset=UTF-8");
                try(Connection connection = DBConnector.getConexao()) {
                    
                    String sql = "SELECT * FROM receita GROUP BY data";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    ResultSet rs = preparedStatement.executeQuery();
                    ResultSetMetaData meta = rs.getMetaData();
                    String coluna = "";
                    for(int c = 1; c<=meta.getColumnCount(); c++){
                        coluna += meta.getColumnName(c)+";";
                    }
                    response.getWriter().write(coluna.toUpperCase()+"@");
                    
                    while(rs.next()) {
                        Date date = rs.getDate("data");
                        SimpleDateFormat formatter = new SimpleDateFormat("MMMM");
                        String mes = formatter.format(date);
                        Integer valor = rs.getInt("valor");
                        response.getWriter().write(mes+";"+valor+"@");
                    }
          
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
        
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(FinanceiroServlet.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(FinanceiroServlet.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
