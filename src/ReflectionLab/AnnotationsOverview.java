package ReflectionLab;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AnnotationsOverview {
    public static void main(String[] args) {
    }

    //@Override – generates compile time error if the method does not override a method in a parent class
    @Override
    public String toString() {
        return "new toString() method";
    }

    //@SupressWarning – turns off compiler warnings
    @SuppressWarnings(value = "unchecked")
    public <T> void warning (int size) {
        T[] unchecked = (T[]) new Object[size];
    }

    //@Deprecated – generates a compiler warning if the element is used
    @Deprecated
    public void deprecatedMethod() {
        System.out.println("Deprecated!");
    }

    //@interface – the keyword for annotations
    public @interface MyAnnotation {
        String myValue() default "default";
    }

    @MyAnnotation(myValue = "value")
    public void annotatedMethod() {
        System.out.println("I am annotated");
    }

    //@Target – specifies where the annotation is applicable
    @Target(ElementType.FIELD)
    public @interface FieldAnnotation{
    }

    //@Retention – specifies where annotation is available
    @Retention(RetentionPolicy.RUNTIME)
    public @interface RuntimeAnnotation{
        //...
    }

}
