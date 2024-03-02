import java.util.Arrays;
import java.util.EmptyStackException;

public class ObjectBasedStackImpl {
    private Object[] stack;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public ObjectBasedStackImpl(){
        stack = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e){
        ensureCapacity();
        stack[size++] = e;
    }

    public Object pop(Object e){
        if(size == 0){
            throw new EmptyStackException();
        }
        Object result = stack[--size];
        stack[size] = null;
        return result;
    }

    private void ensureCapacity(){
        if(stack.length == size){
            stack = Arrays.copyOf(stack, 2 * size + 1);
        }
    }
}
