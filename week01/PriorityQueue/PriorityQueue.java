

package java.util;

import java.util.function.Consumer;


public class PriorityQueue<E> extends AbstractQueue<E>
    implements java.io.Serializable {

    private static final long serialVersionUID = -7720805057305804111L;

    private static final int DEFAULT_INITIAL_CAPACITY = 11;

    /**
     * 优先队列使用数组来存储元素
     * 展现形式为二叉树小顶堆
     * 在父级元素和左右子元素之间存在这以下关系：
     * parentNo = (nodeNo - 1) / 2   nodeNo代表当前节点的索引
     * leftNo = parentNo * 2 + 1    假设parentNo = 0  那么左节点索引就是等于1
     * reightNo = parentNo * 2 +2   右节点索引为2
     */
    transient Object[] queue; // non-private to simplify nested class access

    /**
     * 当前元素个数
     */
    private int size = 0;

    /**
     *
     * 可以自定义实现比较器
     */
    private final Comparator<? super E> comparator;

    /**
     *  修改次数
     */
    transient int modCount = 0; // non-private to simplify nested class access

    /**
     * 添加元素  调用的offer方法
     * @param e
     * @return
     */
    public boolean add(E e) {
        return offer(e);
    }

    /**
     *  入队
     * @param e
     * @return
     */
    public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();
        modCount++;
        int i = size;
        //当前元素个数大于等于数组大小 就扩容
        if (i >= queue.length)
            grow(i + 1);
        //元素个数增加1个
        size = i + 1;
        if (i == 0)
            //如果当前没有一个元素，就把元素放置到数组第一个位置
            queue[0] = e;
        else
            //否则找到相应位置放置
            siftUp(i, e);
        return true;
    }

    /**
     * 扩容
     * @param minCapacity
     */
    private void grow(int minCapacity) {
        //当前数组大小
        int oldCapacity = queue.length;
        //新数组大小
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                (oldCapacity + 2) :
                (oldCapacity >> 1));
        // overflow-conscious code
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        queue = Arrays.copyOf(queue, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    private void siftUp(int k, E x) {
        if (comparator != null)
            siftUpUsingComparator(k, x);
        else
            siftUpComparable(k, x);
    }

    /**
     * 默认排序
     * @param k
     * @param x
     */
    @SuppressWarnings("unchecked")
    private void siftUpComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>) x;
        //一直循环到没有父节点为止
        while (k > 0) {
            //找父节点  (nodeNo-1)/2
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            //如果当前插入数据 比 父节点 大 就直接退出
            if (key.compareTo((E) e) >= 0)
                break;
            queue[k] = e;
            k = parent;
        }
        queue[k] = key;
    }

    public E poll() {
        if (size == 0)
            return null;
        int s = --size;
        modCount++;
        //取出第一个元素
        E result = (E) queue[0];
        //最后一个元素
        E x = (E) queue[s];
        queue[s] = null;
        if (s != 0)
            //把最后一个元素放到第一位 然后重新调整
            siftDown(0, x);
        return result;
    }

    private void siftDown(int k, E x) {
        if (comparator != null)
            siftDownUsingComparator(k, x);
        else
            siftDownComparable(k, x);
    }

    @SuppressWarnings("unchecked")
    private void siftDownComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>)x;
        int half = size >>> 1;        // loop while a non-leaf
        while (k < half) {
            //左节点索引
            int child = (k << 1) + 1; // assume left child is least
            Object c = queue[child];
            //右节点索引
            int right = child + 1;
            //左节点 > 右节点 那么选择右节点 往下遍历
            if (right < size &&
                    ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0)
                c = queue[child = right];
            //如果当前插入数据比 上面选择的节点小了 就直接跳出循环
            if (key.compareTo((E) c) <= 0)
                break;
            queue[k] = c;
            //否则继续往下遍历
            k = child;
        }
        //设置当前位置为key
        queue[k] = key;
    }

    @SuppressWarnings("unchecked")
    private void siftDownUsingComparator(int k, E x) {
        int half = size >>> 1;
        while (k < half) {
            int child = (k << 1) + 1;
            Object c = queue[child];
            int right = child + 1;
            if (right < size &&
                    comparator.compare((E) c, (E) queue[right]) > 0)
                c = queue[child = right];
            if (comparator.compare(x, (E) c) <= 0)
                break;
            queue[k] = c;
            k = child;
        }
        queue[k] = x;
    }


    /**
     * 查看堆顶元素
     * @return
     */
    public E peek() {
        return (size == 0) ? null : (E) queue[0];
    }



}
