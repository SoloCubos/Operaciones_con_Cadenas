package com.teoriacomputacion.model;

import java.util.ArrayList;

public class OperarCadenas {

    public String concatenar(String cadena1, String cadena2){
        return cadena1 + cadena2;
    }

    public String potenciar(String cadena, int potencia) {
        String resultado = new String();
        if (potencia != 0) {
            for (int i=0; i<potencia; i++) {
                resultado += cadena + "";
            }
            return resultado;
        } else {
            return "λ";
        }
    }

    public String longitud(String cadena) {
        return "" + cadena.length();
    }

    public String inversa(String cadena) {
        StringBuilder builder = new StringBuilder();

        for (int i = cadena.length() - 1; i >= 0; i--) {
            builder.append(cadena.charAt(i));
        }
        return builder.toString();
    }

    public ArrayList<String> sufijo(String cadena) {
        ArrayList<String> subCadenas = new ArrayList<>();
        
        subCadenas.add("λ");

        for (int i = cadena.length() - 1; i >= 0; i--) {
            subCadenas.add(cadena.substring(i));
        }
        
        return subCadenas;
    }

    public ArrayList<String> prefijo(String cadena) {
        ArrayList<String> subCadenas = new ArrayList<>();

        subCadenas.add("λ");

        for (int i = 1; i <= cadena.length(); i++) {
            String subcadena = cadena.substring(0, i);
            subCadenas.add(subcadena);
        }

    return subCadenas;
    }
}
