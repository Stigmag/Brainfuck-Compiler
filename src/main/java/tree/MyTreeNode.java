package tree;





import java.util.Iterator;
import java.util.LinkedList;

public class MyTreeNode<T> {
    private T data;
    private LinkedList<MyTreeNode> children = new LinkedList<>();
    private MyTreeNode parent = null;

    public MyTreeNode(T data) {
        this.data = data;
    }

    public void addChild(MyTreeNode child) {
        child.parent = this;
        this.children.add(child);
    }


    public LinkedList<MyTreeNode> getChildren() {
        return children;
    }

    public T getData() {
        return data;
    }

    public MyTreeNode getParent() {
        return parent;
    }


    private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(data);
        buffer.append('\n');
        for (Iterator<MyTreeNode> it = children.iterator(); it.hasNext(); ) {
            MyTreeNode next = (MyTreeNode) it.next();
            if (it.hasNext()) {
                next.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            } else {
                next.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
    }


    public MyTreeNode getLastChildren() {
        return (MyTreeNode) this.children.getLast();
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        print(buffer, "", "");
        return buffer.toString();
    }
}