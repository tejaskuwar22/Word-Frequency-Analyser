package tech.codingclub.utility;
import tech.codingclub.RunnableExample;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManager {
    public static void main(String[] args) {
        System.out.println("This side is Tejas.");
        System.out.println("Running Thread Example at "+new Date().getTime());

        TaskManager taskManager = new TaskManager(100);
        for(int i=0 ; i<10000 ; i++){
            RunnableExample temp = new RunnableExample("THREAD-No-"+i,0, 500+i);
            taskManager.waitTillQueueIsFreeAndAddTask(temp);
            System.out.println("&&&&&&&&&&&& "+i);
        }
        System.out.println("##################################");
    }
}
