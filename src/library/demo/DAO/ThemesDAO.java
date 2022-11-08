package library.demo.DAO;

import library.demo.API.MainMenuOperations;
import library.demo.API.menuOperations.MenuOperationsEnum;
import library.demo.cataloging.Themes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ThemesDAO extends OperationsDAO<Integer, Themes> {

    @Override
    public void view(Map<Integer, List<Themes>> map) {
        try (Statement statement = connectionDataBase.getConnection().createStatement()) {
            System.out.println("\nДанные из БД");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM THEMES  ORDER BY ID;");
            System.out.printf("%-5s%-10s\n", "ID", "Themes");
            System.out.println("--------------------------------");
            List<Themes> list = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String themes = resultSet.getString("THEMES");
                System.out.printf("%-5s%-10s\n", id, themes);
                Themes themes1 = new Themes(id, themes);
                list.add(themes1);
            }
            map.put(MenuOperationsEnum.THEMES.getId(), list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void search() {
        System.out.println("Переходим в меню поиска в категории Тематика");
        System.out.println("Введите ID Тематики для поиска");
        int num = MainMenuOperations.scanner.nextInt();
        try (PreparedStatement statement = connectionDataBase.getConnection().prepareStatement("SELECT THEMES.ID,THEMES.THEMES,NAME " +
                " FROM THEMES,PRODUCT_NAME " +
                " WHERE THEMES.ID =? and PRODUCT_NAME.THEMES=?  ORDER BY NAME ;")) {
            statement.setInt(1, num);
            statement.setInt(2, num);
            System.out.println("\nДанные из БД");
            System.out.printf("%-5s%-20s%-100s\n", "ID", "Themes", "Product Name");
            System.out.println("-------------------------------------------------------------" +
                    "---------------------");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String themes = resultSet.getString("THEMES");
                String productName = resultSet.getString("NAME");
                System.out.printf("%-5s%-20s%-100s\n", id, themes, productName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void change() {
        System.out.println("Введите ID Тематику которую необходимо изменить");
        int num = MainMenuOperations.scanner.nextInt();
        System.out.println("Введите новое Название Тематики");
        String str2 = MainMenuOperations.scanner.nextLine();
        try (PreparedStatement statement = connectionDataBase.getConnection().prepareStatement("UPDATE THEMES SET" +
                " THEMES=? WHERE ID=?;")) {
            statement.setString(1, str2);
            statement.setInt(2, num);
            statement.executeUpdate();
            System.out.println("Операция выполнена успешно");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        System.out.println("Введите ID Тематику которую необходимо удалить");
        int num = MainMenuOperations.scanner.nextInt();
        try (PreparedStatement statement = connectionDataBase.getConnection().prepareStatement("DELETE FROM THEMES WHERE ID=?;")) {
            statement.setInt(1, num);
            statement.executeUpdate();
            System.out.println("Операция выполнена успешно");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add() {
        System.out.println("Введите Название Тематики");
        String str1 = MainMenuOperations.scanner.nextLine();
        try (PreparedStatement statement = connectionDataBase.getConnection().prepareStatement("INSERT INTO THEMES (THEMES) " +
                "VALUES (?);")) {
            statement.setString(1, str1);
            statement.executeUpdate();
            System.out.println("Операция выполнена успешно");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
