import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<?> s = new HashSet<>();
        addToSet(s, "2");

        for(Object o : s){
            System.out.println(o);
        }
    }
    private static <T> void addToSet(Set<?> set, T element) {
        // Since the type of the set is unknown, we need to use a wildcard capture
        @SuppressWarnings("unchecked")
        Set<T> tempSet = (Set<T>) set;
        tempSet.add(element);
    }
}