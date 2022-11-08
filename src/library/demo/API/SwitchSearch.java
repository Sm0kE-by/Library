package library.demo.API;

import library.demo.DAO.*;

public class SwitchSearch {

    private TipyOfPrintedMatterDAO tipyOfPrintedMatterDAO;
    private ThemesDAO themesDAO;
    private PublishingHouseDAO publishingHouseDAO;
    private AuthorDAO authorDAO;
    private PublicationDateDAO publicationDateDAO;
    private ProductNameDAO productNameDAO;

    public SwitchSearch(TipyOfPrintedMatterDAO tipyOfPrintedMatterDAO, ThemesDAO themesDAO,
                        PublishingHouseDAO publishingHouseDAO, AuthorDAO authorDAO,
                        PublicationDateDAO publicationDateDAO, ProductNameDAO productNameDAO) {
        this.tipyOfPrintedMatterDAO = tipyOfPrintedMatterDAO;
        this.themesDAO = themesDAO;
        this.publishingHouseDAO = publishingHouseDAO;
        this.authorDAO = authorDAO;
        this.publicationDateDAO = publicationDateDAO;
        this.productNameDAO = productNameDAO;
    }

    public void searchCategories(int id) {
        //Выбираем категорию для поиска объекта
        switch (id) {
            case (1): {
                tipyOfPrintedMatterDAO.search();
                break;
            }
            case (2): {
                themesDAO.search();
                break;
            }
            case (3): {
                publishingHouseDAO.search();
                break;
            }
            case (4): {

                authorDAO.search();
                break;
            }
            case (5): {
                publicationDateDAO.search();
                break;
            }
            case (6): {
                productNameDAO.search();
                break;
            }
            default: {
                System.out.println("operation entered incorrectly");
            }
        }
    }
}
