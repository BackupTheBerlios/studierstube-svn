/***************************************************************
 * This file is part of the project 'Studierstube' at berliOS. *
 * Copyright (c) 2005-2009 Stefan Holzmüller (twelwan@gmx.de)  *
 * The software and its sources are available under the terms  *
 * of the (3-clause) BSD license. See LICENSE.txt for details. *
 ***************************************************************/

/*
 * ManageZauberPanel.java
 *
 * Created on Jun 11, 2009, 12:16:41 PM
 */

package studierstube.gui;

/**
 *
 * @author twel
 */
public class ManageZauberPanel extends javax.swing.JPanel {

    /** Creates new form ManageZauberPanel */
    public ManageZauberPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelZauberliste = new javax.swing.JPanel();
        labelZauberliste = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listZauberliste = new javax.swing.JList();
        panelZauberDetails = new javax.swing.JPanel();

        labelZauberliste.setText("Zauberliste");

        listZauberliste.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listZauberliste);
        listZauberliste.setListData(studierstube.core.Global.getZauberNames());

        javax.swing.GroupLayout panelZauberlisteLayout = new javax.swing.GroupLayout(panelZauberliste);
        panelZauberliste.setLayout(panelZauberlisteLayout);
        panelZauberlisteLayout.setHorizontalGroup(
            panelZauberlisteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelZauberlisteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelZauberlisteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(labelZauberliste))
                .addContainerGap())
        );
        panelZauberlisteLayout.setVerticalGroup(
            panelZauberlisteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelZauberlisteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelZauberliste)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelZauberDetailsLayout = new javax.swing.GroupLayout(panelZauberDetails);
        panelZauberDetails.setLayout(panelZauberDetailsLayout);
        panelZauberDetailsLayout.setHorizontalGroup(
            panelZauberDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );
        panelZauberDetailsLayout.setVerticalGroup(
            panelZauberDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 431, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelZauberliste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelZauberDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelZauberliste, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelZauberDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelZauberliste;
    private javax.swing.JList listZauberliste;
    private javax.swing.JPanel panelZauberDetails;
    private javax.swing.JPanel panelZauberliste;
    // End of variables declaration//GEN-END:variables

}