package tictak;

public class ThreadTwo implements Runnable
{
    private Thread thread;
    private Object monitor;

    public Thread getThread () {
        return thread;
    }

    public ThreadTwo(Object monitor) {
        this.monitor = monitor;
        thread = new Thread (this);
    }
    
    public void run() {
        try {
            Thread.sleep(1);
            for (int i = 0; i < TicTak.num; i++) {
                synchronized (monitor) {
                    while (TicTak.flag != 2) {
                    monitor.wait();
                    }
                    TicTak.flag = 3;
                    System.out.print(2 + " - ");
                    monitor.notifyAll();
                    if (i < TicTak.num - 1) monitor.wait();
                }
            }
        }
        catch (InterruptedException e) { e.printStackTrace(); }
    }
}
