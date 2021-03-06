package cl.talavera.api.config;

import cl.talavera.api.core.interactor.ShowCategoriesGridInteractor;
import cl.talavera.api.core.interactor.TopCategoriesInteractor;
import cl.talavera.api.core.port.category.CategoriesPresenterPort;
import cl.talavera.api.core.port.category.CategoryDaoPort;
import cl.talavera.api.core.port.category.ShowCategoriesGridInteractorPort;
import cl.talavera.api.core.port.category.TopCategoriesInteractorPort;
import cl.talavera.api.data.dao.CategoryDao;
import cl.talavera.api.data.repository.CategoryRestRepository;
import cl.talavera.api.web.presenter.CategoriesPresenter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoriesConfig {
    @Bean
    public TopCategoriesInteractorPort TopCategoriesInteractor() {
        return new TopCategoriesInteractor(dao(),presenter());
    }

    @Bean
    public ShowCategoriesGridInteractorPort ShowCategoriesGridInteractor() {
        return new ShowCategoriesGridInteractor(dao(),presenter());
    }
    @Bean
    protected CategoryDaoPort dao() {

        CategoryRestRepository repo = new CategoryRestRepository();
        return new CategoryDao(repo);
    }

    @Bean
    protected CategoriesPresenterPort presenter() {
        return new CategoriesPresenter();
    }
}
