package pojo;

public class Page {
    private int start;
    private int count;
    private int total;

//    getter和setter方法
    private static final int defaultCount = 5;

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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

//    构造方法

    public Page() {
        count = defaultCount;
    }

    public Page(int start, int count) {
        this.start = start;
        this.count = count;
    }

    public int getTotalPage(){
        int totalPafge;
        if (0 == total % count) {
            totalPafge = total / count;
        }
        else {
            totalPafge = total / count + 1;
        }
        if (0==totalPafge){
            totalPafge = 1;
        }
        return totalPafge;
    }

    public int getLast(){
        int last;
        if (0 == total % count) {
            last = total - count;
        } else {
            last = total - total % count;
        }
        last = last < 0 ? 0 : last;
        return last;
    }

    public boolean isHasPrevious(){
        if (0 == start) {
            return false;
        }
        return true;
    }
    public boolean isHasNext(){
        if (0 == getLast()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Page[" +
                "start=" + start +
                ", count=" + count +
                ", total=" + total+
                ", getStart()=" + getStart() +
                ", getCount()=" + getCount() +
                ", isHasPreviouse()=" + isHasPrevious() +
                ", isHasNext()=" + isHasNext() +
                ", getTotalPage()=" + getTotalPage() +
                ", getLast()=" + getLast() + "]";
    }
}
