/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2009 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the (3-clause) BSD license. See LICENSE.txt for details. *
**************************************************************/

public static class Main
{
	public static final String NAME = "Studierstube";
	public static final String VERSION = "0.1";
	public static final String COPYRIGHT = "Copyright (c) 2005-2009";
	public static final String AUTHOR = "Stefan Holzmüller";
	public static final String EMAIL = "twelwan@gmx.de";
	
	public static void identify()
	{
		println "$NAME $VERSION"
		println "$COPYRIGHT $AUTHOR ($EMAIL)"
	}
	
	public static void main(String[] args) {
		def zauber = new xml.Zauber()
		zauber.load()
		if (zauber.zauber.ad.is()) //.Inhalt.text()
		{
			println "null"
		}
	}
}
