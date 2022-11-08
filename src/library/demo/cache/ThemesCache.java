package library.demo.cache;

import library.demo.API.menuOperations.MenuOperationsEnum;
import library.demo.DAO.ThemesDAO;
import library.demo.cataloging.Themes;

import java.util.List;
import java.util.Map;

public class ThemesCache implements OperationsCache<Integer, Themes>, CheckCache<Themes> {

    public void view(Map<Integer, List<Themes>> map) {
        if (checkCache(map, MenuOperationsEnum.THEMES.getId())) {
            System.out.println("\nДанные из кэша");
            System.out.printf("%-5s%-10s\n", "ID", "Themes");
            System.out.println("--------------------------------");
            for (Map.Entry<Integer, List<Themes>> entry : map.entrySet()) {
                for (Themes value : entry.getValue()) {
                    int id = value.getId();
                    String themes = value.getThemes();
                    System.out.printf("%-5s%-10s\n", id, themes);
                }
            }
        } else {
            ThemesDAO themesDAO = new ThemesDAO();
            themesDAO.view(map);
        }
    }

    public void search() {
        System.out.println("Переходим в меню поиска в категории Тематика");
    }

    public void change() {
        System.out.println("Переходим в меню изменения в категории Тематика");
    }

    public void delete() {
        System.out.println("Переходим в меню удаления в категории Тематика");
    }

    public void add() {
        System.out.println("Переходим в меню добавления в категории Тематика");
    }
}
