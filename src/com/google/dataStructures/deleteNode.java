package com.google.dataStructures;

public class deleteNode {
    public static boolean deleteNode(LinkedListNode node) {
        if (node == null || node.next == null) {
            return false;
        }

        LinkedListNode nextNode = node.next;
        node.data = nextNode.data;
        node.next = nextNode.next;
        return true;
    }

    private static class LinkedListNode {
        public String data;
        public LinkedListNode next;
    }
}
