package com.rbnbproject.rbnbcloneproject.controller;

import com.rbnbproject.rbnbcloneproject.controller.api.AppRoute;
import com.rbnbproject.rbnbcloneproject.services.ServiceLogementServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = AppRoute.root)
public class ServiceLogementController{

    private final ServiceLogementServiceImpl serviceLogementService;

    public ServiceLogementController(ServiceLogementServiceImpl serviceLogementService) {
        this.serviceLogementService = serviceLogementService;
    }


    @PostMapping("/addservicetohouse/{serviceId}/{houseId}")
    public ResponseEntity<String>addServiceToHouse(@PathVariable("serviceId")Integer id,
                                                   @PathVariable("houseId")String houseId){
        this.serviceLogementService.addServiceToHouse(houseId,id);
        return ResponseEntity.ok().body("Service Logement ajouté avec success");
    }
}
