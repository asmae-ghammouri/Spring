package com.ensa.gi4.controller;

import com.ensa.gi4.service.api.GestionMaterielService;

import java.util.Scanner;

public class GestionMaterielController {

    private GestionMaterielService gestionMaterielService;

    public void listerMateriel() {

        gestionMaterielService.listerMateriel();
    }
    public void ajouterNouveauMateriel() {
        gestionMaterielService.ajouterNouveauMateriel();
    }
    public void deleteMateriel() {
        gestionMaterielService.deleteMateriel();
    }
    public void searchMateriel() {
        gestionMaterielService.search();
    }
    public void allocateMateriel() {
        gestionMaterielService.allocation();
    }
    public void modifieMateriel() {
        gestionMaterielService.modifie();
    }
    public void afficherMenu() {

        System.out.println("1- pour lister le matériel, entrer 1");
        System.out.println("2- pour ajouter un nouveau matériel, entrer 2");
        System.out.println("3- pour supprimer un  matériel par id, entrer 3");
        System.out.println("4- pour chercher un  matériel par id, entrer 4");
        System.out.println("5- pour modifier un  matériel , entrer 5");
        System.out.println("6- pour allocer un  matériel , entrer 6");
        System.out.println("0- pour sortir de l'application, entrer 0");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if ("0".equals(next)) {
            sortirDeLApplication();
        } else if ("1".equals(next)) {
            listerMateriel();
        } else if ("2".equals(next)) {
            ajouterNouveauMateriel();
        } else if ("3".equals(next)) {
           deleteMateriel();
        }
        else if ("4".equals(next)) {
            searchMateriel();
        } else if ("5".equals(next)) {
            modifieMateriel();
        }else if ("6".equals(next)) {
            allocateMateriel();
        } else{
            System.out.println("choix invalide");
        }
    }

    private void sortirDeLApplication() {
        System.exit(0);
    }

    public void setGestionMaterielService(GestionMaterielService gestionMaterielService) {
        // injection par accesseur
        this.gestionMaterielService = gestionMaterielService;
    }
}
