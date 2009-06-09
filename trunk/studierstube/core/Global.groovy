/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2009 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the (3-clause) BSD license. See LICENSE.txt for details. *
**************************************************************/

package studierstube.core

/**
 * @author twel
 *
 */
class Global {
    static final String NAME = "Studierstube"
    static final String VERSION = "0.1"
    static final String COPYRIGHT = "Copyright (c) 2005-2009"
    static final String AUTHOR = "Stefan Holzmüller"
    static final String EMAIL = "twelwan@gmx.de"

    static def mainWindow = null

    static startup() {
        mainWindow = new studierstube.gui.MainWindow()
        mainWindow.setTitle(NAME + " " + VERSION)
        mainWindow.show()
    }

    static shutdown() {
        System.exit(0)
    }

    static setStatusText() {
        //
    }
}
