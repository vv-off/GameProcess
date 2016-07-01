package com.github.vvoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameProcess {
    public static void main(String args[]) throws IOException {
        CommandParsing commandParsing = new CommandParsing();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        commandParsing.setCommand("none");
        String command;


        out:
        while(true){
            switch (commandParsing.getCommand()){
                case NONE:
                    System.out.println("Введите start для начала игры");
                    break;
                case START:
                    System.out.println("Введите map чтобы расставить корабли");
                    break;
                case MAP:
                    System.out.println("Карта кораблей");
                    break;
                case FIRE:
                    System.out.println("Координаты выстрела");
                    break;
                case HELP:
                    System.out.println("Помощь");
                    break;
                case EXIT:
                    break out;
                default:
                    System.out.println("Неправильная команда, введите HELP");
                    break;
            }
            command = reader.readLine();
            if(command.compareTo("")!=0) commandParsing.setCommand(command);
        }
    }

}
