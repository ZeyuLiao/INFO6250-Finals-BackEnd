package edu.neu.booking.ticketbooking.constant;

public class Constants {

    /*
      { code: "AC", name: "Air Canada" },
      { code: "EK", name: "Emirates" },
      { code: "CA", name: "Air China" },
      { code: "LH", name: "Lufthansa" },
      { code: "DL", name: "Delta Air Lines" },
     */
    public static final String AC = "http://localhost:8091/outsideApi/flights";
    public static final String ACT = "http://localhost:8091/outsideApi/addPassenger?flight_number={flight_number}&username={username}";
    public static final String CA = "http://localhost:8092/outsideApi/flights";
    public static final String CAT = "http://localhost:8092/outsideApi/addPassenger?flight_number={flight_number}&username={username}";
}
