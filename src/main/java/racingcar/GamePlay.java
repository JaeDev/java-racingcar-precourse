package racingcar;

import java.util.*;

public class GamePlay {

    GamePlayService service;
    GameCarGroups cars;
    int numberOfGamePlay;

    public GamePlay() {
        service = new GamePlayService();
        this.cars = service.registerCars(service.inputCarNames());
        numberOfGamePlay = service.inputNumberOfGamePlay();
    }

    public void play(){
        for(int round = 0; round < numberOfGamePlay; round++){
            playRound();
            System.out.println();
        }

        whoIsWin();
    }
    private void playRound(){
        Iterator<String> it = cars.keys();
        while(it.hasNext()){
            String carName = it.next();
            String distance = cars.get(carName);
            cars.put(carName, service.getDistance(distance));
        }
        System.out.print(cars.toString());
    }
    private void whoIsWin(){
        cars.whoIsWin();
    }


}
