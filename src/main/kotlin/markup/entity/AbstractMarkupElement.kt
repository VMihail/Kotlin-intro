package markup.entity

import markup.intarfaces.MarkupElement

abstract class AbstractMarkupElement(protected val border: String, private val elements: List<MarkupElement>)
    : MarkupElement {
    override fun toMarkdown(builder: StringBuilder) {
        builder.append(border)
        elements.forEach {
            it.toMarkdown(builder)
        }
        builder.append(border)
    }
}