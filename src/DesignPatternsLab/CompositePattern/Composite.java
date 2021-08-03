package DesignPatternsLab.CompositePattern;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {
    private List<Component> children = new ArrayList<Component>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component c) {
        children.add(c);
    }

    @Override
    public void remove(Component c) {
        children.remove(c);
    }

    @Override
    public void display(int depth) {
        printNameInDepth(depth, name);
        for (Component c : children) {
            c.display(depth + 2);
        }
    }

    public void printNameInDepth(int depth, String name) {
        for (int i = 0; i < depth; i++) {
            System.out.print("-");
        }
        System.out.print(name);
    }
}
