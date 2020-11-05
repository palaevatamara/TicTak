package tictak;

public class TicTak {
    static int num=20;
    static volatile int flag;

    public static void main(String[] args) {
        Object monitor = new Object();
        ThreadOne thr1 = new ThreadOne (monitor);
        ThreadTwo thr2 = new ThreadTwo (monitor);
        ThreadThree thr3 = new ThreadThree(monitor);

        thr1.start();
        thr2.getThread().start();
        thr3.getThread().start();
        flag = 1;

        try {
            thr1.join();
            thr2.getThread().join();
            thr3.getThread().join();
        }
        catch (InterruptedException e) { e.printStackTrace();}
    }
}