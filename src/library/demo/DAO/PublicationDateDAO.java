package library.demo.DAO;

import library.demo.API.MainMenuOperations;
import library.demo.API.menuOperations.MenuOperationsEnum;
import library.demo.cataloging.PublicationDate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PublicationDateDAO extends OperationsDAO<Integer, PublicationDate> {

    @Override
    public void view(Map<Integer, List<PublicationDate>> map) {
        try (Statement statement = connectionDataBase.getConnection().createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM PUBLICATION_DATE ORDER BY ID;");
            System.out.println("\nДанные из БД");
            System.out.printf("%-5s%-10s\n", "ID", "Publication date");
            System.out.println("-------------------------");
            List<PublicationDate> list = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                int publicationDate = resultSet.getInt("PUBLICATION_DATE");
                System.out.printf("%-5s%-10s\n", id, publicationDate);
                PublicationDate publicationDate1 = new PublicationDate(id, publicationDate);
                list.add(publicationDate1);
            }
            map.put(MenuOperationsEnum.YEAR_OF_PUBLISHING.getId(), list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void search() {
        System.out.println("Переходим в меню поиска в категории Год публикации");
        System.out.println("Введите ID Года публикации для поиска");
        int num = MainMenuOperations.scanner.nextInt();
        try (PreparedStatement statement = connectionDataBase.getConnection().prepareStatement("SELECT PUBLICATION_DATE .ID ," +
                " PUBLICATION_DATE .PUBLICATION_DATE ,PRODUCT_NAME .NAME ,THEMES .THEMES " +
                " FROM PUBLICATION_DATE ,PRODUCT_NAME ,THEMES " +
                " WHERE PRODUCT_NAME .PUBLICATION_DATE = ? " +
                " and PRODUCT_NAME .PUBLICATION_DATE =PUBLICATION_DATE .ID " +
                " and PRODUCT_NAME .THEMES =THEMES .ID ORDER BY NAME  ;")) {
            statement.setInt(1, num);
            System.out.println("\nДанные из БД");
            System.out.printf("%-5s%-20s%-100s%-20s\n", "ID", "Publication date", "Product Name", "Themes");
            System.out.println("-------------------------------------------------------------" +
                    "------------------------------------------------------");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                int publicationDate = resultSet.getInt("PUBLICATION_DATE");
                String name = resultSet.getString("NAME");
                String themes = resultSet.getString("THEMES");
                System.out.printf("%-5s%-20s%-100s%-20s\n", id, publicationDate, name, themes);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void change() {
        System.out.println("Введите ID Год публикации который необходимо изменить");
        int num = MainMenuOperations.scanner.nextInt();
        System.out.println("Введите новый Год публикации");
        String str1 = MainMenuOperations.scanner.nextLine();
        try (PreparedStatement statement = connectionDataBase.getConnection().prepareStatement("UPDATE PUBLICATION_DATE SET" +
                " PUBLICATION_DATE=? WHERE ID=?;")) {
            statement.setString(1, str1);
            statement.setInt(2, num);
            statement.executeUpdate();
            System.out.println("Операция выполнена успешно");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        System.out.println("Введите ID Год публикации который необходимо удалить");
        int num = MainMenuOperations.scanner.nextInt();
        try (PreparedStatement statement = connectionDataBase.getConnection().prepareStatement("DELETE FROM PUBLICATION_DATE WHERE ID=?;")) {
            statement.setInt(1, num);
            statement.executeUpdate();
            System.out.println("Операция выполнена успешно");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add() {
        System.out.println("Введите новый Год публикации");
        String str1 = MainMenuOperations.scanner.nextLine();
        try (PreparedStatement statement = connectionDataBase.getConnection().prepareStatement("INSERT INTO PUBLICATION_DATE (PUBLICATION_DATE) " +
                "VALUES (?);")) {
            statement.setString(1, str1);
            statement.executeUpdate();
            System.out.println("Операция выполнена успешно");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

