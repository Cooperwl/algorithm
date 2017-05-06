package sort;

import java.util.Arrays;

/**
 *  插入排序
 * Created by Cooper on 2017/5/6.
 * 原理：
 * 插入排序不是通过交换位置，而是通过比较，找到合适的位置插入元素来达到排序的目的的。
 * 举个栗子，对5,3,8,6,4这个无序序列进行简单插入排序，
 * 首先假设第一个数的位置时正确的，想一下在拿到第一张牌的时候，没必要整理。
 * 然后3要插到5前面，把5后移一位，变成3,5,8,6,4 想一下整理牌的时候应该也是这样吧。
 * 然后8不用动，6插在8前面，8后移一位，4插在5前面，从5开始都向后移一位。
 * 注意在插入一个数的时候要保证这个数前面的数已经有序。
 *
 * 简单插入排序的时间复杂度也是O(n^2)。
 */
public class InsertSort extends BaseSort{

    public void sort() {
        int step = 0;

        for (int i = 1; i < array.length; i++) {//假设第一个数（index=0）的位置是正确的，现在需要从第二数(index=1)的位置开始判断
            int target = array[i];//待插入的数值

            logger.info("需要插入的数据："+target);

            int j = i;
            logger.info("从第"+(j-1)+"位的位置开始判断，即："+array[j-1]);
            while (j>0 && target<array[j-1]){
                logger.info("需要插入的数据"+target+"<"+array[j-1]+",将第"+j+"位重新赋值:"+array[j-1]);
                array[j] = array[j-1];
                j--;
                step++;
            }

            //插入target
            logger.info("对第"+j+"位赋值："+target);
            array[j] = target;
            step++;
        }

        logger.info(Arrays.toString(array)+", total steps: {}", step);
    }
}
