package by.it_academy.jd2.core.dto;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Airport data transfer object. This class is also used as an entity for hibernate.
 * @author Maksim Perekladov
 * @version 0.0
 */

@Entity
@Table(name = "airports_data", schema = "bookings")
public class Airport implements Comparable<Airport> {

    @Id
    @Column(name = "airport_code")
    private String code;
    @Column(name = "airport_name")
    private String name;
    private String city;
    private String coordinates;
    private String timezone;

    /** Creates relationships between airport and flight table for working with sql database. */
    @OneToMany(mappedBy = "departureAirportObject", fetch = FetchType.LAZY)
    private Set<Flight> departureFlights = new HashSet<>();

    /** Creates relationships between airport and flight table for working with sql database. */
    @OneToMany(mappedBy = "arrivalAirportObject", fetch = FetchType.LAZY)
    private Set<Flight> arrivalFlights = new HashSet<>();

    /** Sets departure flight value.
     * @return Set{@literal <}Flight{@literal >}
     */
    public Set<Flight> getDepartureFlights() {
        return departureFlights;
    }

    /** Sets Set of departure flights objects.
     * @param departureFlights - departure flights
     */
    public void setDepartureFlights(Set<Flight> departureFlights) {
        this.departureFlights = departureFlights;
    }

    /** Sets arrival flight value.
     * @return arrival flights
     */
    public Set<Flight> getArrivalFlights() {
        return arrivalFlights;
    }

    /** Sets List of arrival flights objects.
     * @param arrivalFlights - arrival flights
     */
    public void setArrivalFlights(Set<Flight> arrivalFlights) {
        this.arrivalFlights = arrivalFlights;
    }

    /** Sets airport code value.
     * @param code - airport code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /** Gets airport name value.
     * @return airport name
     */
    public String getName() {
        return name;
    }

    /** Sets airport name value.
     * @param name - airport name
     */
    public void setName(String name) {
        this.name = name;
    }

    /** Sets airport city value.
     * @param city - airport city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /** Sets airport coordinates string value.
     * @param coordinates - airport coordinates
     */
    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    /** Sets airport timezone string value.
     * @param timezone - airport timezone
     */
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    /** Gets airport code value.
     * @return airport code
     */
    public String getCode() {
        return code;
    }

    /** Gets airport city value.
     * @return airport city*/
    public String getCity() {
        return city;
    }

    /** Gets airport coordinates string value.
     * @return airport coordinates
     */
    public String getCoordinates() {
        return coordinates;
    }

    /** Gets airport timezone string  value.
     * @return airport timezone
     */
    public String getTimezone() {
        return timezone;
    }

    /** Compares airport objects by airport name. */
    public int compareTo(Airport o) {
        return name.compareTo(o.getName());
    }

    /** Overrides method toString(), returns String with airport attributes */
    @Override
    public String toString() {
        return "Airport{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", coordinates='" + coordinates + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }
}
