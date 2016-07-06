package com.github.vvoff;

public class Fire {
    private Map map;
    private FletShips fletShips;
    private int fireCoordX;
    private int fireCoordY;

    Fire(Map map, FletShips fletShips){

        this.map = map;
        this.fletShips = fletShips;
    }

    public void setFireCoord(int x, int y){
        fireCoordX = x;
        fireCoordY = y;
    }


    public boolean resultShotTest(){
        boolean result = false;

        for(int i=0;i<map.getSizeMap();i++){
            for(int j=0;j<map.getSizeMap();j++){
                if(map.getMassivMap(fireCoordX,fireCoordY).compareTo(ElementMap.SHIP_DECK)==0){
                    result = true;
                }
            }
        }
        return result;
    }

}
