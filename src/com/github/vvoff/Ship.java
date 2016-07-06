package com.github.vvoff;

import java.util.ArrayList;

public class Ship {

    private int numberOfDecks;
    private ArrayList<Deck> listDeck = new ArrayList<>();
    private int numDeckDestroyed = 0;
    private boolean shipDestroyed;

    public boolean getShipDestroyed() {
        return shipDestroyed;
    }

    public void setShipDestroyed(boolean shipDestroyed) {
        this.shipDestroyed = shipDestroyed;
    }

    //в конструкторе создаём и добавляем объекты типа Deck в коллекцию
    //в итоге у нас получается корабль из коллекции палуб
    Ship(int numDecks) {
        numberOfDecks = numDecks;
        for (int i = 0; i < numberOfDecks; i++) {
            listDeck.add(new Deck());
        }
    }

    // установить координаты X,Y палубы корабля
    public void setShipCoord(int numDeck, int x, int y) {
        listDeck.get(numDeck).setX(x);
        listDeck.get(numDeck).setY(y);
    }

    //взять координату X палубы корабля
    public int getShipCoordX(int numDeck) {
        return listDeck.get(numDeck).getX();
    }

    //взять координату Y палубы корабля
    public int getShipCoordY(int numDeck) {
        return listDeck.get(numDeck).getY();
    }

    //взять количество разрушенных палуб корабля
    public int getNumDeckDestroyed() {
        return numDeckDestroyed;
    }

    //установить количество разрушенных палуб корабля
    public void setNumDeckDestroyed(int numDeckDestroyed) {
        this.numDeckDestroyed = numDeckDestroyed;
    }

    //взять количество палуб
    public int getNumberOfDecks() {
        return numberOfDecks;
    }
}
