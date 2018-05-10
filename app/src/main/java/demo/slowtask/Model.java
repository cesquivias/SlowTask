package demo.slowtask;

import android.support.annotation.WorkerThread;

import java.util.Random;

/**
 * A fake source of information. All calls block the thread it runs on so don't
 * run them on the UI thread.
 */
public class Model {
    /**
     * Returns a single piece of information, but takes a long time to do it.
     *
     * @return Some random piece of data
     */
    @WorkerThread
    public String getData() {
        try {
            Thread.sleep(new Random().nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello, world!";
    }
}
