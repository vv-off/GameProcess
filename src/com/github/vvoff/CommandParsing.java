package com.github.vvoff;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandParsing {

    private String command;
    private int xCoordFire;
    private int yCoordFire;
    private char[] ch = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
    private ArrayList<InputState> listState = new ArrayList<>();

    public int getXcoordFire() {
        return xCoordFire;
    }

    public int getYcoordFire() {
        return yCoordFire;
    }

    public void setCommand(String str) {
        command = str;
    }

    private boolean coordinatesShot() {
        Pattern p = Pattern.compile("([a-j][1-9])|[a-j]([1][0])");
        Matcher m = p.matcher(command);

        if (m.matches()) {
            parseCoordinatesShot();
            return true;
        }
        return false;
    }

    private void parseCoordinatesShot() {
        String numStr = "";
        Pattern patChar = Pattern.compile("([a-j])");
        Matcher matcherChar = patChar.matcher(command);
        while (matcherChar.find()) {
            numStr = matcherChar.group();
        }
        for (int i = 0; i < ch.length; i++) {
            if (numStr.compareTo(Character.toString(ch[i])) == 0) {
                yCoordFire = i + 1;
            }
        }
        Pattern patNum = Pattern.compile("([0-9]+)");
        Matcher matcherNum = patNum.matcher(command);
        while (matcherNum.find()) {
            xCoordFire = Integer.parseInt(matcherNum.group());
        }
    }

    //Переделать последовательность вызовов команд
    public InputState getCommand() {
        InputState state = InputState.HELP;
        if (command.equalsIgnoreCase(InputState.NONE.toString())){
            state = InputState.NONE;
        }
        if (command.equalsIgnoreCase(InputState.START.toString())){
            listState.removeAll(listState);
            listState.add(InputState.START);
            state = InputState.START;
        }
        if (command.equalsIgnoreCase(InputState.MAP.toString())){
            if((listState.contains(InputState.START)) && (!listState.contains(InputState.FIRE))){
                if(!listState.contains(InputState.MAP)) listState.add(InputState.MAP);
                state = InputState.MAP;
            }else state = InputState.NONE;
        }
        if (command.equalsIgnoreCase(InputState.EXIT.toString())){
            state = InputState.EXIT;
        }
        if (coordinatesShot()){
            if((listState.contains(InputState.START)) && (listState.contains(InputState.MAP))) {
                if(!listState.contains(InputState.FIRE)) listState.add(InputState.FIRE);
                state = InputState.FIRE;
            }else state = InputState.START;
        }
        return state;
    }
}