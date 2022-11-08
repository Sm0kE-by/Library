package library.demo.createDB;

public class CreateDBMain {
    public CreateDB createDB() {
        CreateDB createDB = new CreateDB();
        createDB.createTables();
        createDB.insertIntoAuthor();
        createDB.insertIntoThemes();
        createDB.insertIntoPublishingHouse();
        createDB.insertIntoTypeOfPrintedMatter();
        createDB.insertIntoPublicationDate();
        createDB.insertIntoProductName();
        return null;
    }
}
