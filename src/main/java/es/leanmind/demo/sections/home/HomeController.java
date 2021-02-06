package es.leanmind.demo.sections.home;

import es.leanmind.demo.inertia.Inertia;
import es.leanmind.demo.sections.products.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import static es.leanmind.demo.inertia.Inertia.Props.with;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public ModelAndView showHome() {
        final var homeViewModel = new HomeViewModel(
            productService.all()
        );

        return Inertia.render("Home", with(homeViewModel));
    }
}
