package search;

import org.testng.annotations.Test;
import sort.SelectSort;

/**
 * 二分查找 折半法
 *
 * 说明：元素必须是有序的，如果是无序的则要先进行排序操作。
 * Created by wangliang on 2017/7/17.
 */
public class BinarySearch extends BaseSearch {

    /**
     * 折半查找
     */
    @Test
    public void search(){
        //首先排序
        array = SelectSort.sort(array);

        int value = 5;
        int low = 0;
        int high = array.length;
        int mid;
        while (low <= high){
            mid = (low + high)/2;
            if (array[mid] == value){
                logger.debug("success!");
                return;
            }
            if (array[mid] > value){
                high = mid-1;
            }
            if (array[mid] < value){
                low = mid+1;
            }
        }
        logger.error("error!");
    }

    /**
     * 递归实现
     */
    @Test
    public void search2(){
        array = SelectSort.sort(array);
        doSearch(array, 3, 0, array.length);
    }

    public void doSearch(int a[], int value, int low, int high){
        int mid = (low+high)/2;
        if (a[mid] == value){
            logger.debug("mid:{} value: {} -- success!", a[mid], value);
            return;
        }else if (a[mid] > value){
            logger.debug("mid:{} value: {} -- fail!", a[mid], value);
            doSearch(a, value, low, mid-1);
        }else {
            logger.debug("mid:{} value: {} -- fail!", a[mid], value);
            doSearch(a, value, mid+1, high);
        }
    }
}
