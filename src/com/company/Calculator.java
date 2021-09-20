package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public void doCalculate(String inputLine){


        double result = 0;
        int temp = 0;
        Pattern patternNumber = Pattern.compile("\\d+");
        Matcher matcherNumber = patternNumber.matcher(inputLine);

        List<String> listNumbers = new ArrayList<>();
        List<String> listSymbols = new ArrayList<>();

        Pattern patternSymbols = Pattern.compile("[+\\-*/]");
        Matcher matcherSymbols = patternSymbols.matcher(inputLine);

        while(matcherNumber.find()){
            listNumbers.add(matcherNumber.group());
        }

        while(matcherSymbols.find()){
            listSymbols.add(matcherSymbols.group());
        }

        if(listNumbers.size() != (listSymbols.size()+1)){
            System.out.println("Неверно введенное выражение");
            return;
        }

        for(int i = 0 ; i < listSymbols.size(); i++){

            if(listSymbols.get(i).equals("*") || listSymbols.get(i).equals("/")){
                if(temp == 0){
                    if(listSymbols.get(i).equals("*")) {
                        temp++;
                        result = Double.parseDouble(listNumbers.get(i)) * Double.parseDouble(listNumbers.get(i + 1));
                        listNumbers.remove(i);
                        listNumbers.remove(i);
                        listNumbers.add(i, String.valueOf(result));
                    }else{
                        temp++;
                        result = Double.parseDouble(listNumbers.get(i)) / Double.parseDouble(listNumbers.get(i + 1));
                        listNumbers.remove(i);
                        listNumbers.remove(i);
                        listNumbers.add(i, String.valueOf(result));
                    }
                    //list3.add(result);
                }else{
                    if(listSymbols.get(i).equals("*")) {

                        result = Double.parseDouble(listNumbers.get(i-temp)) * Double.parseDouble(listNumbers.get(i - temp+1));
                        listNumbers.remove(i - temp);
                        listNumbers.remove(i - temp);
                        listNumbers.add(i-temp,String.valueOf(result));
                        //   temp++;
                    }else{
                        result = Double.parseDouble(listNumbers.get(i-temp)) / Double.parseDouble(listNumbers.get(i-temp+1));
                        listNumbers.remove(i - temp);
                        listNumbers.remove(i - temp);
                        listNumbers.add(i-temp,String.valueOf(result));
                        //   temp++;
                    }
                    temp++;
                }
            }
        }

        for(int i = 0 ; i < listSymbols.size(); i++) {

            if (listSymbols.get(i).equals("*") || listSymbols.get(i).equals("/")) {
                listSymbols.remove(i);
            }
        }

        temp = 0;

        for(int i = 0 ; i < listSymbols.size(); i++) {

            if (listSymbols.get(i).equals("+") || listSymbols.get(i).equals("-")) {
                if(temp == 0) {
                    temp++;
                    if (listSymbols.get(i).equals("+")) {
                        result = Double.parseDouble(listNumbers.get(i)) + Double.parseDouble(listNumbers.get(i + 1));
                        listNumbers.remove(i);
                        listNumbers.remove(i);
                        listNumbers.add(i, String.valueOf(result));
                    }else{
                        result = Double.parseDouble(listNumbers.get(i)) - Double.parseDouble(listNumbers.get(i + 1));
                        listNumbers.remove(i);
                        listNumbers.remove(i);
                        listNumbers.add(i, String.valueOf(result));
                    }
                }else{
                    if(listSymbols.get(i).equals("+")) {
                        result = Double.parseDouble(listNumbers.get(i-temp)) + Double.parseDouble(listNumbers.get(i -temp+ 1));
                        listNumbers.remove(i - temp);
                        listNumbers.remove(i - temp);
                        listNumbers.add(i-temp,String.valueOf(result));
                    }else{
                        result = Double.parseDouble(listNumbers.get(i-temp)) - Double.parseDouble(listNumbers.get(i-temp+1));
                        listNumbers.remove(i - temp);
                        listNumbers.remove(i - temp);
                        listNumbers.add(i-temp,String.valueOf(result));
                    }
                    temp++;
                }

            }

        }


        listNumbers.stream().forEach(System.out::println);

    }
}
