package ReflectionLab;

import ReflectionLab.L4CreateAnnotation.Subject;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Scanner;

public class ReflectionOverview {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Scanner scanner = new Scanner(System.in);

        //Obtain its java.lang.Class object
        Class myClass = Class.forName("ReflectionLab.Person");

        //Obtain Class name
        String className = myClass.getName();
        String simpleClassName = myClass.getSimpleName();

        //Obtain parent class
        Class parentClassName = myClass.getSuperclass();

        //Obtain interfaces
        Class[] interfaces = myClass.getInterfaces();

        //Obtain only public constructors
        Constructor[] ctors = myClass.getConstructors();

        //Obtain all constructors
        Constructor[] allCtors = myClass.getDeclaredConstructors();

        //Get constructor by parameters
        Constructor ctor = myClass.getConstructor(int.class);

        //Get parameter types
        Class[] parameterTypes = ctor.getParameterTypes();

        //Instantiating objects using constructor
        Constructor constructor = Person.class.getConstructor(int.class);
        Person person = (Person) constructor.newInstance(2);

        //Obtain public fields
        Field field = myClass.getField("nickName");
        Field[] fields = myClass.getFields();

        //Obtain all fields
        Field[] allFields = myClass.getDeclaredFields();

        //Get field name and type
        String fieldName = field.getName();
        Object fieldType = field.getType();

        //Setting value for field
        Field field1 = myClass.getDeclaredField("age");
        Person person1 = new Person(2);
        //making private field public
        //Change the behavior of the AccessibleObject
        field1.setAccessible(true);
        Object value = field1.get(person1);
        field1.set(person1, -2);
        field1.set(person1, value);

        //Obtain public methods
        Method[] methods = myClass.getMethods();
        Method method = myClass.getMethod("liftWeights", int.class, int.class);

        //Get methods without parameters
        Method method1 = myClass.getMethod("sayHi", null);

        //Obtain method parameters and return type
        Class[] paramTypes = method.getParameterTypes();
        Class returnType = method.getReturnType();

        //Get methods with parameters
        Method method2 = Person.class.getMethod("liftWeights", int.class, int.class);
        Object returnValue = method2.invoke(null, 2, 3);

        //Obtain the class modifiers like this
        int classModifiers = myClass.getModifiers();

        //can be called on constructors, fields, methods
        int constructorModifiers = constructor.getModifiers();
        int fieldModifiers = field.getModifiers();
        int methodModifiers = method.getModifiers();

        //You can check the modifiers
        System.out.println(Modifier.isPrivate(classModifiers));
        System.out.println(Modifier.isProtected(constructorModifiers));
        System.out.println(Modifier.isPublic(fieldModifiers));
        System.out.println(Modifier.isStatic(methodModifiers));

        //Creating arrays via Java Reflection
        int [] intArray = (int[]) Array.newInstance(int.class, 3);

        //Obtain parameter annotations
        Array.set(intArray, 0, 123);
        Array.set(intArray, 1, 456);

        //Obtain class annotations
        Annotation[] annotations = myClass.getAnnotations();
        Annotation annotation = myClass.getAnnotation(Subject.class);

        //Obtain parameter annotations
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();

        //Obtain fields and methods annotations
        Annotation[] fieldAnot = field.getDeclaredAnnotations();
        Annotation[] methodAnot = method.getDeclaredAnnotations();

        System.out.println();

    }
}
