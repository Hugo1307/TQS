package pt.ua.deti.tqs.lab2.geocoding;

import java.util.Objects;

public class Address {

    private final String road;
    private final String state;
    private final String city;
    private final String zip;
    private final String houseNumber;

    public Address(String road, String state, String city, String zip, String houseNumber) {
        this.road = road;
        this.state = state;
        this.city = city;
        this.zip = zip;
        this.houseNumber = houseNumber;
    }

    public String getRoad() {
        return road;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(road, address.road) && Objects.equals(state, address.state) && Objects.equals(city, address.city) && Objects.equals(zip, address.zip) && Objects.equals(houseNumber, address.houseNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(road, state, city, zip, houseNumber);
    }

    @Override
    public String toString() {
        return "Address{" +
                "road='" + road + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                '}';
    }

}
