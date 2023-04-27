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
    public static final String EK = "http://localhost:8093/outsideApi/flights";
    public static final String EKT = "http://localhost:8093/outsideApi/addPassenger?flight_number={flight_number}&username={username}";
    public static final String LH = "http://localhost:8094/outsideApi/flights";
    public static final String LHT = "http://localhost:8094/outsideApi/addPassenger?flight_number={flight_number}&username={username}";
    public static final String DL = "http://localhost:8095/outsideApi/flights";
    public static final String DLT = "http://localhost:8095/outsideApi/addPassenger?flight_number={flight_number}&username={username}";

}
