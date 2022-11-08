package library.demo.cataloging;

import java.util.Objects;

public class TipyOfPrintedMatter {
    private int id;
    private String nameOfPrintedMatter;

    public TipyOfPrintedMatter(int id, String nameOfPrintedMatter) {
        this.id = id;
        this.nameOfPrintedMatter = nameOfPrintedMatter;
    }

    public TipyOfPrintedMatter() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfPrintedMatter() {
        return nameOfPrintedMatter;
    }

    public void setNameOfPrintedMatter(String nameOfPrintedMatter) {
        this.nameOfPrintedMatter = nameOfPrintedMatter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipyOfPrintedMatter that = (TipyOfPrintedMatter) o;
        return id == that.id && Objects.equals(nameOfPrintedMatter, that.nameOfPrintedMatter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameOfPrintedMatter);
    }

    @Override
    public String toString() {
        return "TipyOfPrintedMatter{" +
                "id=" + id +
                ", NameOfPrintedMatter='" + nameOfPrintedMatter + '\'' +
                '}';
    }
}
