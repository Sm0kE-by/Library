package library.demo.cache;

import library.demo.API.menuOperations.MenuOperationsEnum;
import library.demo.DAO.TipyOfPrintedMatterDAO;
import library.demo.cataloging.TipyOfPrintedMatter;

import java.util.List;
import java.util.Map;

public class TipyOfPrintedMatterCache implements OperationsCache<Integer, TipyOfPrintedMatter>, CheckCache<TipyOfPrintedMatter> {
    @Override
    public void view(Map<Integer, List<TipyOfPrintedMatter>> map) {
        if (checkCache(map, MenuOperationsEnum.PRODUCT_TYPE.getId())) {
            System.out.println("\nДанные из кэша");
            System.out.printf("%-5s%-10s\n", "ID", "Name of printed matter");
            System.out.println("---------------------------------");
            for (Map.Entry<Integer, List<TipyOfPrintedMatter>> entry : map.entrySet()) {
                for (TipyOfPrintedMatter value : entry.getValue()) {
                    int id = value.getId();
                    String nameOfPrintedMatter = value.getNameOfPrintedMatter();
                    System.out.printf("%-5s%-10s\n", id, nameOfPrintedMatter);
                }
            }
        } else {
           TipyOfPrintedMatterDAO tipyOfPrintedMatterDAO = new TipyOfPrintedMatterDAO();
            tipyOfPrintedMatterDAO.view(map);
        }
    }

    @Override
    public void search() {
        System.out.println("Переходим в меню поиска в категории Тап печатной продукции");
    }

    @Override
    public void change() {
        System.out.println("Переходим в меню изменения в категории Тап печатной продукции");
    }

    @Override
    public void delete() {
        System.out.println("Переходим в меню удаления в категории Тап печатной продукции");
    }

    @Override
    public void add() {
        System.out.println("Переходим в меню добавления в категории Тап печатной продукции");
    }
}
