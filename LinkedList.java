package com.quiz.proj;

public class LinkedList {
	static Node head;
	class Node {
		int value;
		Node next;
		Node(int val) {
			value = val;
			next = null;
		}
	}
	// return the head of the linked list after operation
	// there are three different append conditions
	public Node appendHead(Node head, int element) {
		// append an element to the head of a linked list
		Node newHead = new Node(element);
		newHead.next = head;
		head = newHead;
		return head;
	}
	public Node appendAfter(Node head, int element) {
		// append an element in the middle of a linked list
		// for example append after head
		if (head != null) {
		// head should not be null
			Node newNode = new Node(element);
			newNode.next = head.next;
			head.next = newNode;
		}
		return head;
	}
	public Node appendEnd(Node head, int element) {
		// append an element to the tail of the linked list
		Node newNode = new Node(element);
		if (head == null) {
			head = newNode;
			newNode.next = null;
		} else {
			Node pointer = head;
			while (pointer.next != null) {
				pointer = pointer.next;
			}
			pointer.next = newNode;
			newNode.next = null;
		}
		return head;		
	}
	// remove tail
	public Node removeTail(Node head) {
		if (head == null) {
			return head;
		} else {
			Node pointer = head;
			while (pointer.next.next != null) {
				pointer = pointer.next;
			}
			pointer.next = null;
			return head;
		}
	}
	// remove all elements greater than target
	public Node removeGreaterThanTarget(Node head, int target) {
		if (head == null) {
			return head;
		} else {
			Node dummy = new Node(0);
			dummy.next = head;
			Node prev = dummy;
			Node curr = head;
	        while (curr != null) {
	            if (curr.value > target) {
	                prev.next = curr.next;
	            } else {
	                prev = prev.next;
	            }
	            curr = curr.next;
	        }
	        return dummy.next;
		}
	}
	
	public static void main(String[] args) {
		// Test
		LinkedList llist = new LinkedList();
		Node node = head;
		
		node = llist.appendHead(node,6);
		node = llist.appendAfter(node,7);
		node = llist.appendEnd(node,4);
		node = llist.appendEnd(node,9);
		node = llist.appendEnd(node,10);
		node = llist.appendEnd(node,12);
		head = node;
		
        System.out.println("Created Linked list is: ");
        while (node != null)
        {
            System.out.print(node.value + "->");
            node = node.next;
        }
        System.out.println("\nCreated Linked list is: ");
		node=llist.removeTail(head);
        while (node != null)
        {
            System.out.print(node.value + "->");
            node = node.next;
        }
        System.out.println("\nCreated Linked list is: ");
		node=llist.removeGreaterThanTarget(head, 7);
        while (node != null)
        {
            System.out.print(node.value + "->");
            node = node.next;
        }
	}
}
