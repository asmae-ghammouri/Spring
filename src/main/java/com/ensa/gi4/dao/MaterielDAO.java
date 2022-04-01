package com.ensa.gi4.dao;

import com.ensa.gi4.modele.Materiel;

public interface MaterielDAO {

    public void listerMateriel();

    public void ajouterNouveauMateriel(Materiel theMateriel );

    public void delete(int id);

    public void search(int id);

    public void modifie(int id);

    public void allocation(int id);
}
