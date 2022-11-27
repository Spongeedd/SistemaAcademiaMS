package com.sistemaacademiams.academiawb.servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import com.academia.model.service.FuncionariosService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/FuncionarioServlet"})
public class FuncionarioServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
            String operacao = request.getParameter("op");
            
            String nome, cpf, datastr, email, endereco, telefone;

            String jornadastr, phorastr, idstr;
            Integer jornada, phora, id;
            Date nascimento;
            
            switch (operacao) {
                case "a":
                    nome = request.getParameter("nome");
                    cpf = request.getParameter("cpf");
                    datastr = request.getParameter("nascimento");
                    email = request.getParameter("email");
                    endereco = request.getParameter("endereco");
                    telefone = request.getParameter("telefone");

                    jornadastr = request.getParameter("jornada");
                    jornada = Integer.valueOf(jornadastr);
                    phorastr = request.getParameter("phora");
                    phora = Integer.valueOf(phorastr);
                    nascimento = Date.valueOf(datastr);

                    FuncionariosService.adicionarFuncionario(nome, cpf, nascimento, endereco, telefone, email, jornada, phora);
                    response.sendRedirect("Funcionario.jsp");
                    break;
                case "d":
                    idstr = request.getParameter("id");
                    id = Integer.valueOf(idstr);
                    FuncionariosService.removerFuncionario(id);
                    response.sendRedirect("Funcionario.jsp");
                    break;
                case "u":
                    idstr = request.getParameter("id");
                    id = Integer.valueOf(idstr);
                    
                    nome = request.getParameter("nome");
                    cpf = request.getParameter("cpf");
                    datastr = request.getParameter("nascimento");
                    email = request.getParameter("email");
                    endereco = request.getParameter("endereco");
                    telefone = request.getParameter("telefone");
                    jornadastr = request.getParameter("jornada");
                    jornada = Integer.valueOf(jornadastr);
                    phorastr = request.getParameter("phora");
                    phora = Integer.valueOf(phorastr);
                    nascimento = Date.valueOf(datastr);
                    
                    FuncionariosService.editarFuncionario(id, nome, cpf, nascimento, endereco, telefone, email, jornada, phora);
                    response.sendRedirect("Funcionario.jsp");
                    break;
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
