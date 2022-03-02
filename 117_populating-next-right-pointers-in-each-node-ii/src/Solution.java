package com.winner;

import java.util.LinkedList;

public class ConnectLevel {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            Node pre = null;
            for (int i = 0; i < len; i++){
                Node node = queue.pollFirst();
                if(i == 0) {
                    pre = node;
                }else {
                    pre.next = node;
                    pre = pre.next;
                }
                if(node.left != null){
                    queue.addLast(node.left);
                }

                if(node.right != null){
                    queue.addLast(node.right);
                }
            }
            pre.next = null;
        }
        return root;
    }


}
