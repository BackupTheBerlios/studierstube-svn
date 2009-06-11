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
class Spells {
	studierstube.container.Spell[] load() {
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
            def s = new studierstube.container.Spell(
                name:zauber.@name,
                complexity:zauber.Komplexitaet,
                attributes:zauber.Probe.toString().split("/"),
                traits:merkmale,
                variants:varianten)
            list.add(s)
        }
        return list
    }

    void write(studierstube.container.Spell[] list) {
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
                    list.each { spell -> Zauber(name:spell.getName()) { // sort?
                            Komplexitaet(spell.getComplexity())
                            Probe(spell.getAttributes().join("/"))
                            Merkmale() {
                                spell.getTraits().sort().each { Merkmal(it) }
                            }
                            Varianten() {
                                zauber.getVariants().sort().each { Variante(it) }
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


