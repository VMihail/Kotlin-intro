package markup.entity

import markup.entity.AbstractMarkupElement
import markup.intarfaces.MarkupElement

class Strikeout(elements: List<MarkupElement>) : AbstractMarkupElement("~", elements)