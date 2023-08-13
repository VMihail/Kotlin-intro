package markup.entity

import markup.entity.AbstractMarkupElement
import markup.intarfaces.MarkupElement

class Emphasis(elements: List<MarkupElement>) : AbstractMarkupElement("*", elements)