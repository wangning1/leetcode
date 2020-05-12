import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @Description:
 * @CreateDate: 2020/4/14 18:46
 * @Author: wangning
 */
public class FooBar {

    private int n;
    private CountDownLatch fooCd = new CountDownLatch(0);
    private CountDownLatch barCd = new CountDownLatch(1);


    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            fooCd.await();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barCd.countDown();
            fooCd = new CountDownLatch(1);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            barCd.await();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooCd.countDown();
            barCd = new CountDownLatch(1);
        }
    }

}
