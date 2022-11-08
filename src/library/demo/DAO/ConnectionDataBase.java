package library.demo.DAO;

import java.sql.*;

public class ConnectionDataBase {

    public final String DB_URL = "jdbc:h2:C:/Users/User/IdeaProjects/LibraryDemo/db/library";
    public final String DB_Driver = "org.h2.Driver";
    private Connection connection;

    public Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                Class.forName(DB_Driver); //Проверяем наличие JDBC драйвера для работы с БД
                connection = DriverManager.getConnection(DB_URL);//соединениесБД
                System.out.println("Соединение с СУБД выполнено.");
            } catch (ClassNotFoundException e) {
                e.printStackTrace(); // обработка ошибки  Class.forName
                System.out.println("JDBC драйвер для СУБД не найден!");
            } catch (SQLException e) {
                e.printStackTrace(); // обработка ошибок  DriverManager.getConnection
                System.out.println("Ошибка SQL !");
            }
        }
        return connection;
    }
}


