package markup.entity

import markup.entity.AbstractMarkupElement

class Text(text: String) : AbstractMarkupElement(text, listOf()) {
    override fun toMarkdown(builder: StringBuilder) {
        builder.append(border)
    }
}