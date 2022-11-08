package library.demo.cache;

import library.demo.cataloging.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateCache {
    private Map<Integer, List<Author>> mapAuthor = new HashMap<>();
    private Map<Integer, List<ProductName>> mapProductName = new HashMap<>();
    private Map<Integer, List<PublicationDate>> mapPublicationDate = new HashMap<>();
    private Map<Integer, List<PublishingHouse>> mapPublishingHouse = new HashMap<>();
    private Map<Integer, List<Themes>> mapThemes = new HashMap<>();
    private Map<Integer, List<TipyOfPrintedMatter>> mapTipyOfPrintedMatter = new HashMap<>();

    public CreateCache() {
    }

    public Map<Integer, List<Author>> getMapAuthor() {
        return mapAuthor;
    }

    public void setMapAuthor(Map<Integer, List<Author>> mapAuthor) {
        this.mapAuthor = mapAuthor;
    }

    public Map<Integer, List<ProductName>> getMapProductName() {
        return mapProductName;
    }

    public void setMapProductName(Map<Integer, List<ProductName>> mapProductName) {
        this.mapProductName = mapProductName;
    }

    public Map<Integer, List<PublicationDate>> getMapPublicationDate() {
        return mapPublicationDate;
    }

    public void setMapPublicationDate(Map<Integer, List<PublicationDate>> mapPublicationDate) {
        this.mapPublicationDate = mapPublicationDate;
    }

    public Map<Integer, List<PublishingHouse>> getMapPublishingHouse() {
        return mapPublishingHouse;
    }

    public void setMapPublishingHouse(Map<Integer, List<PublishingHouse>> mapPublishingHouse) {
        this.mapPublishingHouse = mapPublishingHouse;
    }

    public Map<Integer, List<Themes>> getMapThemes() {
        return mapThemes;
    }

    public void setMapThemes(Map<Integer, List<Themes>> mapThemes) {
        this.mapThemes = mapThemes;
    }

    public Map<Integer, List<TipyOfPrintedMatter>> getMapTipyOfPrintedMatter() {
        return mapTipyOfPrintedMatter;
    }

    public void setMapTipyOfPrintedMatter(Map<Integer, List<TipyOfPrintedMatter>> mapTipyOfPrintedMatter) {
        this.mapTipyOfPrintedMatter = mapTipyOfPrintedMatter;
    }

    @Override
    public String toString() {
        return "CreateCache{" +
                "mapAuthor=" + mapAuthor +
                ", mapProductName=" + mapProductName +
                ", mapPublicationDate=" + mapPublicationDate +
                ", mapPublishingHouse=" + mapPublishingHouse +
                ", mapThemes=" + mapThemes +
                ", mapTipyOfPrintedMatter=" + mapTipyOfPrintedMatter +
                '}';
    }
}
