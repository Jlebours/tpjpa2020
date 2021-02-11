package dao;

import jpa.entities.KanbanBoard;
import jpa.entities.Utilisateur;

import java.util.List;

public class KandanBoardDao extends AbstractJpaDao<Long, KanbanBoard> {

    public KandanBoardDao() {
        super(KanbanBoard.class);
    }

    public List<KanbanBoard> getKanbanBoards(){
        String query = "select k from KanbanBoard as k";
        return entityManager.createQuery(query, KanbanBoard.class).getResultList();
    }

}
