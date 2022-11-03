package intervive.concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AQSTest {
    private static Integer num = 0;
    Lock lock = new ReentrantLock();
    public static void main(String[] args)throws Exception {
        AQSTest aqsTest = new AQSTest();
    //    CountDownLatch countDownLatch = new CountDownLatch(50);
    //    CyclicBarrier cyclicBarrier = new  CyclicBarrier(50);
        Semaphore semaphore = new Semaphore(10);
        for (int i = 0;i<50;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0;i<50;i++) {
                        aqsTest.add();
                    }
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    // countDownLatch.countDown();
                }
            }).start();
        }
     //   countDownLatch.await();
        System.out.println(num);
    }

    public void add(){
        lock.lock();
        try {
            num++;
        } finally {
            lock.unlock();
        }
    }
}
