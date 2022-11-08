package library.demo.DAO;

import library.demo.API.MainMenuOperations;
import library.demo.API.menuOperations.MenuOperationsEnum;
import library.demo.cataloging.TipyOfPrintedMatter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TipyOfPrintedMatterDAO extends OperationsDAO<Integer, TipyOfPrintedMatter> {

    @Override
    public void view(Map<Integer, List<TipyOfPrintedMatter>> map) {

        try (Statement statement = connectionDataBase.getConnection().createStatement()) {
            System.out.println("\nДанные из БД");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM TYPE_OF_PRINTED_MATTER ORDER BY ID;");
            System.out.printf("%-5s%-10s\n", "ID", "Name of printed matter");
            System.out.println("---------------------------------");
            List<TipyOfPrintedMatter> list = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String nameOfPrintedMatter = resultSet.getString("NAME_OF_PRINTED_MATTER");
                System.out.printf("%-5s%-10s\n", id, nameOfPrintedMatter);
                TipyOfPrintedMatter tipyOfPrintedMatterO = new TipyOfPrintedMatter(id, nameOfPrintedMatter);
                list.add(tipyOfPrintedMatterO);
            }
            map.put(MenuOperationsEnum.PRODUCT_TYPE.getId(), list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void search() {
        System.out.println("Переходим в меню поиска в категории Тип печатной продукции");
        System.out.println("Введите ID Типа печатной продукции для поиска");
        int num = MainMenuOperations.scanner.nextInt();
        try (PreparedStatement statement = connectionDataBase.getConnection().prepareStatement("SELECT TYPE_OF_PRINTED_MATTER.ID ," +
                " TYPE_OF_PRINTED_MATTER .NAME_OF_PRINTED_MATTER , PRODUCT_NAME .NAME  " +
                " FROM TYPE_OF_PRINTED_MATTER  , PRODUCT_NAME  " +
                " WHERE PRODUCT_NAME.TYPE_OF_PRINTED_MATTER = ? " +
                "and PRODUCT_NAME .TYPE_OF_PRINTED_MATTER =TYPE_OF_PRINTED_MATTER .ID " +
                " ORDER BY NAME;")) {
            statement.setInt(1, num);
            System.out.println("\nДанные из БД");
            System.out.printf("%-5s%-20s%-100s\n", "ID", "Name of printed matter", "Product Name");
            System.out.println("-------------------------------------------------------------" +
                    "------------");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String nameOfPrintedMatter = resultSet.getString("NAME_OF_PRINTED_MATTER");
                String productName = resultSet.getString("NAME");
                System.out.printf("%-5s%-20s%-100s\n", id, nameOfPrintedMatter, productName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void change() {
        System.out.println("Введите ID Тип печатной продукции который необходимо изменить");
        int num = MainMenuOperations.scanner.nextInt();
        System.out.println("Введите новое Название");
        String str2 = MainMenuOperations.scanner.nextLine();
        try (PreparedStatement statement = connectionDataBase.getConnection().prepareStatement("UPDATE TYPE_OF_PRINTED_MATTER SET" +
                " NAME_OF_PRINTED_MATTER=? WHERE ID=?;")) {
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
        System.out.println("Введите ID Тип печатной продукции который необходимо удалить");
        int num = MainMenuOperations.scanner.nextInt();
        try (PreparedStatement statement = connectionDataBase.getConnection().prepareStatement("DELETE FROM TYPE_OF_PRINTED_MATTER WHERE ID=?;")) {
            statement.setInt(1, num);
            statement.executeUpdate();
            System.out.println("Операция выполнена успешно");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add() {
        System.out.println("Введите новое Название Тип печатной продукции");
        String str1 = MainMenuOperations.scanner.nextLine();
        try (PreparedStatement statement = connectionDataBase.getConnection().prepareStatement("INSERT INTO TYPE_OF_PRINTED_MATTER (NAME_OF_PRINTED_MATTER) " +
                "VALUES (?);")) {
            statement.setString(1, str1);
            statement.executeUpdate();
            System.out.println("Операция выполнена успешно");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
