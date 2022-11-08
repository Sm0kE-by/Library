package library.demo.cataloging;

import java.util.Objects;

public class ProductName {
    private int id;
    private int typeOfPrintedMatter;
    private int themes;
    private String name;
    private int author;
    private int publishingHouse;
    private int publicationDate;

    public ProductName(int id, int typeOfPrintedMatter, int themes, String name, int author, int publishingHouse, int publicationDate) {
        this.id = id;
        this.typeOfPrintedMatter = typeOfPrintedMatter;
        this.themes = themes;
        this.name = name;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.publicationDate = publicationDate;
    }

    public ProductName() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeOfPrintedMatter() {
        return typeOfPrintedMatter;
    }

    public void setTypeOfPrintedMatter(int typeOfPrintedMatter) {
        this.typeOfPrintedMatter = typeOfPrintedMatter;
    }

    public int getThemes() {
        return themes;
    }

    public void setThemes(int themes) {
        this.themes = themes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(int publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(int publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductName that = (ProductName) o;
        return id == that.id && typeOfPrintedMatter == that.typeOfPrintedMatter
                && themes == that.themes && author == that.author
                && publishingHouse == that.publishingHouse && publicationDate == that.publicationDate
                && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeOfPrintedMatter, themes, name, author, publishingHouse, publicationDate);
    }

    @Override
    public String toString() {
        return "ProductName{" +
                "id=" + id +
                ", typeOfPrintedMatter=" + typeOfPrintedMatter +
                ", themes=" + themes +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", publishingHouse=" + publishingHouse +
                ", publicationDate=" + publicationDate +
                '}';
    }
}
