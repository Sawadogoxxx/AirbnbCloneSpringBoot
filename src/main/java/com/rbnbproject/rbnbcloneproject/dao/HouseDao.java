package com.rbnbproject.rbnbcloneproject.dao;

import com.rbnbproject.rbnbcloneproject.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseDao extends JpaRepository<House,String> {
}
