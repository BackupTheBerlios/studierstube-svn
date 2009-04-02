package tests

//def xdiml = new XmlSlurper().parseText(this.class.getResource('../xml/zauber.xml').text)
def xdiml = new XmlSlurper().parse(new File(this.class.getResource('../xml/zauber.xml').toURI()))
def zaubersprueche = xdiml.children().children()
//zaubersprueche.children().each {println it.@ID}
//zaubersprueche.children().each {println it.Probe}
//zaubersprueche.children().each {println it.Komplexität}
//zaubersprueche.children().Varianten.each { it.children().each { if (it == "Kosten") println it } }
zaubersprueche.children().each {
	def merkmale = []
	it.Merkmale.children().each { merkmale += "$it" }
	def varianten = []
	it.Varianten.children().each { varianten += "$it" }
	def z = new Zauber(id:it.@ID, komplexität:it.Komplexität, probe:it.Probe.toString().split("/"), merkmale:merkmale, varianten:varianten)
	println z.getId()
}

