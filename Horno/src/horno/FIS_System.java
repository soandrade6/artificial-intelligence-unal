/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package horno;

/**
 *
 * @author sofia
 */

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
public class FIS_System {
    final private String path_Fis = "src/horno/FIS_horno.fcl";
    final private FIS fis_var;
    
    public FIS_System() {
        this.fis_var = FIS.load(this.path_Fis, true);
        if (this.fis_var == null) {
            System.err.println("Error al cargar el FIS");
        }
    }
    
    public String evaluar(double humedad, double intensidad, double volumen){
        this.fis_var.setVariable("humedad", humedad);
        this.fis_var.setVariable("intensidad", intensidad);
        this.fis_var.setVariable("volumen" ,volumen);
        this.fis_var.evaluate();
        JFuzzyChart.get().chart(this.fis_var.getFunctionBlock("horno"));
        return "Temperatura " +
                this.fis_var.getVariable("temperatura").getLatestDefuzzifiedValue();        
    }
    
    
    public String get_CD(){

        String[] CD_temperatura = {"baja", "media", "alta"};
        String result = "";

        for (String v1:CD_temperatura){
            if (this.fis_var.getVariable("temperatura").getMembership(v1) > 0){
                result += v1 + ", ";
            }
        }

        result = result.strip();
        StringBuilder sb = new StringBuilder(result);
        sb.deleteCharAt(result.length()-1);

        return sb.toString();
    }
    
}
