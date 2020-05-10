package com.tongle.sheldon.task.sort;

/**
 * 求前面的最大K个 解决方案：小根堆 (数据量比较大（特别是大到内存不可以容纳）时，偏向于采用堆)
 * @author 张恩备
 * @date 2016-11-25 下午12:15:36
 */
public class HeapTest {
    /**
     * 待排序列（R1，R2，...，Rk,...Rn）看作是完全二叉树，通过比较、交换，父节点和孩子节点的值，
     * 使得对于任意元素Rk（k<=n/2）,满足Rk>=R(2k),Rk>=R(2k+1)
     * @param arr    数组对象
     * @param start    数组的开始下标
     * @param end    数组的结束下标
     */
    private static void HeapAdjust(int[] arr, int start, int end) {
        //当下标为start的元素有孩子元素时
        while(start <= end/2) {
            //left和right分别为左右孩子元素的下标,max为左右孩子中值较小的孩子的元素下标
            int left = 2 * start+1;
            int right = 2 * start+2;
            int min = 0;

            //如果既有左孩子，又有右孩子
            if(left < end && right <= end) {
                //如果左孩子小于右孩子的值，max = right，否则为max = left
                if(arr[left] <= arr[right]) {
                    min = left;
                }
                else{
                    min = right;
                }
            }
            //如果只有左孩子，没有右孩子，max值为left
            if(left <= end && right > end) {
                min = left;
            }
            //如果没有孩子，则表明到了完全二叉树的叶子节点
            if(left > end) {
                break;
            }

            //如果当前节点值小于两孩子中的值较大者，那么将当前节点值与max交换
            if(arr[start] > arr[min]){
                int tmp = arr[start];
                arr[start] = arr[min];
                arr[min] = tmp;
            }
            //当前节点向孩子节点迭代
            start = min;
        }
    }

    /**
     * 创建k个节点的小根堆
     *
     * @param a
     * @param k
     * @return
     */
    static int[] createHeap(int a[], int k) {
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = a[i];
        }
        //由最后一个非叶子节点，向根节点迭代，创建最大堆，数组中的最大值将被移动到根节点
        for(int start = k-1/2;start >= 0;start--) {
            HeapAdjust(result, start, k-1);
        }
        return result;

    }

    static void insert(int a[], int value, int k) {
        //当输入元素的值value大于堆的根元素值时，则将堆的根元素的值赋值为输入元素的值value
        a[0]=value;
        //将改变后的堆重新k个节点的生成小根堆
        for(int start = k-1/2;start >= 0;start--) {
            HeapAdjust(a, start, k-1);
        }
    }

    static int[] getTopKByHeap(int input[], int k) {
        int heap[] = createHeap(input, k);
        for(int i=k;i<input.length;i++){
            //当input[i]值大于堆的根元素值时，将input[i]插入到堆中
            if(input[i]>heap[0]){
                insert(heap, input[i], k);
            }
        }

        //将小根堆降序排列
        while(k-1 > 0){
            //交换arr[0]和arr[k-1]的值
            int tmp = heap[0];
            heap[0] = heap[k-1];
            heap[k-1] = tmp;

            //待排序堆的范围变为依次减小，最后剩下一个元素时结束
            //执行完这一步，根元素的值变为整个待序列中的最小值
            HeapAdjust(heap, 0, k-2);

            k--;
        }
        return heap;
    }

    public static void main(String[] args) {
        int a[] = {40,55,49,73,12,27,98,81,64,36,78};
        //获取top3
        int result[] = getTopKByHeap(a, 5);
        for (int temp : result) {
            System.out.print(temp + " ");
        }
    }
}
