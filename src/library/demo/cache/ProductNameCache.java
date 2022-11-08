package library.demo.cache;

import library.demo.API.menuOperations.MenuOperationsEnum;
import library.demo.DAO.ProductNameDAO;
import library.demo.cataloging.ProductName;

import java.util.List;
import java.util.Map;

public class ProductNameCache implements OperationsCache<Integer, ProductName>, CheckCache<ProductName> {

    @Override
    public void view(Map<Integer, List<ProductName>> map) {
        if (checkCache(map, MenuOperationsEnum.PRODUCT_NAME.getId())) {
            System.out.println("\nДанные из кэша");
            System.out.printf("\n%10s%25s%10s%100s%10s%25s%25s\n", "ID", "ID type of printed matter ", "ID Themes",
                    "Name", "ID Author", "ID Publishing house", "ID Publication date");
            System.out.println("--------------------------------------------------------------------------------------" +
                    "-----------------------------------------------------------------------------------------------------------------------");
            for (Map.Entry<Integer, List<ProductName>> entry : map.entrySet()) {
                for (ProductName value : entry.getValue()) {
                    int id = value.getId();
                    int typeOfPrintedMatter = value.getTypeOfPrintedMatter();
                    int themes = value.getThemes();
                    String name = value.getName();
                    int author = value.getAuthor();
                    int publishingHouse = value.getPublishingHouse();
                    int publicationDate = value.getPublicationDate();
                    System.out.printf("%10s%25s%10s%100s%10s%25s%25s\n", id, typeOfPrintedMatter, themes, name, author, publishingHouse, publicationDate);
                }
            }
        } else {
            ProductNameDAO productNameDAO = new ProductNameDAO();
            productNameDAO.view(map);
        }
    }


    @Override
    public void search() {
        System.out.println("Переходим в меню поиска в категории Название продукции");
    }

    @Override
    public void change() {
        System.out.println("Переходим в меню изменения в категории Название продукции");
    }

    @Override
    public void delete() {
        System.out.println("Переходим в меню удаления в категории Название продукции");
    }

    @Override
    public void add() {
        System.out.println("Переходим в меню добавления в категории Название продукции");
    }
}
