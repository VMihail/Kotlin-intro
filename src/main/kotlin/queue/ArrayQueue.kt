package queue

class ArrayQueue<T> : Queue<T> {
    companion object {
        const val DEFAULT_CAPACITY = 10
    }

    private val capacity: Int
    private var array: Array<Any?>
    private var size = 0
    private var first = 0
    private var last = 0

    constructor(capacity: Int) {
        this.capacity = capacity
        array = arrayOfNulls(capacity)
    }

    constructor() : this(DEFAULT_CAPACITY) {

    }

    override fun enqueue(element: T) {
        if (isFill()) {
            ensureCapacity()
        }
        array[last++ % array.size] = element
        ++size
    }

    override fun element(): T {
        if (isEmpty()) {
            throw NoSuchElementException("Queue is empty.")
        }
        @Suppress("UNCHECKED_CAST")
        return array[first % array.size] as T
    }

    override fun dequeue(): T {
        val result = element()
        val mod = array.size
        array[first % mod] = null
        first = (first + 1) % mod
        --size
        return result
    }

    override fun size(): Int {
        return size
    }

    override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun clear() {
        array = arrayOfNulls<Any?>(capacity)
        first = 0
        last = 0
        size = 0
    }

    private fun isFill(): Boolean {
        return array.size == size
    }

    private fun ensureCapacity() {
        val mod = array.size
        val newArray: Array<Any?> = arrayOfNulls(mod.shl(1))
        for (i in 0 until mod) {
            newArray[i] = array[first++ % mod]
        }
        first = 0
        last = 0
        array = newArray
    }
}