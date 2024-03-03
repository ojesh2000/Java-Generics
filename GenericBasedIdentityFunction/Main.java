import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        String[] strings = { "jute", "hemp", "nylon" };
        UnaryOperator<String> sameString = CustomIdentityFunction.getIdentityFunction();
        for (String s : strings)
            System.out.println(sameString.apply(s));
        Number[] numbers = { 1, 2.0, 3L };
        UnaryOperator<Number> sameNumber =CustomIdentityFunction. getIdentityFunction();
        for (Number n : numbers)
            System.out.println(sameNumber.apply(n));
    }
}