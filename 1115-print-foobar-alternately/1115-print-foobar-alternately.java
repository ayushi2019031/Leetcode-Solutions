import java.util.concurrent.*;
class FooBar {
    private int n;
    Semaphore sem = new Semaphore(1);
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while (sem.availablePermits() != 1){}
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            sem.acquire();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while (sem.availablePermits() != 0){}
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            sem.release(1);
        }
    }
}