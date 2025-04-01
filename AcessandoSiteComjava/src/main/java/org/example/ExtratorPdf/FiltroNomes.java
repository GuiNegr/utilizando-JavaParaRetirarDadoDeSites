package org.example.ExtratorPdf;

import java.util.ArrayList;

public class FiltroNomes {
    private ArrayList<String> filtroNomes;

    public FiltroNomes() {
        this.filtroNomes = popularFiltroNomes();
    }

    private ArrayList<String> popularFiltroNomes() {
        ArrayList<String> newFiltro = new ArrayList<>();
        newFiltro.add("PROCEDIMENTO");
        newFiltro.add("RN (alteração)");
        newFiltro.add("(alteração)");
        //daqui para cima não precisa

        newFiltro.add("OD");
        newFiltro.add("AMB");
        newFiltro.add("HCO");
        newFiltro.add("HSO");
        newFiltro.add("REF");
        newFiltro.add("PAC");
        //daqui para baixo não precisa
        newFiltro.add("DUT");
        newFiltro.add("SUBGRUPO");
        newFiltro.add("GRUPO");
        return newFiltro;
    }

    public ArrayList<String> popularFiltroCOmALFABETO() {
        ArrayList<String> newFiltro = new ArrayList<>();
        newFiltro.add("A");
        newFiltro.add("B");
        newFiltro.add("C");
        newFiltro.add("D");
        newFiltro.add("E");
        newFiltro.add("F");
        newFiltro.add("G");
        newFiltro.add("H");
        newFiltro.add("I");
        newFiltro.add("J");
        newFiltro.add("L");
        newFiltro.add("M");
        return newFiltro;
    }


    public ArrayList<String> getFiltroNomes() {
        return filtroNomes;
    }
}
