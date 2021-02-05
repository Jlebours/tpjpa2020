package jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class KanbanBoard implements Serializable {

    private long id;
    private String nom;
    List<Section> listeSections;
    List<Utilisateur> listeUtilisateurs;

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

    @OneToMany(mappedBy = "kanbanBoard", cascade = CascadeType.REMOVE)
    public List<Section> getListeSections() {
        return listeSections;
    }

    public void setListeSections(List<Section> listeSections) {
        this.listeSections = listeSections;
    }

    @ManyToMany(mappedBy = "listeKanbansBoard")
    public List<Utilisateur> getListeUtilisateurs() {
        return listeUtilisateurs;
    }

    public void setListeUtilisateurs(List<Utilisateur> listeUtilisateurs) {
        this.listeUtilisateurs = listeUtilisateurs;
    }
}
