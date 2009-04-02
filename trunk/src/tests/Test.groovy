package tests

//def xdiml = new XmlSlurper().parseText(this.class.getResource('../xml/zauber.xml').text)
def xdiml = new XmlSlurper().parse(new File(this.class.getResource('../xml/zauber.xml').toURI()))
def zaubersprueche = xdiml.children().children()
zaubersprueche.children().each { zauber ->
	def merkmale = []
	zauber.Merkmale.children().each { merkmale.add(it) }
	def varianten = []
	zauber.Varianten.children().each { varianten.add(it) }
	def z = new Zauber(
			id:zauber.@ID,
			komplexität:zauber.Komplexität,
			probe:zauber.Probe.toString().split("/"),
			merkmale:merkmale,
			varianten:varianten)
	println z
}
