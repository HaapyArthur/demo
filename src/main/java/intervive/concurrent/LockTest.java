package intervive.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    public static void main(String[] args) {
        for (int i=0;i<5;i++){
            Thread t = new Thread(new Worker());
            t.start();
        }

    }
    static Lock lock = new ReentrantLock();
    static class Worker implements Runnable{
        @Override
        public void run() {
         //   lock.lock();
            System.out.println("thread name :" + Thread.currentThread().getName() );

            System.out.println("thread name :" + Thread.currentThread().getName() + " start" );

            for (int i=0;i<4;i++){

                System.out.println("thread name :" + Thread.currentThread().getName() + " " + i);

            }
            System.out.println("thread name :" + Thread.currentThread().getName() + " end" );

        //    lock.unlock();
        }
    }
}
