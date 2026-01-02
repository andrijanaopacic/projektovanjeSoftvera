/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Bicikla;

/**
 *
 * @author HP
 */
public class ModelTabeleBicikla extends AbstractTableModel {

    private List<Bicikla> bicikle = new ArrayList<>();
    private String[] kolone = {"Tip", "Cena sata", "Cena dana"};

    public List<Bicikla> getLista() {
        return bicikle;
    }

    public void setLista(List<Bicikla> bicikle) {
        this.bicikle = bicikle;
    }

    public String[] getKolone() {
        return kolone;
    }

    public void setKolone(String[] kolone) {
        this.kolone = kolone;
    }

    public ModelTabeleBicikla(List<Bicikla> bicikle) {
        this.bicikle = bicikle;
    }
    
    @Override
    public int getRowCount() {
         if (bicikle.isEmpty()) {
            return 0;
        } else {
            return bicikle.size();
        }
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Bicikla b = bicikle.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return b.getTip();
            case 1:
                return b.getCenaPoSatu();
            case 2:
                return b.getCenaPoDanu();
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
    
}
