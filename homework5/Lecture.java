import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Queue;

public class Lecture {
    public static void main(String[] args) {
        // Read from the text file using Scanner
        String[][] text = new String[0][];
        try {
            //Reading file by using Scanner
            Scanner scanner = new Scanner(new File("tree.txt"));
            int row = 0;
            while (scanner.hasNextLine()) {
                String temp = scanner.nextLine();
                if (temp.isEmpty()) {
                    continue; // Skip empty lines
                }
                // Split the line by semicolon and store the columns in the array
                String[] column = temp.split(";");
                if (text.length == row) {
                    text = resize(text, row + 1);
                }
                // Store the information in the array at the row index
                text[row] = column;
                row++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: "+ e.getMessage());
            System.exit(1);
        }

        // Create the tree structure using DefaultMutableTreeNode
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        for (String[] row : text) {
            DefaultMutableTreeNode currentNode = root;
            for (int i = 0; i < row.length; i++) {
                // Get the value of the current column
                String value = row[i];
                // Find the child node of the current node
                DefaultMutableTreeNode childNode = findChild(currentNode, value);
                // If the child node is null, create a new node and add it to the current node
                if (childNode == null) {
                    childNode = new DefaultMutableTreeNode(value);
                    currentNode.add(childNode);
                }
                // Set the current node to the child node
                currentNode = childNode;
            }
        }

        // Create and display the JFrame with the JTree
        JFrame frame = new JFrame("Tree Structure");
        JTree tree = new JTree(root);
        frame.add(tree);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boolean visibility = true;
        frame.setVisible(visibility);


        System.out.println("Breadth-first search: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a string to search in the tree: ");
        String search = scanner.nextLine();
        BFSSearch(root, search);


        System.out.println("\n\nDepth-first search: ");
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter a string to search in the tree: ");
        String dfs = s.nextLine();
        DFSSearch(root, dfs);


        System.out.println("\n\nPost-order traversal: ");
        Scanner p = new Scanner(System.in);
        System.out.println("Please enter a string to search in the tree: ");
        String pot = p.nextLine();
        postOrderTraversal(root, pot);
        
        scanner.close();
        s.close();
        p.close();

    }
    /**
     * Resize the array
     * @param array
     * @param size
     * @return new array that has been resized
     */
    private static String[][] resize(String[][] array, int size) {
        String[][] newArray = new String[size][];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }
    /**
     * Finds the child node of the parent node
     * @param node
     * @param value
     * @return child node
     */
    private static DefaultMutableTreeNode findChild(DefaultMutableTreeNode node, String value) {
        for (int i = 0; i < node.getChildCount(); i++) {
            DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) node.getChildAt(i);
            if (childNode.getUserObject().equals(value)) {
                return childNode;
            }
        }
        return null;
    }

    /**
     * BFS search method using queue to store the nodes in the tree and poll the nodes out of the queue to search for the string in the tree and print the steps.
     * @param root
     * @param search
     */
    private static void BFSSearch(DefaultMutableTreeNode root, String search) {
        Queue<DefaultMutableTreeNode> queue = new LinkedList<>();
        queue.add(root);
        int step = 1;
        System.out.println("Using BFS to find " + search + " in the tree");
        while (!queue.isEmpty()) {
            DefaultMutableTreeNode node = queue.poll();
            System.out.print("Step " + step + " -> " + node);
            if (node.getUserObject().equals(search)) {
                System.out.println("(Found!)");
                return;
            }
            for (int i = 0; i < node.getChildCount(); i++) {
                queue.add((DefaultMutableTreeNode) node.getChildAt(i));
            }
            System.out.print("\n");
            step++;
        }
        System.out.println("Not found.");
    }

    /**
     * DFS search method using stack to store the nodes in the tree and pop the nodes out of the stack to search for the string in the tree and print the steps.
     * @param root
     * @param search
     */
    private static void DFSSearch(DefaultMutableTreeNode root, String search) {
        Stack<DefaultMutableTreeNode> stack = new Stack<>();
        stack.add(root);
        int step = 1;
        System.out.println("Using DFS to find " + search + " in the tree");
        while (!stack.isEmpty()) {
            DefaultMutableTreeNode node = stack.pop();
            System.out.print("Step " + step + " -> " + node);
            if (node.getUserObject().equals(search)) {
                System.out.println("(Found!)");
                return;
            }
            for (int i = 0; i < node.getChildCount(); i++) {
                stack.add((DefaultMutableTreeNode) node.getChildAt(i));
            }
            System.out.print("\n");
            step++;
        }
        System.out.println("Not found.");
    }
    /**
     * Post-order traversal search method tries to find the search string in the tree by traversing the tree in post-order (left, right, root) and printing the steps.
     * @param node
     * @param search
     */
    private static void postOrderTraversal(DefaultMutableTreeNode node, String search) {
        //Used enumeration to traverse the tree in post-order in DefaultMutableTreeNode class
        Enumeration<TreeNode> en = node.postorderEnumeration();
        int step = 1;
        System.out.println("Using post-order traversal to find " + search + " in the tree");
        while (en.hasMoreElements()) {
            DefaultMutableTreeNode n = (DefaultMutableTreeNode) en.nextElement();
            System.out.print("Step " + step + " -> " + n.getUserObject().toString());
            if (n.getUserObject().equals(search)) {
                System.out.println("(Found!)");
                return;
            }
            System.out.print("\n");
            step++;
        }
        System.out.println("Not found.");
    }
}
