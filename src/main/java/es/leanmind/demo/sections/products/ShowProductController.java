package es.leanmind.demo.sections.products;

import es.leanmind.demo.inertia.Inertia;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import static es.leanmind.demo.inertia.Inertia.Props.with;

@Controller
public class ShowProductController {

    private final ProductService productService;

    public ShowProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public ModelAndView index(@PathVariable Long id) {
        final var viewModel = new ShowProductViewModel(
            productService.getById(id)
        );

        return Inertia.render("Product", with(viewModel));
    }
}
