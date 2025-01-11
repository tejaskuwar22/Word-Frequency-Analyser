package tech.codingclub;
import java.util.Date;
import java.util.Scanner;

public class ThreadExample extends Thread{
    private String threadName;
    public int counter;
    private int waitTimeWhileLoop;

    public ThreadExample(String threadName, int counter, int waitTimeWhileLoop){
        this.threadName = threadName;
        this.counter = counter;
        this.waitTimeWhileLoop = waitTimeWhileLoop;
    }

    public void run() {
        while (counter < 1000) {
            counter++;
            try {
                Thread.sleep(waitTimeWhileLoop);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " : " + counter);
        }
    }

    public static void main(String[] args) {
        System.out.println("This side is Tejas.");
        System.out.println("Running Thread Example at "+new Date().getTime());

        ThreadExample thread1 = new ThreadExample("THREAD_A",0,500);
        ThreadExample thread2 = new ThreadExample("THREAD_B",0,1000);
        ThreadExample thread3 = new ThreadExample("THREAD_C",0,2000);

        thread1.start();
        thread2.start();
        thread3.start();

        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
    }
}
