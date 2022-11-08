package library.demo.cataloging;

import java.util.Objects;

public class PublishingHouse {
    private int id;
    private String name;
    private String country;
    private String city;

    public PublishingHouse(int id, String name, String country, String city) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
    }

    public PublishingHouse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublishingHouse that = (PublishingHouse) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(country, that.country)
                && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country, city);
    }

    @Override
    public String toString() {
        return "PublishingHouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
