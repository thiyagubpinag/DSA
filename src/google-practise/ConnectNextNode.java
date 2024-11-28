import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class ConnectNextNode {

    public Node connect(Node root) {
        HashMap<Integer, List<Node>> map = new HashMap<>();
        update(map, root, 0);
        for (Integer level : map.keySet()) {
            Node temp = null;
            for (Node child : map.get(level)) {
                if (temp == null) {
                    temp = child;
                } else {
                    temp.next = child;
                    temp = child;
                }
            }
        }
        System.out.println(map);
        return root;
    }

    public void update(HashMap<Integer, List<Node>> map, Node root, int level) {
        if (root == null) {
            return;
        }
        List<Node> innerNode = map.getOrDefault(level, new ArrayList<>());
        innerNode.add(root);
        map.put(level, innerNode);
        update(map, root.left, level + 1);
        update(map, root.right, level + 1);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        ConnectNextNode connectNextNode = new ConnectNextNode();
        connectNextNode.connect(root);
    }
}
