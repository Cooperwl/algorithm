package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 选择排序算法
 * Created by Cooper on 2017/5/6.
 *
 * 选择排序算法原理：
 * 每一次从待排序的序列中找出最小的元素，放在序列起始位置，直到全部待排序的序列元素排完
 * 举个栗子，对5,3,8,6,4这个无序序列进行简单选择排序，
 * 首先要选择5以外的最小数来和5交换，也就是选择3和5交换，
 * 一次排序后就变成了3,5,8,6,4.对剩下的序列一次进行选择和交换，
 * 最终就会得到一个有序序列。其实选择排序可以看成冒泡排序的优化，
 * 因为其目的相同，只是选择排序只有在确定了最小数的前提下才进行交换，
 * 大大减少了交换的次数。选择排序的时间复杂度为O(n^2)
 *
 *
 */
public class SelectSort extends BaseSort{

    public void sort() {

        int step = 0;

        int minIndex ;//定义一个指针
        for (int i = 0; i < array.length - 1; i++) {//只需要循环n-1次
            minIndex = i;
            logger.info("min index point to "+array[i]);
            for (int j = i+1; j < array.length; j++) {//从i+1的位置开始比较
                logger.info("jedge "+array[minIndex] +" and "+ array[j]);
                if (array[minIndex] > array[j]){
                    logger.info("min index point to "+array[j]);
                    minIndex = j;
                }
                step++;
            }
            if (minIndex != i){
                swap(array, minIndex, i);
            }
        }

        logger.info(Arrays.toString(array)+", total steps: {}", step);
    }
}
