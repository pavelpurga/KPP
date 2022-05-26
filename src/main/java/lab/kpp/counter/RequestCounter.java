package lab.kpp.counter;

public class RequestCounter {
    private static int count= 0;
    public synchronized void increment(){
        count++;
    }
    public synchronized int getCount(){
        return count;
    }
}