package library.demo.API;

import library.demo.DAO.*;

public class SwitchChange {

    private TipyOfPrintedMatterDAO tipyOfPrintedMatterDAO;
    private ThemesDAO themesDAO;
    private PublishingHouseDAO publishingHouseDAO;
    private AuthorDAO authorDAO;
    private PublicationDateDAO publicationDateDAO;
    private ProductNameDAO productNameDAO;

    public SwitchChange(TipyOfPrintedMatterDAO tipyOfPrintedMatterDAO, ThemesDAO themesDAO,
                        PublishingHouseDAO publishingHouseDAO, AuthorDAO authorDAO,
                        PublicationDateDAO publicationDateDAO, ProductNameDAO productNameDAO) {
        this.tipyOfPrintedMatterDAO = tipyOfPrintedMatterDAO;
        this.themesDAO = themesDAO;
        this.publishingHouseDAO = publishingHouseDAO;
        this.authorDAO = authorDAO;
        this.publicationDateDAO = publicationDateDAO;
        this.productNameDAO = productNameDAO;
    }

    public void changeCategories(int id) {
        //Выбираем категорию для изменения объекта
        switch (id) {
            case (1): {
                tipyOfPrintedMatterDAO.change();
                break;
            }
            case (2): {
                themesDAO.change();
                break;
            }
            case (3): {
                publishingHouseDAO.change();
                break;
            }
            case (4): {
                authorDAO.change();
                break;
            }
            case (5): {
                publicationDateDAO.change();
                break;
            }
            case (6): {
                productNameDAO.change();
                break;
            }
            default: {
                System.out.println("operation entered incorrectly");
            }
        }
    }
}
