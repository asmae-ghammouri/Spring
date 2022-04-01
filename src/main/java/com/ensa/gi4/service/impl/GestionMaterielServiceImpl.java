package com.ensa.gi4.service.impl;

import com.ensa.gi4.dao.MaterielDAOImp;
import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;

import java.util.Scanner;

public class GestionMaterielServiceImpl implements GestionMaterielService {

    private MaterielDAOImp materielDAOImp ;

    public GestionMaterielServiceImpl(MaterielDAOImp materielDAOImp) {
        this.materielDAOImp = materielDAOImp;
    }

    @Override
    public void init() {
        System.out.println("inititialisation du service");
    }

    @Override
    public void listerMateriel() {materielDAOImp.listerMateriel();
    }

    @Override
    public void ajouterNouveauMateriel() {
        System.out.println("1- pour ajouter un livre , entrer 1");
        System.out.println("2- pour ajouter une chaise, entrer 2");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if ("1".equals(next)) {

            System.out.println("entrez le nom du livre");
            String name = scanner.next();
            Materiel livre = new Livre();
            livre.setName(name);
            livre.setId();
            materielDAOImp.ajouterNouveauMateriel(livre);

        }
        else if ("2".equals(next)) {

            System.out.println("entrez le nom du chaise");
            String name = scanner.next();
            Materiel chaise =new Chaise();
            chaise.setId();
            chaise.setName(name);

            materielDAOImp.ajouterNouveauMateriel(chaise);
        }
        else {
            System.out.println("choix invalide");
        }
    }

    @Override
    public void deleteMateriel() {
        System.out.println("Entrez l'Id' du livre ou chaise que vous voulez supprimer;");
        Scanner scanner = new Scanner(System.in);
        int id = Integer.parseInt(scanner.next());

            materielDAOImp.delete(id);



    }
    @Override
    public void search() {
        System.out.println("Entrez l'Id' du livre ou chaise que vous cherchez");
        Scanner scanner = new Scanner(System.in);
        int id = Integer.parseInt(scanner.next());

        materielDAOImp.search(id);



    }

    @Override
    public void modifie() {
        System.out.println("Entrez l'Id' du livre ou chaise que vous voulez modifier");
        Scanner scanner = new Scanner(System.in);
        int id = Integer.parseInt(scanner.next());

        materielDAOImp.modifie(id);
    }
    @Override
    public void allocation()  {
        System.out.println("Entrez l'id du materiel que vous voulez allouer : ");
        Scanner scanner = new Scanner(System.in);
        int id = Integer.parseInt(scanner.next());
        materielDAOImp.allocation(id);
    }
}