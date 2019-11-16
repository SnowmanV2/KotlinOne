import Xml.Companion.addresses
import Xml.Companion.obj
import kotlin.text.StringBuilder

class XmlObjectBuilder {
    internal var result = StringBuilder().append("")
    infix fun String.to(value: Any) {
        result.append("<$this> $value </$this>\n")
    }
}

class Xml {
    companion object {
        private val builder = XmlObjectBuilder()
        fun obj(content: XmlObjectBuilder.() -> Unit): StringBuilder {
            builder.result.append("<object>\n")
            builder.content()
            return builder.result.append("</object>\n")
        }
        fun addresses(content: XmlObjectBuilder.() -> Unit): StringBuilder {
            builder.result.append("<addresses>\n")
            builder.content()
            return builder.result.append("</addresses>\n")
        }
    }
}

fun main() {
    val obj = obj {
        "name" to "Имя1"
        "surname" to "Имя2"
        "birthDate" to "13.02.2019"
        addresses {
            "address" to "first address"
            "address" to "second address"
            "address" to "third address"
        }
    }
    println(obj)
}