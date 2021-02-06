package es.leanmind.demo.sections.products;

import lombok.Value;

@Value
public class Product {
    Long id;
    String name;
    String description;
}
