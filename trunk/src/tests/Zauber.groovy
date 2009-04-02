/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2009 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the (3-clause) BSD license. See LICENSE.txt for details. *
**************************************************************/

package tests

/**
 * @author twel
 *
 */
public class Zauber {
	String id
	String komplexität
	String[] probe
	String[] merkmale
	String[] varianten
	
	public String toString() {
		return "ID = $id; Komplexität = $komplexität; Probe = $probe; Merkmale = $merkmale; Varianten = $varianten"
	}
}
