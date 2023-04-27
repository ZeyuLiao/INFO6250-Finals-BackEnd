package edu.neu.airline.emirates.service;


import edu.neu.airline.emirates.entity.Proxy;
import edu.neu.airline.emirates.repository.ProxyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProxyService {

    @Autowired
    ProxyRepository proxyRepository;

    public void addProxy(Proxy proxy){
        proxyRepository.save(proxy);
    }

    @Transactional
    public void removeProxy(String flight_number,String airline){
        proxyRepository.deleteProxyByFlightAndCompany(flight_number,airline);
    }

    @Transactional
    // when proxy is not available send delete request to target airline company
    public void requestRemoveProxy(String flight_number){

        Map<String,String> mp = new HashMap<>();
        mp.put("AC","http://localhost:8091/outsideApi/deleteProxy?proxy_flight_number={proxy_flight_number}");
        mp.put("CA","http://localhost:8092/outsideApi/deleteProxy?proxy_flight_number={proxy_flight_number}");
        mp.put("EK","http://localhost:8093/outsideApi/deleteProxy?proxy_flight_number={proxy_flight_number}");
        mp.put("LH","http://localhost:8094/outsideApi/deleteProxy?proxy_flight_number={proxy_flight_number}");
        mp.put("DL","http://localhost:8095/outsideApi/deleteProxy?proxy_flight_number={proxy_flight_number}");
        for(String airline: proxyRepository.findDistinctProxyCompaniesByFlightNumber(flight_number)){
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.delete(mp.get(airline), flight_number);
            proxyRepository.deleteProxyByFlightAndCompany(flight_number,airline);
        }
    }
}
