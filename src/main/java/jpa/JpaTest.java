package jpa;

import dao.FicheDao;
import dao.KandanBoardDao;
import dao.SectionDao;
import dao.UtilisateurDao;
import jpa.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//Creation de kanbans
		KandanBoardDao kanbanDao = new KandanBoardDao();
		KanbanBoard tab1 = new KanbanBoard();
		tab1.setNom("Premier Kanban");
		kanbanDao.save(tab1);
		KanbanBoard tab2 = new KanbanBoard();
		tab2.setNom("Second Kanban");
		kanbanDao.save(tab2);

		//Creation de sections
		SectionDao sectionDao = new SectionDao();
		Section sec1 = new Section();
		sec1.setNom("A faire");
		sec1.setKanbanBoard(tab1);
		sectionDao.save(sec1);
		Section sec2 = new Section();
		sec2.setNom("En cours");
		sec2.setKanbanBoard(tab1);
		sectionDao.save(sec2);
		Section sec3 = new Section();
		sec3.setNom("Termine");
		sec3.setKanbanBoard(tab1);
		sectionDao.save(sec3);

		//Creation de fiches
		FicheDao ficheDao = new FicheDao();
		Fiche fiche1 = new Fiche();
		fiche1.setLibelle("Premiere fiche");
		fiche1.setSection(sec1);
		ficheDao.save(fiche1);

		//Creation des utilisateurs
		UtilisateurDao utiDao = new UtilisateurDao();
		Utilisateur uti1 = new Utilisateur();
		uti1.setMail("premieruti@gmail.com");
		uti1.setNom("Yves");
		List<KanbanBoard> kanbanUti1 = new ArrayList<>();
		kanbanUti1.add(tab1);
		uti1.setListeKanbansBoard(kanbanUti1);
		utiDao.save(uti1);
		Admin uti2 = new Admin();
		uti2.setMail("admin@gmail.com");
		uti2.setListeKanbansBoard(kanbanUti1);
		uti2.setEquipe("Maintenance");
		utiDao.save(uti2);

		//Execution des requetes
		System.out.println("Premiere requete :");
		System.out.println(utiDao.getUtilisateurWithMail().toString());
		System.out.println("Seconde requete :");
		List<Utilisateur> liste = utiDao.getUtilisateurs();
		for (Utilisateur uti : liste){
			System.out.println(uti.toString());
		}
		System.out.println("Troisieme requete :");
		System.out.println(utiDao.getUtilisateurWithMailCriteria("Yves"));

		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

		//factory.close();
	}


}
