package controller;

import dao.PendaftaranDAO;
import model.Pendaftaran;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PendaftaranServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PendaftaranDAO dao = new PendaftaranDAO();
        List<Pendaftaran> pendaftaranList = dao.getAllPendaftaran();
        
        request.setAttribute("pendaftaranList", pendaftaranList);
        request.getRequestDispatcher("/view/pendaftaran/list.jsp").forward(request, response);
    }
}