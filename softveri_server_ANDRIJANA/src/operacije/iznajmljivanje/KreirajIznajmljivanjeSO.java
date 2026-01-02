/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.iznajmljivanje;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import model.Iznajmljivanje;
import model.StavkaIznajmljivanja;
import operacije.ApstraktnaGenerickaOperacija;
import repozitorijum.db.DBKonekcija;

/**
 *
 * @author HP
 */
public class KreirajIznajmljivanjeSO extends ApstraktnaGenerickaOperacija {

    private boolean uspesno = false;
    private boolean postoji = false;

    public boolean getUspesno() {
        return uspesno;
    }
    
    @Override
    protected void preduslovi(Object objekat) throws Exception {
        if (objekat == null || !(objekat instanceof Iznajmljivanje)) {
            throw new Exception("Nije prosleđen parametar odgovarajućeg tipa.");
        }

        int brStavki = ((Iznajmljivanje) objekat).getListaStavkiIznajmljivanja().size();
        int brIstih = 0;

        try {
            String upit = "SELECT * FROM bicikla b JOIN stavkaiznajmljivanja si ON b.idBicikla=si.idBicikla JOIN iznajmljivanje i ON i.idIznajmljivanje=si.idIznajmljivanje JOIN prodavac p ON i.idProdavac=p.idProdavac JOIN kupac k ON k.idKupac=i.idKupac WHERE i.ukupanIznos=" + ((Iznajmljivanje) objekat).getUkupanIznos() + " AND p.idProdavac=" + ((Iznajmljivanje) objekat).getProdavac().getIdProdavac()+ " AND k.idKupac=" + ((Iznajmljivanje) objekat).getKupac().getIdKupac();
            Statement st = DBKonekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);

            while (rs.next()) {
                double cena = rs.getDouble("si.cena");
                double iznos = rs.getDouble("si.iznos");
                int brojSati = rs.getInt("si.brojSati");
                int brojDana = rs.getInt("si.brojDana");
                Date vremeOd = rs.getTimestamp("si.vremeOd");
                Date vremeDo = rs.getTimestamp("si.vremeDo");
                String tipBicikle = rs.getString("b.tip");

                for (StavkaIznajmljivanja stavka : ((Iznajmljivanje) objekat).getListaStavkiIznajmljivanja()) {
                    if (stavka.getCena() == cena &&
                        stavka.getIznos() == iznos &&
                        stavka.getBrojSati() == brojSati &&
                        stavka.getBrojDana() == brojDana &&
                        stavka.getVremeOd().equals(vremeOd) &&
                        stavka.getVremeDo().equals(vremeDo) &&
                        stavka.getBicikla().getTip().equals(tipBicikle)) {
                        brIstih++;
                    }
                }
            }

            if (brIstih == brStavki) {
                postoji = true;
            }


        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    protected void izvrsi(Object objekat, Object kljuc) throws Exception {
            if (!postoji) {
            Iznajmljivanje iznajmljivanje = (Iznajmljivanje) objekat;

            broker.add(iznajmljivanje);

            int ID = -1;
            try {
                String upit = "SELECT * FROM iznajmljivanje WHERE idKupac = " + iznajmljivanje.getKupac().getIdKupac() +
                              " AND idProdavac = " + iznajmljivanje.getProdavac().getIdProdavac() +
                              " AND ukupanIznos = " + iznajmljivanje.getUkupanIznos();

                Statement st = DBKonekcija.getInstance().getConnection().createStatement();
                ResultSet rs = st.executeQuery(upit);

                while (rs.next()) {
                    ID = rs.getInt("idIznajmljivanje");
                }

            } catch (SQLException ex) {
                throw ex;
            }

            iznajmljivanje.setIdIznajmljivanje(ID);

            for (StavkaIznajmljivanja stavka : iznajmljivanje.getListaStavkiIznajmljivanja()) {
                stavka.setIznajmljivanje(iznajmljivanje);
                broker.add(stavka);
            }

            uspesno = true;
        }
    }


    
}
