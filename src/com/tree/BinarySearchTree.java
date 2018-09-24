package com.tree;

public class BinarySearchTree {
    private TreeNode root;
    private int min;
    private int max;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
            min = value;
            max = value;
        } else {
            root.insert(value);

            //Set min and max here for constant time lookup
            if (value < min) {
                min = value;
            } else if (value > max) {
                max = value;
            }
        }
    }

    public TreeNode get(int value) {
        if (root != null) {
            return root.get(value);
        }

        return null;
    }

    //MY ITERATIVE APPROACH
    public void delete(int value) {
        if (root == null) {
            return;
        }

        TreeNode parentNode = findParentNode(value);

        //TargetNode will always exist if there is a parent node
        //isRoot will check the case if the root is the target node (Then there's no parent child assignment, just new root assignment)
        //isLeftChild will help reduce logic
        if (parentNode != null) {
            TreeNode targetNode = null;
            boolean isRoot = false;
            boolean isLeftChild = false;

            if (parentNode.getLeftChild() != null && value == parentNode.getLeftChild().getData()) {
                isLeftChild = true;
                targetNode = parentNode.getLeftChild();
            } else if (parentNode.getRightChild() != null && value == parentNode.getRightChild().getData()) {
                targetNode = parentNode.getRightChild();
            } else if (parentNode.getData() == root.getData()){
                isRoot = true;
                targetNode = root;
            }

            //CASE 3
            if (targetNode.getLeftChild() != null && targetNode.getRightChild() != null) {
                deleteCase3(parentNode, targetNode, isRoot, isLeftChild);
            }
            //CASE 1
            else if (targetNode.getLeftChild() == null && targetNode.getRightChild() == null) {
                deleteCase1(parentNode, targetNode, isRoot, isLeftChild);
            }
            //CASE 2
            else {
                deleteCase2(parentNode, targetNode, isRoot, isLeftChild);
            }

        }
    }

    private void deleteCase1(TreeNode parentNode, TreeNode targetNode, boolean isRoot, boolean isLeftChild) {
        if (isRoot) {
            root = null;
            return;
        }

        if (isLeftChild) {
            parentNode.setLeftChild(null);
        } else {
            parentNode.setRightChild(null);
        }
    }

    private void deleteCase2(TreeNode parentNode, TreeNode targetNode, boolean isRoot, boolean isLeftChild) {
        TreeNode replacedNode = null;

        if (targetNode.getLeftChild() != null) {
            replacedNode = targetNode.getLeftChild();
        } else {
            replacedNode = targetNode.getRightChild();
        }

        if (isRoot) {
            root = replacedNode;
        } else {
            if (isLeftChild) {
                parentNode.setLeftChild(replacedNode);
            } else {
                parentNode.setRightChild(replacedNode);
            }
        }
    }

    private void deleteCase3(TreeNode parentNode, TreeNode targetNode, boolean isRoot, boolean isLeftChild) {
        TreeNode replacedNode = targetNode.getRightChild();

        while (replacedNode.getLeftChild() != null){
            if (replacedNode.getLeftChild().getLeftChild() == null) {
                TreeNode tempParent = replacedNode;
                replacedNode = replacedNode.getLeftChild();
                replacedNode.setRightChild(targetNode.getRightChild());
                tempParent.setLeftChild(null);
                break;
            }
            replacedNode = replacedNode.getLeftChild();
        }

        replacedNode.setLeftChild(targetNode.getLeftChild());


        if (isRoot) {
            root = replacedNode;
            return;
        }

        if (isLeftChild) {
            parentNode.setLeftChild(replacedNode);
        } else {
            parentNode.setRightChild(replacedNode);
        }
    }

    private TreeNode findParentNode(int value) {
        if (value == root.getData()){
            return root;
        }

        TreeNode curNode = root;

        while (curNode != null) {
            if ((curNode.getLeftChild() != null && curNode.getLeftChild().getData() == value) || (curNode.getRightChild() != null && curNode.getRightChild().getData() == value)){
                return curNode;
            }

            if (curNode.getData() > value){
                curNode = curNode.getLeftChild();
            } else if (curNode.getData() < value) {
                curNode = curNode.getRightChild();
            }
        }

        return curNode;
    }

//    //UDEMY RECURSIVE APPRAOCH (LESS CODE, MORE CONFUSING)
//    public void delete(int value) {
//        root = delete(root, value);
//    }
//
//    private TreeNode delete(TreeNode subtreeRoot, int value) {
//        if (subtreeRoot == null) {
//            return subtreeRoot;
//        }
//
//        if (value < subtreeRoot.getData()){
//            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
//        } else if (value > subtreeRoot.getData()){
//            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
//        } else {
//            //CASE 0 & 1: Node has 0 or 1 children
//            if (subtreeRoot.getLeftChild() == null) {
//                return subtreeRoot.getRightChild();
//            } else if (subtreeRoot.getRightChild() == null) {
//                return subtreeRoot.getLeftChild();
//            }
//
//            //CASE 3: node to delete has 2 children
//            subtreeRoot.setData(subtreeRoot.getRightChild().min());
//            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));
//        }
//
//        return subtreeRoot;
//    }

    public int min() {
        if (root != null) {
            return root.min();
        }

        return -1;
    }

    public int max() {
        if (root != null) {
            return root.max();
        }

        return -1;
    }


    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }

    public void traversePreOrder() {
        if (root != null) {
            root.traversePreOrder();
        }
    }

    public void traversePostOrder() {
        if (root != null) {
            root.traversePostOrder();
        }
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
