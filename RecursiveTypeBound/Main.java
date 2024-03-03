import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

    }

    public static <E extends Comparable<E>> E max(Collection<E> c){
        if(c.isEmpty()){
            throw new IllegalArgumentException("Empty Collection");
        }
        E result = null;
        for(E e : c){
            if(e == null || e.compareTo(result) > 0){
                result = Objects.requireNonNull(e);
            }
        }
        return result;
    }
}