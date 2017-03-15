package com.sdajava.SzyfrCezara;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

    public class SzyfrCezara {
        String text;
        String textPoZmianie;

        public SzyfrCezara () throws IOException{
            File file = new File ("C://Users//RENT//Desktop//Input.txt");
            String text = "";
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                text += sc.nextLine();
            }
            this.text = text;
            sc.close();

            szyfrujemy();

            File output = new File ( "C://Users//RENT//Desktop//Output.txt" );
            PrintWriter pw = new PrintWriter (output);
            pw.println (this.textPoZmianie);
            pw.close();

        }

        public void szyfrujemy(){
            String text ="";
            char[] tab = this.text.toCharArray();
            int ascii;
            for (int i = 0; i <tab.length; i++){
                ascii = (int) tab[i];

                if (ascii >= 65 && ascii <= 87){
                    ascii += 3;
                    text += (char) ascii;
                }
                else if (ascii >= 88 && ascii <= 90){
                    ascii -= 23;
                    text += (char) ascii;
                }
                else if (ascii >= 97 && ascii <= 119){
                    ascii += 3;
                    text += (char) ascii;
                }
                else if (ascii >= 120 && ascii <= 122){
                    ascii -= 23;
                    text += (char) ascii;
                }
            }
            this.textPoZmianie = text;
        }

        public static void main(String[] args) throws IOException {
            SzyfrCezara kod = new SzyfrCezara();
        }

    }

