import com.github.javaparser.ast.Node
import java.util.*

fun <T> Node.descendantsOfType(type: Class<T>): List<T> {
    val descendants = LinkedList<T>()
    SpecificNodeIterator(type, object : SpecificNodeIterator.NodeHandler<T> {
        override fun handle(node: T): Boolean {
            descendants.add(node)
            return true
        }
    }).explore(this)
    return descendants
}

class SpecificNodeIterator<T>(private val type: Class<T>, private val nodeHandler: SpecificNodeIterator.NodeHandler<T>) {
    interface NodeHandler<T> {
        fun handle(node: T): Boolean
    }

    fun explore(node: Node) {
        if (type.isInstance(node)) {
            if (!nodeHandler.handle(type.cast(node))) {
                return
            }
        }
        for (child in node.childNodes) {
            explore(child)
        }
    }
}
