/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forme;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import model.Bicikla;

/**
 *
 * @author HP
 */
public class KreirajBicikla extends javax.swing.JDialog {

    private GlavnaForma gf;
    private Bicikla bicikla;
    
    public KreirajBicikla(java.awt.Frame parent, boolean modal, Bicikla bicikla) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false);
        this.setTitle("Kreiraj biciklu");
        this.setPreferredSize(new Dimension(650, 500)); 
        this.setMinimumSize(new Dimension(650, 500));
        this.setMaximumSize(new Dimension(650, 500));

        this.gf = (GlavnaForma) parent;
        this.bicikla = bicikla;
    }

    public GlavnaForma getGf() {
        return gf;
    }

    public void setGf(GlavnaForma gf) {
        this.gf = gf;
    }

    public Bicikla getBicikla() {
        return bicikla;
    }

    public void setBicikla(Bicikla bicikla) {
        this.bicikla = bicikla;
    }

    public JButton getjButtonObrisi() {
        return jButtonObrisi;
    }

    public void setjButtonObrisi(JButton jButtonObrisi) {
        this.jButtonObrisi = jButtonObrisi;
    }

    public JButton getjButtonObrisiBiciklu() {
        return jButtonObrisiBiciklu;
    }

    public void setjButtonObrisiBiciklu(JButton jButtonObrisiBiciklu) {
        this.jButtonObrisiBiciklu = jButtonObrisiBiciklu;
    }

    public JButton getjButtonOdustani() {
        return jButtonOdustani;
    }

    public void setjButtonOdustani(JButton jButtonOdustani) {
        this.jButtonOdustani = jButtonOdustani;
    }

    public JButton getjButtonPrikaziObrisi() {
        return jButtonPrikaziObrisi;
    }

    public void setjButtonPrikaziObrisi(JButton jButtonPrikaziObrisi) {
        this.jButtonPrikaziObrisi = jButtonPrikaziObrisi;
    }

    public JButton getjButtonPrikaziPromeni() {
        return jButtonPrikaziPromeni;
    }

    public void setjButtonPrikaziPromeni(JButton jButtonPrikaziPromeni) {
        this.jButtonPrikaziPromeni = jButtonPrikaziPromeni;
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

    public JTextField getjTextFieldCenaPoDanu() {
        return jTextFieldCenaPoDanu;
    }

    public void setjTextFieldCenaPoDanu(JTextField jTextFieldCenaPoDanu) {
        this.jTextFieldCenaPoDanu = jTextFieldCenaPoDanu;
    }

    public JTextField getjTextFieldCenaPoSatu() {
        return jTextFieldCenaPoSatu;
    }

    public void setjTextFieldCenaPoSatu(JTextField jTextFieldCenaPoSatu) {
        this.jTextFieldCenaPoSatu = jTextFieldCenaPoSatu;
    }

    public JTextField getjTextFieldTip() {
        return jTextFieldTip;
    }

    public void setjTextFieldTip(JTextField jTextFieldTip) {
        this.jTextFieldTip = jTextFieldTip;
    }

    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldTip = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCenaPoSatu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCenaPoDanu = new javax.swing.JTextField();
        jButtonObrisiBiciklu = new javax.swing.JButton();
        jButtonPrikaziObrisi = new javax.swing.JButton();
        jButtonPromeni = new javax.swing.JButton();
        jButtonPrikaziPromeni = new javax.swing.JButton();
        jButtonOdustani = new javax.swing.JButton();
        jButtonObrisi = new javax.swing.JButton();
        jButtonSacuvaj = new javax.swing.JButton();
        jButtonZapamti = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Bicikla");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 29, -1, -1));

        jLabel2.setText("Tip bicikle:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 77, -1, -1));
        getContentPane().add(jTextFieldTip, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 74, 211, -1));

        jLabel3.setText("Cena po satu:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 133, -1, -1));
        getContentPane().add(jTextFieldCenaPoSatu, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 130, 211, -1));

        jLabel4.setText("Cena po danu:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 187, -1, -1));
        getContentPane().add(jTextFieldCenaPoDanu, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 184, 211, -1));

        jButtonObrisiBiciklu.setText("Obriši biciklu");
        getContentPane().add(jButtonObrisiBiciklu, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 256, 174, -1));

        jButtonPrikaziObrisi.setText("Prikaži biciklu");
        getContentPane().add(jButtonPrikaziObrisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 256, 174, -1));

        jButtonPromeni.setText("Promeni biciklu");
        getContentPane().add(jButtonPromeni, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 305, 174, -1));

        jButtonPrikaziPromeni.setText("Prikaži biciklu");
        getContentPane().add(jButtonPrikaziPromeni, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 305, 174, -1));

        jButtonOdustani.setText("Odustani");
        getContentPane().add(jButtonOdustani, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 305, 174, -1));

        jButtonObrisi.setText("Obriši");
        getContentPane().add(jButtonObrisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 256, 174, -1));

        jButtonSacuvaj.setText("Sačuvaj");
        getContentPane().add(jButtonSacuvaj, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 256, 174, -1));

        jButtonZapamti.setText("Zapamti");
        getContentPane().add(jButtonZapamti, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 256, 174, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonObrisi;
    private javax.swing.JButton jButtonObrisiBiciklu;
    private javax.swing.JButton jButtonOdustani;
    private javax.swing.JButton jButtonPrikaziObrisi;
    private javax.swing.JButton jButtonPrikaziPromeni;
    private javax.swing.JButton jButtonPromeni;
    private javax.swing.JButton jButtonSacuvaj;
    private javax.swing.JButton jButtonZapamti;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextFieldCenaPoDanu;
    private javax.swing.JTextField jTextFieldCenaPoSatu;
    private javax.swing.JTextField jTextFieldTip;
    // End of variables declaration//GEN-END:variables

    public void ZapamtiAddActionListeners(ActionListener actionListener) {
        jButtonZapamti.addActionListener(actionListener);
    }

    public void PromeniAddActionListeners(ActionListener actionListener) {
        jButtonSacuvaj.addActionListener(actionListener);
    }

    public void ObrisiAddActionListeners(ActionListener actionListener) {
        jButtonObrisi.addActionListener(actionListener);
    }

    public void OdustaniAddActionListeners(ActionListener actionListener) {
        jButtonOdustani.addActionListener(actionListener);
    }

    public void ObrisiBiciklaAddActionListeners(ActionListener actionListener) {
        jButtonObrisiBiciklu.addActionListener(actionListener);
    }

    public void PrikaziObrisiAddActionListeners(ActionListener actionListener) {
        jButtonPrikaziObrisi.addActionListener(actionListener);
    }

    public void PromeniBiciklaAddActionListeners(ActionListener actionListener) {
        jButtonPromeni.addActionListener(actionListener);
    }

    public void PrikaziPromeniAddActionListeners(ActionListener actionListener) {
        jButtonPrikaziPromeni.addActionListener(actionListener);
    }
    
}
