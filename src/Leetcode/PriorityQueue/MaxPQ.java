package Leetcode.PriorityQueue;

public class MaxPQ {
    private Integer[] pq;
    private int size;

    public MaxPQ(int cap) {
        pq = new Integer[cap + 1];
    }

    int parent(int root) {
        return root / 2;
    }
    // 左孩子的索引
    int left(int root) {
        return root * 2;
    }
    // 右孩子的索引
    int right(int root) {
        return root * 2 + 1;
    }

    /* 返回当前队列中最大元素 */
    public int max() {
        return pq[1];
    }

    /* 插入元素 e */
    public void insert(int e) {
        size++;
        pq[size] = e;
        swim(size);
    }

    /* 删除并返回当前队列中最大元素 */
    public int delMax() {
        int res = pq[1];
        swap(1, size);
        pq[size] = null;
        size--;
        sink(1);
        return res;
    }

    /* 上浮第 x 个元素，以维护最大堆性质 */
    private void swim(int x) {
        while (x > 1 && less(parent(x), x)) {
            swap(parent(x), x);
            x = parent(x);
        }
    }

    /* 下沉第 x 个元素，以维护最大堆性质 */
    private void sink(int x) {
        // 如果沉到堆底，就沉不下去了
        while (left(x) <= size) {
            // 先假设左边节点较大
            int max = left(x);
            // 如果右边节点存在，比一下大小
            if (right(x) <= size && less(max, right(x)))
                max = right(x);
            // 结点 x 比俩孩子都大，就不必下沉了
            if (less(max, x)) break;
            // 否则，不符合最大堆的结构，下沉 x 结点
            swap(x, max);
            x = max;
        }
    }

    /* 交换数组的两个元素 */
    private void swap(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    /* pq[i] 是否比 pq[j] 小？ */
    private boolean less(int i, int j) {
        return pq[i] < pq[j];
    }

}
