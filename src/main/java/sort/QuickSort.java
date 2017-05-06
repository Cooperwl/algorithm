package sort;

import java.util.Arrays;

/**
 * 快速排序
 * Created by Cooper on 2017/5/6.
 * 原理：
 * 相比于冒泡排序，快速排序是比较和交换小数和大数，这样一来不仅把小数冒泡到上面同时也把大数沉到下面。
 *
 * 举个栗子：对5,3,8,6,4这个无序序列进行快速排序，思路是右指针找比基准数小的，左指针找比基准数大的，交换之。
 * 5,3,8,6,4 首先用5作为比较的基准，最终会把比5小的移动到5的左边，比5大的移动到5的右边。
 * 5,3,8,6,4 首先设置i,j两个指针分别指向两端，j指针先扫描，4比5小停止。然后i扫描，8比5大停止。交换i,j位置。
 * 5,3,4,6,8 然后j指针再扫描，这时j扫描4时两指针相遇。停止。然后交换4和基准数。
 * 4,3,5,6,8 一次划分后达到了左边比5小，右边比5大的目的。之后对左右子序列递归排序，最终得到有序序列。
 *
 * 快速排序是不稳定的，其时间平均时间复杂度是O(nlgn)。
 */
public class QuickSort extends BaseSort {

    public void sort() {
        quickSort(array, 0, array.length-1);

        logger.info(Arrays.toString(array));
    }

    /**
     *
     * @param array origin array
     * @param leftIndex 指向左边的指针
     * @param rightIndex 指向右边的指针
     */
    private void quickSort(int[] array, int leftIndex, int rightIndex){
        if (leftIndex > rightIndex) return;

        int tempIndex = partition2(array,leftIndex,rightIndex);

        logger.info("sort again："+leftIndex+" to "+(tempIndex-1));
        quickSort(array, leftIndex, tempIndex-1);
        logger.info("sort again："+(tempIndex+1)+" to "+rightIndex);
        quickSort(array, tempIndex+1, rightIndex);

    }

    private int partition(int[] array, int leftIndex, int rightIndex){
        int temp = array[leftIndex];
        int tempIndex = leftIndex;

        logger.info("save value:{}, index:{}", temp,tempIndex);

        while (leftIndex<rightIndex){
            while (leftIndex<rightIndex && array[rightIndex]>=temp){
                logger.info("rightIndex[{}] value {} > temp value:{}, rightIndex to {}", rightIndex,array[rightIndex], temp,rightIndex-1);
                rightIndex--;
            }

            while (leftIndex<rightIndex && array[leftIndex]<=temp){
                logger.info("leftIndex[{}] value {} < temp value:{}, leftIndex to{}", leftIndex,array[leftIndex], temp,leftIndex+1);
                leftIndex++;
            }
            swap(array,leftIndex,rightIndex);
        }
        swap(array, tempIndex, leftIndex);
        return leftIndex;
    }

    private int partition2(int[] array, int leftIndex, int rightIndex){
        int temp = array[leftIndex];
        while (leftIndex<rightIndex){
            while (leftIndex<rightIndex && array[rightIndex]>=temp){
                logger.info("rightIndex[{}] value {} > temp value:{}, rightIndex to {}", rightIndex,array[rightIndex], temp,rightIndex-1);
                rightIndex--;
            }
            logger.info("set array[{}] = rightIndex:{} value:{}", leftIndex, rightIndex, array[rightIndex]);
            array[leftIndex] = array[rightIndex];//把小的移到左边
            while (leftIndex<rightIndex && array[leftIndex]<=temp){
                logger.info("leftIndex[{}] value {} < temp value:{}, leftIndex to {}", leftIndex,array[leftIndex], temp,leftIndex+1);
                leftIndex++;
            }
            logger.info("set array[{}] = leftIndex:{} value:{}", rightIndex, leftIndex, array[leftIndex]);
            array[rightIndex] = array[leftIndex];//把大的移到右边
        }
        array[leftIndex] = temp;
        return leftIndex;
    }
}
