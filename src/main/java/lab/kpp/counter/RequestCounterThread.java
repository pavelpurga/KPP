package lab.kpp.counter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestCounterThread extends Thread{
    Logger logger = LoggerFactory.getLogger(RequestCounterThread.class);
    RequestCounter counter = new RequestCounter();
    public RequestCounterThread(){
        super();
        start();
    }
    public void run(){
        logger.info(Thread.currentThread().getName() + " work");
        counter.increment();
    }
}