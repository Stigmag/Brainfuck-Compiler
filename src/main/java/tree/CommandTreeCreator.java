package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CommandTreeCreator {

    private MyTreeNode<String> root;

    public CommandTreeCreator() {
        this.root = new MyTreeNode<>("root");
    }

    public MyTreeNode<String> getRoot() {
        return root;
    }

    public void createTree(String c) {

        List<String> l = new LinkedList<>(Arrays.asList(c.split("")));
        buildTree(l, root);

    }

    private void buildTree(List<String> nodeNames, MyTreeNode<String> node) {

        if (nodeNames.isEmpty()) {
            return;
        }

        String nodeName = nodeNames.remove(0);
        MyTreeNode myNode = new MyTreeNode<>(nodeName);
        int index = node.getChildren().indexOf(myNode);

        if (index == -1) {

            node.addChild(myNode);
            myNode = node;

            if (nodeName.charAt(0) == '[') {

                myNode = node.getLastChildren();

            }
            if (nodeName.charAt(0) == ']') {
                myNode = node.getParent();
            }
        }

        buildTree(nodeNames, myNode);

    }


}
