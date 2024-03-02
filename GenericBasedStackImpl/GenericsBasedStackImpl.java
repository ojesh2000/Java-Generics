import java.util.Arrays;
import java.util.EmptyStackException;

public class GenericsBasedStackImpl <T>{
    private T[] stack;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public GenericsBasedStackImpl(){
        stack = (T[])(new Object[DEFAULT_INITIAL_CAPACITY]);
        //Throws warning - Unchecked cast: 'java.lang.Object[]' to 'T[]'
        //stack = new T[DEFAULT_INITIAL_CAPACITY]; //---> throws Error as a Generic array can not be initialized
    }

    public void push(T e){
        ensureCapacity();
        stack[size++] = e;
    }

    public T pop(){
        if(size == 0){
            throw new EmptyStackException();
        }
        T result = stack[--size];
        stack[size] = null;
        return result;
    }

    private void ensureCapacity(){
        if(size == stack.length){
            stack = Arrays.copyOf(stack, 2 * size + 1);
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
