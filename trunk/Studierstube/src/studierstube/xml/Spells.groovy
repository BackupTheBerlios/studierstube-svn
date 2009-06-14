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
	void load() {
        def input = new File(getUserFile())
        if (input.canRead()) {
            println "Lade Zauber aus $input ..."
        }
        else {
            input = this.class.getResourceAsStream('zauber.xml')
            println "Lade Zauber aus JAR-Datei ..."
            if (input == null) {
                studierstube.gui.Popup.errorMessage("Zauber konnten nicht geladen werden")
                return null
            }
        }

        def xdiml = new XmlSlurper().parse(input)
        println "Studierstube XML-Format ist Version " + xdiml.Studierstube.@version
        def spells = []
        xdiml.Studierstube.Zaubersprueche.children().each { zauber ->
            def merkmale = []
            zauber.Merkmale?.children()?.each { merkmale.add(it) }
            def modifikationen = []
            zauber.Modifikationen?.children()?.each { modifikationen.add(it) }
            def varianten = []
            zauber.Varianten?.children()?.each { varianten.add(it) }
            def s = new studierstube.model.Spell(
                name:zauber.@name,
                complexity:zauber.Komplexitaet,
                attributes:zauber.Probe.toString().split("/"),
                traits:merkmale,
                modifications:modifikationen,
                variants:varianten)  // TODO zuschlag etc.
            spells.add(s)
        }
        studierstube.model.Spell.list = spells

        def mods, traits = []
        spells.collect {
            it.getModifications().each {mods += it}
            it.getTraits().each {traits += it}
        }
        studierstube.model.Spell.uniqueModifications = mods?.unique()?.sort()
        studierstube.model.Spell.uniqueTraits = traits?.unique()?.sort()
    }

    void write() {
        def spells = studierstube.model.Spell.list

        def dir = new File(getUserDirectory())
        if (!dir.isDirectory()) {
            dir.mkdir()
        }
        def file = new File(getUserFile())
        if (file.canWrite()) {
            if (!studierstube.gui.Popup.confirmDialog("$file überschreiben?"))
                return  // no nothing
        }

        def mb = new groovy.xml.MarkupBuilder(new IndentPrinter(new PrintWriter(file)))
        mb.XDIML(version:"1.2") {
            Studierstube(version:studierstube.Core.VERSION) {
                Zaubersprueche {
                    spells.each { spell -> Zauber(name:spell.getName()) { // sort?
                            Komplexitaet(spell.getComplexity())
                            Probe(spell.getAttributes()?.join("/"))
                            Merkmale() {
                                spell.getTraits()?.sort()?.each { Merkmal(it) }
                            }
                            Modifikationen() {
                                spell.getModifications()?.sort()?.each { Modifikation(it) }
                            }
                            Varianten() {  // TODO zuschlag etc.
                                spell.getVariants()?.sort()?.each { Variante(it) }
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


