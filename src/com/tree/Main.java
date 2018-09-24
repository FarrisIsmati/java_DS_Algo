package com.tree;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree intTree = new BinarySearchTree();
        intTree.insert(27);
        intTree.insert(26);
        intTree.insert(30);



        intTree.delete(27);
        intTree.traverseInOrder();
    }
}
