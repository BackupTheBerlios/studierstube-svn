/***************************************************************
 * This file is part of the project 'Studierstube' at berliOS. *
 * Copyright (c) 2005-2009 Stefan Holzmüller (twelwan@gmx.de)  *
 * The software and its sources are available under the terms  *
 * of the (3-clause) BSD license. See LICENSE.txt for details. *
 ***************************************************************/

package studierstube.container

/**
 *
 * @author twel
 */
class Spell {
	String name
	String complexity
	String[] attributes
	String[] traits
	String[] variants

	String toString() {
		return "Name = $name; Komplexität = $complexity; Probe = $attributes; Merkmale = $traits; Varianten = $variants"
	}
}
