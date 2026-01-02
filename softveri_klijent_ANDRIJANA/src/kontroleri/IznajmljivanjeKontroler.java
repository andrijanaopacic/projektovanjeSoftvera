/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import forme.KreirajIznajmljivanje;
import forme.PretraziIznajmljivanje;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import koordinator.Koordinator;
import model.Bicikla;
import model.Iznajmljivanje;
import model.Kupac;
import model.Prodavac;
import model.StavkaIznajmljivanja;
import modeli.ModelTabeleIznajmljivanje;
import modeli.ModelTabeleStavkaIznajmljivanja;

/**
 *
 * @author HP
 */
public class IznajmljivanjeKontroler {
    
    private final KreirajIznajmljivanje ki;
    private final PretraziIznajmljivanje pi;

    public IznajmljivanjeKontroler(KreirajIznajmljivanje ki, PretraziIznajmljivanje pi) {
        this.ki = ki;
        this.pi = pi;
        addActionListeners();
    }
    
    private void addActionListeners() {
        ki.ZapamtiAddActionListeners(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zapamti();
            }

            private void zapamti() {

                Prodavac prodavac = null;
                Kupac kupac = null;
                double ukupanIznos = 0;
                List<StavkaIznajmljivanja> stavke = new ArrayList<>();

                try {
                    prodavac = (Prodavac) ki.getjComboBoxProdavci().getSelectedItem();
                    kupac = (Kupac) ki.getjComboBoxKupac().getSelectedItem();
                    ukupanIznos = Double.parseDouble(ki.getjTextFieldUkupanIznos().getText().trim());

                    ModelTabeleStavkaIznajmljivanja mt = (ModelTabeleStavkaIznajmljivanja) ki.getjTableStavkeIznajmljivanja().getModel();
                    stavke = mt.getStavke();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ki, "Greška pri unosu iznosa.", "Greška", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (prodavac == null || kupac == null || stavke.isEmpty()) {
                    JOptionPane.showMessageDialog(ki, "Niste uneli sve podatke.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (ukupanIznos <= 0) {
                    JOptionPane.showMessageDialog(ki, "Ukupan iznos mora biti veći od 0.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                
                Iznajmljivanje iznajmljivanje = new Iznajmljivanje();
                iznajmljivanje.setKupac(kupac);
                iznajmljivanje.setProdavac(prodavac);
                iznajmljivanje.setUkupanIznos(ukupanIznos);
                iznajmljivanje.setListaStavkiIznajmljivanja(stavke);

                for (StavkaIznajmljivanja stavka : stavke) {
                    stavka.setIznajmljivanje(iznajmljivanje);
                }

                boolean uspesno = Komunikacija.getInstance().kreirajIznajmljivanje(iznajmljivanje);

                if (!uspesno) {
                    JOptionPane.showMessageDialog(ki, "Sistem ne može da zapamti iznajmljivanje.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(ki, "Sistem je zapamtio iznajmljivanje.", "Uspešno", JOptionPane.INFORMATION_MESSAGE);
                    ki.dispose();
                }
            }
            });
            
            ki.PromeniAddActionListeners(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                promeni();

            }

            
            private void promeni() {
                Prodavac prodavac = null;
                Kupac kupac = null;
                List<StavkaIznajmljivanja> stavke = new ArrayList<>();
                double ukupanIznos = 0.0;

                try {
                    prodavac = (Prodavac) ki.getjComboBoxProdavci().getSelectedItem();
                    kupac = (Kupac) ki.getjComboBoxKupac().getSelectedItem();

                    ModelTabeleStavkaIznajmljivanja mt = (ModelTabeleStavkaIznajmljivanja) ki.getjTableStavkeIznajmljivanja().getModel();
                    stavke = mt.getStavke();

                    if (prodavac == null || kupac == null || stavke == null || stavke.isEmpty()) {
                        JOptionPane.showMessageDialog(ki, "Niste uneli sve podatke.", "Greška", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    for (StavkaIznajmljivanja stavka : stavke) {
                        LocalDateTime vremeOd = stavka.getVremeOd();
                        LocalDateTime vremeDo = stavka.getVremeDo();
                        
                        if (vremeOd.isAfter(vremeDo) || vremeOd.isEqual(vremeDo)) {
                            JOptionPane.showMessageDialog(ki, "Vreme početka mora biti pre vremena završetka.", "Greška", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                        if (vremeOd.isAfter(LocalDateTime.now()) || vremeDo.isAfter(LocalDateTime.now())) {
                            JOptionPane.showMessageDialog(ki, "Vreme iznajmljivanja ne može biti u budućnosti.", "Greška", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        long trajanje = java.time.Duration.between(vremeOd, vremeDo).toHours();
                        int brojDana = (int) (trajanje / 24);
                        int brojSati = (int) (trajanje % 24);

                        Bicikla bicikla = stavka.getBicikla();

                        StavkaIznajmljivanja novaStavka = new StavkaIznajmljivanja(
                            bicikla,
                            stavka.getIdStavkaIznajmljivanja(),
                            0,
                            0,
                            vremeOd,
                            vremeDo,
                            brojSati,
                            brojDana,
                            null
                        );

                        ukupanIznos += novaStavka.getIznos();
                        stavka.setCena(novaStavka.getCena());
                        stavka.setIznos(novaStavka.getIznos());
                        stavka.setBrojSati(brojSati);
                        stavka.setBrojDana(brojDana);
                    }

                    if (ukupanIznos <= 0) {
                        JOptionPane.showMessageDialog(ki, "Ukupan iznos mora biti veći od 0.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ki, "Greška pri unosu ili obradi podataka.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Iznajmljivanje iznajmljivanje = new Iznajmljivanje(
                    ki.getIznajmljivanje().getIdIznajmljivanje(),
                    ukupanIznos,
                    stavke,
                    kupac,
                    prodavac
                );

                for (StavkaIznajmljivanja stavka : stavke) {
                    stavka.setIznajmljivanje(iznajmljivanje);
                }

                int odluka = JOptionPane.showConfirmDialog(ki, "Da li ste sigurni da želite da sačuvate promene?", "Potvrda", JOptionPane.YES_NO_OPTION);
                if (odluka == JOptionPane.YES_OPTION) {
                    boolean uspesno = Komunikacija.getInstance().promeniIznajmljivanje(iznajmljivanje);

                    if (!uspesno) {
                        JOptionPane.showMessageDialog(ki, "Sistem ne može da zapamti iznajmljivanje.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(ki, "Sistem je zapamtio iznajmljivanje.", "Uspešno", JOptionPane.INFORMATION_MESSAGE);
                        ki.dispose();
                    }
                }
            }
            
            });
        
        ki.OdustaniAddActionListeners(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                odustani();

            }

            private void odustani() {

                int izbor = JOptionPane.showConfirmDialog(ki, "Da li ste sigurni da želite da odustanete?", "Potvrda", JOptionPane.YES_NO_OPTION);
                if (izbor == 0) {
                    ki.dispose();
                }

            }
        });
        
        ki.PromeniIznajmljivanjeAddActionListeners(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                promeni();

            }

            private void promeni() {

                ki.getjComboBoxProdavci().setEnabled(true);
                ki.getjComboBoxKupac().setEnabled(true);
                ki.getjComboBoxBicikla().setEnabled(true);
                ki.getjTextFieldVremeOd().setEditable(true);
                ki.getjTextFieldVremeDo().setEditable(true);
                ki.getjButtonDodajStavku().setVisible(true);
                ki.getjButtonSacuvaj().setVisible(true);
                ki.getjButtonZapamti().setVisible(false);
                ki.getjButtonOdustani().setVisible(true);
                ki.getjButtonObrisiStavku().setVisible(true);
                ki.getjButtonPrikazi().setVisible(true);
                ki.getjButtonPromeni().setVisible(false);
                ki.getjTextFieldUkupanIznos().setEditable(false);

            }
        });
        
        ki.PrikaziAddActionListeners(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            prikazi();
        }

        private void prikazi() {
            String datumOd = null;
            String datumDo = null;

            try {
                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy. HH:mm:ss");
                if (!ki.getIznajmljivanje().getListaStavkiIznajmljivanja().isEmpty()) {
                    StavkaIznajmljivanja stavka = ki.getIznajmljivanje().getListaStavkiIznajmljivanja().get(0);
                    datumOd = format.format(java.sql.Timestamp.valueOf(stavka.getVremeOd()));
                    datumDo = format.format(java.sql.Timestamp.valueOf(stavka.getVremeDo()));
                    ki.getjTextFieldVremeOd().setText(datumOd);
                    ki.getjTextFieldVremeDo().setText(datumDo);
                    ki.getjComboBoxBicikla().setSelectedItem(stavka.getBicikla());
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(ki, "Greška prilikom obrade datuma.", "Greška", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ki.getjTextFieldUkupanIznos().setText(String.valueOf(ki.getIznajmljivanje().getUkupanIznos()));
            ki.getjComboBoxProdavci().setSelectedItem(ki.getIznajmljivanje().getProdavac());
            ki.getjComboBoxKupac().setSelectedItem(ki.getIznajmljivanje().getKupac());

            ki.getjTextFieldVremeOd().setEnabled(false);
            ki.getjTextFieldVremeDo().setEnabled(false);
            ki.getjComboBoxBicikla().setEnabled(false);
            ki.getjComboBoxProdavci().setEnabled(false);
            ki.getjComboBoxKupac().setEnabled(false);
            ki.getjButtonDodajStavku().setVisible(false);
            ki.getjButtonSacuvaj().setVisible(false);
            ki.getjButtonZapamti().setVisible(false);
            ki.getjButtonOdustani().setVisible(false);
            ki.getjButtonObrisiStavku().setVisible(false);
            ki.getjButtonPrikazi().setVisible(false);
            ki.getjButtonPromeni().setVisible(true);
            ki.getjTextFieldUkupanIznos().setEditable(false);
        }
    });
        
        ki.DodajStavkuAddActionListeners(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dodajStavku();
        }

        private void dodajStavku() {
            Bicikla bicikla = null;
            LocalDateTime vremeOd = null;
            LocalDateTime vremeDo = null;

            try {
                bicikla = (Bicikla) ki.getjComboBoxBicikla().getSelectedItem();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm:ss");

                vremeOd = LocalDateTime.parse(ki.getjTextFieldVremeOd().getText().trim(), formatter);
                vremeDo = LocalDateTime.parse(ki.getjTextFieldVremeDo().getText().trim(), formatter);
                
                if (vremeOd.isAfter(vremeDo) || vremeOd.isEqual(vremeDo)) {
                            JOptionPane.showMessageDialog(ki, "Vreme početka mora biti pre vremena završetka.", "Greška", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                        if (vremeOd.isAfter(LocalDateTime.now()) || vremeDo.isAfter(LocalDateTime.now())) {
                            JOptionPane.showMessageDialog(ki, "Vreme iznajmljivanja ne može biti u budućnosti.", "Greška", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(ki, "Greška pri unosu bicikle ili vremena. Proverite format datuma i vremena.", "Greška", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (bicikla == null || vremeOd == null || vremeDo == null) {
                JOptionPane.showMessageDialog(ki, "Niste uneli sve podatke.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (vremeDo.isBefore(vremeOd)) {
                JOptionPane.showMessageDialog(ki, "Vreme do mora biti posle vremena od.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                return;
            }

            long trajanje = Duration.between(vremeOd, vremeDo).toHours();
            int brojDana = (int) (trajanje / 24);
            int brojSati = (int) (trajanje % 24);

            ModelTabeleStavkaIznajmljivanja mt = (ModelTabeleStavkaIznajmljivanja) ki.getjTableStavkeIznajmljivanja().getModel();
            List<StavkaIznajmljivanja> stavke = mt.getStavke();
            int idStavke = stavke.size() + 1;

            StavkaIznajmljivanja stavka = new StavkaIznajmljivanja(
                bicikla,
                idStavke,
                0.0,
                0.0,
                vremeOd,
                vremeDo,
                brojSati,
                brojDana,
                null
            );

            if (stavke.contains(stavka)) {
                JOptionPane.showMessageDialog(ki, "Ova stavka je već dodata.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
            } else {
                mt.dodajElement(stavka);
            }

            double ukupno = 0;
            for (StavkaIznajmljivanja s : mt.getStavke()) {
                ukupno += s.getIznos();
            }

            double ukupno2Decimale = Math.round(ukupno * 100.0) / 100.0;
            ki.getjTextFieldUkupanIznos().setText(String.valueOf(ukupno2Decimale));
        }
    });

        ki.ObrisiStavkuAddActionListeners(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            obrisiStavku();
        }

        private void obrisiStavku() {
            int selektovaniRed = ki.getjTableStavkeIznajmljivanja().getSelectedRow();

            if (selektovaniRed == -1) {
                JOptionPane.showMessageDialog(ki, "Morate izabrati stavku koju želite da obrišete.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                return;
            }

            ModelTabeleStavkaIznajmljivanja mt = (ModelTabeleStavkaIznajmljivanja) ki.getjTableStavkeIznajmljivanja().getModel();
            mt.getStavke().remove(selektovaniRed);
            mt.refresujPodatke();

            int noviId = 1;
            for (StavkaIznajmljivanja s : mt.getStavke()) {
                s.setIdStavkaIznajmljivanja(noviId++);
            }

            double ukupno = 0;
            for (StavkaIznajmljivanja s : mt.getStavke()) {
                ukupno += s.getIznos();
            }

            double ukupno2Decimale = Math.round(ukupno * 100.0) / 100.0;
            ki.getjTextFieldUkupanIznos().setText(String.valueOf(ukupno2Decimale));
        }
    });
        
        pi.VratiListuSvihIznajmljivanjaAddActionListeners(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            vratiListuSvihIznajmljivanja();
        }

        private void vratiListuSvihIznajmljivanja() {
            List<Iznajmljivanje> listaIznajmljivanja = Komunikacija.getInstance().vratiListuSvaIznajmljivanja();

            if (listaIznajmljivanja == null || listaIznajmljivanja.isEmpty()) {
                JOptionPane.showMessageDialog(pi, "Sistem ne može da nađe nijedno iznajmljivanje.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                JOptionPane.showMessageDialog(pi, "Sistem je uspešno pronašao iznajmljivanja.", "Uspešno", JOptionPane.INFORMATION_MESSAGE);
            }

            ModelTabeleIznajmljivanje mt = (ModelTabeleIznajmljivanje) pi.getjTableIznajmljivanja().getModel();
            mt.setLista(listaIznajmljivanja);
            mt.refresujPodatke();
        }
    });
        
        pi.VratiListuIznajmljivanjaSaUslovomAddActionListeners(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            vratiListuIznajmljivanjaSaUslovom();
        }

            private void vratiListuIznajmljivanjaSaUslovom() {
                List<Iznajmljivanje> listaIznajmljivanja = new ArrayList<>();
                int ID = Integer.MIN_VALUE;
                String prodavac = null;
                String kupac = null;
                String tipBicikle = null;

                try {

                    if (!pi.getjTextFieldID().getText().trim().isEmpty()) {
                        ID = Integer.parseInt(pi.getjTextFieldID().getText().trim());
                    }

                    if (!pi.getjTextFieldProdavac().getText().trim().isEmpty()) {
                        prodavac = pi.getjTextFieldProdavac().getText().trim();
                    }
                    if (!pi.getjTextFieldKupac().getText().trim().isEmpty()) {
                        kupac = pi.getjTextFieldKupac().getText().trim();
                    }
                    if (!pi.getjTextFieldBickla().getText().trim().isEmpty()) {
                        tipBicikle = pi.getjTextFieldBickla().getText().trim();
                    }
                } catch (NumberFormatException numberFormatException) {
                    JOptionPane.showMessageDialog(pi, "Greška pri unosu ili obradi podataka.", "Greška", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (ID == Integer.MIN_VALUE && prodavac == null && kupac == null && tipBicikle == null) {
                    JOptionPane.showMessageDialog(pi, "Morate uneti bar jedan kriterijum po kome želite da pretražite iznajmljivanja.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (ID != Integer.MIN_VALUE) {

                    List<Iznajmljivanje> lista = Komunikacija.getInstance().vratiIznajmljivanjaPoID(ID);

                    if (lista != null && !lista.isEmpty()) {
                        for (Iznajmljivanje i : lista) {
                            if (!listaIznajmljivanja.contains(i)) {
                                listaIznajmljivanja.add(i);
                            }

                        }
                    }
                }

                if (prodavac != null && prodavac.strip().split(" ").length >= 3) {
                    JOptionPane.showMessageDialog(pi, "Možete uneti samo ime i prezime za prodavca.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (kupac != null && kupac.strip().split(" ").length >= 3) {
                    JOptionPane.showMessageDialog(pi, "Možete uneti samo ime i prezime za kupca.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (prodavac != null) {
                    List<Iznajmljivanje> lista = Komunikacija.getInstance().vratiIznajmljivanjaPoImenuProdavca(prodavac);

                    if (lista != null && !lista.isEmpty()) {
                        for (Iznajmljivanje i : lista) {
                            if (!listaIznajmljivanja.contains(i)) {
                                listaIznajmljivanja.add(i);
                            }

                        }
                    }
                }
                if (kupac != null) {
                    List<Iznajmljivanje> lista = Komunikacija.getInstance().vratiIznajmljivanjaPoImenuKupca(kupac);

                    if (lista != null && !lista.isEmpty()) {
                        for (Iznajmljivanje i : lista) {
                            if (!listaIznajmljivanja.contains(i)) {
                                listaIznajmljivanja.add(i);
                            }

                        }
                    }
                }
                if (tipBicikle != null) {
                    Bicikla b = new Bicikla(tipBicikle);

                    List<Iznajmljivanje> lista = Komunikacija.getInstance().vratiIznajmljivanjaPoTipuBicikle(b);

                    if (lista != null && !lista.isEmpty()) {
                        for (Iznajmljivanje i : lista) {
                            if (!listaIznajmljivanja.contains(i)) {
                                listaIznajmljivanja.add(i);
                            }

                        }
                    }

                }

                if (listaIznajmljivanja.isEmpty()) {
                    JOptionPane.showMessageDialog(pi, "Sistem ne može da nađe iznajmljivanja po zadatim kriterijumima.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                    return;
                } else {
                    JOptionPane.showMessageDialog(pi, "Sistem je našao iznajmljivanja po zadatim kriterijumima.", "Uspešno", JOptionPane.INFORMATION_MESSAGE);

                }

                ModelTabeleIznajmljivanje mt = (ModelTabeleIznajmljivanje) pi.getjTableIznajmljivanja().getModel();
                mt.setLista(listaIznajmljivanja);
                mt.refresujPodatke();

            }

        });

        
        pi.PrikaziIznajmljivanjeAddActionListeners(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            prikaziIznajmljivanje();
        }

        private void prikaziIznajmljivanje() {
            int selektovaniRed = pi.getjTableIznajmljivanja().getSelectedRow();

            if (selektovaniRed == -1) {
                JOptionPane.showMessageDialog(pi, "Morate izabrati iznajmljivanje iz tabele.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                return;
            }

            ModelTabeleIznajmljivanje mt = (ModelTabeleIznajmljivanje) pi.getjTableIznajmljivanja().getModel();
            Iznajmljivanje iznajmljivanje = mt.getLista().get(selektovaniRed);
            Iznajmljivanje iznajmljivanjeDetalji = Komunikacija.getInstance().pretraziIznajmljivanje(iznajmljivanje);

            if (iznajmljivanjeDetalji == null) {
                JOptionPane.showMessageDialog(pi, "Sistem ne može da nađe iznajmljivanje.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                return;
            }

            pi.dispose();
            try {
                Koordinator.getInstance().otvoriKreirajIznajmljivanje(iznajmljivanjeDetalji);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(pi, "Sistem ne može da prikaže iznajmljivanje.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
            }
        }
    });

        pi.RadioIDAddActionListeners(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            radioID();
        }

        private void radioID() {
            pi.getjTextFieldID().setText("");
            pi.getjTextFieldProdavac().setText("");
            pi.getjTextFieldKupac().setText("");
            pi.getjTextFieldBickla().setText("");

            pi.getjTextFieldID().setEditable(true);
            pi.getjTextFieldProdavac().setEditable(false);
            pi.getjTextFieldKupac().setEditable(false);
            pi.getjTextFieldBickla().setEditable(false);
        }
    });
        
        pi.RadioProdavacAddActionListeners(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            radioProdavac();
        }

        private void radioProdavac() {
            pi.getjTextFieldID().setText("");
            pi.getjTextFieldProdavac().setText("");
            pi.getjTextFieldKupac().setText("");
            pi.getjTextFieldBickla().setText("");

            pi.getjTextFieldID().setEditable(false);
            pi.getjTextFieldProdavac().setEditable(true);
            pi.getjTextFieldKupac().setEditable(false);
            pi.getjTextFieldBickla().setEditable(false);
        }
    });
        
        pi.RadioKupacAddActionListeners(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            radioKupac();
        }

        private void radioKupac() {
            pi.getjTextFieldID().setText("");
            pi.getjTextFieldProdavac().setText("");
            pi.getjTextFieldKupac().setText("");
            pi.getjTextFieldBickla().setText("");

            pi.getjTextFieldID().setEditable(false);
            pi.getjTextFieldProdavac().setEditable(false);
            pi.getjTextFieldKupac().setEditable(true);
            pi.getjTextFieldBickla().setEditable(false);
        }
    });
        
        pi.RadioBiciklaAddActionListeners(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            radioBicikla();
        }

        private void radioBicikla() {
            pi.getjTextFieldID().setText("");
            pi.getjTextFieldProdavac().setText("");
            pi.getjTextFieldKupac().setText("");
            pi.getjTextFieldBickla().setText("");

            pi.getjTextFieldID().setEditable(false);
            pi.getjTextFieldProdavac().setEditable(false);
            pi.getjTextFieldKupac().setEditable(false);
            pi.getjTextFieldBickla().setEditable(true);
        }
    });









    }

    public void otvoriFormuKreirajIznajmljivanje(Iznajmljivanje iznajmljivanje) {
         if (iznajmljivanje == null) {
            ki.getjComboBoxKupac().setSelectedItem(null);
            ki.getjComboBoxProdavci().setSelectedItem(null);
            ki.getjComboBoxBicikla().setSelectedItem(null);
            ki.getjTextFieldUkupanIznos().setEditable(false);
            ki.getjTextFieldUkupanIznos().setText("0.0");

            popuniKupce();
            popuniProdavce();
            popuniBicikle();
            popuniTabeluStavki(null);

            ki.getjTextFieldVremeOd().setText("");
            ki.getjTextFieldVremeDo().setText("");

            ki.getjButtonPrikazi().setVisible(false);
            ki.getjButtonPromeni().setVisible(false);
            ki.getjButtonSacuvaj().setVisible(false);
            ki.getjButtonZapamti().setVisible(true);
            ki.getjButtonDodajStavku().setVisible(true);
            ki.getjButtonOdustani().setVisible(true);
            ki.getjButtonObrisiStavku().setVisible(true);

//            JOptionPane.showMessageDialog(ki, "Sistem je kreirao iznajmljivanje.", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
            ki.setVisible(true);

        } else {
            ki.getjComboBoxKupac().setSelectedItem(iznajmljivanje.getKupac());
            ki.getjComboBoxProdavci().setSelectedItem(iznajmljivanje.getProdavac());
            ki.getjComboBoxBicikla().setSelectedItem(null);
            ki.getjTextFieldUkupanIznos().setEditable(false);

            ki.getjComboBoxKupac().setEnabled(false);
            ki.getjComboBoxProdavci().setEnabled(false);
            ki.getjComboBoxBicikla().setEnabled(false);
            ki.getjTextFieldVremeOd().setEditable(false);
            ki.getjTextFieldVremeDo().setEditable(false);

            ki.getjButtonDodajStavku().setVisible(true);
            ki.getjButtonSacuvaj().setVisible(false);
            ki.getjButtonZapamti().setVisible(false);
            ki.getjButtonOdustani().setVisible(false);
            ki.getjButtonObrisiStavku().setVisible(false);
            ki.getjButtonPromeni().setVisible(true);
            ki.getjButtonPrikazi().setVisible(false);

            popuniKupce();
            popuniProdavce();
            popuniBicikle();

            List<StavkaIznajmljivanja> listaStavki = iznajmljivanje.getListaStavkiIznajmljivanja();
            popuniTabeluStavki(listaStavki);

            ki.getjTextFieldUkupanIznos().setText(String.valueOf(iznajmljivanje.getUkupanIznos()));
            ki.getjComboBoxKupac().setSelectedItem(iznajmljivanje.getKupac());
            ki.getjComboBoxProdavci().setSelectedItem(iznajmljivanje.getProdavac());
            ki.getjComboBoxBicikla().setSelectedItem(null);
            if (!listaStavki.isEmpty()) {
                StavkaIznajmljivanja prva = listaStavki.get(0);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm:ss");
                ki.getjTextFieldVremeOd().setText(prva.getVremeOd().format(formatter));
                ki.getjTextFieldVremeDo().setText(prva.getVremeDo().format(formatter));
            }

            JOptionPane.showMessageDialog(ki, "Sistem je našao iznajmljivanje.", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
            ki.setVisible(true);
        }

    }
    
    private void popuniKupce() {
        List<Kupac> listaKupaca = Komunikacija.getInstance().vratiListuSviKupci();

        ki.getjComboBoxKupac().removeAllItems();
        for (Kupac kupac : listaKupaca) {
            ki.getjComboBoxKupac().addItem(kupac);
        }
    }
    
    private void popuniProdavce() {
        List<Prodavac> listaProdavaca = Komunikacija.getInstance().vratiListuSviProdavci();

        ki.getjComboBoxProdavci().removeAllItems();
        for (Prodavac prodavac : listaProdavaca) {
            ki.getjComboBoxProdavci().addItem(prodavac);
        }
    }
    
    private void popuniBicikle() {
        List<Bicikla> listaBicikli = Komunikacija.getInstance().vratiListuSviBicikla();

        ki.getjComboBoxBicikla().removeAllItems();
        for (Bicikla bicikla : listaBicikli) {
            ki.getjComboBoxBicikla().addItem(bicikla);
        }
    }
    
    private void popuniTabeluStavki(List<StavkaIznajmljivanja> stavke) {
        List<StavkaIznajmljivanja> lista = new ArrayList<>();
        if (stavke != null) {
            lista = stavke;
        }
        ModelTabeleStavkaIznajmljivanja modelTabele = new ModelTabeleStavkaIznajmljivanja(lista);
        ki.getjTableStavkeIznajmljivanja().setModel(modelTabele);
    }   
    
    public void otvoriFormuPretraziIznajmljivanje() {
        pi.getjRadioButtonID().setSelected(true);
        pi.getjTextFieldID().setEditable(true);
        pi.getjTextFieldProdavac().setEditable(false);
        pi.getjTextFieldKupac().setEditable(false);
        pi.getjTextFieldBickla().setEditable(false);

        ButtonGroup group = new ButtonGroup();
        group.add(pi.getjRadioButtonID());
        group.add(pi.getjRadioButtonProdavac());
        group.add(pi.getjRadioButtonKupac());
        group.add(pi.getjRadioButtonBicikla());

        popuniTabeluIznajmljivanja();
        pi.setVisible(true);
    }
    
    private void popuniTabeluIznajmljivanja() {
        List<Iznajmljivanje> iznajmljivanja = new ArrayList<>();
        ModelTabeleIznajmljivanje modelTabele = new ModelTabeleIznajmljivanje(iznajmljivanja);
        pi.getjTableIznajmljivanja().setModel(modelTabele);
    }







    
}
