package jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role",discriminatorType = DiscriminatorType.STRING)
@NamedQueries({
        @NamedQuery(name = "touslesutilisateurs", query = "select u from Utilisateur u"),
        @NamedQuery(name = "touslesutilisateursPARNOM", query = "select u from Utilisateur u where u.nom=:nom")
        })
public class Utilisateur implements Serializable {

    String mail;
    String nom;
    List<Fiche> listeFiches;
    List<KanbanBoard> listeKanbansBoard;

    @Id
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.REMOVE)
    public List<Fiche> getListeFiches() {
        return listeFiches;
    }

    public void setListeFiches(List<Fiche> listeFiches) {
        this.listeFiches = listeFiches;
    }

    @ManyToMany
    public List<KanbanBoard> getListeKanbansBoard() {
        return listeKanbansBoard;
    }

    public void setListeKanbansBoard(List<KanbanBoard> listeKanbansBoard) {
        this.listeKanbansBoard = listeKanbansBoard;
    }

    public String toString(){
        return "Mail de l'utilisateur : " + getMail();
    }
}
