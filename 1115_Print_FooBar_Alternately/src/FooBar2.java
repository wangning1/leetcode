import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @Description:
 * @CreateDate: 2020/4/15 14:39
 * @Author: wangning
 */
public class FooBar2 {

    private int n;
    private Semaphore fooSemphore;
    private Semaphore barSemphore;
    private volatile boolean canBar = false;


    public FooBar2(int n) {
        this.n = n;
        fooSemphore = new Semaphore(1);
        barSemphore = new Semaphore(1);

    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooSemphore.acquire();
            canBar = true;
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barSemphore.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        while (canBar) {
            for (int i = 0; i < n; i++) {
                barSemphore.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                fooSemphore.release();
            }
            break;
        }
    }
}
