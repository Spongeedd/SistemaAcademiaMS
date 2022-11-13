package servlets;

import academiawb.model.service.MatriculaService;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "MatriculaServlet", urlPatterns = {"/MatriculaServlet"})
public class MatriculaServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
            String operacao = request.getParameter("op");
            
            String nome;
            String cpf;
            String datastr;
            String email;
            String endereco;
            String telefone;
            String plano;
            String pacote;
            Date nascimento;
            String idstr;
            Integer id;
            
            switch (operacao) {
                case "a":
                    nome = request.getParameter("nome");
                    cpf = request.getParameter("cpf");
                    datastr = request.getParameter("nascimento");
                    email = request.getParameter("email");
                    endereco = request.getParameter("endereco");
                    telefone = request.getParameter("telefone");

                    plano = request.getParameter("plano");
                    pacote = request.getParameter("pacote");
                    nascimento = Date.valueOf(datastr);

                    MatriculaService.adicionarMatricula(nome, cpf, nascimento, endereco, telefone, email, plano, pacote);
                    response.sendRedirect("Matricula.jsp");
                    break;
                case "d":
                    idstr = request.getParameter("id");
                    id = Integer.valueOf(idstr);
                    MatriculaService.removerMatricula(id);
                    response.sendRedirect("Matricula.jsp");
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
                    plano = request.getParameter("plano");
                    pacote = request.getParameter("pacote");
                    nascimento = Date.valueOf(datastr);
                    
                    MatriculaService.editarMatricula(id, nome, cpf, nascimento, endereco, telefone, email, plano, pacote);
                    response.sendRedirect("Matricula.jsp");
                    break;
                default:
                    response.sendRedirect("Matricula.jsp");
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
        } catch (SQLException ex) {
            Logger.getLogger(MatriculaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MatriculaServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(MatriculaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MatriculaServlet.class.getName()).log(Level.SEVERE, null, ex);
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
