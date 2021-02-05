package dao;

import jpa.entities.Fiche;

public class FicheDao extends AbstractJpaDao<Long, Fiche> {

    public FicheDao() {
        super(Fiche.class);
    }

}
