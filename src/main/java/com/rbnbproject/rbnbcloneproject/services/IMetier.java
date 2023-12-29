package com.rbnbproject.rbnbcloneproject.services;

import java.util.List;

public interface IMetier<E,Id>{
    /**
     * Ajouter Une Entité
     */
    E addEntity(E e);
    /**
     * Rechercher une Entité
     */
    E findEntite(Id id);

    /**
     * Liste des Des Entités
     */
    List<E>findAll();
    /**
     * Supprimer une Entité
     */
    void deleteEntite(Id id);
    /**
     * void updateEntite
     */
    void updateEntitie(E e,Id id);
}
