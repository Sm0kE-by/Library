package library.demo.API;

import library.demo.DAO.*;
import library.demo.cache.*;

public class APIMain {

    private CreateCache createCache = new CreateCache();

    TipyOfPrintedMatterCache tipyOfPrintedMatterCache = new TipyOfPrintedMatterCache();
    ThemesCache themesCache = new ThemesCache();
    PublishingHouseCache publishingHouseCache = new PublishingHouseCache();
    AuthorCache authorCache = new AuthorCache();
    PublicationDateCache publicationDateCache = new PublicationDateCache();
    ProductNameCache productNameCache = new ProductNameCache();

    private TipyOfPrintedMatterDAO tipyOfPrintedMatterDAO = new TipyOfPrintedMatterDAO();
    private ThemesDAO themesDAO = new ThemesDAO();
    private PublishingHouseDAO publishingHouseDAO = new PublishingHouseDAO();
    private AuthorDAO authorDAO = new AuthorDAO();
    private PublicationDateDAO publicationDateDAO = new PublicationDateDAO();
    private ProductNameDAO productNameDAO = new ProductNameDAO();

    SwithProsmotrCategorii swithProsmotrCategorii = new SwithProsmotrCategorii(createCache, tipyOfPrintedMatterCache,
            themesCache, publishingHouseCache, authorCache, publicationDateCache, productNameCache);
    SwitchSearch switchSearch = new SwitchSearch(tipyOfPrintedMatterDAO, themesDAO, publishingHouseDAO,
            authorDAO, publicationDateDAO, productNameDAO);
    SwitchChange switchChange = new SwitchChange(tipyOfPrintedMatterDAO, themesDAO, publishingHouseDAO,
            authorDAO, publicationDateDAO, productNameDAO);
    SwitchDelete switchDelete = new SwitchDelete(tipyOfPrintedMatterDAO, themesDAO, publishingHouseDAO,
            authorDAO, publicationDateDAO, productNameDAO);
    SwitchAdd switchAdd = new SwitchAdd(tipyOfPrintedMatterDAO, themesDAO, publishingHouseDAO,
            authorDAO, publicationDateDAO, productNameDAO);

    public MenuCategoriesOperations menuCategoriesOperations = new MenuCategoriesOperations(swithProsmotrCategorii,
            switchSearch, switchChange, switchDelete, switchAdd);
    public MainMenuOperations mainMenuOperations = new MainMenuOperations(menuCategoriesOperations);

    public void startsMenu() {
        while (true) {
            mainMenuOperations.mainScreen();
        }
    }
}
