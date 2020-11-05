package tictak;

public class ThreadThree implements Runnable{
    private Object monitor;
    private Thread thread;

    public Thread getThread() {
        return thread;
    }

    public ThreadThree(Object monitor) {
        this.monitor = monitor;
        thread = new Thread(this);

    }

    @Override
    public void run() {
        try {
            Thread.sleep(1);
            for (int i = 0; i < TicTak.num; i++) {
                synchronized (monitor) {
                    while (TicTak.flag != 3) {
                    monitor.wait();
                    }
                    TicTak.flag = 1;
                    System.out.println(3);
                    monitor.notifyAll();
                    if (i < TicTak.num - 1) monitor.wait();
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
