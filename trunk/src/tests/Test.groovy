package tests

//def xdiml = new XmlSlurper().parseText(this.class.getResource('../xml/zauber.xml').text)
def xdiml = new XmlSlurper().parse(new File(this.class.getResource('../xml/zauber.xml').toURI()))
def zaubersprueche = xdiml.children().children()
//zaubersprueche.children().each {println it.@ID}
//zaubersprueche.children().each {println it.Probe}
//zaubersprueche.children().each {println it.Komplexität}
zaubersprueche.children().Varianten.each { it.children().each { if (it == "Kosten") println it } }