package library.demo.DAO;

import library.demo.API.MainMenuOperations;
import library.demo.API.menuOperations.MenuOperationsEnum;
import library.demo.cataloging.ProductName;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductNameDAO extends OperationsDAO<Integer, ProductName> {

    @Override
    public void view(Map<Integer, List<ProductName>> map) {
        try (Statement statement = connectionDataBase.getConnection().createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUCT_NAME ORDER BY ID;");
            System.out.println("\nДанные из БД");
            System.out.printf("\n%10s%25s%10s%100s%10s%25s%25s\n", "ID", "ID type of printed matter ", "ID Themes",
                    "Name", "ID Author", "ID Publishing house", "ID Publication date");
            System.out.println("--------------------------------------------------------------------------------------" +
                    "-----------------------------------------------------------------------------------------------------------------------");
            List<ProductName> list = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                int typeOfPrintedMatter = resultSet.getInt("TYPE_OF_PRINTED_MATTER");
                int themes = resultSet.getInt("THEMES");
                String name = resultSet.getString("NAME");
                int author = resultSet.getInt("AUTHOR");
                int publishingHouse = resultSet.getInt("PUBLISHING_HOUSE");
                int publicationDate = resultSet.getInt("PUBLICATION_DATE");
                System.out.printf("%10s%25s%10s%100s%10s%25s%25s\n", id, typeOfPrintedMatter, themes, name, author, publishingHouse, publicationDate);
                ProductName productName = new ProductName(id, typeOfPrintedMatter, themes, name, author, publishingHouse, publicationDate);
                list.add(productName);
            }
            map.put(MenuOperationsEnum.PRODUCT_NAME.getId(), list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void search() {
        System.out.println("Переходим в меню поиска в категории Название продукции");
        System.out.println("Введите ID Продукта для поиска");
        int num = MainMenuOperations.scanner.nextInt();
        try (PreparedStatement statement = connectionDataBase.getConnection().prepareStatement("SELECT PRODUCT_NAME.ID, PRODUCT_NAME .NAME, " +
                "AUTHOR .LAST_NAME, PUBLISHING_HOUSE .NAME, PUBLICATION_DATE.PUBLICATION_DATE " +
                "FROM PRODUCT_NAME ,AUTHOR ,PUBLICATION_DATE ,PUBLISHING_HOUSE " +
                "WHERE PRODUCT_NAME .ID = ? and PRODUCT_NAME .AUTHOR = AUTHOR.ID_AUTHOR " +
                "and PRODUCT_NAME.PUBLISHING_HOUSE = PUBLISHING_HOUSE .ID " +
                "and PRODUCT_NAME.PUBLICATION_DATE = PUBLICATION_DATE .ID ORDER BY NAME ;")) {
            statement.setInt(1, num);
            System.out.println("\nДанные из БД");
            System.out.printf("%-5s%-100s%-20s%-20s%-20s\n", "ID", "Product Name", "Author", "Publishing House", "Publication Date");
            System.out.println("-------------------------------------------------------------" +
                    "---------------------");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                String last_name = resultSet.getString("LAST_NAME");
                String name1 = resultSet.getString("NAME");
                int num1 = resultSet.getInt("PUBLICATION_DATE");
                System.out.printf("%-5s%-100s%-20s%-20s%-20s\n", id, name, last_name, name1, num1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void change() {
        System.out.println("Введите ID Продукта который необходимо изменить");
        int num = MainMenuOperations.scanner.nextInt();
        System.out.println("Введите ID Тип печатной продукции");
        int num1 = MainMenuOperations.scanner.nextInt();
        System.out.println("Введите ID Тематики");
        int num2 = MainMenuOperations.scanner.nextInt();
        System.out.println("Введите Название продукции");
        String str1 = MainMenuOperations.scanner.nextLine();
        System.out.println("Введите ID Автора");
        int num3 = MainMenuOperations.scanner.nextInt();
        System.out.println("Введите ID Издательства");
        int num4 = MainMenuOperations.scanner.nextInt();
        System.out.println("Введите ID Года издания");
        int num5 = MainMenuOperations.scanner.nextInt();
        try (PreparedStatement statement = connectionDataBase.getConnection().prepareStatement("UPDATE PRODUCT_NAME SET" +
                " type_of_printed_matter=?," +
                " themes =?," +
                " name =?," +
                " author =?," +
                " publishing_house =?," +
                " publication_date =?," +
                " WHERE ID_AUTHOR=?;")) {
            statement.setInt(1, num1);
            statement.setInt(2, num2);
            statement.setString(3, str1);
            statement.setInt(4, num3);
            statement.setInt(5, num4);
            statement.setInt(6, num5);
            statement.setInt(7, num);
            statement.executeUpdate();
            System.out.println("Операция выполнена успешно");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        System.out.println("Введите ID Продукта который необходимо удалить");
        int num = MainMenuOperations.scanner.nextInt();
        try (PreparedStatement statement = connectionDataBase.getConnection().prepareStatement("DELETE FROM PRODUCT_NAME WHERE ID=?;")) {
            statement.setInt(1, num);
            statement.executeUpdate();
            System.out.println("Операция выполнена успешно");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add() {
        System.out.println("Введите ID Тип печатной продукции");
        int num1 = MainMenuOperations.scanner.nextInt();
        System.out.println("Введите ID Тематики");
        int num2 = MainMenuOperations.scanner.nextInt();
        System.out.println("Введите Название продукции");
        String str1 = MainMenuOperations.scanner.nextLine();
        System.out.println("Введите ID Автора");
        int num3 = MainMenuOperations.scanner.nextInt();
        System.out.println("Введите ID Издательства");
        int num4 = MainMenuOperations.scanner.nextInt();
        System.out.println("Введите ID Года издания");
        int num5 = MainMenuOperations.scanner.nextInt();
        try (PreparedStatement statement = connectionDataBase.getConnection().prepareStatement("INSERT INTO product_name (type_of_printed_matter, themes, name, author, " +
                " publishing_house, publication_date) " +
                " VALUES (?,?,?,?,?,?);")) {
            statement.setInt(1, num1);
            statement.setInt(2, num2);
            statement.setString(3, str1);
            statement.setInt(4, num3);
            statement.setInt(5, num4);
            statement.setInt(6, num5);
            statement.executeUpdate();
            System.out.println("Операция выполнена успешно");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

