package sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * 冒泡排序
 * Created by Cooper on 2017/5/6.
 * <p>
 * 原理：通过与相邻元素的比较和交换来把小的数交换到最前面。
 * 这个过程类似于水泡向上升一样，因此而得名。
 * 举个栗子，对5,3,8,6,4这个无序序列进行冒泡排序。
 * 首先从后向前冒泡，4和6比较，把4交换到前面，序列变成5,3,8,4,6。
 * 同理4和8交换，变成5,3,4,8,6,3和4无需交换。
 * 5和3交换，变成3,5,4,8,6,3.这样一次冒泡就完了，把最小的数3排到最前面了。
 * 对剩下的序列依次冒泡就会得到一个有序序列。
 *
 * 冒泡排序的时间复杂度为O(n^2)。
 */
public class BubbleSort {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private int[] array = new int[]{1,5,2,9,10,4,3,12,8,10};

    @Test
    public void sort(){

        for (int i = 0; i < array.length; i++) {
            for (int j = array.length -1; j > i; j--) {
                if (array[j] < array[j-1]){
                    swap(array, j, j-1);
                }
            }
        }
        logger.info(Arrays.toString(array));
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
