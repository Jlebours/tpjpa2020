package dao;

import jpa.entities.Utilisateur;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UtilisateurDao extends AbstractJpaDao<String, Utilisateur> {

    public UtilisateurDao() {
        super(Utilisateur.class);
    }

    public Utilisateur getUtilisateurWithMail() {
        String query = "select u from Utilisateur as u where u.mail=:mail";
        return entityManager.createQuery(query, Utilisateur.class)
                .setParameter("mail", "admin@gmail.com").getSingleResult();
    }

    public List<Utilisateur> getUtilisateurs(){
        return entityManager.createNamedQuery("touslesutilisateurs", Utilisateur.class).getResultList();
    }

    public String getUtilisateurWithMailCriteria(String nom){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> query = criteriaBuilder.createQuery(String.class);
        Root<Utilisateur> from = query.from(Utilisateur.class);
        query.select(from.get("mail")).where(from.get("nom").in(nom));
        return entityManager.createQuery(query).getSingleResult();
    }

}
