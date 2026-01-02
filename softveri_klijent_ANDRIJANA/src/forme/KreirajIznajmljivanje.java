/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forme;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Bicikla;
import model.Iznajmljivanje;
import model.Kupac;
import model.Prodavac;

/**
 *
 * @author HP
 */
public class KreirajIznajmljivanje extends javax.swing.JDialog {

    private GlavnaForma gf;
    private Iznajmljivanje iznajmljivanje;
   
    public KreirajIznajmljivanje(java.awt.Frame parent, boolean modal, Iznajmljivanje iznajmljivanje) {
        super(parent, modal);
        initComponents();
        this.gf = (GlavnaForma) parent;
        this.iznajmljivanje = iznajmljivanje;
        this.setPreferredSize(new Dimension(850, 750)); 
        this.setMinimumSize(new Dimension(850, 750));
        this.setMaximumSize(new Dimension(850, 750));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Kreiraj iznajmljivanje");
        jPanel1.setPreferredSize(new Dimension(700, 200));
        jPanel1.setMinimumSize(new Dimension(700, 200));   
        




    }

    public GlavnaForma getGf() {
        return gf;
    }

    public void setGf(GlavnaForma gf) {
        this.gf = gf;
    }

    public Iznajmljivanje getIznajmljivanje() {
        return iznajmljivanje;
    }

    public void setIznajmljivanje(Iznajmljivanje iznajmljivanje) {
        this.iznajmljivanje = iznajmljivanje;
    }
    
    

    public JButton getjButtonObrisiStavku() {
        return jButtonObrisiStavku;
    }

    public void setjButtonObrisiStavku(JButton jButton1) {
        this.jButtonObrisiStavku = jButton1;
    }

    public JButton getjButtonDodajStavku() {
        return jButtonDodajStavku;
    }

    public void setjButtonDodajStavku(JButton jButtonDodajStavku) {
        this.jButtonDodajStavku = jButtonDodajStavku;
    }

    public JButton getjButtonOdustani() {
        return jButtonOdustani;
    }

    public void setjButtonOdustani(JButton jButtonOdustani) {
        this.jButtonOdustani = jButtonOdustani;
    }

    public JButton getjButtonPrikazi() {
        return jButtonPrikazi;
    }

    public void setjButtonPrikazi(JButton jButtonPrikazi) {
        this.jButtonPrikazi = jButtonPrikazi;
    }

    public JButton getjButtonPromeni() {
        return jButtonPromeni;
    }

    public void setjButtonPromeni(JButton jButtonPromeni) {
        this.jButtonPromeni = jButtonPromeni;
    }

    public JButton getjButtonSacuvaj() {
        return jButtonSacuvaj;
    }

    public void setjButtonSacuvaj(JButton jButtonSacuvaj) {
        this.jButtonSacuvaj = jButtonSacuvaj;
    }

    public JButton getjButtonZapamti() {
        return jButtonZapamti;
    }

    public void setjButtonZapamti(JButton jButtonZapamti) {
        this.jButtonZapamti = jButtonZapamti;
    }

    public JComboBox<Bicikla> getjComboBoxBicikla() {
        return jComboBoxBicikla;
    }

    public void setjComboBoxBicikla(JComboBox<Bicikla> jComboBoxBicikla) {
        this.jComboBoxBicikla = jComboBoxBicikla;
    }

    public JComboBox<Kupac> getjComboBoxKupac() {
        return jComboBoxKupac;
    }

    public void setjComboBoxKupac(JComboBox<Kupac> jComboBoxKupac) {
        this.jComboBoxKupac = jComboBoxKupac;
    }

    public JComboBox<Prodavac> getjComboBoxProdavci() {
        return jComboBoxProdavci;
    }

    public void setjComboBoxProdavci(JComboBox<Prodavac> jComboBoxProdavci) {
        this.jComboBoxProdavci = jComboBoxProdavci;
    }

    public JTextField getjTextFieldUkupanIznos() {
        return jTextFieldUkupanIznos;
    }

    public void setjTextFieldUkupanIznos(JTextField jTextFieldUkupanIznos) {
        this.jTextFieldUkupanIznos = jTextFieldUkupanIznos;
    }

    public JTextField getjTextFieldVremeDo() {
        return jTextFieldVremeDo;
    }

    public void setjTextFieldVremeDo(JTextField jTextFieldVremeDo) {
        this.jTextFieldVremeDo = jTextFieldVremeDo;
    }

    public JTextField getjTextFieldVremeOd() {
        return jTextFieldVremeOd;
    }

    public void setjTextFieldVremeOd(JTextField jTextFieldVremeOd) {
        this.jTextFieldVremeOd = jTextFieldVremeOd;
    }

    public JTable getjTableStavkeIznajmljivanja() {
        return jTableStavkeIznajmljivanja;
    }

    public void setjTableStavkeIznajmljivanja(JTable jTableStavkeIznajmljivanja) {
        this.jTableStavkeIznajmljivanja = jTableStavkeIznajmljivanja;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxProdavci = new javax.swing.JComboBox<>();
        jComboBoxKupac = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldUkupanIznos = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableStavkeIznajmljivanja = new javax.swing.JTable();
        jButtonPromeni = new javax.swing.JButton();
        jButtonPrikazi = new javax.swing.JButton();
        jButtonSacuvaj = new javax.swing.JButton();
        jButtonZapamti = new javax.swing.JButton();
        jButtonOdustani = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxBicikla = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldVremeOd = new javax.swing.JTextField();
        jTextFieldVremeDo = new javax.swing.JTextField();
        jButtonDodajStavku = new javax.swing.JButton();
        jButtonObrisiStavku = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Iznajmljivanje");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 32, -1, -1));

        jLabel2.setText("Prodavac:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 74, -1, -1));

        jLabel3.setText("Kupac:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 111, -1, -1));

        getContentPane().add(jComboBoxProdavci, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 71, 157, -1));

        getContentPane().add(jComboBoxKupac, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 111, 157, -1));

        jLabel4.setText("UKUPAN IZNOS:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 74, -1, -1));
        getContentPane().add(jTextFieldUkupanIznos, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 71, 172, -1));

        jTableStavkeIznajmljivanja.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableStavkeIznajmljivanja);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 379, 683, 184));

        jButtonPromeni.setText("Promeni iznajmljivanje");
        jButtonPromeni.setPreferredSize(new java.awt.Dimension(150, 25));
        jButtonPromeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPromeniActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPromeni, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 609, 180, -1));

        jButtonPrikazi.setText("Prikaži iznajmljivanje");
        jButtonPrikazi.setPreferredSize(new java.awt.Dimension(150, 25));
        getContentPane().add(jButtonPrikazi, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 609, 180, -1));

        jButtonSacuvaj.setText("Sačuvaj");
        getContentPane().add(jButtonSacuvaj, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 610, 138, -1));

        jButtonZapamti.setText("Zapamti");
        getContentPane().add(jButtonZapamti, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 610, 138, -1));

        jButtonOdustani.setText("Odustani");
        getContentPane().add(jButtonOdustani, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 650, 138, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Stavka iznajmljivanja:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 19, -1, -1));

        jLabel6.setText("Tip bicikle:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 65, -1, -1));

        jPanel1.add(jComboBoxBicikla, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 62, 152, -1));

        jLabel7.setText("Vreme od (dd.MM.yyyy. HH:mm:ss):");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 117, -1, -1));

        jLabel8.setText("Vreme do (dd.MM.yyyy. HH:mm:ss):");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 176, -1, -1));
        jPanel1.add(jTextFieldVremeOd, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 114, 152, -1));

        jTextFieldVremeDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldVremeDoActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldVremeDo, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 173, 152, -1));

        jButtonDodajStavku.setText("Dodaj stavku");
        jPanel1.add(jButtonDodajStavku, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 73, -1, -1));

        jButtonObrisiStavku.setText("Obriši stavku");
        jPanel1.add(jButtonObrisiStavku, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 114, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 151, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldVremeDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldVremeDoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldVremeDoActionPerformed

    private void jButtonPromeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPromeniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonPromeniActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDodajStavku;
    private javax.swing.JButton jButtonObrisiStavku;
    private javax.swing.JButton jButtonOdustani;
    private javax.swing.JButton jButtonPrikazi;
    private javax.swing.JButton jButtonPromeni;
    private javax.swing.JButton jButtonSacuvaj;
    private javax.swing.JButton jButtonZapamti;
    private javax.swing.JComboBox<Bicikla> jComboBoxBicikla;
    private javax.swing.JComboBox<Kupac> jComboBoxKupac;
    private javax.swing.JComboBox<Prodavac> jComboBoxProdavci;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableStavkeIznajmljivanja;
    private javax.swing.JTextField jTextFieldUkupanIznos;
    private javax.swing.JTextField jTextFieldVremeDo;
    private javax.swing.JTextField jTextFieldVremeOd;
    // End of variables declaration//GEN-END:variables

    public void ZapamtiAddActionListeners(ActionListener actionListener) {
        jButtonZapamti.addActionListener(actionListener);
    }

    public void OdustaniAddActionListeners(ActionListener actionListener) {
        jButtonOdustani.addActionListener(actionListener);
    }

    public void PromeniAddActionListeners(ActionListener actionListener) {
        jButtonSacuvaj.addActionListener(actionListener);
    }

    public void PromeniIznajmljivanjeAddActionListeners(ActionListener actionListener) {
        jButtonPromeni.addActionListener(actionListener);
    }

    public void PrikaziAddActionListeners(ActionListener actionListener) {
        jButtonPrikazi.addActionListener(actionListener);
    }

    public void DodajStavkuAddActionListeners(ActionListener actionListener) {
        jButtonDodajStavku.addActionListener(actionListener);
    }

    public void ObrisiStavkuAddActionListeners(ActionListener actionListener) {
        jButtonObrisiStavku.addActionListener(actionListener);
    }
}
