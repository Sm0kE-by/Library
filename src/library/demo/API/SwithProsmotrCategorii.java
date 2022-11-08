package library.demo.API;

import library.demo.cache.*;

public class SwithProsmotrCategorii {
    private CreateCache createCache;
    private TipyOfPrintedMatterCache tipyOfPrintedMatterCache;
    private ThemesCache themesCache;
    private PublishingHouseCache publishingHouseCache;
    private AuthorCache authorCache;
    private PublicationDateCache publicationDateCache;
    private ProductNameCache productNameCache;

    public SwithProsmotrCategorii(CreateCache createCache, TipyOfPrintedMatterCache tipyOfPrintedMatterCache,
                                  ThemesCache themesCache, PublishingHouseCache publishingHouseCache,
                                  AuthorCache authorCache, PublicationDateCache publicationDateCache,
                                  ProductNameCache productNameCache) {
                this.createCache = createCache;
        this.tipyOfPrintedMatterCache = tipyOfPrintedMatterCache;
        this.themesCache = themesCache;
        this.publishingHouseCache = publishingHouseCache;
        this.authorCache = authorCache;
        this.publicationDateCache = publicationDateCache;
        this.productNameCache = productNameCache;
    }

    public void viewCategories(int num) {
        //Выбираем категорию для просмотра объекта
        switch (num) {
            case (1): {
                tipyOfPrintedMatterCache.view(createCache.getMapTipyOfPrintedMatter());
                break;
            }
            case (2): {
                themesCache.view(createCache.getMapThemes());
                break;
            }
            case (3): {
                publishingHouseCache.view(createCache.getMapPublishingHouse());
                break;
            }
            case (4): {
                authorCache.view(createCache.getMapAuthor());
                break;
            }
            case (5): {
                publicationDateCache.view(createCache.getMapPublicationDate());
                break;
            }
            case (6): {
                productNameCache.view(createCache.getMapProductName());
                break;
            }
            default: {
                System.out.println("operation entered incorrectly");
            }
        }
    }
}
