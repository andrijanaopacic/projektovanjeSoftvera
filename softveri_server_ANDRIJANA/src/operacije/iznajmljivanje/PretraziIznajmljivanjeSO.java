/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.iznajmljivanje;

import java.util.List;
import model.Iznajmljivanje;
import model.StavkaIznajmljivanja;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author HP
 */
public class PretraziIznajmljivanjeSO extends ApstraktnaGenerickaOperacija{

    private Iznajmljivanje iznajmljivanje;

    public Iznajmljivanje getIznajmljivanje() {
        return iznajmljivanje;
    }
    
    @Override
    protected void preduslovi(Object objekat) throws Exception {
        if (objekat == null || !(objekat instanceof Iznajmljivanje)) {
            throw new Exception("Nije prosleđen parametar odgovarajućeg tipa.");
        }

    }

    @Override
    protected void izvrsi(Object objekat, Object kljuc) throws Exception {
        String upit1 = " JOIN prodavac ON prodavac.idProdavac = iznajmljivanje.idProdavac JOIN kupac ON iznajmljivanje.idKupac=kupac.idKupac JOIN mesto ON mesto.idMesto = kupac.idMesto WHERE iznajmljivanje.idIznajmljivanje = " + ((Iznajmljivanje) objekat).getIdIznajmljivanje();
        Iznajmljivanje i = (Iznajmljivanje) broker.getObject((Iznajmljivanje) objekat, upit1);
        String upit2 = " JOIN bicikla ON bicikla.idBicikla=stavkaiznajmljivanja.idBicikla WHERE idIznajmljivanje=" + i.getIdIznajmljivanje();
        List<StavkaIznajmljivanja> stavke = broker.getAll(new StavkaIznajmljivanja(), upit2);
        i.setListaStavkiIznajmljivanja(stavke);

        this.iznajmljivanje = i;
    }
}
