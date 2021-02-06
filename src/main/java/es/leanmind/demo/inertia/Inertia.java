package es.leanmind.demo.inertia;

import lombok.experimental.UtilityClass;
import org.springframework.web.servlet.ModelAndView;

@UtilityClass
public class Inertia {

    private static final String INERTIA_VIEW_NAME = "inertiaView";

    public static ModelAndView render(String component) {
        return new ModelAndView(INERTIA_VIEW_NAME)
            .addObject("component", component);
    }

    public static ModelAndView render(String component, Props props) {
        return new ModelAndView(INERTIA_VIEW_NAME)
            .addObject("component", component)
            .addObject("props", props.getContent());
    }

    public static class Props {
        private final Object content;

        private Props(Object viewModel) {
            this.content = viewModel;
        }

        public static Props with(Object viewModel) {
            return new Props(viewModel);
        }

        public Object getContent() {
            return content;
        }
    }
}
