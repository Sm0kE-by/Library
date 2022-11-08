package library.demo.API;

import library.demo.API.menuOperations.MenuOperationsEnum;

public class MenuCategoriesOperations {

    private SwithProsmotrCategorii swithProsmotrCategorii;
    private SwitchSearch switchSearch;
    private SwitchChange switchChange;
    private SwitchDelete switchDelete;
    private SwitchAdd switchAdd;

    public MenuCategoriesOperations(SwithProsmotrCategorii swithProsmotrCategorii,
                                    SwitchSearch switchSearch, SwitchChange switchChange,
                                    SwitchDelete switchDelete, SwitchAdd switchAdd) {
        this.swithProsmotrCategorii = swithProsmotrCategorii;
        this.switchSearch = switchSearch;
        this.switchChange = switchChange;
        this.switchDelete = switchDelete;
        this.switchAdd = switchAdd;
    }

    public void screenOperationsMenuCategories() {
        //перебор и отображение меню операций из Enum
        System.out.printf("\n%-35s %-3s\n", "OPERATIONS", "ID");
        for (MenuOperationsEnum operation : MenuOperationsEnum.values()) {
            System.out.printf("%-35s %-3s\n", operation.getNameOperation(), operation.getId());
        }
        System.out.println("Выберите операцию, введя нужный ID:");
    }

    public void selectionOperations(int id1Menu) {
        int num = id1Menu;  //Число введенное в главном меню
        System.out.println("ВВОД ДАННЫХ");
        int num2 = MainMenuOperations.scanner.nextInt();    //выбираем раздел во втором меню
        switch (num) {
            case (1): {
                swithProsmotrCategorii.viewCategories(num2);
                break;
            }
            case (2): {
                switchSearch.searchCategories(num2);
                break;
            }
            case (3): {
                switchChange.changeCategories(num2);
                break;
            }
            case (4): {
                switchDelete.deleteCategories(num2);
                break;
            }
            case (5): {
                switchAdd.addCategories(num2);
                break;
            }
            default: {
                System.out.println("operation entered incorrectly");
            }
        }
    }
}
