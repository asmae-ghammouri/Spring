package com.ensa.gi4.dao;

import com.ensa.gi4.database.DB;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MaterielDAOImp implements MaterielDAO{
    DB db ;

    public MaterielDAOImp(DB db) {
        this.db = db;
    }

    @Override
    public void listerMateriel() {


        int livre=0;
        int chaise=0;
        for( Materiel materiel : db.materiels){

            if(materiel.getClass().getName().equals("com.ensa.gi4.modele.Livre")){
                livre++;
                System.out.println( "Livre : " + "(" + materiel.getId() +", "+ materiel.getName()+")");
            }
            if(materiel.getClass().getName().equals("com.ensa.gi4.modele.Chaise")){
                chaise++;
                System.out.println( "Chaise : " + "(" + materiel.getId() +", "+ materiel.getName()+")");
            }



        }
        System.out.println("Liste de matériel :\n" + livre + " Livres \n"+ chaise +" chaises");
    }

    @Override
    public void ajouterNouveauMateriel(Materiel materiel) {

        db.materiels.add(materiel);
    }

    @Override
    public void delete(int id) {
        int delete =0;

        for( Materiel materiel : db.materiels){
            if(materiel.getId()==id){
                delete = 1;
                db.materiels.remove(materiel);
                System.out.println("Materiel with id " + id +" deleted");
                break;
            }
        }
        if(delete ==0){
            System.out.println("Materiel with id " + id +" does'nt exist");
        }



    }

    @Override
    public void search(int id) {
        int search =0;

        for( Materiel materiel : db.materiels){
            if(materiel.getId()==id){
                search = 1;
                System.out.println("Materiel with id " + id +" exists");
                break;
            }
        }
        if(search ==0){
            System.out.println("Materiel with id " + id +" does'nt exist");
        }



    }

    @Override
    public void modifie(int id) {
        int modifie =0;

        for( Materiel materiel : db.materiels){
            if(materiel.getId()==id){
                modifie = 1;
                String oldName=materiel.getName();
                System.out.println("Entrez le nouveau nom");
                Scanner scanner = new Scanner(System.in);
                String name = scanner.next();
                materiel.setName(name);
                System.out.println("successfully modifed from " +oldName +" to " +name);
                break;
            }
        }
        if(modifie ==0){
            System.out.println("Materiel with id " + id +" does'nt exist");
        }

    }
    @Override
    public void allocation(int id)  {
        int allouer = 0;

            for (Materiel materiel : db.materiels) {
                if (materiel.getId() == id) {
                    allouer=1;
                    db.materiels.remove(materiel);
                    System.out.println("Combien du temps voulez vous allouer ce materiel  ");
                    Scanner scanner = new Scanner(System.in);
                    String time = scanner.next();

                    new Thread(() -> {
                        try {
                            TimeUnit.SECONDS.sleep(
                                    Long.parseLong(time));
                            db.materiels.add(materiel);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();
                    System.out.println("the Materiel with id " + id + " allocate with seccess");
                    break;
                }
            }
            if (allouer == 0) {
                System.out.println("Materiel  with id  doesn't exist" + id);
            }

    }

}
