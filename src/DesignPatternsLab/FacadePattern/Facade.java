package DesignPatternsLab.FacadePattern;

public class Facade {
    private SubSystemOne one;
    private SubSystemTwo two;

    public Facade() {
        one = new SubSystemOne();
        two = new SubSystemTwo();
    }

    public void methodA() {
        System.out.println("\nMethodA() ---- ");
        one.MethodOne();
        two.MethodTwo();
    }

    public void methodB() {
        System.out.println("\nMethodB() ---- ");
        two.MethodTwo();
    }
}
