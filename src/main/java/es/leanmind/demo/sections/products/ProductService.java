package es.leanmind.demo.sections.products;

import org.springframework.stereotype.Component;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ProductService {

    private static final Map<Long, Product> PRODUCTS = Map.of(
        1L, new Product(1L, "Product 1", "Product 1 description"),
        2L, new Product(2L, "Product 2", "Product 2 description"),
        3L, new Product(3L, "Product 3", "Product 3 description")
    );

    public List<Product> all() {
        return PRODUCTS.values().stream()
            .sorted(Comparator.comparingLong(Product::getId))
            .collect(Collectors.toList());
    }

    public Product getById(Long id) {
        return PRODUCTS.get(id);
    }
}
