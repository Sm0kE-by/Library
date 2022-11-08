package library.demo.API;

import library.demo.API.menuOperations.GlavnoeMenuOperations;

import java.util.Scanner;

public class MainMenuOperations {
    public static Scanner scanner = new Scanner(System.in);
    public MenuCategoriesOperations menuCategoriesOperations;

    public MainMenuOperations(MenuCategoriesOperations menuCategoriesOperations) {
        this.menuCategoriesOperations = menuCategoriesOperations;
    }

    public void mainScreen() {
        // отображение операций Главного Меню
        System.out.println("LIBRARY NAME");
        System.out.println("Welcome to library");
        System.out.printf("%-35s %-3s\n", "OPERATIONS", "ID");
        showOperationsGlMenu();
        System.out.println("Выберите операцию, введя нужный ID:");
        chooseOperationGlMenu(scanner);
    }

    public void showOperationsGlMenu() {
        //перебор и отображение операций главного меню из Enum
        for (GlavnoeMenuOperations operation : GlavnoeMenuOperations.values()) {
            System.out.printf("%-35s %-3s\n", operation.getNameOperation(), operation.getId());
        }
    }

    public void chooseOperationGlMenu(Scanner scanner) {
        int numMM = scanner.nextInt();// Выбор операции в главном меню
        switch (numMM) {
            case (1): {
                GlavnoeMenuOperations.VIEW_SECTIONS.viewSections(menuCategoriesOperations, numMM);
                break;
            }
            case (2): {
                GlavnoeMenuOperations.SEARCH.viewSections(menuCategoriesOperations, numMM);
                break;
            }
            case (3): {
                GlavnoeMenuOperations.CHANGE.viewSections(menuCategoriesOperations, numMM);
                break;
            }
            case (4): {
                GlavnoeMenuOperations.DELETE.viewSections(menuCategoriesOperations, numMM);
                break;
            }
            case (5): {
                GlavnoeMenuOperations.ADD.viewSections(menuCategoriesOperations, numMM);
                break;
            }
            case (6): {
                GlavnoeMenuOperations.FEEDBACK.feedback();
                break;
            }
            case (7): {
                GlavnoeMenuOperations.EXIT.exit();
                break;
            }
            default: {
                System.out.println("operation entered incorrectly");
            }
        }
    }
}
