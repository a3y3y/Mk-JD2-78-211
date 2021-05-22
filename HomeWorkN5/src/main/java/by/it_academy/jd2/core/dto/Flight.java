package by.it_academy.jd2.core.dto;

import javax.persistence.*;

/**
 * Flight data transfer object. This class is also used as an entity for hibernate.
 * @author Maksim Perekladov
 * @version 0.0
 */

@Entity
@Table(name = "flights", schema = "bookings")
@SqlResultSetMapping(name="FlightResult", classes = {
        @ConstructorResult(targetClass = Flight.class,
                columns = {@ColumnResult(name="flight_no"), @ColumnResult(name="scheduled_departure"),
                        @ColumnResult(name="scheduled_arrival"), @ColumnResult(name="status"),
                        @ColumnResult(name="departure_airport"), @ColumnResult(name="arrival_airport"),
                        @ColumnResult(name="aircraft_model")})
})
public class Flight {
    @Id
    @Column(name = "flight_id")
    private int id;
    @Column(name = "flight_no")
    private String flightNo;
    @Column(name = "scheduled_departure")
    private String scheduledDeparture;
    @Column(name = "scheduled_arrival")
    private String scheduledArrival;
    private String status;
    @Transient
    private String departureAirport;
    @Transient
    private String arrivalAirport;
    @Column(name = "aircraft_code")
    private String aircraftModel;

    /** Creates relationships between airport and flight table for working with sql database. */
    @ManyToOne
    @JoinColumn(name = "departure_airport")
    private Airport departureAirportObject;

    /** Creates relationships between airport and flight table for working with sql database. */
    @ManyToOne
    @JoinColumn(name = "arrival_airport")
    private Airport arrivalAirportObject;

    /** Gets departure airport object.
     * @return departure airport
     */
    public Airport getDepartureAirportObject() {
        return departureAirportObject;
    }

    /** Sets departure airport object.
     * @param departureAirportObject - departure airport
     */
    public void setDepartureAirportObject(Airport departureAirportObject) {
        this.departureAirportObject = departureAirportObject;
    }

    /** Gets arrival airport object.
     * @return arrival airport
     */
    public Airport getArrivalAirportObject() {
        return arrivalAirportObject;
    }

    /** Sets arrival airport object.
     * @param arrivalAirportObject - arrival airport
     */
    public void setArrivalAirportObject(Airport arrivalAirportObject) {
        this.arrivalAirportObject = arrivalAirportObject;
    }

    /** Gets flight id.
     * @return fkight id
     */
    public int getId() {
        return id;
    }

    /** Sets id.
     * @param id - flight id
     */
    public void setId(int id) {
        this.id = id;
    }

    /** Sets flight number.
     * @param flightNo - flight number
     */
    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    /** Sets scheduled departure.
     * @param scheduledDeparture - scheduled departure time
     */
    public void setScheduledDeparture(String scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }

    /** Sets scheduled arrival.
     * @param scheduledArrival - scheduled arrival time
     */
    public void setScheduledArrival(String scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }

    /** Sets flight status.
     * @param status - flight status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /** Sets departure airport.
     * @param departureAirport - departure airport
     */
    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    /** Sets arrival airport.
     * @param arrivalAirport - arrival airport
     */
    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    /** Sets aircraft model.
     * @param aircraftModel - aircraft model
     */
    public void setAircraftModel(String aircraftModel) {
        this.aircraftModel = aircraftModel;
    }

    /** Gets flight number.
     * @return flight number
     */
    public String getFlightNo() {
        return flightNo;
    }

    /** Gets scheduled departure.
     * @return scheduled departure
     */
    public String getScheduledDeparture() {
        return scheduledDeparture;
    }

    /** Gets scheduled arrival.
     * @return scheduled arrival
     */
    public String getScheduledArrival() {
        return scheduledArrival;
    }

    /** Gets flight status.
     * @return flight status
     */
    public String getStatus() {
        return status;
    }

    /** Gets departure airport.
     * @return departure airport
     */
    public String getDepartureAirport() {
        return departureAirport;
    }

    /** Gets arrival airport.
     * @return arrival airport
     */
    public String getArrivalAirport() {
        return arrivalAirport;
    }

    /** Gets aircraft model.
     * @return aircraft model
     */
    public String getAircraftModel() {
        return aircraftModel;
    }

    /** Overrides method toString(), returns String with flight attributes */
    @Override
    public String toString() {
        return "Flight{" +
                "flightNo='" + flightNo + '\'' +
                ", scheduledDeparture='" + scheduledDeparture + '\'' +
                ", scheduledArrival='" + scheduledArrival + '\'' +
                ", status='" + status + '\'' +
                ", departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", aircraftModel='" + aircraftModel + '\'' +
                '}';
    }

    /** Constructs flight objects with empty fields. */
    public Flight() {
    }

    /** Constructs flight objects with specified parameters
     * @param flightNo flight number
     * @param scheduledDeparture flight scheduled departure
     * @param scheduledArrival flight scheduled arrival
     * @param status flight status
     * @param departureAirport flight departure airport
     * @param arrivalAirport flight arrival airport
     * @param aircraftModel flight aircraft model
     */
    public Flight(String flightNo, String scheduledDeparture, String scheduledArrival,
                  String status, String departureAirport, String arrivalAirport,
                  String aircraftModel) {
        this.flightNo = flightNo;
        this.scheduledDeparture = scheduledDeparture;
        this.scheduledArrival = scheduledArrival;
        this.status = status;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.aircraftModel = aircraftModel;
    }
}
