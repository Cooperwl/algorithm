package sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
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
    }

    @Test
    public void testSort(){
        sort();
    }

    public abstract void sort();

    @AfterTest
    public void after(){
        end = System.currentTimeMillis();
        logger.info("sort end. take {} ms.", end-start);
    }

    /**
     * 数据交换
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
