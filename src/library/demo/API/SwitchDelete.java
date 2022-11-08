package library.demo.API;

import library.demo.DAO.*;

public class SwitchDelete {

    private TipyOfPrintedMatterDAO tipyOfPrintedMatterDAO;
    private ThemesDAO themesDAO;
    private PublishingHouseDAO publishingHouseDAO;
    private AuthorDAO authorDAO;
    private PublicationDateDAO publicationDateDAO;
    private ProductNameDAO productNameDAO;

    public SwitchDelete(TipyOfPrintedMatterDAO tipyOfPrintedMatterDAO, ThemesDAO themesDAO,
                        PublishingHouseDAO publishingHouseDAO, AuthorDAO authorDAO,
                        PublicationDateDAO publicationDateDAO, ProductNameDAO productNameDAO) {
        this.tipyOfPrintedMatterDAO = tipyOfPrintedMatterDAO;
        this.themesDAO = themesDAO;
        this.publishingHouseDAO = publishingHouseDAO;
        this.authorDAO = authorDAO;
        this.publicationDateDAO = publicationDateDAO;
        this.productNameDAO = productNameDAO;
    }

    public void deleteCategories(int id) {
        //Выбираем категорию для удаления объекта
        switch (id) {
            case (1): {
                tipyOfPrintedMatterDAO.delete();
                break;
            }
            case (2): {
                themesDAO.delete();
                break;
            }
            case (3): {
                publishingHouseDAO.delete();
                break;
            }
            case (4): {
                authorDAO.delete();
                break;
            }
            case (5): {
                publicationDateDAO.delete();
                break;
            }
            case (6): {
                productNameDAO.delete();
                break;
            }
            default: {
                System.out.println("operation entered incorrectly");
            }
        }
    }
}
