/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forme;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class PretraziIznajmljivanje extends javax.swing.JDialog {

    private GlavnaForma gf;
   
    public PretraziIznajmljivanje(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.gf = (GlavnaForma) parent;
        this.setLocationRelativeTo(null);
        this.setTitle("Pretraži iznajmljivanje");
    }

    public GlavnaForma getGf() {
        return gf;
    }

    public void setGf(GlavnaForma gf) {
        this.gf = gf;
    }

    public JButton getjButtonPretrazi() {
        return jButtonPretrazi;
    }

    public void setjButtonPretrazi(JButton jButtonPretrazi) {
        this.jButtonPretrazi = jButtonPretrazi;
    }

    public JButton getjButtonPretraziSve() {
        return jButtonPretraziSve;
    }

    public void setjButtonPretraziSve(JButton jButtonPretraziSve) {
        this.jButtonPretraziSve = jButtonPretraziSve;
    }

    public JButton getjButtonPrikaziIznajmljivanje() {
        return jButtonPrikaziIznajmljivanje;
    }

    public void setjButtonPrikaziIznajmljivanje(JButton jButtonPrikaziIznajmljivanje) {
        this.jButtonPrikaziIznajmljivanje = jButtonPrikaziIznajmljivanje;
    }

    public JRadioButton getjRadioButtonBicikla() {
        return jRadioButtonBicikla;
    }

    public void setjRadioButtonBicikla(JRadioButton jRadioButtonBicikla) {
        this.jRadioButtonBicikla = jRadioButtonBicikla;
    }

    public JRadioButton getjRadioButtonID() {
        return jRadioButtonID;
    }

    public void setjRadioButtonID(JRadioButton jRadioButtonID) {
        this.jRadioButtonID = jRadioButtonID;
    }

    public JRadioButton getjRadioButtonKupac() {
        return jRadioButtonKupac;
    }

    public void setjRadioButtonKupac(JRadioButton jRadioButtonKupac) {
        this.jRadioButtonKupac = jRadioButtonKupac;
    }

    public JRadioButton getjRadioButtonProdavac() {
        return jRadioButtonProdavac;
    }

    public void setjRadioButtonProdavac(JRadioButton jRadioButtonProdavac) {
        this.jRadioButtonProdavac = jRadioButtonProdavac;
    }

    public JTable getjTableIznajmljivanja() {
        return jTableIznajmljivanja;
    }

    public void setjTableIznajmljivanja(JTable jTableIznajmljivanja) {
        this.jTableIznajmljivanja = jTableIznajmljivanja;
    }

    public JTextField getjTextFieldBickla() {
        return jTextFieldBickla;
    }

    public void setjTextFieldBickla(JTextField jTextFieldBickla) {
        this.jTextFieldBickla = jTextFieldBickla;
    }

    public JTextField getjTextFieldID() {
        return jTextFieldID;
    }

    public void setjTextFieldID(JTextField jTextFieldID) {
        this.jTextFieldID = jTextFieldID;
    }

    public JTextField getjTextFieldKupac() {
        return jTextFieldKupac;
    }

    public void setjTextFieldKupac(JTextField jTextFieldKupac) {
        this.jTextFieldKupac = jTextFieldKupac;
    }

    public JTextField getjTextFieldProdavac() {
        return jTextFieldProdavac;
    }

    public void setjTextFieldProdavac(JTextField jTextFieldProdavac) {
        this.jTextFieldProdavac = jTextFieldProdavac;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonPretraziSve = new javax.swing.JButton();
        jRadioButtonID = new javax.swing.JRadioButton();
        jTextFieldID = new javax.swing.JTextField();
        jRadioButtonProdavac = new javax.swing.JRadioButton();
        jTextFieldProdavac = new javax.swing.JTextField();
        jRadioButtonKupac = new javax.swing.JRadioButton();
        jTextFieldKupac = new javax.swing.JTextField();
        jRadioButtonBicikla = new javax.swing.JRadioButton();
        jTextFieldBickla = new javax.swing.JTextField();
        jButtonPretrazi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableIznajmljivanja = new javax.swing.JTable();
        jButtonPrikaziIznajmljivanje = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Iznajmljivanje");

        jLabel2.setText("Prikaži sva iznajmljivanja:");

        jButtonPretraziSve.setText("Prikaži sve");

        jRadioButtonID.setText("Filtriraj iznajmljivanja prema ID-u:");
        jRadioButtonID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonIDActionPerformed(evt);
            }
        });

        jRadioButtonProdavac.setText("Filtriraj iznajmljivanja prema prodavcu:");

        jRadioButtonKupac.setText("Filtriraj iznajmljivanja prema kupcu:");

        jRadioButtonBicikla.setText("Filtriraj iznajmljivanja prema tipu bicikle:");

        jButtonPretrazi.setText("Pretraži");

        jTableIznajmljivanja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableIznajmljivanja);

        jButtonPrikaziIznajmljivanje.setText("PRIKAŽI DETALJE IZNAJMLJIVANJA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonPrikaziIznajmljivanje, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButtonBicikla)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldBickla))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonPretraziSve, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jRadioButtonID)
                                            .addComponent(jRadioButtonProdavac)
                                            .addComponent(jRadioButtonKupac))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jTextFieldID, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                                                    .addComponent(jTextFieldProdavac)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(jTextFieldKupac, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                                .addComponent(jButtonPretrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonID)
                            .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jRadioButtonProdavac)
                                    .addComponent(jTextFieldProdavac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jButtonPretrazi)))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonKupac)
                            .addComponent(jTextFieldKupac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonBicikla)
                            .addComponent(jTextFieldBickla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButtonPrikaziIznajmljivanje, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonPretraziSve))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonIDActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPretrazi;
    private javax.swing.JButton jButtonPretraziSve;
    private javax.swing.JButton jButtonPrikaziIznajmljivanje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioButtonBicikla;
    private javax.swing.JRadioButton jRadioButtonID;
    private javax.swing.JRadioButton jRadioButtonKupac;
    private javax.swing.JRadioButton jRadioButtonProdavac;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableIznajmljivanja;
    private javax.swing.JTextField jTextFieldBickla;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldKupac;
    private javax.swing.JTextField jTextFieldProdavac;
    // End of variables declaration//GEN-END:variables

    public void VratiListuSvihIznajmljivanjaAddActionListeners(ActionListener actionListener) {
        jButtonPretraziSve.addActionListener(actionListener);
    }

    public void VratiListuIznajmljivanjaSaUslovomAddActionListeners(ActionListener actionListener) {
        jButtonPretrazi.addActionListener(actionListener);
    }

    public void PrikaziIznajmljivanjeAddActionListeners(ActionListener actionListener) {
        jButtonPrikaziIznajmljivanje.addActionListener(actionListener);
    }

    public void RadioIDAddActionListeners(ActionListener actionListener) {
        jRadioButtonID.addActionListener(actionListener);
    }

    public void RadioProdavacAddActionListeners(ActionListener actionListener) {
        jRadioButtonProdavac.addActionListener(actionListener);
    }

    public void RadioKupacAddActionListeners(ActionListener actionListener) {
        jRadioButtonKupac.addActionListener(actionListener);
    }

    public void RadioBiciklaAddActionListeners(ActionListener actionListener) {
        jRadioButtonBicikla.addActionListener(actionListener);
    }
}
