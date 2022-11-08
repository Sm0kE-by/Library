package library.demo.cataloging;

import java.util.Objects;

public class PublicationDate {
    private int id;
    private int publication_date;

    public PublicationDate(int id, int publication_date) {
        this.id = id;
        this.publication_date = publication_date;
    }

    public PublicationDate() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(int publication_date) {
        this.publication_date = publication_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublicationDate that = (PublicationDate) o;
        return id == that.id && publication_date == that.publication_date;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, publication_date);
    }

    @Override
    public String toString() {
        return "PublicationDate{" +
                "id=" + id +
                ", publication_date=" + publication_date +
                '}';
    }
}
