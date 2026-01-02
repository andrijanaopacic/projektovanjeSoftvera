/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.bicikla;

import java.util.List;
import model.Bicikla;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author HP
 */
public class VratiListuBiciklaBiciklaSO extends ApstraktnaGenerickaOperacija{

    private List<Bicikla> lista;

    public List<Bicikla> getLista() {
        return lista;
    }
    
    @Override
    protected void preduslovi(Object objekat) throws Exception {
        if (objekat == null || !(objekat instanceof Bicikla)) {
            throw new Exception("Nije prosleđen parametar odgovarajućeg tipa.");
        }
    }

    @Override
    protected void izvrsi(Object objekat, Object kljuc) throws Exception {
        String upit = "";

        String tip = ((Bicikla) kljuc).getTip();

        if (tip != null && !tip.isEmpty()) {
            upit += " WHERE bicikla.tip = '" + tip + "'";
        }

        List<Bicikla> lista = broker.getAll((Bicikla) objekat, upit);
        this.lista = lista;
}

    
}
