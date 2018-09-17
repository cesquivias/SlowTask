package demo.slowtask

import android.support.annotation.WorkerThread

/**
 * A fake source of information. All calls block the thread it runs on so don't
 * run them on the UI thread.
 */
class Model {
    /**
     * Returns a single piece of information, but takes a long time to do it.
     *
     * @return Some random piece of data
     */
    val data: String
        @WorkerThread
        get() {
            Thread.sleep(5000)
            return "Hello, world!"
        }
}
