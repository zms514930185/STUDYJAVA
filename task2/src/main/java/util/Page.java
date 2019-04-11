package util;

public class Page {
    int start = 0;
    int count = 20;
    int last = 0;



    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
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
    public void calculateLast(int total){
//        如果总数能被每页的数整除，则最后一页的第一个last就是总数减去每页的显示数，
//        如total=55，count=11，则last=44
        if (0==total%count){
            last = total - count;
        }else{
//            如果不能被整除，则最后一页的第一行为总数减去能被整除的数的余数，如total=63，count=11，则last55
            last = total - total % count;
        }
    }
}
