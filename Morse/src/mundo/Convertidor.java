/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

/**
 *
 * @author Angie Mendez
 */
public class Convertidor {

    private String texto;
    private String textoAlfabeto;
    private String codigoMorse;
    private final String arrayTabla[][];
    private String[] separar;

    public Convertidor() {
        this.arrayTabla = new String[43][2];
    }

    public String convertirMorse() {
    codigoMorse = "";
    llenarTabla();
    separar = new String [texto.length()];
        for (int i = 0; i < texto.length(); i++) {
            separar[i] = texto.substring(i, i+1);
        }
        for (int i = 0; i < separar.length; i++) {
            for (int j = 0; j < arrayTabla.length; j++) {
               if(arrayTabla[j][0].equalsIgnoreCase(separar[i])){
                   codigoMorse += arrayTabla[j][1]+ " ";
                   break;
               } 
            }
        }
        return codigoMorse;
    }

    public String convertirTexto() {
        separar = texto.split(" ");
        llenarTabla();
        textoAlfabeto = "";
        for (int i = 0; i < separar.length; i++) {
            for (int k = 0; k < arrayTabla.length; k++) {
                if (separar[i].equals(arrayTabla[k][1])) {
                    textoAlfabeto += arrayTabla[k][0];
                    break;
                }
            }
        }
        return textoAlfabeto;
    }

    public String getTextoAlfabeto() {
        return textoAlfabeto;
    }

    public String getCodigoMorse() {
        return codigoMorse;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void llenarTabla() {

        for (int i = 0; i < 26; i++) {
            this.arrayTabla[i][0] = Character.toString((char) ('A' + i));
        }
        for (int i = 0; i < 10; i++) {
            this.arrayTabla[i + 27][0] = Integer.toString(i);
        }
        arrayTabla[37][0] = "/";
        arrayTabla[38][0] = "@";
        arrayTabla[39][0] = "!";
        arrayTabla[40][0] = "=";
        arrayTabla[41][0] = "_";
        arrayTabla[42][0] = "-";
        arrayTabla[26][0] = " ";
        arrayTabla[0][1] = ".-";
        arrayTabla[1][1] = "-...";
        arrayTabla[2][1] = "-.-.";
        arrayTabla[3][1] = "-..";
        arrayTabla[4][1] = ".";
        arrayTabla[5][1] = "..-.";
        arrayTabla[6][1] = "--.";
        arrayTabla[7][1] = "....";
        arrayTabla[8][1] = "..";
        arrayTabla[9][1] = ".---";
        arrayTabla[10][1] = "-.-";
        arrayTabla[11][1] = ".-..";
        arrayTabla[12][1] = "--";
        arrayTabla[13][1] = "-.";
        arrayTabla[14][1] = "---";
        arrayTabla[15][1] = ".--.";
        arrayTabla[16][1] = "--.-";
        arrayTabla[17][1] = ".-.";
        arrayTabla[18][1] = "...";
        arrayTabla[19][1] = "-";
        arrayTabla[20][1] = "..-";
        arrayTabla[21][1] = "...-";
        arrayTabla[22][1] = ".--";
        arrayTabla[23][1] = "-..-";
        arrayTabla[24][1] = "-.--";
        arrayTabla[25][1] = "--..";
        arrayTabla[26][1] = ".......";
        arrayTabla[27][1] = "-----";
        arrayTabla[28][1] = ".----";
        arrayTabla[29][1] = "..---";
        arrayTabla[30][1] = "...--";
        arrayTabla[31][1] = "....-";
        arrayTabla[32][1] = ".....";
        arrayTabla[33][1] = "-....";
        arrayTabla[34][1] = "--...";
        arrayTabla[35][1] = "---..";
        arrayTabla[36][1] = "----.";
        arrayTabla[37][1] = "-..-.";
        arrayTabla[38][1] = ".--.-.";
        arrayTabla[39][1] = "-.-.--";
        arrayTabla[40][1] = "-...-";
        arrayTabla[41][1] = "..--.-";
        arrayTabla[42][1] = "-....-";

    }

    public String[][] getArrayTabla() {
        return arrayTabla;
    }

}
