package library.demo.API.menuOperations;

public enum MenuOperationsEnum {
    PRODUCT_TYPE("Тип печатной продукции", 1),
    THEMES("Тематика", 2),
    EDITION("Редакция", 3),
    AUTHOR("Автор", 4),
    YEAR_OF_PUBLISHING("Год издания", 5),
    PRODUCT_NAME("Название продукции", 6);

    private String nameOperation;
    private int id;

    MenuOperationsEnum(String nameOperation, int id) {
        this.nameOperation = nameOperation;
        this.id = id;
    }

    public String getNameOperation() {
        return nameOperation;
    }

    public int getId() {
        return id;
    }


}

