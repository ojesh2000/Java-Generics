import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> randInt = List.of(1 , 2 , 3 , 4 , 5);
        ArrayClass<Integer> arrayClass = new ArrayClass<>(randInt);
        ListClass<Integer> listClass = new ListClass<>(randInt);
        System.out.println("ArrayClass result: " + arrayClass.choose());
        System.out.println("ListClass result: " + listClass.choose());
    }
}