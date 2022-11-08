package library.demo.DAO;

import library.demo.API.MainMenuOperations;
import library.demo.API.menuOperations.MenuOperationsEnum;
import library.demo.cataloging.PublishingHouse;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PublishingHouseDAO extends OperationsDAO<Integer, PublishingHouse> {
    @Override
    public void view(Map<Integer, List<PublishingHouse>> map) {
        try (Statement statement = connectionDataBase.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PUBLISHING_HOUSE ORDER BY ID;");
            System.out.println("\nДанные из БД");
            System.out.printf("%-5s%-30s%-20s%-20s\n", "ID", "Name", "Country", "City");
            System.out.println("-------------------------------------------------------------------");
            List<PublishingHouse> list = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                String country = resultSet.getString("COUNTRY");
                String city = resultSet.getString("CITY");
                System.out.printf("%-5s%-20s%-20s%-20s\n", id, name, country, city);
                PublishingHouse publishingHouse = new PublishingHouse(id, name, country, city);
                list.add(publishingHouse);
            }
            map.put(MenuOperationsEnum.EDITION.getId(), list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void search() {
        System.out.println("Переходим в меню поиска в категории Издательства");
        System.out.println("Введите ID Издательства для поиска");
        int num = MainMenuOperations.scanner.nextInt();
        try (PreparedStatement statement = connectionDataBase.getConnection().prepareStatement("SELECT PUBLISHING_HOUSE .ID , PUBLISHING_HOUSE .NAME ," +
                " PUBLISHING_HOUSE .COUNTRY , PUBLISHING_HOUSE .CITY , PRODUCT_NAME .NAME , AUTHOR .LAST_NAME " +
                "                FROM PUBLISHING_HOUSE ,AUTHOR, PRODUCT_NAME " +
                "               WHERE PRODUCT_NAME.PUBLISHING_HOUSE =? " +
                "and PRODUCT_NAME .PUBLISHING_HOUSE =PUBLISHING_HOUSE .ID " +
                "and PRODUCT_NAME .AUTHOR =AUTHOR .ID_AUTHOR ORDER BY NAME ;")) {
            statement.setInt(1, num);
            System.out.println("\nДанные из БД");
            System.out.printf("%-5s%-20s%-20s%-20s%-100s%-20s\n", "ID", "Name", "Country", "City", "Product Name", "Author");
            System.out.println("-------------------------------------------------------------" +
                    "----------------------------------------------");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                String country = resultSet.getString("COUNTRY");
                String city = resultSet.getString("CITY");
                String productName = resultSet.getString("PRODUCT_NAME.NAME");
                String last_name = resultSet.getString("LAST_NAME");
                System.out.printf("%-5s%-20s%-20s%-20s%-100s%-20s\n", id, name, country, city, productName, last_name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void change() {
        System.out.println("Введите ID Издательства которое необходимо изменить");
        int num = MainMenuOperations.scanner.nextInt();
        System.out.println("Введите Название");
        String str1 = MainMenuOperations.scanner.nextLine();
        System.out.println("Введите Страну");
        String str2 = MainMenuOperations.scanner.nextLine();
        System.out.println("Введите Город");
        String str3 = MainMenuOperations.scanner.nextLine();
        try (PreparedStatement statement = connectionDataBase.getConnection().prepareStatement("UPDATE PUBLISHING_HOUSE SET" +
                " NAME=?," +
                " COUNTRY =?," +
                " CITY =?" +
                " WHERE ID=?;")) {
            statement.setString(1, str1);
            statement.setString(2, str2);
            statement.setString(3, str3);
            statement.setInt(4, num);
            statement.executeUpdate();
            System.out.println("Операция выполнена успешно");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        System.out.println("Введите ID Издательства которое необходимо удалить");
        int num = MainMenuOperations.scanner.nextInt();
        try (PreparedStatement statement = connectionDataBase.getConnection().prepareStatement("DELETE FROM PUBLISHING_HOUSE WHERE ID=?;")) {
            statement.setInt(1, num);
            statement.executeUpdate();
            System.out.println("Операция выполнена успешно");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add() {
        System.out.println("Введите Название");
        String str1 = MainMenuOperations.scanner.nextLine();
        System.out.println("Введите Страну");
        String str2 = MainMenuOperations.scanner.nextLine();
        System.out.println("Введите Город");
        String str3 = MainMenuOperations.scanner.nextLine();
        try (PreparedStatement statement = connectionDataBase.getConnection().prepareStatement("INSERT INTO PUBLISHING_HOUSE (NAME, COUNTRY, CITY) " +
                "VALUES (?, ?, ?);")) {
            statement.setString(1, str1);
            statement.setString(2, str2);
            statement.setString(3, str3);
            statement.executeUpdate();
            System.out.println("Операция выполнена успешно");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

