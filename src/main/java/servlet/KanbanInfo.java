package servlet;

import dao.KandanBoardDao;
import jpa.entities.KanbanBoard;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "userinfo",
        urlPatterns = {"/KanbanInfo"})
public class KanbanInfo extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        /*out.println("<HTML>\n<BODY>\n" +
                "<H1>Recapitulatif des informations</H1>\n" +
                "<UL>\n" +
                " <LI>Nom du kanban board : "
                + request.getParameter("name") + "\n" +
                "</UL>\n" +
                "</BODY></HTML>");*/

        KandanBoardDao kanbanDao = new KandanBoardDao();
        KanbanBoard tab1 = new KanbanBoard();
        String kanbanName = request.getParameter("name");
        tab1.setNom(kanbanName);
        kanbanDao.save(tab1);

        response.sendRedirect("/myurl");
    }


}
