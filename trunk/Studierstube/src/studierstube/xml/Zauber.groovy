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
        def input = new File(getUserFile())
        if (input.canRead()) {
            println "Lade Zauber aus $input ..."
        }
        else {
            input = this.class.getResourceAsStream('zauber.xml')
            println "Lade Zauber aus JAR-Datei ..."
            if (input == null) {
                studierstube.gui.Popup.showErrorMessage("Zauber konnten nicht geladen werden")
                return null
            }
        }
        
        def xdiml = new XmlSlurper().parse(input)
        println "Studierstube XML-Format ist Version " + xdiml.Studierstube.@version
        def list = []
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
        def dir = new File(getUserDirectory())
        if (!dir.isDirectory()) {
            dir.mkdir()
        }
        def file = new File(getUserFile())
        if (file.exists()) {
            if (!studierstube.gui.Popup.showConfirmDialog("$file überschreiben?"))
                return  // no nothing
        }

        def mb = new groovy.xml.MarkupBuilder(new IndentPrinter(new PrintWriter(file)))
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

    String getUserDirectory() {
        def home = System.getProperty("user.home")
        def subdir = "/.studierstube/"
        if (System.getProperty("os.name").startsWith("Windows")) {
            subdir = "\\Studierstube\\"
        }
        return home + subdir
    }

    String getUserFile() {
        return getUserDirectory() + "zauber.xml"
    }
}

