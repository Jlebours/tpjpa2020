package dao;

import jpa.entities.KanbanBoard;

public class KandanBoardDao extends AbstractJpaDao<Long, KanbanBoard> {

    public KandanBoardDao() {
        super(KanbanBoard.class);
    }

}
