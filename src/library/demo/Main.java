package library.demo;

import library.demo.API.APIMain;
import library.demo.createDB.CreateDBMain;

public class Main {
    public static void main(String[] args) {

//        Если необходимо СОЗДАТЬ и ЗАПОЛНИТЬ таблицы в БД заново
//        CreateDBMain createDBMain = new CreateDBMain();
//        createDBMain.createDB();

        APIMain apiMain = new APIMain();
        apiMain.startsMenu();

    }
}
