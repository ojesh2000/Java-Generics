import java.util.function.Function;
import java.util.function.UnaryOperator;

public class CustomIdentityFunction<T> {
    private static final UnaryOperator<Object> identityFunction = t -> t;
//    private static final UnaryOperator<T> identityFunction = t -> t;
//    The above line gives the following error
//    'CustomIdentityFunction.this' cannot be referenced from a static context
//    The custom parameter T is not present inside the class where all the static variables are initialized("static context").
//    Hence, we can not initialize a static Generic variable inside such classes.
//    To overcome this problem, we have initialized a static variable with type "Object" and casted it to a generic while returning
    @SuppressWarnings("unchecked")
    //It is safe to Suppress the warning of the following return statement as
    //UnaryOperator<T> extends Function<T, T>
    public static <T> UnaryOperator<T> getIdentityFunction(){
        return (UnaryOperator<T>) identityFunction;
//        return (UnaryOperator<T>)Function.identity();
//        This is inbuilt java identity function
    }


}
