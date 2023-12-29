package com.rbnbproject.rbnbcloneproject.dao;

import com.rbnbproject.rbnbcloneproject.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationDao extends JpaRepository<Reservation,String> {
}
