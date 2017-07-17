package search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Created by wangliang on 2017/7/17.
 */
@Test
public class BaseSearch {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected int[] array = new int[]{1,5,2,9,14,4,3,12,8,10};

    private Long start, end;
    @BeforeTest
    public void befort(){
        start = System.currentTimeMillis();
        logger.info("origin array： "+ Arrays.toString(array));
    }

    @AfterTest
    public void after(){
        end = System.currentTimeMillis();
        logger.info("sort end. result:{} ,take {} ms.", Arrays.toString(array), end-start);
    }
}
