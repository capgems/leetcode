package JavaPractice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Semaphores {

    //permit and acquire

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 12; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    Download.INSTANCE.downloadData();
                }
            });
        }
    }
}

enum Download {

    INSTANCE;

    private Semaphore semaphore = new Semaphore(3, true);

    public void downloadData() {
        try {
            semaphore.acquire();
            download();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }

    }

    private void download() {
        System.out.println("Downloading data from the web");
        try {
            Thread.sleep(2000);
            System.out.println("Downloaded");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}