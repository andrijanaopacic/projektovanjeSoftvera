/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.iznajmljivanje;

import java.util.List;
import model.Bicikla;
import model.Iznajmljivanje;
import model.StavkaIznajmljivanja;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author HP
 */
public class VratiListuIznajmljivanjeBiciklaSO extends ApstraktnaGenerickaOperacija{

    private List<Iznajmljivanje> lista;

    public List<Iznajmljivanje> getLista() {
        return lista;
    }
    
    @Override
    protected void preduslovi(Object objekat) throws Exception {
        if (objekat == null || !(objekat instanceof Iznajmljivanje)) {
            throw new Exception("Nije prosleđen parametar odgovarajućeg tipa.");
        }
    }

    @Override
    protected void izvrsi(Object objekat, Object kljuc) throws Exception {

        String upit1 = " JOIN prodavac ON prodavac.idProdavac = iznajmljivanje.idProdavac " +
                   "JOIN kupac ON kupac.idKupac = iznajmljivanje.idKupac " +
                   "JOIN mesto ON mesto.idMesto = kupac.idMesto " +
                   "JOIN stavkaiznajmljivanja ON stavkaiznajmljivanja.idIznajmljivanje = iznajmljivanje.idIznajmljivanje " +
                   "JOIN bicikla ON bicikla.idBicikla = stavkaiznajmljivanja.idBicikla";

        Bicikla biciklaUslov = (Bicikla) kljuc;

        if (biciklaUslov.getTip() != null) {
            upit1 += " WHERE bicikla.tip = '" + biciklaUslov.getTip() + "'";
        }

        List<Iznajmljivanje> lista = broker.getAll((Iznajmljivanje) objekat, upit1);

        for (Iznajmljivanje iznajmljivanje : lista) {
            String upit2 = " JOIN bicikla ON bicikla.idBicikla = stavkaiznajmljivanja.idBicikla " +
                           "WHERE idIznajmljivanje = " + iznajmljivanje.getIdIznajmljivanje();

            List<StavkaIznajmljivanja> stavke = broker.getAll(new StavkaIznajmljivanja(), upit2);
            iznajmljivanje.setListaStavkiIznajmljivanja(stavke);
        }

        this.lista = lista;
    }


    
}
