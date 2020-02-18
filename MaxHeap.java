package MaxHeap;

import java.lang.Math;
import java.util.Arrays;

public class MaxHeap {
    private int[] arr;
    protected int length;

    public MaxHeap() {
        this.arr = new int[Integer.MAX_VALUE / 4 - 1];
        length = 0;
    }

    public boolean add(int item) {
        arr[length] = item;
        ++length;
        return insert_swap(length-1);
    }

    public void delete_root() {
        // Based on the property of heap, we can only delete the root
        // First, we need to swap the root node with the last child in the bottom level
        arr[0] = arr[length-1];
        arr[length-1] = 0;
        length--;
        //Adjust the tree to match the property
        delete_adjust(0, arr);
    }

    public void print_heap() {
        // Print the heap in an array
        for(int j = 0; j < length; ++j) {
            System.out.print(arr[j] + "\t");
        }

        System.out.println();

        // Print the heap in a tree form
        int level = 0;
        int sum = 0;
        for(int i = 0; i < length; ++i) {
            if (i > sum) {
                System.out.println();
                level++;
                sum += (int)Math.pow(2, level);
            }
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    private int parent(int n) {
        return (int)Math.floor((n-1)/2);
    }

    private int left_child(int n) {
        return 2 * n + 1;
    }

    private int right_child(int n) {
        return 2 * n  + 2;
    }

    private boolean insert_swap(int n) {
        int pNode = parent(n);

        if (arr[pNode] >= arr[n]) {
            return true;
        }

        int temp = arr[pNode];
        arr[pNode] = arr[n];
        arr[n] = temp;

        return insert_swap(pNode);
    }

    private void delete_adjust(int n, int[] arr) {
        int left = left_child(n) < length ? left_child(n) : -1;
        int right = right_child(n) < length ? right_child(n) : -1;

        int pNode = arr[n];
        int leftNode = left != -1 ? arr[left] : Integer.MIN_VALUE;
        int rightNode = right != -1 ? arr[right] : Integer.MIN_VALUE;

        if (pNode >= leftNode && pNode >= rightNode)
            return;

        int max = Math.max(pNode, Math.max(leftNode, rightNode));

        if (leftNode == max) {
            arr[n] = leftNode;
            arr[left] = pNode;
            delete_adjust(left, arr);
        }

        if (rightNode == max) {
            arr[n] = rightNode;
            arr[right] = pNode;
            delete_adjust(right, arr);
        }

    }
}
