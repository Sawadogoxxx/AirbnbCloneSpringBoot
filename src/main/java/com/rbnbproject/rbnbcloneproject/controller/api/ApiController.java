package com.rbnbproject.rbnbcloneproject.controller.api;
import org.springframework.http.ResponseEntity;
import java.util.List;


public interface ApiController<E,Id> {
    /**
     * Ajouter Une Entité
     */
    ResponseEntity<?> addEntity(E entity);
    /**
     * Rechercher une Entité
     */
    ResponseEntity<E> findEntite(Id id);

    /**
     * Liste des Des Entités
     */
    List<E> findAll();
    /**
     * Supprimer une Entité
     */
    ResponseEntity<String> deleteEntite(Id id);
    /**
     * void updateEntite
     */
    ResponseEntity<E> updateEntitie(E e,Id id);
}
