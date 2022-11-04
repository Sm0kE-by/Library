package library.demo.createDB;

import library.demo.ConnectionDataBase;

import java.sql.SQLException;
import java.sql.Statement;

class CreateDB implements CreateTablesAndInsert{

    ConnectionDataBase connectionDataBase = new ConnectionDataBase();

    @Override
    public CreateDB createTables() {

        try (Statement statement = connectionDataBase.getConnection().createStatement()) {
            statement.executeUpdate("CREATE TABLE type_of_printed_matter (  " +
                    " id INT NOT NULL AUTO_INCREMENT," +
                    " name_of_printed_matter char(30) NOT NULL, " +
                    " PRIMARY KEY(id));");
            statement.executeUpdate("  CREATE TABLE themes (   " +
                    "   id INT NOT NULL AUTO_INCREMENT, " +
                    "   themes char(25) NOT NULL,   " +
                    "   PRIMARY KEY(id));");
            statement.executeUpdate("  CREATE TABLE publishing_house (   " +
                    "   id INT NOT NULL AUTO_INCREMENT, " +
                    "   name char(30) NOT NULL,   " +
                    "   country char(20) NOT NULL,   " +
                    "   city char(20) NOT NULL,   " +
                    "   PRIMARY KEY(id));");
            statement.executeUpdate("  CREATE TABLE author  (  " +
                    "   id_author INT NOT NULL AUTO_INCREMENT, " +
                    "   first_name char(20) NOT NULL,   " +
                    "   second_name char(20) NOT NULL,   " +
                    "   last_name char(20) NOT NULL,   " +
                    "   PRIMARY KEY(id_author));");
            statement.executeUpdate("  CREATE TABLE product_name  (  " +
                    "   id INT NOT NULL AUTO_INCREMENT, " +
                    "   type_of_printed_matter INT NOT NULL,   " +
                    "   themes INT NOT NULL,   " +
                    "   name varchar(100) NOT NULL,   " +
                    "   author INT,   " +
                    "   publishing_house INT NOT NULL , " +
                    "   publication_date INT NOT NULL, " +
                    "   PRIMARY KEY(id)," +
                    "   FOREIGN KEY (type_of_printed_matter) REFERENCES type_of_printed_matter (id)," +
                    "   FOREIGN KEY (themes) REFERENCES themes (id)," +
                    "   FOREIGN KEY (author) REFERENCES author (id_author)," +
                    "   FOREIGN KEY (publishing_house) REFERENCES publishing_house (id));");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CreateDB insertIntoTypeOfPrintedMatter() {

        try (Statement statement = connectionDataBase.getConnection().createStatement()) {

            statement.addBatch(" INSERT INTO type_of_printed_matter (name_of_printed_matter) VALUES ('book');");
            statement.addBatch(" INSERT INTO type_of_printed_matter (name_of_printed_matter) VALUES ('magazine');");
            statement.addBatch(" INSERT INTO type_of_printed_matter (name_of_printed_matter) VALUES ('newspaper');");
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CreateDB insertIntoThemes() {

        try (Statement statement = connectionDataBase.getConnection().createStatement()) {
            statement.addBatch( " INSERT INTO themes (themes) VALUES ('fantasy');");
            statement.addBatch( " INSERT INTO themes (themes) VALUES ('politics and business');");
            statement.addBatch( " INSERT INTO themes (themes) VALUES ('beauty and health');");
            statement.addBatch( " INSERT INTO themes (themes) VALUES ('scientific literature');");
            statement.addBatch( " INSERT INTO themes (themes) VALUES ('news');");
            statement.addBatch( " INSERT INTO themes (themes) VALUES ('leisure');");
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CreateDB insertIntoPublishingHouse() {

        try (Statement statement = connectionDataBase.getConnection().createStatement()) {
            statement.addBatch( " INSERT INTO publishing_house (name, country, city) VALUES ('Eksmo','Russia','Moscow');");
            statement.addBatch( " INSERT INTO publishing_house (name, country, city) VALUES ('New house','Russia','Irkutsk');");
            statement.addBatch( " INSERT INTO publishing_house (name, country, city) VALUES ('Thieves and beggars','Belarus','Gomel');");
            statement.addBatch( " INSERT INTO publishing_house (name, country, city) VALUES ('Cosmopolitan','USA','NY');");
            statement.addBatch( " INSERT INTO publishing_house (name, country, city) VALUES ('Think','Romania','Bucharest');");
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CreateDB insertIntoAuthor() {

        try (Statement statement = connectionDataBase.getConnection().createStatement()) {
            statement.addBatch( " INSERT INTO author (first_name, second_name, last_name) VALUES ('Vasiliy', 'Igorevich', 'Rakovets');");
            statement.addBatch( " INSERT INTO author (first_name, second_name, last_name) VALUES ('Kirill', 'Vladimirovich','Yuranov');");
            statement.addBatch( " INSERT INTO author (first_name, second_name, last_name) VALUES ('Denis','Yusufovich','Kuznecov');");
            statement.addBatch( " INSERT INTO author (first_name, second_name, last_name) VALUES ('Andrey','Nikolaevich','Melnikov');");
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CreateDB insertIntoProductName() {

        try (Statement statement = connectionDataBase.getConnection().createStatement()) {
            statement.addBatch( " INSERT INTO product_name (type_of_printed_matter, themes, name, author, publishing_house, publication_date)" +
            " VALUES ('1','1','From dirt to Kings','2','3','2022');");
            statement.addBatch(" INSERT INTO product_name (type_of_printed_matter, themes, name, author, publishing_house, publication_date)" +
            " VALUES ('1','2','Impact of senile dementia on political views','2','3','2021');");
            statement.addBatch( " INSERT INTO product_name (type_of_printed_matter, themes, name, author, publishing_house, publication_date)" +
            " VALUES ('2','4','Programming algorithms for microcontrollers of the family PIC','2','2','2012');");
            statement.addBatch( " INSERT INTO product_name (type_of_printed_matter, themes, name, author, publishing_house, publication_date)" +
            " VALUES ('1','4','Fundamentals of the World Economy','1','1','2014');");
            statement.addBatch(" INSERT INTO product_name (type_of_printed_matter, themes, name, author, publishing_house, publication_date)" +
            " VALUES ('1','1','Tiered world','4','1','2014');");
            statement.addBatch( " INSERT INTO product_name (type_of_printed_matter, themes, name, author, publishing_house, publication_date)" +
            " VALUES ('1','1','The Hitchhiker''s Guide to the Galaxy','3','1','2017');");
            statement.addBatch( " INSERT INTO product_name (type_of_printed_matter, themes, name, author, publishing_house, publication_date)" +
            " VALUES ('1','1','Faceless Hero','3','1','2021');");
            statement.addBatch( " INSERT INTO product_name (type_of_printed_matter, themes, name, author, publishing_house, publication_date)" +
            " VALUES ('1','1','Secret materials','4','1','2017');");
            statement.addBatch( " INSERT INTO product_name (type_of_printed_matter, themes, name, author, publishing_house, publication_date)" +
            " VALUES ('1','1','Galaxy news','3','1','2020');");
            statement.addBatch( " INSERT INTO product_name (type_of_printed_matter, themes, name, author, publishing_house, publication_date)" +
            " VALUES ('1','4','How to become a millionaire','4','2','2022');");
            statement.addBatch( " INSERT INTO product_name (type_of_printed_matter, themes, name, author, publishing_house, publication_date)" +
            " VALUES ('1','1','Galactic patrol','2','1','2016');");
            statement.addBatch(" INSERT INTO product_name (type_of_printed_matter, themes, name, author, publishing_house, publication_date)" +
            " VALUES ('1','1','Lord of the Rings','2','1','2013');");
            statement.addBatch( " INSERT INTO product_name (type_of_printed_matter, themes, name, author, publishing_house, publication_date)" +
            " VALUES ('1','3','Book of recipes','4','3','2021');");
            statement.addBatch(  " INSERT INTO product_name (type_of_printed_matter, themes, name, author, publishing_house, publication_date)" +
            " VALUES ('1','3','Women''s beauty secrets','1','4','2020');");
            statement.addBatch(" INSERT INTO product_name (type_of_printed_matter, themes, name, author, publishing_house, publication_date)" +
            " VALUES ('1','4','Business analytics','1','5','2021');");
            statement.addBatch(" INSERT INTO product_name (type_of_printed_matter, themes, name, author, publishing_house, publication_date)" +
            " VALUES ('1','3','All about winter fishing','1','3','2020');");
            statement.addBatch(" INSERT INTO product_name (type_of_printed_matter, themes, name, publishing_house, publication_date)" +
            " VALUES ('2','3','Young needleworker','3','2011');");
            statement.addBatch( " INSERT INTO product_name (type_of_printed_matter, themes, name, publishing_house, publication_date)" +
            " VALUES ('2','3','Rich and beautiful','4','2007');");
            statement.addBatch(" INSERT INTO product_name (type_of_printed_matter, themes, name, publishing_house, publication_date)" +
            " VALUES ('3','5','Moscow time','1','2010');");
            statement.addBatch( " INSERT INTO product_name (type_of_printed_matter, themes, name, publishing_house, publication_date)" +
            " VALUES ('3','5','Chronicles of a metallurgist','2','2020');");
            statement.addBatch( " INSERT INTO product_name (type_of_printed_matter, themes, name, publishing_house, publication_date)" +
            " VALUES ('3','5','Gomel truth','3','2014');");
            statement.addBatch( " INSERT INTO product_name (type_of_printed_matter, themes, name, publishing_house, publication_date)" +
            " VALUES ('2','3','Healthy sleep','4','2018');");
            statement.addBatch( " INSERT INTO product_name (type_of_printed_matter, themes, name, publishing_house, publication_date)" +
            " VALUES ('3','3','Health in every home','4','2019');");
            statement.addBatch( " INSERT INTO product_name (type_of_printed_matter, themes, name, publishing_house, publication_date)" +
            " VALUES ('2','4','Programming for beginners','5','2014');");
            statement.addBatch( " INSERT INTO product_name (type_of_printed_matter, themes, name, publishing_house, publication_date)" +
            " VALUES ('3','3','Hunting and fishing','3','2014');");
            statement.addBatch(" INSERT INTO product_name (type_of_printed_matter, themes, name, publishing_house, publication_date)" +
            " VALUES ('2','3','Miss Universe','4','2014');");
            statement.addBatch( " INSERT INTO product_name (type_of_printed_matter, themes, name, publishing_house, publication_date)" +
            " VALUES ('3','3','my Garden','5','2014');");
            statement.addBatch( " INSERT INTO product_name (type_of_printed_matter, themes, name, publishing_house, publication_date)" +
            " VALUES ('2','4','Labor market analytics','2','2020');");
            statement.addBatch(" INSERT INTO product_name (type_of_printed_matter, themes, name, publishing_house, publication_date)" +
            " VALUES ('3','5','Student News Portal','3','2014');");
            statement.addBatch( " INSERT INTO product_name (type_of_printed_matter, themes, name, publishing_house, publication_date)" +
            " VALUES ('2','4','Young radio technician','2','2014');");
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

