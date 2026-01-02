/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.StavkaIznajmljivanja;

/**
 *
 * @author HP
 */
public class ModelTabeleStavkaIznajmljivanja extends AbstractTableModel {

    private List<StavkaIznajmljivanja> stavke = new ArrayList<>();
    private String[] kolone = {"ID", "Tip bicikle", "Broj dana", "Broj sati", "Cena sata", "Ukupan iznos"};

    public List<StavkaIznajmljivanja> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaIznajmljivanja> stavke) {
        this.stavke = stavke;
    }

    public String[] getKolone() {
        return kolone;
    }

    public void setKolone(String[] kolone) {
        this.kolone = kolone;
    }

    public ModelTabeleStavkaIznajmljivanja(List<StavkaIznajmljivanja> stavke) {
        this.stavke = stavke;
    }
    
    @Override
    public int getRowCount() {
        if (stavke.isEmpty()) {
            return 0;
        } else {
            return stavke.size();
        }
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaIznajmljivanja stavka = stavke.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return stavka.getIdStavkaIznajmljivanja();
            case 1:
                return stavka.getBicikla().getTip();
            case 2:
                return stavka.getBrojDana();
            case 3:
                return stavka.getBrojSati();
            case 4:
                return stavka.getCena();
            case 5:
                return stavka.getIznos();
            default:
                return "N/A";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void refresujPodatke() {
        fireTableDataChanged();
    }

    public void dodajElement(StavkaIznajmljivanja sp) {
        stavke.add(sp);
        fireTableDataChanged();
    }
    
}
