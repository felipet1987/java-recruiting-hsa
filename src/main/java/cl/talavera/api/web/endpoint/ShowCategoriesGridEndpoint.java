package cl.talavera.api.web.endpoint;

import cl.talavera.api.core.domain.Category;
import cl.talavera.api.core.port.category.CategoriesPresenterPort;
import cl.talavera.api.core.port.category.ShowCategoriesGridInteractorPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShowCategoriesGridEndpoint {
    private final CategoriesPresenterPort presenter;
    private final ShowCategoriesGridInteractorPort interactor;

    public ShowCategoriesGridEndpoint(ShowCategoriesGridInteractorPort interactor, CategoriesPresenterPort presenter) {
        this.presenter = presenter;
        this.interactor = interactor;
    }

    @RequestMapping("/categories/grid")
    public ResponseEntity<List<Category>> present() {
        interactor.run();
        return ResponseEntity.ok(presenter.retrieve());
    }
}
