package cl.talavera.api.web;

import cl.talavera.api.core.domain.Category;
import cl.talavera.api.core.port.category.CategoriesPresenterPort;
import cl.talavera.api.core.port.category.ShowCategoriesGridInteractorPort;
import cl.talavera.api.web.endpoint.ShowCategoriesGridEndpoint;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class ShowCategoriesGridEndpointShould {
    @Test
    void present() {
        ShowCategoriesGridInteractorPort interactor = mock(ShowCategoriesGridInteractorPort.class);
        CategoriesPresenterPort presenter = mock(CategoriesPresenterPort.class);
        ShowCategoriesGridEndpoint endpoint = new ShowCategoriesGridEndpoint(interactor,presenter);

        List<Category> view = expectedView();
        when(presenter.retrieve()).thenReturn(view);

        ResponseEntity<List<Category>> response = endpoint.present();



        verify(interactor,times(1)).run();
        verify(presenter,times(1)).retrieve();
        assertThat(response, equalTo(ResponseEntity.ok(view)));
    }

    private List<Category> expectedView() {
        return asList(Category.builder().build());
    }
}
