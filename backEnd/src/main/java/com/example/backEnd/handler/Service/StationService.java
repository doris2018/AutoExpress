package com.example.backEnd.handler.Service;


import com.example.backEnd.handler.dao.StationDao;
import com.example.backEnd.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationService {

    @Autowired
    private StationDao stationDao;

    public Integer addStation(StationRequestBody stationRequest) {
        return stationDao.addStation(stationRequest);
    }

    public List<StationInfoResponseBody> getAllStations() {
        return stationDao.getAllStations();
    }

    public Station getStationById(int stationId) {
        return stationDao.getStationById(stationId);
    }
}
