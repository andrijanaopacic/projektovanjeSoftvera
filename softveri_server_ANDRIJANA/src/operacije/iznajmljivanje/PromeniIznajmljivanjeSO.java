/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.iznajmljivanje;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Iznajmljivanje;
import model.StavkaIznajmljivanja;
import operacije.ApstraktnaGenerickaOperacija;
import repozitorijum.db.DBKonekcija;

/**
 *
 * @author HP
 */
public class PromeniIznajmljivanjeSO extends ApstraktnaGenerickaOperacija {

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
            String upit = "SELECT * FROM bicikla b " +
                          "JOIN stavkaiznajmljivanja si ON b.idBicikla = si.idBicikla " +
                          "JOIN iznajmljivanje i ON i.idIznajmljivanje = si.idIznajmljivanje " +
                          "JOIN prodavac p ON i.idProdavac = p.idProdavac " +
                          "JOIN kupac k ON i.idKupac = k.idKupac " +
                          "WHERE i.ukupanIznos = " + ((Iznajmljivanje) objekat).getUkupanIznos() +
                          " AND p.idProdavac = " + ((Iznajmljivanje) objekat).getProdavac().getIdProdavac() +
                          " AND k.idKupac = " + ((Iznajmljivanje) objekat).getKupac().getIdKupac();

            Statement st = DBKonekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);

            while (rs.next()) {
                double cena = rs.getDouble("si.cena");
                double iznos = rs.getDouble("si.iznos");
                int brojSati = rs.getInt("si.brojSati");
                int brojDana = rs.getInt("si.brojDana");
                LocalDateTime vremeOdBaza = rs.getTimestamp("si.vremeOd").toLocalDateTime();
                LocalDateTime vremeDoBaza = rs.getTimestamp("si.vremeDo").toLocalDateTime();
                String tipBicikle = rs.getString("b.tip");

                for (StavkaIznajmljivanja stavka : ((Iznajmljivanje) objekat).getListaStavkiIznajmljivanja()) {
                    if (stavka.getCena() == cena &&
                        stavka.getIznos() == iznos &&
                        stavka.getBrojSati() == brojSati &&
                        stavka.getBrojDana() == brojDana &&
                        stavka.getVremeOd().equals(vremeOdBaza) &&
                        stavka.getVremeDo().equals(vremeDoBaza) &&
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
            Iznajmljivanje iznajmljivanjeZaPromenu = (Iznajmljivanje) objekat;
            List<StavkaIznajmljivanja> stavkeProsledjene = iznajmljivanjeZaPromenu.getListaStavkiIznajmljivanja();

            String upit = " JOIN bicikla ON bicikla.idBicikla=stavkaiznajmljivanja.idBicikla " +
                          "JOIN iznajmljivanje ON iznajmljivanje.idIznajmljivanje=stavkaiznajmljivanja.idIznajmljivanje " +
                          "WHERE iznajmljivanje.idIznajmljivanje=" + iznajmljivanjeZaPromenu.getIdIznajmljivanje();

            List<StavkaIznajmljivanja> stavkeIzBaze = broker.getAll(new StavkaIznajmljivanja(), upit);
            
            for (StavkaIznajmljivanja stBaza : stavkeIzBaze) {
                boolean postojiUListiProsledjenih = false;
                for (StavkaIznajmljivanja st : stavkeProsledjene) {
                    if (stBaza.getIdStavkaIznajmljivanja() == st.getIdStavkaIznajmljivanja()) {
                        postojiUListiProsledjenih = true;
                        break;
                    }
                }
                if (!postojiUListiProsledjenih) {
                    stBaza.setIznajmljivanje(iznajmljivanjeZaPromenu);
                    broker.delete(stBaza);
                }
            }

            for (StavkaIznajmljivanja st : stavkeProsledjene) {
                boolean postojiUBazi = false;

                for (StavkaIznajmljivanja stBaza : stavkeIzBaze) {
                    if (st.getIdStavkaIznajmljivanja() == stBaza.getIdStavkaIznajmljivanja()) {
                        postojiUBazi = true;
                        break;
                    }
                }

                if (postojiUBazi) {
                    broker.edit(st);
                } else {
                    st.setIznajmljivanje(iznajmljivanjeZaPromenu);
                    broker.add(st);
                }
            }

            broker.edit(iznajmljivanjeZaPromenu);
            uspesno = true;
        }
}

}
    



    
