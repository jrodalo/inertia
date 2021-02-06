package es.leanmind.demo.sections.home;

import es.leanmind.demo.sections.products.Product;
import lombok.Value;

import java.util.List;

@Value
public class HomeViewModel {
    List<Product> products;
}
