package queue

class LinkedQueue<T> : Queue<T> {
    private class Node<T> {
        private var value: T
        var next: Node<T>? = null

        constructor(value: T) {
            this.value = value
        }

        constructor(value: T, next: Node<T>) : this(value) {
            this.next = next
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Node<*>

            if (value != other.value) return false
            return next == other.next
        }

        override fun hashCode(): Int {
            var result = value?.hashCode() ?: 0
            result = 31 * result + (next?.hashCode() ?: 0)
            return result
        }
    }

    private var first: Node<T>? = null
    private var last: Node<T>? = null

    private var size = 0

    override fun enqueue(element: T) {
        if (isEmpty()) {
            first = Node(element)
            return
        }
        if (size == 1) {
            last = Node(element)
            first!!.next = last
            return
        }
        last!!.next = Node(element)
        last = last!!.next
    }

    override fun element(): T {
        TODO("Not yet implemented")
    }

    override fun dequeue(): T {
        TODO("Not yet implemented")
    }

    override fun size(): Int = size

    override fun isEmpty(): Boolean = size == 0

    override fun clear() {
        TODO("Not yet implemented")
    }
}