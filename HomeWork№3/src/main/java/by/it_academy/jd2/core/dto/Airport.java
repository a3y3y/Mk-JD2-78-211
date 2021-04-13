package by.it_academy.jd2.core.dto;

/**
 * Airport data transfer object
 * @author Maksim Perekladov
 * @version 0.0
 */
public class Airport implements Comparable<Airport> {
    private String code;
    private String name;
    private String city;
    private String coordinates;
    private String timezone;

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getCode() {
        return code;
    }

    public String getCity() {
        return city;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public String getTimezone() {
        return timezone;
    }

    @Override
    public int compareTo(Airport o) {
        return name.compareTo(o.getName());
    }
}
