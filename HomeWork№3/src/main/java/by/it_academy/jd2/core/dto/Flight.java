package by.it_academy.jd2.core.dto;

/**
 * Flight data transfer object
 * @author Maksim Perekladov
 * @version 0.0
 */

public class Flight {
    private String flightNo;
    private String scheduledDeparture;
    private String scheduledArrival;
    private String status;
    private String departureAirport;
    private String arrivalAirport;
    private String aircraftModel;


    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public void setScheduledDeparture(String scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }

    public void setScheduledArrival(String scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }


    public void setAircraftModel(String aircraftModel) {
        this.aircraftModel = aircraftModel;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public String getScheduledDeparture() {
        return scheduledDeparture;
    }

    public String getScheduledArrival() {
        return scheduledArrival;
    }

    public String getStatus() {
        return status;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public String getAircraftModel() {
        return aircraftModel;
    }
}
