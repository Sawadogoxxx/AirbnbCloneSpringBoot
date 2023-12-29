package com.rbnbproject.rbnbcloneproject.services;

import com.rbnbproject.rbnbcloneproject.dao.ReservationDao;
import com.rbnbproject.rbnbcloneproject.enums.TypeVoyageur;
import com.rbnbproject.rbnbcloneproject.exceptions.EntityExistException;
import com.rbnbproject.rbnbcloneproject.exceptions.EntityNotFoundException;
import com.rbnbproject.rbnbcloneproject.model.House;
import com.rbnbproject.rbnbcloneproject.model.Reservation;
import com.rbnbproject.rbnbcloneproject.model.Voyageur;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Transactional
@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationDao reservationDao;
    private final HouseServiceImpl houseService;

    public ReservationServiceImpl(ReservationDao reservationDao, HouseServiceImpl houseService, VoyageurServiceImpl voyageurService) {
        this.reservationDao = reservationDao;
        this.houseService = houseService;
    }

    @Override
    public Reservation addEntity(Reservation reservation) {
        if(reservation==null)
            throw new EntityNotFoundException("Cette reservation est invalide!!");
        reservation.setId(UUID.randomUUID().toString());
        return this.reservationDao.save(reservation);
    }

    @Override
    public Reservation findEntite(String id) {
        return this.reservationDao.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Cette reservation est introuvable!!!"));
    }

    @Override
    public List<Reservation> findAll() {
        return this.reservationDao.findAll();
    }

    @Override
    public void deleteEntite(String id) {
        Reservation reservation=this.findEntite(id);
        this.reservationDao.delete(reservation);
    }

    public Reservation saveReservation(Reservation reservation,String houseId){
        if(reservation==null)
            throw new EntityNotFoundException("Cette Reservation est invalide Veillez bien Renseigner!!!");
        if(reservation.getVoyageurs().isEmpty())throw new EntityNotFoundException("La liste de  voyageurs  est invalide!!!");

        List<TypeVoyageur>typeVoyageurs=new ArrayList<>();
        reservation.getVoyageurs().forEach(voyageur -> typeVoyageurs.add(voyageur.getTypeVoyageur()));
        if(typeVoyageurs.size()>3)throw new RuntimeException("Erreur le nombre de type de Voyageur et incorrect!!");


        House house=this.houseService.findEntite(houseId);
        reservation.setHouse(house);
        Integer nbPersonne=reservation.getVoyageurs()
                .stream().mapToInt(Voyageur::getNbplace)
                .sum();
        if(nbPersonne>house.getNbmaxPerso())
            throw new RuntimeException("Une Erreur est Survenue le nombre de Personne maximun est dépassé");

      return   this.addEntity(reservation);
    }
    @Override
    public void updateEntitie(Reservation reservation, String s) {

    }


}
