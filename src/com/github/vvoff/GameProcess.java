package com.github.vvoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameProcess {
    public static void main(String args[]) throws IOException {
        CommandParsing commandParsing = new CommandParsing();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        commandParsing.setCommand(InputState.NONE.toString());
        String command;

        Map yourMap = null;
        Map compMap = null;
        FletShips yourFlet = null;
        FletShips compFlet = null;

        out:
        while (true) {
            switch (commandParsing.getCommand()) {
                case NONE:
                    System.out.println("Введите start для начала игры.");
                    break;
                case START:
                    yourMap = new Map(12);
                    compMap = new Map(12);
                    yourFlet = new FletShips();
                    compFlet = new FletShips();
                    System.out.println("Игра началась! Введите map чтобы расставить корабли.");
                    break;
                case MAP:
                    yourFlet.setShips(yourMap);
                    compFlet.setShips(compMap);
                    yourMap.drawMap(true);
                    compMap.drawMap(false);
                    System.out.println("Корабли расставлены, введите координаты выстрела.");
                    break;
                case FIRE:
                    System.out.println("Координаты выстрела:");
                    System.out.println("X = " + commandParsing.getXcoordFire());
                    System.out.println("Y = " + commandParsing.getYcoordFire());
                    break;
                case ERROR_MAP_NOT_START:
                    System.out.println("Ошибка! Нельзя расставить корабли, игра не начата. Введите start.");
                    break;
                case ERROR_MAP_IS_FIGHTING:
                    System.out.println("Ошибка! Нельзя расставить корабли. Идет бой.");
                    System.out.println("Введите координаты встрела или start для создания новой игры.");
                    break;
                case ERROR_MAP_IS_ALREADY:
                    System.out.println("Ошибка! Корабли уже расставлены.");
                    System.out.println("Введите координаты выстрела или start для создания новой игры.");
                    break;
                case ERROR_FIRE_NOT_START:
                    System.out.println("Ошибка! Нельзя сделать выстрел, игра не начата.");
                    System.out.println("Введите start для начала игры.");
                    break;
                case ERROR_FIRE_NOT_MAP:
                    System.out.println("Ошибка! Нельзя сделать выстрел.");
                    System.out.println("Корабли не расставлены. Введите map чтобы расставить корабли.");
                    break;
                case HELP:
                    System.out.println("start  - начало новой игры");
                    System.out.println("map    - создать карту игры");
                    System.out.println("a1-j10 - оординаты выстрела");
                    System.out.println("exit   - Выйти из игры");
                    break;
                case EXIT:
                    break out;
                case ERROR_COMMAND:
                    System.out.println("Ошибка! Неправильная команда, введите HELP для справки.");
                    break;
            }
            command = reader.readLine();
            if (command.compareTo("") != 0) commandParsing.setCommand(command);
        }
    }
}
