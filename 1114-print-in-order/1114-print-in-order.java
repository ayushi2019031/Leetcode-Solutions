import java.util.concurrent.*;
class Foo {
    Semaphore sem = new Semaphore(2);
    public Foo() {
      
    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (sem.availablePermits() != 2){}
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        sem.acquire();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (sem.availablePermits() != 1){}
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        sem.acquire();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (sem.availablePermits() != 0){}
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        sem.release(2); 
    }
}