package library.demo.cache;

import library.demo.API.menuOperations.MenuOperationsEnum;
import library.demo.DAO.AuthorDAO;
import library.demo.cataloging.Author;

import java.util.List;
import java.util.Map;

public class AuthorCache implements OperationsCache<Integer, Author>, CheckCache<Author> {


    public void view(Map<Integer, List<Author>> map) {
        if (checkCache(map, MenuOperationsEnum.AUTHOR.getId())) {
            System.out.println("\nДанные из кэша");
            System.out.printf("%-5s%-20s%-20s%-20s\n", "ID", "First Name", "Second Name", "Last Name");
            System.out.println("--------------------------------------------------------");
            for (Map.Entry<Integer, List<Author>> entry : map.entrySet()) {
                for (Author value : entry.getValue()) {
                    int id = value.getId();
                    String firstName = value.getFirstName();
                    String secondName = value.getSecondName();
                    String lastName = value.getLastName();
                    System.out.printf("%-5s%-20s%-20s%-20s\n", id, firstName, secondName, lastName);
                }
            }
        } else {
            AuthorDAO authorDAO = new AuthorDAO();
            authorDAO.view(map);
        }
    }

    public void search() {
        System.out.println("Переходим в меню поиска в категории Авторы");
    }


    public void change() {
        System.out.println("Переходим в меню изменения в категории Авторы");
    }


    public void delete() {
        System.out.println("Переходим в меню удаления в категории Авторы");
    }


    public void add() {
        System.out.println("Переходим в меню добавления в категории Авторы");
    }
}
