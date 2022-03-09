package homeproject.testingfield.model;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable {

    private String street;
    private String town;
    private String country;
    private String postCode;

    public Address() {
    }

    public Address(String street, String town, String country, String postCode) {
        this.street = street;
        this.town = town;
        this.country = country;
        this.postCode = postCode;
    }

    public String getStreet() {
        return street;
    }

    public String getTown() {
        return town;
    }

    public String getCountry() {
        return country;
    }

    public String getPostCode() {
        return postCode;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) && Objects.equals(town, address.town) && Objects.equals(country, address.country) && Objects.equals(postCode, address.postCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, town, country, postCode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", town='" + town + '\'' +
                ", country='" + country + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }
}
