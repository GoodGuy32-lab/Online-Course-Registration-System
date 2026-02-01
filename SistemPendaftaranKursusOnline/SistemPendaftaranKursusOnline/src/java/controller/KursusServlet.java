package controller;

import dao.KursusDAO;
import model.Kursus;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KursusServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        KursusDAO dao = new KursusDAO();
        List<Kursus> kursusList = dao.getAllKursus();
        
        request.setAttribute("kursusList", kursusList);
        request.getRequestDispatcher("/view/kursus/list.jsp").forward(request, response);
    }
}