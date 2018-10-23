package design.pattern.composite;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Component {

    List<Component> children = new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    public boolean addComponent(Component c) {
        return children.add(c);
    }

    public boolean removeComponent(Component c) {
        return children.remove(c);
    }

    public List<Component> getChildren() {
        return children;
    }
}
