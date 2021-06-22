package com.example.backEnd.handler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class StationController {

    @Autowired
    private StationService stationService;

    @RequestMapping(value = "/admin/addStation", method = RequestMethod.POST)
    public ResponseEntity<Object> addStation(@RequestBody StationRequestBody stationRequest) {

   
        Integer stationId = stationService.addStation(stationRequest);

        //if add unsuccessfully, return bad request
        if (stationId == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        //if add successfully, get a list of stations
        List<StationInfoResponseBody> stationList = stationService.getAllStations();

        //return a list of stations and status
        return new ResponseEntity<>(stationList, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/allStations", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllStations() {

        //get all stations as a list
        List<StationInfoResponseBody> stationList = stationService.getAllStations();

        //return a list of stations and status
        return new ResponseEntity<>(stationList, HttpStatus.OK);
    }
}
