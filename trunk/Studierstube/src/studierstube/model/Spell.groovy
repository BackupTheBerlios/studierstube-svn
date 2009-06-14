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
    static def uniqueModifications = []
    static def uniqueTraits = []

	String name
	String complexity
	String[] attributes
    String[] traits
    String[] modifications
	String[] variants

	String toString() {
		return "Spell ID ${this.hashCode()}: Name = $name; \
Komplexität = $complexity; Probe = $attributes; Merkmale = $traits; \
Modifikationen = $modifications; Varianten = $variants"
	}

    void setProperty(String propertyName, def value) {
        def method = this.class.getMethod("set"+propertyName, value.getClass())
        method.invoke(this, value);
    }

    static Spell byName(String name) {
        list.find { it.name == name }  // finds first occurence
    }

    static String[] getSpellList() {
        return list.collect { it.getName() }?.sort()
    }

    static String[] getUniqueTraits() { // just declare as String[] ?
        return uniqueTraits
    }
}
