package library.demo.cache;

import library.demo.API.menuOperations.MenuOperationsEnum;
import library.demo.DAO.PublishingHouseDAO;
import library.demo.cataloging.PublishingHouse;

import java.util.List;
import java.util.Map;

public class PublishingHouseCache implements OperationsCache<Integer, PublishingHouse>, CheckCache<PublishingHouse> {

    public void view(Map<Integer, List<PublishingHouse>> map) {
        if (checkCache(map, MenuOperationsEnum.EDITION.getId())) {
            System.out.println("\nДанные из кэша");
            System.out.printf("%-5s%-30s%-20s%-20s\n", "ID", "Name", "Country", "City");
            System.out.println("-------------------------------------------------------------------");
            for (Map.Entry<Integer, List<PublishingHouse>> entry : map.entrySet()) {
                for (PublishingHouse value : entry.getValue()) {
                    int id = value.getId();
                    String name = value.getName();
                    String country = value.getCountry();
                    String city = value.getCity();
                    System.out.printf("%-5s%-20s%-20s%-20s\n", id, name, country, city);
                }
            }
        } else {
            PublishingHouseDAO publishingHouseDAO = new PublishingHouseDAO();
            publishingHouseDAO.view(map);
        }
    }

    public void search() {
        System.out.println("Переходим в меню поиска в категории Издательства");
    }


    public void change() {
        System.out.println("Переходим в меню изменения в категории Издательства");
    }


    public void delete() {
        System.out.println("Переходим в меню удаления в категории Издательства");
    }


    public void add() {
        System.out.println("Переходим в меню добавления в категории Издательства");
    }
}
