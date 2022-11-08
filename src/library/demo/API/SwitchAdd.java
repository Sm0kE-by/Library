package library.demo.API;

import library.demo.DAO.*;

public class SwitchAdd {

    private TipyOfPrintedMatterDAO tipyOfPrintedMatterDAO;
    private ThemesDAO themesDAO;
    private PublishingHouseDAO publishingHouseDAO;
    private AuthorDAO authorDAO;
    private PublicationDateDAO publicationDateDAO;
    private ProductNameDAO productNameDAO;

    public SwitchAdd(TipyOfPrintedMatterDAO tipyOfPrintedMatterDAO, ThemesDAO themesDAO,
                     PublishingHouseDAO publishingHouseDAO, AuthorDAO authorDAO,
                     PublicationDateDAO publicationDateDAO, ProductNameDAO productNameDAO) {
        this.tipyOfPrintedMatterDAO = tipyOfPrintedMatterDAO;
        this.themesDAO = themesDAO;
        this.publishingHouseDAO = publishingHouseDAO;
        this.authorDAO = authorDAO;
        this.publicationDateDAO = publicationDateDAO;
        this.productNameDAO = productNameDAO;
    }

    public void addCategories(int id) {
        //Выбираем категорию для добавления объекта
        switch (id) {
            case (1): {
                tipyOfPrintedMatterDAO.add();
                break;
            }
            case (2): {
                themesDAO.add();
                break;
            }
            case (3): {
                publishingHouseDAO.add();
                break;
            }
            case (4): {
                authorDAO.add();
                break;
            }
            case (5): {
                publicationDateDAO.add();
                break;
            }
            case (6): {
                productNameDAO.add();
                break;
            }
            default: {
                System.out.println("operation entered incorrectly");
            }
        }
    }
}
