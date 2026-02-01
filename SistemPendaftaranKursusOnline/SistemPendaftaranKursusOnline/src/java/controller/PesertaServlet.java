package controller;

import dao.PesertaDAO;
import model.Peserta;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PesertaServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PesertaDAO dao = new PesertaDAO();
        List<Peserta> pesertaList = dao.getAllPeserta();
        
        // Set data ke request
        request.setAttribute("pesertaList", pesertaList);
        
        // Forward ke JSP
        request.getRequestDispatcher("/view/peserta/list.jsp").forward(request, response);
    }
}