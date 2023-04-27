package edu.neu.booking.ticketbooking.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.neu.booking.ticketbooking.constant.Constants;
import edu.neu.booking.ticketbooking.entity.vo.Flights;
import edu.neu.booking.ticketbooking.entity.vo.SearchVo;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.*;


@Service
public class FlightService {
    public List<Flights> getAllFlight(SearchVo searchVo) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        // 如果需要携带 token，则设置请求头 Authorization
        // headers.setBearerAuth("your_token_here");

        HttpEntity<SearchVo> request = new HttpEntity<>(searchVo, headers);

        List<Flights> flights = new ArrayList<>();
        //Air Canada
        ResponseEntity<List<Flights>> responseEntity = restTemplate.exchange(Constants.AC, HttpMethod.POST, request,
                new ParameterizedTypeReference<>() {
                });

        responseEntity.getBody().forEach(flights::add);
        //China Airlines
        responseEntity = restTemplate.exchange(Constants.CA, HttpMethod.POST, request,
                new ParameterizedTypeReference<>() {
                });

        responseEntity.getBody().forEach(flights::add);
        responseEntity = restTemplate.exchange(Constants.EK, HttpMethod.POST, request,
                new ParameterizedTypeReference<>() {
                });

        responseEntity.getBody().forEach(flights::add);
        responseEntity = restTemplate.exchange(Constants.LH, HttpMethod.POST, request,
                new ParameterizedTypeReference<>() {
                });

        responseEntity.getBody().forEach(flights::add);
        responseEntity = restTemplate.exchange(Constants.DL, HttpMethod.POST, request,
                new ParameterizedTypeReference<>() {
                });

        responseEntity.getBody().forEach(flights::add);

        flights.sort(Comparator.comparing(Flights::getDeparture_time));
        return flights;
    }

    public String buyTicket(String flight_number,String username) {
        String URL = "";
        switch (flight_number.substring(0,2)){
            case "CA": URL = Constants.CAT;
                break;
            case "AC": URL = Constants.ACT;
                break;
            case "EK": URL = Constants.EKT;
                break;
            case "LH": URL = Constants.LHT;
                break;
            case "DL": URL = Constants.DLT;
                break;
        }
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("flight_number", flight_number);
        uriVariables.put("username", username);
        URI uri = new UriTemplate(URL).expand(uriVariables);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                entity,
                String.class
        );

        String responseBody = response.getBody();
        return responseBody;
    }

}
