package tictak;

public class ThreadOne extends Thread {
    private Object monitor;
  
    public ThreadOne(Object monitor) {
        this.monitor = monitor;
    }

    public void run () {
        try
        {
            for (int i = 0; i < TicTak.num; i++) {
                synchronized (monitor) {
                    while (TicTak.flag != 1) {
                    monitor.wait();
                    }
                    TicTak.flag = 2;
                    System.out.print(1 + " - ");
                    monitor.notifyAll();
                    if (i < TicTak.num - 1) monitor.wait();
                }
            }
        }
        catch (InterruptedException e) { e.printStackTrace(); }
    }
}
