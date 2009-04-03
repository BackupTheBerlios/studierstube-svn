package tests

def zl = []

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
	zl.add(z)
}

def mb = new groovy.xml.MarkupBuilder(new IndentPrinter(new PrintWriter("/tmp/test.xml")))
mb.XDIML(version:"1.2") {
	Studierstube(version:"0.1") { // TODO: global variable
		Zaubersprueche {
			zl.each { zauber -> 
				Zauber(ID:zauber.getId()) {
					Komplexitaet(zauber.getKomplexität())
					Probe(zauber.getProbe().join("/"))
					Merkmale() {
						zauber.getMerkmale().sort().each {
							Merkmal(it)
						}
					}
					Varianten() {
						zauber.getVarianten().sort().each {
							Variante(it)
						}
					}
				}
			}
		}
	}
}
