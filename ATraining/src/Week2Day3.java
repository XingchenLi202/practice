import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//create 2 thread, and print 1a2b3c...
public class Week2Day3 {
   //*********************************  synchronized  *****************************************
//   static Week2Day3 o = new Week2Day3();
//   static boolean flag = true;
//   public static void main(String[] args) throws InterruptedException {
//      //1
//      Thread t1 = new Thread(new Runnable() {
//         @Override
//         public synchronized void run() {
//            for(int i = 1; i <= 26; ){
//               synchronized (o) {
//                  if (flag) {
//                     System.out.print(Thread.currentThread().getName() + " ");
//                     System.out.println(i++);
//                     flag = !flag;
//                  }
//                  o.notify();
//
//                  try {
//                     o.wait();
//                  } catch (InterruptedException e) {
//                     e.printStackTrace();
//                  }
//               }
//            }
//         }
//      });
//      //2
//      Thread t2 = new Thread(new Runnable() {
//         @Override
//         public synchronized void run() {
//            for(int i = 0; i < 26;) {
//               synchronized (o) {
//                  if(!flag) {
//                     System.out.print(Thread.currentThread().getName() + " ");
//                     System.out.println((char) ('a' + i++));
//                     flag = !flag;
//                  }
//                  o.notify();
//
//                  try {
//                     o.wait();
//                  } catch (InterruptedException e) {
//                     e.printStackTrace();
//                  }
//               }
//            }
//         }
//      });
//
//      t1.start();
//      t2.start();
//
//      t1.join();
//      t2.join();
//   }
//********************************* ReentrantLock *****************************************************
   static boolean flag = true;
   private static ReentrantLock lock = new ReentrantLock();
   private static Condition blockingQueue1 = lock.newCondition();
   private static Condition blockingQueue2 = lock.newCondition();

   public static void main(String[] args) throws InterruptedException{
      Thread t1 = new Thread(new Runnable() {
         @Override
         public void run() {
            lock.lock();
            try {
               for(int i = 1; i <= 26; ){
                  while(!flag){
                     blockingQueue1.await();
                  }
                  System.out.println(Thread.currentThread().getName() + ": " + i++);
                  flag = !flag;
                  blockingQueue2.signal();
               }
            } catch (InterruptedException e) {
               e.printStackTrace();
            } finally {
               lock.unlock();
            }
         }
      });
      Thread t2 = new Thread(new Runnable() {
         @Override
         public void run() {
            lock.lock();
            try {
               for(int i = 0; i < 26; ){
                  while(flag){
                     blockingQueue2.await();
                  }
                  System.out.println(Thread.currentThread().getName() + ": " + (char)('a' + i++));
                  flag = !flag;
                  blockingQueue1.signal();
               }
            } catch (InterruptedException e) {
               e.printStackTrace();
            } finally {
               lock.unlock();
            }
         }
      });
      t1.start();
      t2.start();
      t1.join();
      t2.join();
   }
   
}
