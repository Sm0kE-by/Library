package library.demo.DAO;

import library.demo.API.MainMenuOperations;
import library.demo.API.menuOperations.MenuOperationsEnum;
import library.demo.cataloging.Author;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class AuthorDAO extends OperationsDAO<Integer, Author> {

    @Override
    public void view(Map<Integer, List<Author>> map) {
        try (Statement statement = connectionDataBase.getConnection().createStatement()) {
            System.out.println("\nДанные из БД");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM author ORDER BY ID_AUTHOR;");
            System.out.printf("%-5s%-20s%-20s%-20s\n", "ID", "First Name", "Second Name", "Last Name");
            System.out.println("--------------------------------------------------------");
            List<Author> list = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID_AUTHOR");
                String firstName = resultSet.getString("FIRST_NAME");
                String secondName = resultSet.getString("SECOND_NAME");
                String lastName = resultSet.getString("LAST_NAME");
                System.out.printf("%-5s%-20s%-20s%-20s\n", id, firstName, secondName, lastName);
                Author author = new Author(id, firstName, secondName, lastName);
                list.add(author);
            }
            map.put(MenuOperationsEnum.AUTHOR.getId(), list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void search() {
        System.out.println("Переходим в меню поиска в категории Авторы");
        System.out.println("Введите ID Автора для поиска");
        int num = MainMenuOperations.scanner.nextInt();
        try (PreparedStatement statement = connectionDataBase.getConnection().prepareStatement("SELECT ID_AUTHOR ,FIRST_NAME ,SECOND_NAME ,LAST_NAME, NAME " +
                "FROM AUTHOR, PRODUCT_NAME " +
                "WHERE ID_AUTHOR =? AND AUTHOR =? ORDER BY NAME;")) {
            statement.setInt(1, num);
            statement.setInt(2, num);
            System.out.println("\nДанные из БД");
            System.out.printf("%-5s%-20s%-20s%-20s%-100s\n", "ID", "First Name", "Second Name", "Last Name", "Product Name");
            System.out.println("-------------------------------------------------------------" +
                    "----------------------------------------------");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID_AUTHOR");
                String firstName = resultSet.getString("FIRST_NAME");
                String secondName = resultSet.getString("SECOND_NAME");
                String lastName = resultSet.getString("LAST_NAME");
                String productName = resultSet.getString("NAME");
                System.out.printf("%-5s%-20s%-20s%-20s%-100s\n", id, firstName, secondName, lastName, productName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void change() {
        System.out.println("Введите ID автора которого необходимо изменить");
        int num = MainMenuOperations.scanner.nextInt();
        System.out.println("Введите Имя");
        String str1 = MainMenuOperations.scanner.nextLine();
        System.out.println("Введите Отчество");
        String str2 = MainMenuOperations.scanner.nextLine();
        System.out.println("Введите Фамилию");
        String str3 = MainMenuOperations.scanner.nextLine();
        try (PreparedStatement statement = connectionDataBase.getConnection().prepareStatement("UPDATE AUTHOR SET" +
                " FIRST_NAME=?," +
                " SECOND_NAME =?," +
                " LAST_NAME =?" +
                " WHERE ID_AUTHOR=?;")) {
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
        System.out.println("Введите ID автора которого необходимо удалить");
        int num = MainMenuOperations.scanner.nextInt();
        try (PreparedStatement statement = connectionDataBase.getConnection().prepareStatement("DELETE FROM AUTHOR WHERE ID_AUTHOR=?;")) {
            statement.setInt(1, num);
            statement.executeUpdate();
            System.out.println("Операция выполнена успешно");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add() {
        System.out.println("Введите Имя нового автора");
        String str1 = MainMenuOperations.scanner.nextLine();
        System.out.println("Введите Отчество нового автора");
        String str2 = MainMenuOperations.scanner.nextLine();
        System.out.println("Введите Фамилию нового автора");
        String str3 = MainMenuOperations.scanner.nextLine();
        try (PreparedStatement statement = connectionDataBase.getConnection().prepareStatement("INSERT INTO author (first_name, second_name, last_name) " +
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
