package sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 *
 * Created by Cooper on 2017/5/6.
 */
@Test
public abstract class BaseSort {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected int[] array = new int[]{1,5,2,9,14,4,3,12,8,10};

    private Long start, end;

    @BeforeTest
    public void befort(){
        start = System.currentTimeMillis();
        logger.info("origin array： "+Arrays.toString(array));
    }

    @Test
    public void testSort(){
        sort();
    }

    public abstract void sort();

    @AfterTest
    public void after(){
        end = System.currentTimeMillis();
        logger.info("sort end. result:{} ,take {} ms.", Arrays.toString(array), end-start);
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }


    /**
     * 数据交换
     * @param array origin
     * @param left index I
     * @param right Index J
     */
    protected void swap(int[] array, int left, int right){
        if (left == right) return;
        logger.info("swap value:" + array[left] + " and " + array[right]);
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
        logger.info("after swap :"+Arrays.toString(array));
    }

}
