/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.bicikla;

import model.Bicikla;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author HP
 */
public class PretraziBiciklaSO extends ApstraktnaGenerickaOperacija{

    private Bicikla bicikla;

    public Bicikla getBicikla() {
        return bicikla;
    }
    
    
    @Override
    protected void preduslovi(Object objekat) throws Exception {
        if (objekat == null || !(objekat instanceof Bicikla)) {
            throw new Exception("Nije prosleđen parametar odgovarajućeg tipa.");
        }
    }

    @Override
    protected void izvrsi(Object objekat, Object kljuc) throws Exception {
        String upit = " WHERE idBicikla = " + ((Bicikla) objekat).getIdBicikla();
        Bicikla bicikla = (Bicikla) broker.getObject((Bicikla) objekat, upit);
        this.bicikla = bicikla;

    }
    
}
