package com.andersen.collections;

import java.util.Objects;

public class LinkedList<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;


    private static class Node<E> {
        E item;
        Node<E> previous;
        Node<E> next;

        public Node(E item, Node<E> previous, Node<E> next) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }

        @Override
        public String toString() {
            return "item=" + item;
        }
    }

    public E get(int index) {
        if (index >= 0 && index < size) {
            Node<E> node;
            if (index < (size >> 1)) {
                node = first;
                for (int i = 1; i < index; i++) {
                    node = node.next;
                }
            } else {
                node = last;
                for (int i = size - 1; i > index; i--) {
                    node = node.previous;
                }
            }
            return node.item;
        }
        throw new IndexOutOfBoundsException();
    }

    public int size() {
        return size;
    }

    public void add(E element) {
        Node<E> node = new Node<>(element, last, null);
        Node<E> lastLink = last;
        last = node;
        if (lastLink != null) {
            lastLink.next = node;
        } else {
            first = node;
        }
        size++;
    }

    public boolean remove(E element) {
        Node<E> prevNode;
        Node<E> nextNode;
        if (Objects.nonNull(element) && size != 0) {
            if (first.item.equals(element)) {
                first = first.next;
                first.previous = null;
                size--;
                return true;
            }
            for (Node<E> node = first; node != null; node = node.next) {
                if (node.item.equals(element)) {
                    if (Objects.isNull(node.next)) {
                        last = node.previous;
                    } else {
                        prevNode = node.previous;
                        nextNode = node.next;
                        prevNode.next = nextNode;
                        nextNode.previous = prevNode;
                    }
                    size--;
                    return true;
                }
            }
            return false;
        }
        throw new NullPointerException();
    }

    public E set(int index, E element) {
        if (Objects.isNull(first)) {
            throw new NullPointerException();
        }
        if (index > 0 && index < size) {
            Node<E> node = first;
            int i = 0;
            for (; node.next != null; node = node.next) {
                if (i == index) {
                    break;
                }
                i++;
            }
            E oldValue = node.item;
            node.item = element;
            return oldValue;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "size=" + size +
                ", first=" + first +
                ", last=" + last +
                '}';
    }
}
