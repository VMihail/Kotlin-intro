package markup.intarfaces

interface MarkupElement {
    fun toMarkdown(builder: StringBuilder)
}