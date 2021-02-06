package es.leanmind.demo.inertia;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.leanmind.demo.sections.home.HomeViewModel;
import es.leanmind.demo.sections.products.Product;
import es.leanmind.demo.sections.products.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class InertiaApplicationTests {

    private static final List<Product> PRODUCTS = List.of(
        new Product(1L, "Test Product 1", "Test Product description"),
        new Product(2L, "Test Product 2", "Test Product description")
    );

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @BeforeEach
    void setUp() {
        when(productService.all()).thenReturn(PRODUCTS);
    }

    @Test
    void requestWithoutInertiaHeaderReturnsHTML() throws Exception {
        final var expected = expectedInertiaPage();

        mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.TEXT_HTML))
            .andExpect(content().string(containsString(expected)));
    }

    @Test
    void requestWithInertiaHeaderReturnsJSON() throws Exception {
        final var expected = expectedInertiaPage();

        mockMvc.perform(get("/").header(InertiaView.INERTIA_HEADER_NAME, true))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().json(expected));
    }

    private String expectedInertiaPage() throws JsonProcessingException {
        final var inertiaPage = InertiaPage.builder()
            .component("Home")
            .props(new HomeViewModel(PRODUCTS))
            .url("/")
            .build();

        return new ObjectMapper().writeValueAsString(inertiaPage);
    }

}
