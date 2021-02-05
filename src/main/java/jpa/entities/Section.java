package jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Section implements Serializable {

    long id;
    String nom;
    List<Fiche> listeFiches;
    KanbanBoard kanbanBoard;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @OneToMany(mappedBy = "section", cascade = CascadeType.PERSIST)
    public List<Fiche> getListeFiches() {
        return listeFiches;
    }

    public void setListeFiches(List<Fiche> listeFiches) {
        this.listeFiches = listeFiches;
    }

    @ManyToOne
    public KanbanBoard getKanbanBoard() {
        return kanbanBoard;
    }

    public void setKanbanBoard(KanbanBoard kanbanBoard) {
        this.kanbanBoard = kanbanBoard;
    }
}
