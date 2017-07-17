package search;

import org.testng.annotations.Test;
import sort.SelectSort;

/**
 * 插值查找
 * 基本思想：基于二分查找算法，将查找点的选择改进为自适应选择，可以提高查找效率。当然，差值查找也属于有序查找。
 * 注：对于表长较大，而关键字分布又比较均匀的查找表来说，插值查找算法的平均性能比折半查找要好的多。
 * 反之，数组中如果分布非常不均匀，那么插值查找未必是很合适的选择。
 * 　　复杂度分析：查找成功或者失败的时间复杂度均为O(log2(log2n))。
 * <p>
 * Created by wangliang on 2017/7/17.
 */
public class InsertionSearch extends BaseSearch {

    @Test
    public void search() {
        SelectSort.sort(array);

        boolean search = doSearch(array, 4, 0, array.length - 1);
        logger.error("结果：{}", search);
    }

    private boolean doSearch(int[] a, int value, int low, int high) {
        int mid = low + (value - a[low]) / (a[high] - a[low]) * (high - low);
        logger.debug("mid:{} value: {}", mid, value);
        if (a[mid] == value)
            return true;
        if (a[mid] > value) {
            logger.debug("mid:{} value: {} -- fail!", a[mid], value);
            return doSearch(a, value, low, mid - 1);
        }
        if (a[mid] < value) {
            logger.debug("mid:{} value: {} -- fail!", a[mid], value);
            return doSearch(a, value, mid + 1, high);
        }
        return false;
    }
}
