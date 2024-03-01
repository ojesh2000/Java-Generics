import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayClass <T>{
    private final T[] localArray;

    public ArrayClass(Collection<T> collection){
        localArray = (T[])collection.toArray();
        //Since arrays are refiable and collections are not, we get a warning
        //Unchecked cast: 'java.lang.Object[]' to 'T[]'
        //The compiler can not guarantee that this assignment will work at run time or not.Hence, we get a warning
        //Arrays are refiable and covariant.
        //Lists and generics are non refiable.
        //Only Lists and Maps of unbounded wildcards are refiable.(List<?> or Map<?,?>).
        //Hence, to eliminate this warning, prefer Lists to array.
    }

    public Object choose(){
        Random rnd = ThreadLocalRandom.current();
        return localArray[rnd.nextInt(localArray.length)];
    }
}
