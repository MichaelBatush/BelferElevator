package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Belfer {
    //isntantiate 3 Belfer elevators
    //

    // if upper botton was press go UP one floor.
    
    BelferElevator e1 = new BelferElevator();
    BelferElevator e2 = new BelferElevator();
    BelferElevator e3 = new BelferElevator();
    int currentWeight1;
    int currentWeight2;
    int currentWeight3;

    List<BelferElevator> Three_Elevators = new ArrayList<>();
    
    
public Belfer(){
    currentWeight1 = 0;
    currentWeight2 = 0;
    currentWeight3 = 0;
}

    private int getWeight(BelferElevator e){
    return 0;
    }

private BelferElevator getClosestElevator(int i, boolean direction){
    //true is up, false is down

    HashMap<Integer, ArrayList<BelferElevator>> mapa = createStatusForElevators(i);

    /*   LOGIC

        IDEAL TO LESS IDEAL to go UP
    1. going UP being BELOW  12
    2. not being used 13
    3. going DOWN being BELOW 11
    4. going DOWN being ABOVE 21
    5. going UP being ABOVE 22

        IDEAL TO LESS IDEAL to go DOWN
    1. going DOWN being ABOVE 21
    2. not being used 13
    3. going UP being ABOVE 22
    4. going UP being BELOW 12
    5. going DOWN being BELOW 11
     */

    Integer[] orderValuesGoingUp = {12, 13, 11, 21, 22};
    Integer[] orderValuesGoingDown = {21, 13, 22, 12, 11};

    if (direction){
        for (var o : orderValuesGoingUp){
            if (mapa.get(0).size() == 1){
                return mapa.get(0).get(0);
            } else if (mapa.get(0).size() > 1){
                return chooseOneElevatorAmongMany(mapa.get(0), i);
            }
        }
    } else {
        for (var o : orderValuesGoingDown){
            if (mapa.get(0).size() == 1){
                return mapa.get(0).get(0);
            } else if (mapa.get(0).size() > 1){
                return chooseOneElevatorAmongMany(mapa.get(0), i);
            }
        }
    }
    throw new IllegalArgumentException("IT SHOULD NEVER GET HERE!!!!!");
}

private HashMap createStatusForElevators(int i){
    HashMap<Integer, ArrayList<BelferElevator>> mapa = createHashmap();

    for(BelferElevator b : Three_Elevators) {
        if (b.getFloor() > i) {
            b.setStatus_helper(20);
        } else {
            b.setStatus_helper(10);
        }
        if (b.getStatus() == BelferElevator.ElevatorState.MOVING_UP) {
            b.setStatus_helper((b.getStatus_helper() + 2));
        } else if (e1.getStatus() == BelferElevator.ElevatorState.MOVING_DOWN) {
            b.setStatus_helper((b.getStatus_helper() + 1));
        }
        int e = b.getStatus_helper();

        mapa.get(e).add(b);
        //six values we working with, 11,12,13, 21,22
    }
}

private BelferElevator chooseOneElevatorAmongMany(ArrayList<BelferElevator> lista, int floorCalled){
    BelferElevator be = null;
    for (var i : lista){
        if (be == null)
            be = i;
        if (Math.abs((floorCalled-i.getFloor())) < Math.abs((floorCalled - be.getFloor()))){
            be = i;
        }
    }

    return be;
}
private HashMap createHashmap(){
    HashMap<Integer, ArrayList<BelferElevator>> mapa = new HashMap<>();
    mapa.put(11, new ArrayList<>());
    mapa.put(12, new ArrayList<>());
    mapa.put(13, new ArrayList<>());
    mapa.put(21, new ArrayList<>());
    mapa.put(22, new ArrayList<>());

    return mapa;
}


private boolean stop(){
    return false;
}



}
