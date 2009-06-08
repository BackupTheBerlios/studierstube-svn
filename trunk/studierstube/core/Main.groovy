/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package studierstube.core

public class Main {
    public static startup() {

        def z = new studierstube.xml.Zauber()
        z.load()
        println z.list[0]

    }
}
