package com.xlj.util;

/**
 * @Author XuLeJun
 * @Date 2020/6/24 17:53
 */

public class PageUtil {
    int start = 0;
    int count = 5;
    int last = 0;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
//        this.start = start;
        if(start>=0){
            this.start = start;
        }else{
            this.start = 0;
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public void caculateLast(int total) {
        if (total % count == 0) {
            last = total - count;
        } else {
            last = total - total % count;
        }
    }

}
