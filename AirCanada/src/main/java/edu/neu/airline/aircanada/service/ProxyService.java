package edu.neu.airline.aircanada.service;

import edu.neu.airline.aircanada.entity.Proxy;
import edu.neu.airline.aircanada.repository.ProxyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
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


    // when proxy is not available send delete request to target airline company
    public void requestRemoveProxy(String flight_number){

        Map<String,String> mp = new HashMap<>();
        mp.put("AC","http://localhost:8091/removeProxy?proxy_flight_number={proxy_flight_number}");
        mp.put("CA","http://localhost:8092/removeProxy?proxy_flight_number={proxy_flight_number}");
        mp.put("EK","http://localhost:8093/removeProxy?proxy_flight_number={proxy_flight_number}");
        mp.put("LH","http://localhost:8094/removeProxy?proxy_flight_number={proxy_flight_number}");
        mp.put("DL","http://localhost:8095/removeProxy?proxy_flight_number={proxy_flight_number}");
        for(String airline: proxyRepository.findDistinctProxyCompaniesByFlightNumber(flight_number)){
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.delete(mp.get(airline), flight_number);
            proxyRepository.deleteProxyByCompany(airline);
        }
    }
}
