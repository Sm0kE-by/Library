package library.demo.API.menuOperations;

import library.demo.API.MenuCategoriesOperations;

public enum GlavnoeMenuOperations {
    VIEW_SECTIONS("Категории", 1),
    SEARCH("Поиск", 2),
    CHANGE("Изменить", 3),
    DELETE("Удалить", 4),
    ADD("Добавить", 5),
    FEEDBACK("Обратная связь", 6) {
        public void feedback() {
            System.out.println("РЕСПУБЛИКА БЕЛАРУСЬ, г.Гомель, ул. Сщветская д.1\n" +
                    "   Контактный телефон: +375-25-777-66-55 \n" +
                    "   Email: GomelLibrary@mail.ru");
        }
    },
    EXIT("Выход из приложения", 7);

    private String nameOperation;
    private int id;

    GlavnoeMenuOperations(String nameOperation, int id) {
        this.nameOperation = nameOperation;
        this.id = id;
    }

    public String getNameOperation() {
        return nameOperation;
    }

    public int getId() {
        return id;
    }

    public void viewSections(MenuCategoriesOperations menuCategoriesOperations, int chislo1Menu) {
        menuCategoriesOperations.screenOperationsMenuCategories();
        menuCategoriesOperations.selectionOperations(chislo1Menu);
    }

    public void feedback() {

    }

    public void exit() {
        System.exit(0);
    }
}