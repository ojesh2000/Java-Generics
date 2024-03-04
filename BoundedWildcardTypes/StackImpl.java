import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

public class StackImpl <T>{
    private T[] stack;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public StackImpl(){
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

    //Using this pushAll method from Main gives the following error
    //'pushAll(java.lang.Iterable<java.lang.Number>)' in 'StackImpl' cannot be applied to '(java.lang.Iterable<java.lang.Integer>)'
    //Although Integer is a SubType of Number, Lists/Iterables are invariant.
    //Thus, even if E is a subType of T, it doesn't imply that List<E> is a subType of List<T> as well.
    /**To overcome this problem we use bounded wildcard types**/
//    public void pushAll(Iterable<T> src){
//        for (T t: src){
//            push(t);
//        }
//    }


    //Now the type of Iterable is -> something that extends T
    //This code compiles without any error
    //Here T serves as a producer.
    public void pushAll(Iterable<? extends T> src){
        for (T t: src){
            push(t);
        }
    }

    //popAll method pops an element from the Stack and adds it to a Collection dst

    //This code gives the following error in Main
    //'popAll(java.util.Collection<java.lang.Number>)' in 'StackImpl' cannot be applied to '(java.util.Collection<java.lang.Object>)'
    //This is because Collections are invariant, thus it might make sense to push an element of Type number in an ArrayList<Object>
    //It is not possible.
    //To overcome this problem we again use bounded wildcard types
//    public void popAll(Collection<T> dst){
//        while(!isEmpty()){
//            dst.add(pop());
//        }
//    }

    //This code compiles without giving any exception.
    //Here T serves as a consumer
    public void popAll(Collection<? super T> dst){
        while(!isEmpty()){
            dst.add(pop());
        }
    }
    /**PECS stands for producer-extends, consumer-super.**/
}

