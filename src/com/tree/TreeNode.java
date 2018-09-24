package com.tree;

public class TreeNode {
    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }

    public void insert(int value) {
        //RECURSIVE APPROACH
//        if (value == data) {
//            return;
//        }
//
//        if (value < data) {
//            if (leftChild == null){
//                leftChild = new TreeNode(value);
//            } else {
//                leftChild.insert(value);
//            }
//        }
//
//        if (value > data) {
//            if (rightChild == null){
//                rightChild = new TreeNode(value);
//            } else {
//                rightChild.insert(value);
//            }
//        }

        //ITERATIVE APPROACH
        TreeNode curNode = this;
        int curData = data;

        while(curNode != null) {
            if (value == curData){
                return;
            }

            if (value < curData) {
                if (curNode.getLeftChild() == null){
                    curNode.setLeftChild(new TreeNode(value));
                } else {
                    curNode = curNode.getLeftChild();
                    if (curNode != null){
                        curData = curNode.getData();
                    }
                }
            }

            if (value > curData) {
                if (curNode.getRightChild() == null){
                    curNode.setRightChild(new TreeNode(value));
                } else {
                    curNode = curNode.getRightChild();
                    if (curNode != null){
                        curData = curNode.getData();
                    }
                }
            }
        }
    }

    public TreeNode get(int value) {
        if (data == value) {
            return this;
        }

        if (value < data) {
            if (leftChild != null) {
                return leftChild.get(value);
            }
        } else {
            if (rightChild != null) {
                return rightChild.get(value);
            }
        }

        return null;
    }

    public int min() {
        if (leftChild != null) {
            return leftChild.min();
        } else {
            return data;
        }
    }

    public int max() {
        if (rightChild != null) {
            return rightChild.max();
        } else {
            return data;
        }
    }

    public void traverseInOrder() {
        if (leftChild != null) {
            leftChild.traverseInOrder();
        }

        System.out.println(data);

        if (rightChild != null) {
            rightChild.traverseInOrder();
        }
    }

    public void traversePreOrder() {
        System.out.println(data);

        if (leftChild != null) {
            leftChild.traversePreOrder();
        }

        if (rightChild != null) {
            rightChild.traversePreOrder();
        }
    }

    public void traversePostOrder() {
        if (leftChild != null) {
            leftChild.traversePostOrder();
        }

        if (rightChild != null) {
            rightChild.traversePostOrder();
        }

        System.out.println(data);
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
