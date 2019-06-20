package comA;

import com.trees.BuildTree;
import com.trees.Node;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class TreeProgs {

    public static void main(String[] args) {

        Node root = null;
        final Integer intArray[] = { 6, 3, 1, 2, 4, 5, 9, 7 ,8, 10 };
        root = BuildTree.build123Recur(root, intArray);
        printNode(root);

        System.out.println("\n*********printPerimeter Right***********");
        printPerimeter(root);
        System.out.println("\n********printPerimeter Wrong************");
        printPerimeter2(root);         //WRONG

        System.out.println("\n********checkCousins - parents different and same level************");
        System.out.println(areCousins(root, 2, 7));
        System.out.println(areCousins(root, 1, 10));

        System.out
                .println("\n******Print a Binary Tree in Vertical Order - In this i cant maintain top down or bottom up order**");
        HashMap<Integer, ArrayList> map = printNodesVertically(root,0, new HashMap<Integer,ArrayList>());
        System.out.println(map);

        System.out
                .println("\n******Print a Binary Tree in Vertical Order - Level order to maintain top down or bottom up order**");
        TreeMap<Integer, ArrayList> map2 = printNodesVerticallyLOT(root,0, new TreeMap<Integer,ArrayList>());
        System.out.println(map2);

        System.out
                .println("\n******Print a left right view, same for top bottm just vertical order**");
        TreeMap<Integer,Integer> lMap = new TreeMap<>();
        TreeMap<Integer,Integer> rMap = new TreeMap<>();
        printTreeLfetRightViews(root,0, lMap,rMap);
        System.out.println(lMap);
        System.out.println(rMap);

        System.out
                .println("\n****LCA of 2 nodes can be done via stack and no stack****");
        System.out.println("LCA Of 2,7 "+getLCAof2Nodes(root,2,7).data);
        System.out.println("LCA Of 3,2 "+getLCAof2Nodes(root,2,3).data);
        System.out.println("LCA Of 3,3 "+getLCAof2Nodes(root,3,3).data);


        System.out.println("*******Print all root to leaf paths*********");
        printAllRootToLeafPaths(root,0,new Integer[100]);


        System.out.println("*******BST *********");
        System.out.println(validateBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE));

        System.out.println(lcaOfBST(root,2,7));
    }

    private static int lcaOfBST(Node root, int i, int j) {


       return 1;
    }


    private static boolean validateBST(Node root, int min, int max) {
        if(root == null){
            return true;
        }
        if(root.getIntVal()<= min || root.getIntVal() >= max){
            return false;
        }
       return validateBST(root.left,min,root.getIntVal()) && validateBST(root.right,root.getIntVal(),max);
    }

    private static void printAllRootToLeafPaths(Node root, int i, Integer[] ints) {
        ints[i] = (Integer) root.data;
        if(root.left==null && root.right==null){
            for(int j=0;j<=i;j++){
                System.out.print(ints[j]+",");
            }
            System.out.println();
            return;
        }
        if(root.left!=null){
            printAllRootToLeafPaths(root.left,i+1,ints);
        }
        if(root.right!=null){
            printAllRootToLeafPaths(root.right,i+1,ints);
        }
    }

    private static Node getLCAof2Nodes(Node root, int i, int j) {
        if(root==null){
            return null;
        }
        if(root.data.compareTo(i)==0 || root.data.compareTo(j)==0){
            return root;
        }
        Node left  = getLCAof2Nodes(root.left,i,j);
        Node right  = getLCAof2Nodes(root.right,i,j);
        if(left!=null && right!=null){
            return root;
        }
        if(left != null){
            return left;
        }
        return right;
    }

    private static void printTreeLfetRightViews(Node root, int i, TreeMap<Integer, Integer> lMap, TreeMap<Integer, Integer> rMap) {
        Queue<Node> queue = new LinkedBlockingQueue<>();
        Queue<Integer> metaQueue = new LinkedBlockingQueue<>();
        queue.add(root);
        metaQueue.add(0);

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            Integer meta = metaQueue.poll();

            if(!lMap.containsKey(meta)){
                lMap.put(meta,(Integer) node.data);
            }
            rMap.put(meta,(Integer) node.data);
            if(node.left!=null){
                queue.add(node.left);
                metaQueue.add(meta+1);
            }
            if(node.right!=null){
                queue.add(node.right);
                metaQueue.add(meta+1);
            }
        }
    }

    private static TreeMap<Integer, ArrayList> printNodesVerticallyLOT(Node root, int i, TreeMap<Integer, ArrayList> map) {
        Queue<Node> queue = new LinkedBlockingQueue<>();
        Queue<Integer> metaQueue = new LinkedBlockingQueue<>();
        queue.add(root);
        metaQueue.add(0);

        while(!queue.isEmpty()){
            Node node = queue.poll();
            Integer meta = metaQueue.poll();

            ArrayList list = map.getOrDefault(meta, new ArrayList<>());
            list.add(node.data);
            map.put(meta,list);

            if(node.left!=null){
                queue.add(node.left);
                metaQueue.add(meta-1);
            }
            if(node.right!=null){
                queue.add(node.right);
                metaQueue.add(meta+1);
            }
        }
        return map;
    }

    private static HashMap printNodesVertically(Node root,int i, HashMap<Integer, ArrayList> map) {
        if(root == null){
            return null;
        }
        ArrayList list = map.getOrDefault(i, new ArrayList<>());
        list.add(root.data);
        map.put(i,list);
        printNodesVertically(root.left,i-1,map);
        printNodesVertically(root.right,i+1,map);

        return map;
    }

    private static boolean areCousins(Node root, int i, int j) {
        Node parent1 = getParent(root,i);
        Node parent2 = getParent(root,j);
        if(parent1.data.compareTo(parent2.data) == 0){
            return false;
        }
        else{
            int h1 = getHeightOfNode(root,i);
            int h2 = getHeightOfNode(root,j);
            if(h1 == h2){
                return true;
            }
            return false;
        }
    }

    private static int getHeightOfNode(Node root, int i) {
        if(root == null){
            return -1;
        }
        if(root.data.compareTo(i)==0){
            return 1;
        }
        int h1 = 1+getHeightOfNode(root.left,i);
        int h2 = 1+getHeightOfNode(root.right,i);
        if(h1 == 0){
            return h2;
        }
        return h1;
    }


    private static Node getParent(Node root, int j) {
        if(root == null){
            return null;
        }
        if((root.left!=null && root.left.data.compareTo(j)==0 )|| (root.right!=null && root.right.data.compareTo(j)==0 )){
            return root;
        }
        Node df = getParent(root.left,j);
        if(df == null){
            df = getParent(root.right,j);
        }
        return df;
    }

    private static void printPerimeter(Node root) {
        printLeft(root);
        printLeafNodes(root);
        printRight(root);
    }

    static void printPerimeter2(final Node root) {
        System.out.print(root.data + ",");
        printPreorder(root.left);
        printPostorder(root.right);
        System.out.print(root.data + "...");
    }

    private static void printLeafNodes(Node root) {
        if(root==null){
            return;
        }
        if(root.left!=null){
            printLeafNodes(root.left);
        }
        if(root.left==null && root.right==null){
            System.out.print(root.data);
        }
        if(root.right!=null){
            printLeafNodes(root.right);
        }
    }

    private static void printRight(Node root) {
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            return;
        }
        if(root.right!=null){
            printRight(root.right);
        }
        else{
            printRight(root.left);
        }
        System.out.print(root.data);
    }

    private static void printLeft(Node root) {
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            return;
        }
        System.out.print(root.data);
        if(root.left!=null){
            printLeft(root.left);
        }
        else{
            printLeft(root.right);
        }
    }


    private static void printPreorder(final Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + ",");
        printPreorder(root.left);

        if (root != null) {
            temp(root.right);
        }
    }

    private static void printPostorder(final Node root) {

        if (root != null) {
            temp(root.left);
        }

        if (root == null) {
            return;
        }
        printPostorder(root.right);
        System.out.print(root.data + ",");
    }

    private static void temp(final Node root) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            System.out.print(root.data + ",");
        }

        temp(root.left);
        temp(root.right);
    }


    public static <T extends Comparable<?>> void printNode(Node root) {
        int maxLevel = maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<Node>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Node node) {
        if (node == null)
            return 0;

        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}