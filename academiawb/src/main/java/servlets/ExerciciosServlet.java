package servlets;

import academiawb.model.service.ExerciciosService;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ExerciciosServlet", urlPatterns = {"/ExerciciosServlet"})
public class ExerciciosServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
            String operacao = request.getParameter("op");
           
            String idstr;
            Integer id;
            String plano;
            String descricao;
            String serie;
            String repeticoes;
            
            switch (operacao) {
                case "a":
                    plano = request.getParameter("plano");
                    descricao = request.getParameter("descricao");
                    serie = request.getParameter("serie");
                    repeticoes = request.getParameter("repeticoes");

                    ExerciciosService.adicionarExercicios(plano, descricao, serie, repeticoes);
                    response.sendRedirect("Exercicios.jsp");
                    break;
                case "d":
                    idstr = request.getParameter("id");
                    id = Integer.valueOf(idstr);
                    ExerciciosService.removerExercicio(id);
                    response.sendRedirect("Exercicios.jsp");
                    break;
                default:
                    response.sendRedirect("Exercicios.jsp");
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
            Logger.getLogger(ExerciciosServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExerciciosServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ExerciciosServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExerciciosServlet.class.getName()).log(Level.SEVERE, null, ex);
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
