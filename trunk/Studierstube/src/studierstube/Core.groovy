/***************************************************************
 * This file is part of the project 'Studierstube' at berliOS. *
 * Copyright (c) 2005-2009 Stefan Holzmüller (twelwan@gmx.de)  *
 * The software and its sources are available under the terms  *
 * of the (3-clause) BSD license. See LICENSE.txt for details. *
 ***************************************************************/

package studierstube

/**
 *
 * @author twel
 */
class Core {

    static final String NAME = "Studierstube"
    static final String VERSION = "0.1"
    static final String COPYRIGHT = "Copyright (c) 2005-2009"
    static final String AUTHOR = "Stefan Holzmüller"
    static final String EMAIL = "twelwan@gmx.de"

    static def mainWindow = null

    Core() {
        new studierstube.xml.Spells().load()

        String program = NAME + " " + VERSION
        mainWindow = new studierstube.gui.MainViewFrame()
        mainWindow.setTitle(program)
        mainWindow.setVisible(true)  // in EDT?
        setStatusText(program + " gestartet")
    }

    static shutdown() {
        System.exit(0)
    }

    static setStatusText(String status) {
        mainWindow.setStatusText(status)
    }

}

