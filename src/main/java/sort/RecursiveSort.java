package sort;

import java.util.Arrays;

/**
 * 归并排序算法的实现
 * Created by Cooper on 2017/5/6.
 *
 * 归并排序使用了递归分治的思想，所以理解起来比较容易。
 * 其基本思想是，先递归划分子问题，然后合并结果。
 * 把待排序列看成由两个有序的子序列，然后合并两个子序列，然后把子序列看成由两个有序序列。。。。。
 * 倒着来看，其实就是先两两合并，然后四四合并。。。最终形成有序序列。
 *
 * 空间复杂度为O(n)，时间复杂度为O(nlogn)。
 */
public class RecursiveSort extends BaseSort {

    public void sort() {
        recursive(array,0, array.length-1);
    }

    /**
     * 递归分治
     * @param array  待排数组
     * @param leftIndex 左指针
     * @param rightIndex 右指针
     */
    private void recursive(int[] array, int leftIndex, int rightIndex){

        if (leftIndex >= rightIndex) return;
        logger.info("recursive compare left index:{} and right index:{}", leftIndex, rightIndex);

        int mid = (leftIndex + rightIndex) / 2;
        logger.info("start recursive left index:{}. mid is {}",leftIndex,mid);
        recursive(array,leftIndex,mid);//递归排序左边
        logger.info("start recursive right index:{}. mid is {}",rightIndex,mid);
        recursive(array,mid+1,rightIndex);//递归排序右边
        merge(array,leftIndex, mid, rightIndex);
    }

    /**
     * 合并
     * @param array  待排数组
     * @param leftIndex 左指针
     * @param mid 中间指针
     * @param rightIndex 右指针
     */
    private void merge(int[] array, int leftIndex, int mid, int rightIndex) {

        logger.info("merge from left index:{} to right index:{}, middle:{}, origin array:{}",leftIndex, rightIndex,mid, Arrays.toString(array));
        //[left, mid] [mid+1, right]
        int[] temp = new int[rightIndex - leftIndex + 1]; //中间数组
        int i = leftIndex;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= rightIndex) {
            logger.info("compare {} and {}", array[i], array[j]);
            if(array[i] <= array[j]) {
                logger.info("set temp[{}] = {}", k, array[i]);
                temp[k++] = array[i++];
            }else {
                logger.info("set temp[{}] = {}", k, array[j]);
                temp[k++] = array[j++];
            }
        }
        while(i <= mid) {
            temp[k++] = array[i++];
        }
        while(j <= rightIndex) {
            temp[k++] = array[j++];
        }
        logger.info("temp Array after first circle to :"+Arrays.toString(temp));
        for(int p=0; p<temp.length; p++) {
            array[leftIndex + p] = temp[p];
        }

        logger.info("orgin array after merge to :{}",Arrays.toString(array));
    }
}
