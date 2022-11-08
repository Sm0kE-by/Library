package library.demo.cache;

import library.demo.API.menuOperations.MenuOperationsEnum;
import library.demo.DAO.PublicationDateDAO;
import library.demo.cataloging.PublicationDate;

import java.util.List;
import java.util.Map;

public class PublicationDateCache implements OperationsCache<Integer, PublicationDate>, CheckCache<PublicationDate> {

    @Override
    public void view(Map<Integer, List<PublicationDate>> map) {
        if (checkCache(map, MenuOperationsEnum.YEAR_OF_PUBLISHING.getId())) {
            System.out.println("\nДанные из кэша");
            System.out.printf("%-5s%-10s\n", "ID", "Publication date");
            System.out.println("-------------------------");
            for (Map.Entry<Integer, List<PublicationDate>> entry : map.entrySet()) {
                for (PublicationDate value : entry.getValue()) {
                    int id = value.getId();
                    int publicationDate = value.getPublication_date();
                    System.out.printf("%-5s%-10s\n", id, publicationDate);
                }
            }
        } else {
            PublicationDateDAO publicationDate = new PublicationDateDAO();
            publicationDate.view(map);
        }
    }

    @Override
    public void search() {
        System.out.println("Переходим в меню поиска в категории Год публикации");
    }

    @Override
    public void change() {
        System.out.println("Переходим в меню изменения в категории Год публикации");
    }

    @Override
    public void delete() {
        System.out.println("Переходим в меню удаления в категории Год публикации");
    }

    @Override
    public void add() {
        System.out.println("Переходим в меню добавления в категории Год публикации");
    }
}
