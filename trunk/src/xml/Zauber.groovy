/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2009 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the (3-clause) BSD license. See LICENSE.txt for details. *
**************************************************************/

package xml

/**
 * @author twel
 *
 */
public class Zauber {
	def liste = []
	
	public void load() {
		def xdiml = new XmlSlurper().parse(new File(this.class.getResource('zauber.xml').toURI()))
		def zaubersprueche = xdiml.children().children()  // ugly
		zaubersprueche.children().each { zauber ->
			def merkmale = []
			zauber.Merkmale.children().each { merkmale.add(it) }
			def varianten = []
			zauber.Varianten.children().each { varianten.add(it) }
			def z = new container.Zauber(
					id:zauber.@ID,
					komplexitaet:zauber.Komplexitaet,
					probe:zauber.Probe.toString().split("/"),
					merkmale:merkmale,
					varianten:varianten)
			liste.add(z)
		}
	}
	
	public void write() {
		def mb = new groovy.xml.MarkupBuilder(new IndentPrinter(new PrintWriter("/tmp/test.xml")))
		mb.XDIML(version:"1.2") {
			Studierstube(version:"0.1") { // TODO: global variable
				Zaubersprueche {
					liste.each { zauber -> Zauber(ID:zauber.getId()) {
						Komplexitaet(zauber.getKomplexitaet())
						Probe(zauber.getProbe().join("/"))
						Merkmale() {
							zauber.getMerkmale().sort().each { Merkmal(it) }
						}
						Varianten() {
							zauber.getVarianten().sort().each { Variante(it) }
						}
					} }
				}
			}
		}
	}
}
