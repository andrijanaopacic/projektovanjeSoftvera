/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author HP
 */
public class Bicikla implements ApstraktniDomenskiObjekat,Serializable{
    
    private int idBicikla;
    private String tip;
    private double cenaPoSatu;
    private double cenaPoDanu;

    public Bicikla() {
    }

    public Bicikla(int idBicikla, String tip, double cenaPoSatu, double cenaPoDanu) {
        this.idBicikla = idBicikla;
        this.tip = tip;
        this.cenaPoSatu = cenaPoSatu;
        this.cenaPoDanu = cenaPoDanu;
    }
    
    public Bicikla(String tip, double cenaPoSatu, double cenaPoDanu) {
        this.tip = tip;
        this.cenaPoSatu = cenaPoSatu;
        this.cenaPoDanu = cenaPoDanu;
    }
    
    public Bicikla(String tip) {
        this.tip = tip;
    }

    

    public int getIdBicikla() {
        return idBicikla;
    }

    public void setIdBicikla(int idBicikla) {
        this.idBicikla = idBicikla;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public double getCenaPoSatu() {
        return cenaPoSatu;
    }

    public void setCenaPoSatu(double cenaPoSatu) {
        this.cenaPoSatu = cenaPoSatu;
    }

    public double getCenaPoDanu() {
        return cenaPoDanu;
    }

    public void setCenaPoDanu(double cenaPoDanu) {
        this.cenaPoDanu = cenaPoDanu;
    }

    
    
    @Override
    public String toString() {
        return tip;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bicikla other = (Bicikla) obj;
        return Objects.equals(this.tip, other.tip);
    }

    @Override
    public String vratiNazivTabele() {
        return "bicikla";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        
        while(rs.next()){
                int id = rs.getInt("bicikla.idBicikla");
                String tip  = rs.getString("bicikla.tip");
                double cenaPoSatu = rs.getDouble("bicikla.cenaPoSatu");
                double cenaPoDanu = rs.getDouble("bicikla.cenaPoDanu");
                Bicikla b = new Bicikla(id, tip, cenaPoSatu, cenaPoDanu);
                lista.add(b);
            }
        
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "tip,cenaPoSatu,cenaPoDanu";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
         return "'" + tip + "'," + cenaPoSatu + "," + cenaPoDanu;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "bicikla.idBicikla=" + idBicikla;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        try {
            Bicikla bicikla = null;

            while (rs.next()) {
                int id = rs.getInt("bicikla.idBicikla");
                String tip = rs.getString("bicikla.tip");
                double cenaPoSatu = rs.getDouble("bicikla.cenaPoSatu");
                double cenaPoDanu = rs.getDouble("bicikla.cenaPoDanu");

                bicikla = new Bicikla(id, tip, cenaPoSatu, cenaPoDanu);
            }

            return bicikla;
        } catch (Exception ex) {
            System.err.println("Greška prilikom obrade podataka iz ResultSet-a kod vraćanja bicikle: " + ex.getMessage());
            return null;
        }
    }


    @Override
    public String vratiVrednostiZaIzmenu() {
       return "tip='" + tip + "', cenaPoSatu=" + cenaPoSatu + ", cenaPoDanu=" + cenaPoDanu;
    }    
    
    
}
