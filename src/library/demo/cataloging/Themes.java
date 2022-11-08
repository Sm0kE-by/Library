package library.demo.cataloging;

import java.util.Objects;

public class Themes {
    private int id;
    private String themes;

    public Themes(int id, String themes) {
        this.id = id;
        this.themes = themes;
    }

    public Themes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThemes() {
        return themes;
    }

    public void setThemes(String themes) {
        this.themes = themes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Themes themes1 = (Themes) o;
        return id == themes1.id && Objects.equals(themes, themes1.themes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, themes);
    }

    @Override
    public String toString() {
        return "Themes{" +
                "id=" + id +
                ", themes='" + themes + '\'' +
                '}';
    }
}
