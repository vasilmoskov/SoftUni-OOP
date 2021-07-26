package ReflectionAndAnnotationLab;

import ReflectionAndAnnotationLab.L5CodingTracker.Author;

public class AccessingAnot {

    //@Author(name = "Gosho")
    public class AuthoredClass {
        public void main(String[] args) {
            Class cl = AuthoredClass.class;

            Author author = (Author) cl.getAnnotation(Author.class);

            System.out.println(author.name());

//            Annotation[] annotations = cl.getAnnotations();
//
//            for (Annotation annotation : annotations) {
//                if (annotation.annotationType().equals(Author.class)){
//                    Author author1 = (Author) annotation;
//                    System.out.println(author.name());
//                }
//            }


        }
    }
}
