package com.sistemaacademiams.academiawb.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.academia.model.db.DBConnector;
import com.academia.model.service.CobrancaService;
import com.academia.model.service.FinanceiroService;
import com.academia.model.service.LogService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(name = "IndexServlet", urlPatterns = {"/IndexServlet"})
public class IndexServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, ParseException {
            HttpSession session = request.getSession(true);
            try(Connection connection = DBConnector.getConexao()) {
                String senha = request.getParameter("senha");
                String login = request.getParameter("login");

                String sql = "SELECT * FROM funcionario WHERE nome=? and cpf=?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, login);
                preparedStatement.setString(2, senha);

                ResultSet rs = preparedStatement.executeQuery();
                if (login.equals("admin") && senha.equals("123")) {
                    FinanceiroService.caculaDebitos();
                    FinanceiroService.calculaFaturamento();
                    try {
                        FinanceiroService.calculaReceita();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    CobrancaService.adicionaCobranca();
                    LogService.setUsuario("admin");
                    session.setAttribute("debitos", FinanceiroService.getPagamentos());
                    session.setAttribute("faturamento", FinanceiroService.getFaturamento());
                    session.setAttribute("receita", FinanceiroService.getReceita());
                    RequestDispatcher rd = request.getRequestDispatcher("DashboardDono.jsp");   
                    rd.forward(request, response);
                }
                else if (rs.next()) {
                    LogService.setUsuario(rs.getString("nome"));
                    response.sendRedirect("DashboardFunc.jsp");      
                }
                else {
                    response.sendRedirect("index.jsp");
                }
        } catch (SQLException e) {
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
        } catch (ParseException ex) {
            Logger.getLogger(IndexServlet.class.getName()).log(Level.SEVERE, null, ex);
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

        } catch (ParseException ex) {
            Logger.getLogger(IndexServlet.class.getName()).log(Level.SEVERE, null, ex);
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
