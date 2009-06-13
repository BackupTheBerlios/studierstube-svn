/***************************************************************
 * This file is part of the project 'Studierstube' at berliOS. *
 * Copyright (c) 2005-2009 Stefan Holzmüller (twelwan@gmx.de)  *
 * The software and its sources are available under the terms  *
 * of the (3-clause) BSD license. See LICENSE.txt for details. *
 ***************************************************************/

package studierstube.model

//import groovy.beans.Bindable (req. groovy 1.6.2)

/**
 *
 * @author twel
 */
class Spell {

    static def list = []

	String name
	String complexity
	String[] attributes
    String[] modifications
	String[] variants
    String[] traits

	String toString() {
		return "Name = $name; Komplexität = $complexity; Probe = $attributes; \
                Modifikationen = $modifications; Varianten = $variants; \
                Merkmale = $traits"
	}

    static void saveXml() {
        def xmlSpells = new studierstube.xml.Spells()
        xmlSpells.write(list)
    }
}
