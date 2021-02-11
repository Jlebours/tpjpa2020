package servlet;

import dao.KandanBoardDao;
import jpa.entities.KanbanBoard;
import jpa.entities.Utilisateur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "mytest",
        urlPatterns = {"/myurl"})
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter p = new PrintWriter(resp.getOutputStream());

        KandanBoardDao kanbanDao = new KandanBoardDao();
        List<KanbanBoard> liste = kanbanDao.getKanbanBoards();
        for (KanbanBoard kanban : liste) {
            p.print(kanban.getNom());
        }

        p.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
}
