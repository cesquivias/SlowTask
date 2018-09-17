package demo.slowtask

/**
 * Returns the fibonacci sequence very slowly to the callback. Initally, the sequence is stopped.
 * To resume or stop the sequence set enabled to true & false, respectively.
 */
class FibonacciModel {
    /**
     * When a new number in the sequence is computed, it will be called to this callback
     */
    var callback: ((Int) -> Unit)? = null

    /**
     * The sequence is started when enabled is true and stops when it's set to false
     */
    var enabled = false
        set(value) {
            if (value) {
                start()
            }
        }

    private var a = 1
    private var b = 1

    private fun start() {
        while (enabled) {
            callback?.invoke(a)
            val temp = b
            b += a
            a = temp
            Thread.sleep(2000)
        }
    }
}