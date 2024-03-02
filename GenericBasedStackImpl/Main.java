import java.util.*;

public class Main {
    public static void main(String[] args) {
        //1st is more preferred than 2nd as
        //the first technique requires only a single cast (where the array is created), while the second requires a separate cast each time an array element is read
        GenericsBasedStackImpl<String> stack1 = new GenericsBasedStackImpl<>();
        GenericsBasedStackImpl2<String> stack2 = new GenericsBasedStackImpl2<>();
        List<String> toPrint = List.of("Hi", "Hello", "Ok", "random", "Ear");
        System.out.println("Result of stack1");
        for (String s : toPrint) {
            stack1.push(s);
        }
        while (!stack1.isEmpty()) {
            System.out.println(stack1.pop().toUpperCase());
        }

        System.out.println("Result of stack2");
        for (String s : toPrint) {
            stack2.push(s);
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().toUpperCase());
        }
    }
}