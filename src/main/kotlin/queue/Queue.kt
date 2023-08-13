package queue

interface Queue<T> {
    fun enqueue(element: T)
    fun element(): T
    fun dequeue(): T
    fun size(): Int
    fun isEmpty(): Boolean
    fun clear()
}