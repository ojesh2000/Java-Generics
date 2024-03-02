import java.util.Arrays;
import java.util.EmptyStackException;

public class GenericsBasedStackImpl2<T>{
    private Object[] stack;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public GenericsBasedStackImpl2(){
        stack = (new Object[DEFAULT_INITIAL_CAPACITY]);
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
        @SuppressWarnings("unchecked")
        T result = (T)(stack[--size]);
        //Since generics are non-refiable types, the compiler can not ensure that the Object array will contain elements of Type "T" at runtime.
        //Hence, we get a warning which can be suppressed.
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
