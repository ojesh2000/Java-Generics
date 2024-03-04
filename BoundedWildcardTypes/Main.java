import java.util.*;

public class Main {
    public static void main(String[] args) {
        StackImpl<Number> pushStack = new StackImpl<>();
        Iterable<Integer> l = List.of(1 , 2 , 3 , 4 , 5 , 6);
        pushStack.pushAll(l);

        StackImpl<Number> popStack = new StackImpl<>();
        Collection<Object> dst = new ArrayList<>();
        popStack.popAll(dst);

        Set<Integer> integers = Set.of(1, 3, 5);
        Set<Double> doubles = Set.of(2.0, 4.0, 6.0);
        Set<Number> numbers = combineSets(integers, doubles);

    }

    //s1 and s2 are both E producers
    //Apply PECS
    public static <E> Set<E> combineSets(Set<? extends E> s1, Set<? extends E> s2){
        Set<E> newSet = new HashSet<>(s1);
        newSet.addAll(s2);
        return newSet;
    }

    //Main Function throws error
//    public static <E> Set<E> combineSets(Set<E> s1, Set<E> s2){
//        Set<E> newSet = new HashSet<>(s1);
//        newSet.addAll(s2);
//        return newSet;
//    }
}