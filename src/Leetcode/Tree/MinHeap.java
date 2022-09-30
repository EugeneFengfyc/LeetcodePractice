package Leetcode.Tree;

public class MinHeap {
    int[] minHeap;
    int heapsize = 0;
    int realSize = 0;

    public MinHeap(int heapsize) {
        this.heapsize = heapsize;
        minHeap = new int[heapsize + 1];
        minHeap[0] = 0;
    }

    public void peek() {
        int peek = minHeap[1];
        System.out.println(peek);
    }

    public int size() {
        return realSize;
    }

    public String toString() {
        if (realSize == 0) {
            return "No element";
        }
        else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (int i = 1; i <= realSize; i++) {
                sb.append(minHeap[i]);
                sb.append(',');
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(']');
            return sb.toString();
        }
    }

    public void add(int element) {
        realSize++;
        if (realSize > heapsize) {
            System.out.println("Added too many elements");
            realSize--;
            return;
        }
        minHeap[realSize] = element;
        int index = realSize;
        int parent = index / 2;
        while (minHeap[index] < minHeap[parent] && index > 1) {
            int temp = minHeap[index];
            minHeap[index] = minHeap[parent];
            minHeap[parent] = temp;
            index = parent;
            parent = index / 2;
        }
    }

    //Delete the top element in the minHeap
    public int pop() {
        if (realSize < 0) {
            System.out.println("Don't have enough elements");
            return Integer.MAX_VALUE;
        }
        else {
            int removeElement = minHeap[1];
            minHeap[1] = minHeap[realSize];
            realSize--;
            int index = 1;
            while (index <= realSize / 2) {
                int left = index * 2;
                int right = (index * 2) + 1;
                if (minHeap[index] > left || minHeap[index] > right) {
                    if (minHeap[right] > minHeap[left]) {
                        int temp = minHeap[index];
                        minHeap[index] = minHeap[left];
                        minHeap[left] = temp;
                        index = left;
                    }
                    else {
                        int temp = minHeap[index];
                        minHeap[index] = minHeap[right];
                        minHeap[right] = temp;
                        index = right;
                    }
                }
                else {
                    break;
                }

            }
            return removeElement;
        }

    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(3);
        minHeap.add(3);
        minHeap.add(6);
        minHeap.add(2);
        System.out.println(minHeap.toString());
        minHeap.pop();
        System.out.println(minHeap.toString());
        minHeap.pop();
        System.out.println(minHeap.toString());
    }
}
