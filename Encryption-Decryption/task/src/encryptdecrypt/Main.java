package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

interface Algorithm {
    String encoding(String data, int key);
    String decoding(String data, int key);
}

class UnicodeAlgorithm implements Algorithm {
    @Override
    public String encoding(String data ,int key){
        StringBuilder cText = new StringBuilder();
        for (char character: data.toCharArray()) {
            int originalAlphabetPosition = character - 'a';
            int newAlphabetPosition = (originalAlphabetPosition + key) ;
            char newChar = (char) ('a' + newAlphabetPosition);
            cText.append(newChar);
        }

        return cText.toString();
    }

    @Override
    public String decoding(String data, int key) {
        StringBuilder dText = new StringBuilder();
        for (char character: data.toCharArray()) {
            int originalAlphabetPosition = character - 'a';
            int newAlphabetPosition = (originalAlphabetPosition - key) ;
            char newChar = (char) ('a' + newAlphabetPosition);
            dText.append(newChar);
        }
        return dText.toString();
    }
}

class ShiftAlgorithm implements Algorithm {

    @Override
    public String encoding(String data, int key) {
        StringBuilder seText = new StringBuilder();
        char c;
        for (int i = 0; i < data.length(); i++) {
            c = data.charAt(i);
            if (Character.isLetter(c)){
                c = (char) (data.charAt(i) + key);
            }
            if ((Character.isLowerCase(data.charAt(i)) && c > 'z')
                    || (Character.isUpperCase(data.charAt(i)) && c > 'Z')){
                c = (char) (data.charAt(i) - (26 - key));
            }
            seText.append(c);
           }
            return seText.toString();
        }

    @Override
    public String decoding(String data, int key) {
        return  encoding(data,(26-(key%26)));
    }
}

class AlgorithmMaker {
    private Algorithm algorithm;

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public String encoding(String data, int key){
      return this.algorithm.encoding(data, key);
    }

    public String decoding(String data, int key){
       return this.algorithm.decoding(data, key);
    }

}


public class Main {

    public static String readFile(File file)throws IOException {
        return new String(Files.readAllBytes(Paths.get(String.valueOf(file))));
    }




    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                map.put(args[i], args[i + 1]);
            } else if (args[i].equals("-key")) {
                map.put(args[i], args[i + 1]);
            } else if (args[i].equals("-data")) {
                map.put(args[i], args[i + 1]);
            } else if (args[i].equals("-in")) {
                map.put(args[i], args[i + 1]);
            } else if (args[i].equals("-out")) {
                map.put(args[i], args[i + 1]);
            }else if (args[i].equals("-alg")){
                map.put(args[i],args[i+1]);
            }
        }


        map.getOrDefault("-mode","enc");
        map.getOrDefault("-key","0");
        String mode = map.get("-mode");
        String data = map.get("-data");

        int key = Integer.parseInt(map.get("-key"));
        AlgorithmMaker algorithmMaker = new AlgorithmMaker();
        if (map.containsValue("unicode")) {
            algorithmMaker.setAlgorithm(new UnicodeAlgorithm());
        }
        if (map.containsValue("shift")){
            algorithmMaker.setAlgorithm(new ShiftAlgorithm());
        }




        String onFile = map.get("-in");
        String opFile = map.get("-out");

        String dataFile = null;

        if (map.containsKey("-data")) {

            switch (mode) {
                case "enc":
                    System.out.println(algorithmMaker.encoding(data, key));
                    break;

                case "dec":
                    System.out.println(algorithmMaker.decoding(data, key));
                    break;
            }
        }else if (map.containsKey("-in") && map.containsKey("-out")){
            File inFile = new File(onFile);

            File outFile = new File(opFile);
            try {
                dataFile  = readFile(inFile);
                try (FileWriter writer = new FileWriter(outFile)){
                    if (mode.equals("enc")){
                        writer.write(algorithmMaker.encoding(dataFile,key));
                    }
                    if (mode.equals("dec")) {
                        writer.write(algorithmMaker.decoding(dataFile, key));
                    }
                }catch (IOException e){
                    System.out.println("Error : Cant write the file");
                }
        }catch (IOException e){
                System.out.println("Error: Cant read the file");
            }



        }else if (map.containsKey("-in") && !map.containsKey("-out")){
            File inFile = new File(System.getProperty("user.dir") + "\\" + map.get("in"));
            try {
                dataFile  = readFile(inFile);
            }catch (IOException e){
                System.out.println("Error: Cant read the file");
            }
            if (mode.equals("enc")){
                System.out.println(algorithmMaker.encoding(dataFile,key));
            }
            if (mode.equals("dec")) {
                System.out.println(algorithmMaker.decoding(dataFile, key));
            }
        }




    }

}

