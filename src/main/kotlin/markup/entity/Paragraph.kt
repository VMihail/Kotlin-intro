package markup.entity

import markup.entity.AbstractMarkupElement
import markup.intarfaces.MarkupElement

class Paragraph(elements: List<MarkupElement>) : AbstractMarkupElement("", elements)