/***************************************************************
 * This file is part of the project 'Studierstube' at berliOS. *
 * Copyright (c) 2005-2009 Stefan Holzmüller (twelwan@gmx.de)  *
 * The software and its sources are available under the terms  *
 * of the (3-clause) BSD license. See LICENSE.txt for details. *
 ***************************************************************/

package studierstube.gui

/**
 *
 * @author twel
 */
class Popup {
	static boolean showConfirmDialog(String message) {
        int n = javax.swing.JOptionPane.showConfirmDialog(
                studierstube.Core.mainWindow,
                message,
                "Fortfahren?",
                javax.swing.JOptionPane.OK_CANCEL_OPTION);
        if (n == 0) return true
        else return false
    }

    static void showErrorMessage(String message) {
        int n = javax.swing.JOptionPane.showMessageDialog(
                studierstube.Core.mainWindow,
                message,
                "Fehler",
                javax.swing.JOptionPane.ERROR_MESSAGE);
    }
}

