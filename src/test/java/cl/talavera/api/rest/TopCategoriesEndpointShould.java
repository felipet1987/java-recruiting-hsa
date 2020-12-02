package cl.talavera.api.rest;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import cl.talavera.api.core.port.CategoriesPresenterPort;
import cl.talavera.api.core.port.TopCategoriesInteractorPort;
import cl.talavera.api.rest.CategoryView;
import cl.talavera.api.rest.TopCategoriesEndpoint;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

public class TopCategoriesEndpointShould {
    @Test
    void present() {
        TopCategoriesInteractorPort interactor = mock(TopCategoriesInteractorPort.class);

        CategoriesPresenterPort presenter = mock(CategoriesPresenterPort.class);
        TopCategoriesEndpoint endpoint = new TopCategoriesEndpoint(interactor,presenter);

        List<CategoryView> view = expectedView();
        when(presenter.retrieve()).thenReturn(view);

        ResponseEntity<List<CategoryView>> response = endpoint.present();



        verify(interactor,times(1)).run();
        verify(presenter,times(1)).retrieve();
        assertThat(response, equalTo(ResponseEntity.ok(view)));

    }

    private List<CategoryView> expectedView() {
        List<CategoryView> list = new ArrayList<>();
        list.add(CategoryView.builder().name("category").build());
        return list;
    }
}