package es.leanmind.demo.inertia;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class InertiaPage {
    String component;
    Object props;
    String url;
}
