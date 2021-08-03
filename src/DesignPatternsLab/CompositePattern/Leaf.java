package DesignPatternsLab.CompositePattern;

public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component c) {
        System.out.println("Cannot add to a leaf");
    }

    @Override
    public void remove(Component c) {
        System.out.println("Cannot remove from a leaf");
    }

    @Override
    public void display(int depth) {
        printNameInDepth(depth, name);
    }

    private void printNameInDepth(int depth, String name) {

    }
}
