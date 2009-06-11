/***************************************************************
 * This file is part of the project 'Studierstube' at berliOS. *
 * Copyright (c) 2005-2009 Stefan Holzmüller (twelwan@gmx.de)  *
 * The software and its sources are available under the terms  *
 * of the (3-clause) BSD license. See LICENSE.txt for details. *
 ***************************************************************/

package studierstube.xml

/**
 *
 * @author twel
 */
class Zauber {
    studierstube.container.Zauber[] load() {
        def list = []
        def xdiml = new XmlSlurper().parse(new File(this.class.getResource('zauber.xml').toURI()))  // this relative path does not work in .jar
        println "Reading XML format version " + xdiml.Studierstube.@version  // debug() ?
        xdiml.Studierstube.Zaubersprueche.children().each { zauber ->
            def merkmale = []
            zauber.Merkmale.children().each { merkmale.add(it) }
            def varianten = []
            zauber.Varianten.children().each { varianten.add(it) }
            def z = new studierstube.container.Zauber(
                name:zauber.@name,
                komplexitaet:zauber.Komplexitaet,
                probe:zauber.Probe.toString().split("/"),
                merkmale:merkmale,
                varianten:varianten)
            list.add(z)
        }
        return list
    }

    void write(studierstube.container.Zauber[] list) {
        def mb = new groovy.xml.MarkupBuilder(new IndentPrinter(new PrintWriter("/tmp/test.xml")))
        mb.XDIML(version:"1.2") {
            Studierstube(version:studierstube.core.Global.VERSION) {
                Zaubersprueche {
                    list.each { zauber -> Zauber(name:zauber.getName()) { // sort?
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

