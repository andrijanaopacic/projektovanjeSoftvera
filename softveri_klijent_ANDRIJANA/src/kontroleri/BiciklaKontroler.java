/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import forme.KreirajBicikla;
import forme.PretraziBicikla;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import koordinator.Koordinator;
import model.Bicikla;
import modeli.ModelTabeleBicikla;

/**
 *
 * @author HP
 */
public class BiciklaKontroler {
    
    private final KreirajBicikla kb;
    private final PretraziBicikla pb;

    public BiciklaKontroler(KreirajBicikla kb, PretraziBicikla pb) {
        this.kb = kb;
        this.pb = pb;
        addActionListeners();
    }
    
    private void addActionListeners() {
        kb.ZapamtiAddActionListeners(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zapamti();

            }

            private void zapamti() {
                double cenaPoSatu = 0.0;
                double cenaPoDanu = 0.0;
                String tip = null;

                
                String cenaPoSatuText = kb.getjTextFieldCenaPoSatu().getText().trim();
                String cenaPoDanuText = kb.getjTextFieldCenaPoDanu().getText().trim();
                tip = kb.getjTextFieldTip().getText().trim();

                if (cenaPoSatuText.isEmpty() || cenaPoDanuText.isEmpty() || tip.isEmpty()) {
                    JOptionPane.showMessageDialog(kb, "Sva polja moraju biti popunjena.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    cenaPoSatu = Double.parseDouble(cenaPoSatuText);
                    cenaPoDanu = Double.parseDouble(cenaPoDanuText);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(kb, "Cena mora biti broj (npr. 120.5).", "Greška", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (tip.trim().length() > 30) {
                    JOptionPane.showMessageDialog(kb, "Naziv tipa bicikle može sadržati maksimalno 30 karaktera.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                    return;
                }


                Bicikla b = new Bicikla(tip, cenaPoSatu, cenaPoDanu);

                boolean uspesno = Komunikacija.getInstance().kreirajBicikla(b);
                if (!uspesno) {
                    JOptionPane.showMessageDialog(kb, "Sistem ne može da zapamti biciklu.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                } else {

                    JOptionPane.showMessageDialog(kb, "Sistem je zapamtio biciklu.", "Uspešno", JOptionPane.INFORMATION_MESSAGE);
                    kb.dispose();
                }
            }

        });
        
        kb.PromeniAddActionListeners(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                promeni();
            }

            private void promeni() {
                double cenaPoSatu = 0.0;
                double cenaPoDanu = 0.0;
                String tip = null;

                
                String cenaPoSatuText = kb.getjTextFieldCenaPoSatu().getText().trim();
                String cenaPoDanuText = kb.getjTextFieldCenaPoDanu().getText().trim();
                tip = kb.getjTextFieldTip().getText().trim();

                if (cenaPoSatuText.isEmpty() || cenaPoDanuText.isEmpty() || tip.isEmpty()) {
                    JOptionPane.showMessageDialog(kb, "Sva polja moraju biti popunjena.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    cenaPoSatu = Double.parseDouble(cenaPoSatuText);
                    cenaPoDanu = Double.parseDouble(cenaPoDanuText);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(kb, "Cena mora biti broj (npr. 120.5).", "Greška", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (tip.trim().length() > 30) {
                    JOptionPane.showMessageDialog(kb, "Naziv tipa bicikle može sadržati maksimalno 30 karaktera.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Bicikla b = new Bicikla(kb.getBicikla().getIdBicikla(),tip, cenaPoSatu, cenaPoDanu);

                int odgovor = JOptionPane.showConfirmDialog(kb, "Da li ste sigurni da želite da sačuvate unete promene?", "Potvrda", JOptionPane.YES_NO_OPTION);

                if (odgovor == 0) {
                    boolean uspesno = Komunikacija.getInstance().promeniBicikla(b);
                    if (!uspesno) {
                        JOptionPane.showMessageDialog(kb, "Sistem ne može da zapamti biciklu.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                    } else {

                        JOptionPane.showMessageDialog(kb, "Sistem je zapamtio biciklu.", "Uspešno", JOptionPane.INFORMATION_MESSAGE);
                        kb.dispose();
                    }
                }
            }

        });
        
        kb.ObrisiAddActionListeners(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obrisi();
            }

            private void obrisi() {
                int odgovor = JOptionPane.showConfirmDialog(kb, "Da li ste sigurni da želite da obrišete biciklu", "Potvrda", JOptionPane.YES_NO_OPTION);
                if (odgovor == 0) {
                    double cenaPoSatu = 0.0;
                    double cenaPoDanu = 0.0;
                    String tip = null;

                    String cenaPoSatuText = kb.getjTextFieldCenaPoSatu().getText().trim();
                    String cenaPoDanuText = kb.getjTextFieldCenaPoDanu().getText().trim();
                    tip = kb.getjTextFieldTip().getText().trim();
                    
                    try {
                        cenaPoSatu = Double.parseDouble(cenaPoSatuText);
                        cenaPoDanu = Double.parseDouble(cenaPoDanuText);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(kb, "Greška pri obradi podataka.", "Greška", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Bicikla b = new Bicikla(kb.getBicikla().getIdBicikla(),tip, cenaPoSatu, cenaPoDanu);

                    boolean uspesno = Komunikacija.getInstance().obrisiBicikla(b);
                    if (!uspesno) {
                        JOptionPane.showMessageDialog(kb, "Sistem ne može da obriše biciklu.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                    } else {

                        JOptionPane.showMessageDialog(kb, "Sistem je obrisao biciklu.", "Uspešno", JOptionPane.INFORMATION_MESSAGE);
                        kb.dispose();
                    }
                }
            }

        });
        
        kb.OdustaniAddActionListeners(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                odustani();
            }

            private void odustani() {
                int izbor = JOptionPane.showConfirmDialog(kb, "Da li ste sigurni da želite da odustanete?", "Potvrda", JOptionPane.YES_NO_OPTION);
                if (izbor == 0) {
                    kb.dispose();
                }
            }

        });
        
        kb.ObrisiBiciklaAddActionListeners(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obrisiBicikla();
            }

            private void obrisiBicikla() {
                kb.getjButtonSacuvaj().setVisible(false);
                kb.getjButtonZapamti().setVisible(false);
                kb.getjButtonOdustani().setVisible(true);
                kb.getjButtonObrisi().setVisible(true);
                kb.getjButtonPromeni().setVisible(true);
                kb.getjButtonObrisiBiciklu().setVisible(false);
                kb.getjButtonPrikaziObrisi().setVisible(true);
                kb.getjButtonPrikaziPromeni().setVisible(false);
                kb.getjTextFieldTip().setText(kb.getBicikla().getTip());
                kb.getjTextFieldCenaPoSatu().setText(String.valueOf(kb.getBicikla().getCenaPoSatu()));
                kb.getjTextFieldCenaPoDanu().setText(String.valueOf(kb.getBicikla().getCenaPoDanu()));
                kb.getjTextFieldCenaPoSatu().setEditable(false);
                kb.getjTextFieldCenaPoDanu().setEditable(false);
                kb.getjTextFieldTip().setEditable(false);
            }

        });
        
        kb.PrikaziObrisiAddActionListeners(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prikaziObrisi();
            }

            private void prikaziObrisi() {
                kb.getjButtonSacuvaj().setVisible(false);
                kb.getjButtonZapamti().setVisible(false);
                kb.getjButtonOdustani().setVisible(false);
                kb.getjButtonObrisi().setVisible(false);
                kb.getjButtonPromeni().setVisible(true);
                kb.getjButtonObrisiBiciklu().setVisible(true);
                kb.getjButtonPrikaziObrisi().setVisible(false);
                kb.getjButtonPrikaziPromeni().setVisible(false);
                kb.getjTextFieldTip().setText(kb.getBicikla().getTip());
                kb.getjTextFieldCenaPoSatu().setText(String.valueOf(kb.getBicikla().getCenaPoSatu()));
                kb.getjTextFieldCenaPoDanu().setText(String.valueOf(kb.getBicikla().getCenaPoDanu()));
                kb.getjTextFieldCenaPoSatu().setEditable(false);
                kb.getjTextFieldCenaPoDanu().setEditable(false);
                kb.getjTextFieldTip().setEditable(false);
            }

        });
        
        kb.PromeniBiciklaAddActionListeners(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                promeniBicikla();

            }

            private void promeniBicikla() {
                kb.getjButtonSacuvaj().setVisible(true);
                kb.getjButtonZapamti().setVisible(false);
                kb.getjButtonOdustani().setVisible(true);
                kb.getjButtonObrisi().setVisible(false);
                kb.getjButtonPromeni().setVisible(false);
                kb.getjButtonObrisiBiciklu().setVisible(true);
                kb.getjButtonPrikaziObrisi().setVisible(false);
                kb.getjButtonPrikaziPromeni().setVisible(true);
                kb.getjTextFieldCenaPoDanu().setEditable(true);
                kb.getjTextFieldCenaPoSatu().setEditable(true);
                kb.getjTextFieldTip().setEditable(true);
            }

        });
        
        kb.PrikaziPromeniAddActionListeners(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prikaziPromeni();

            }

            private void prikaziPromeni() {
                kb.getjButtonSacuvaj().setVisible(false);
                kb.getjButtonZapamti().setVisible(false);
                kb.getjButtonOdustani().setVisible(false);
                kb.getjButtonObrisi().setVisible(false);
                kb.getjButtonPromeni().setVisible(true);
                kb.getjButtonObrisiBiciklu().setVisible(true);
                kb.getjButtonPrikaziObrisi().setVisible(false);
                kb.getjButtonPrikaziPromeni().setVisible(false);
                kb.getjTextFieldTip().setText(kb.getBicikla().getTip());
                kb.getjTextFieldCenaPoSatu().setText(String.valueOf(kb.getBicikla().getCenaPoSatu()));
                kb.getjTextFieldCenaPoDanu().setText(String.valueOf(kb.getBicikla().getCenaPoDanu()));
                kb.getjTextFieldCenaPoSatu().setEditable(false);
                kb.getjTextFieldCenaPoDanu().setEditable(false);
                kb.getjTextFieldTip().setEditable(false);
            }

        });
        
        pb.VratiListuSviBicklaAddActionListeners(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vratiListuSviBicikla();
            }

            private void vratiListuSviBicikla() {

                List<Bicikla> lista = Komunikacija.getInstance().vratiListuSviBicikla();

                if (lista == null || lista.isEmpty()) {
                    JOptionPane.showMessageDialog(pb, "Sistem ne može da nađe sve bicikle.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                    return;
                } else {
                    JOptionPane.showMessageDialog(pb, "Sistem je našao sve bicikle.", "Uspešno", JOptionPane.INFORMATION_MESSAGE);

                }

                ModelTabeleBicikla mt = (ModelTabeleBicikla) pb.getjTableBicikle().getModel();
                mt.setLista(lista);
                mt.refresujPodatke();

            }
        });
        
        pb.VratiListuBiciklaSaUslovomAddActionListeners(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vratiListuBiciklaSaUslovom();
            }

            private void vratiListuBiciklaSaUslovom() {
                List<Bicikla> lista = new ArrayList<>();
                String tip = null;

                try {

                    if (!pb.getjTextFieldTip().getText().trim().isEmpty()) {
                        tip = pb.getjTextFieldTip().getText().trim();
                    }

                } catch (NumberFormatException numberFormatException) {
                    JOptionPane.showMessageDialog(pb, "Greška pri unosu ili obradi podataka.", "Greška", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                if (tip != null) {
                    Bicikla bicikla = new Bicikla(tip);

                    List<Bicikla> lista1 = Komunikacija.getInstance().vratiListuBiciklaBicikla(bicikla);

                    for (Bicikla b : lista1) {
                        if (!lista.contains(b)) {
                            lista.add(b);
                        }

                    }
                }

                if (lista.isEmpty()) {
                    JOptionPane.showMessageDialog(pb, "Sistem ne može da nađe biciklu po zadatom kriterijumu.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                    return;
                } else {
                    JOptionPane.showMessageDialog(pb, "Sistem je našao biciklu po zadatom kriterijumu.", "Uspešno", JOptionPane.INFORMATION_MESSAGE);
                }

                ModelTabeleBicikla mt = (ModelTabeleBicikla) pb.getjTableBicikle().getModel();
                mt.setLista(lista);
                mt.refresujPodatke();
            }
        });
        
        pb.PrikaziBiciklaAddActionListeners(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prikaziBicikla();
            }

            private void prikaziBicikla() {
                int selektovaniRed = pb.getjTableBicikle().getSelectedRow();

                if (selektovaniRed == -1) {
                    JOptionPane.showMessageDialog(pb, "Morate izabrati biciklu iz tabele.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                ModelTabeleBicikla mt = (ModelTabeleBicikla) pb.getjTableBicikle().getModel();
                Bicikla b = mt.getLista().get(selektovaniRed);
                Bicikla bDetalji = Komunikacija.getInstance().pretraziBicikla(b);
                if (bDetalji == null) {
                    JOptionPane.showMessageDialog(pb, "Sistem ne može da nađe biciklu.", "Upozorenje", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                pb.dispose();
                Koordinator.getInstance().otvoriKreirajBickikla(bDetalji);

            }
        });
        
        
    }
    
    public void otvoriFormuKreirajBicikla(Bicikla bicikla) {

        if (bicikla == null) {

            kb.getjButtonSacuvaj().setVisible(false);
            kb.getjButtonZapamti().setVisible(true);
            kb.getjButtonOdustani().setVisible(true);
            kb.getjButtonObrisi().setVisible(false);
            kb.getjButtonPromeni().setVisible(false);
            kb.getjButtonObrisiBiciklu().setVisible(false);
            kb.getjButtonPrikaziObrisi().setVisible(false);
            kb.getjButtonPrikaziPromeni().setVisible(false);
            JOptionPane.showMessageDialog(kb, "Sistem je kreirao biciklu.", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);

            kb.setVisible(true);

        } else {

            kb.getjButtonSacuvaj().setVisible(false);
            kb.getjButtonZapamti().setVisible(false);
            kb.getjButtonOdustani().setVisible(false);
            kb.getjButtonObrisi().setVisible(false);
            kb.getjButtonPromeni().setVisible(true);
            kb.getjButtonObrisiBiciklu().setVisible(true);
            kb.getjButtonPrikaziObrisi().setVisible(false);
            kb.getjButtonPrikaziPromeni().setVisible(false);
            kb.getjTextFieldTip().setText(kb.getBicikla().getTip());
            kb.getjTextFieldCenaPoSatu().setText(String.valueOf(kb.getBicikla().getCenaPoSatu()));
            kb.getjTextFieldCenaPoDanu().setText(String.valueOf(kb.getBicikla().getCenaPoDanu()));
            kb.getjTextFieldCenaPoSatu().setEditable(false);
            kb.getjTextFieldCenaPoDanu().setEditable(false);
            kb.getjTextFieldTip().setEditable(false);
            JOptionPane.showMessageDialog(kb, "Sistem je našao biciklu.", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);

            kb.setVisible(true);
        }

    }
    
    public void otvoriFormuPretraziBicikla() {
        popuniTabelu();
        pb.setVisible(true);
    }

    private void popuniTabelu() {

        List<Bicikla> bicikle = new ArrayList<>();
        ModelTabeleBicikla modelTabele = new ModelTabeleBicikla(bicikle);
        pb.getjTableBicikle().setModel(modelTabele);

    }
    
}
