package edu.neu.airline.aircanada.controller;

import edu.neu.airline.aircanada.entity.Proxy;
import edu.neu.airline.aircanada.service.ProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ProxyController {
    @Autowired
    ProxyService proxyService;

    @GetMapping("/addProxy")
    public ResponseEntity<?> addProxy(@RequestParam String flight_number, @RequestParam String company_name){
        Proxy proxy = new Proxy();
        proxy.setProxy_company(company_name);
        proxy.setFlight_number(flight_number);
        proxyService.addProxy(proxy);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
