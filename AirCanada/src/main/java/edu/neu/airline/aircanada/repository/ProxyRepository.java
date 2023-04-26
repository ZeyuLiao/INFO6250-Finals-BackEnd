package edu.neu.airline.aircanada.repository;

import edu.neu.airline.aircanada.entity.Passenger;
import edu.neu.airline.aircanada.entity.Proxy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProxyRepository extends JpaRepository<Proxy,String> {

    @Query("DELETE FROM Proxy f WHERE f.flight_number = :flight_number AND f.proxy_company = :proxy_company")
    void deleteProxyByFlightAndCompany(@Param("proxy_company") String flight_number,@Param("proxy_company") String proxy_company);

    @Query("SELECT DISTINCT f.proxy_company FROM Proxy f WHERE f.flight_number = ?1")
    List<String> findDistinctProxyCompaniesByFlightNumber(@Param("flightNumber") String flight_number);
}
