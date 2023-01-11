//create 2 thread, and print 1a2b3c...
public class Week2Day3 {

   static final Object o = new Object();
   public static void main(String[] args) throws InterruptedException {
      //1
      Thread t1 = new Thread(new Runnable() {
         @Override
         public void run() {
            for(int i = 1; i <= 26; i++){
               synchronized (o) {
                  System.out.println(i);
                  o.notify();

                  try {
                     o.wait();
                  } catch (InterruptedException e) {
                     e.printStackTrace();
                  }

               }
            }
         }
      });
      //2
      Thread t2 = new Thread(new Runnable() {
         @Override
         public void run() {
            for(int i = 0; i < 26; i++) {
               synchronized (o) {
                  System.out.println((char) ('a' + i));

                  o.notify();

                  try {
                     o.wait();
                  } catch (InterruptedException e) {
                     e.printStackTrace();
                  }
               }
            }
         }
      });
      t1.start();
      t2.start();
      t1.join();
      t2.join();
   }
}
