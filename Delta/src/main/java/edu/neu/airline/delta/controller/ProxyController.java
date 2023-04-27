package edu.neu.airline.delta.controller;


import edu.neu.airline.delta.entity.Proxy;
import edu.neu.airline.delta.service.ProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/removeProxy")
    public ResponseEntity<?> removeProxy(@RequestParam String flight_number, @RequestParam String company_name){
        proxyService.removeProxy(flight_number,company_name);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
