import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ListClass <T>{
    List<T> localList;

    public ListClass(Collection<T> collection){
        localList = collection.stream().toList();
        //No warnings here
    }

    public Object choose(){
        Random rnd = ThreadLocalRandom.current();
        return localList.get(rnd.nextInt(localList.size()));
    }
}
