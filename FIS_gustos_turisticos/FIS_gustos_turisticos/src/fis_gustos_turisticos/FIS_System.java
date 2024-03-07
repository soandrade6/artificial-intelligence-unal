package fis_gustos_turisticos;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

public class FIS_System {
    final private String path_Fis = "src/fis_gustos_turisticos/FIS_gustos_turisticos.fcl";
    final private FIS fis_var;

    public FIS_System() {
        this.fis_var = FIS.load(this.path_Fis, true);
        if (this.fis_var == null) {
            System.err.println("Error al cargar el FIS");
        }
    }

    public String evaluar (double nivel_de_presupuesto, double clima, double popularidad_historica){
        this.fis_var.setVariable("nivel_de_presupuesto", nivel_de_presupuesto);
        this.fis_var.setVariable("clima", clima);
        this.fis_var.setVariable("popularidad_historica" ,popularidad_historica);
        this.fis_var.evaluate();
        JFuzzyChart.get().chart(this.fis_var.getFunctionBlock("turismo"));
        return "Tipo_de_destino " +
                this.fis_var.getVariable("tipo_de_destino").getLatestDefuzzifiedValue()
                + "\nAlojamiento_recomendado " +
                this.fis_var.getVariable("alojamiento_recomendado").getLatestDefuzzifiedValue();
    }

    public String get_CD(){

        String[] CD_salid_destiono = {"playa", "montana", "ciudad", "rural"};
        String result_destiono = "";

        for (String v1:CD_salid_destiono){
            if (this.fis_var.getVariable("tipo_de_destino").getMembership(v1) > 0){
                result_destiono += v1 + ", ";
            }
        }

        String[] CD_salid_alojamiento = {"camping", "hostal", "casa_rural", "apartamento_vacacional",
                "hotel_de_lujo", "resort"};
        String result_alojamiento = "";
        for (String v1:CD_salid_alojamiento){
            if (this.fis_var.getVariable("alojamiento_recomendado").getMembership(v1) > 0){
                result_alojamiento += v1 + ", ";
            }
        }

        result_destiono = result_destiono.strip();
        StringBuilder sb = new StringBuilder(result_destiono);
        sb.deleteCharAt(result_destiono.length()-1);

        result_alojamiento = result_alojamiento.strip();
        StringBuilder sb2 = new StringBuilder(result_alojamiento);
        sb2.deleteCharAt(result_alojamiento.length()-1);

        return sb.toString() + " " + sb2.toString();
    }



}
