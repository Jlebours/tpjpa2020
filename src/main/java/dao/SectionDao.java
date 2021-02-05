package dao;

import jpa.entities.Section;

public class SectionDao extends AbstractJpaDao<Long, Section> {

    public SectionDao() {
        super(Section.class);
    }
}
