package lambda.style;


import java.awt.*;
import java.util.function.Function;
import java.util.stream.Stream;

class Camera {

    public Camera(Function<Color, Color>... filters) {
        setFilters(filters);
    }

    private Function<Color, Color> filter;

    public void setFilters(Function<Color, Color>... filters) {
        filter = Stream.of(filters)
//                .reduce(color -> color, (theFilters, aFilter) -> theFilters.andThen(aFilter);
                .reduce(Function.identity(), Function::andThen);
    }

    public Color snap(Color input) {
        return filter.apply(input);
    }
}

public class DecoratingLambdaSample2 {

    public static void printSnap(Camera camera) {
        System.out.println(camera.snap(new Color(125, 125, 125)));
    }

    public static void main(String[] args) {
        printSnap(new Camera());
        System.out.println();

        printSnap(new Camera(Color::brighter));
        System.out.println();

        printSnap(new Camera(Color::darker));
        System.out.println();

        printSnap(new Camera(Color::brighter, Color::darker));
    }
}
