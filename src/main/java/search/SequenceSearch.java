package search;

import org.testng.annotations.Test;

/**
 * Created by wangliang on 2017/7/17.
 */
public class SequenceSearch extends BaseSearch {

    @Test
    public void search(){

        int value = 8;
        for (int i : array) {
            if (value == i){
                logger.debug("查找成功！");
                return;
            }
        }
        logger.debug("error");
    }
}
