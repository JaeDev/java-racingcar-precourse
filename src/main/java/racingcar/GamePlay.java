package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GamePlay {
    private final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_NUMBER_OF_GAME_PLAY = "시도할 회수는 몇 회인가요?";
    private final String ERROR_MSG_INPUT_CAR_NAME = "잘못 입력하였습니다. 자동차 이름은 5자이하, 중복 안됨.";
    private final String ERROR_MSG_NUMBER_OF_GAME_PLAY = "잘못 입력하였습니다. 숫자를 입력해주세요.";


    Scanner scanner;
    List<GameCar> cars;
    int numberOfGamePlay;

    public GamePlay() {
        this.scanner = new Scanner(System.in);
        this.cars = registerCars(inputCarNames());
        numberOfGamePlay = inputNumberOfGamePlay();
    }

    public void play(){
        for(int round = 0; round < numberOfGamePlay; round++){
            playRound(round);
            System.out.println();
        }
    }
    private void playRound(int round){
        for(int carIdx = 0; carIdx < cars.size(); carIdx++){
            GameCar car = cars.get(carIdx);
            car.setDistance(goStraightOrNot(car));
            cars.set(carIdx, car);
            System.out.println(car.toString());
        }
    }
    private String goStraightOrNot(GameCar car){
        int random = RandomUtils.getRandomValue();
        if(random>=4){
            return car.getDistance()+"-";
        }
        return car.getDistance();
    }

    private List<GameCar> registerCars(String inputCarNames){
        String[] inputArr = inputCarNames.split(",");
        List<GameCar> inputList = new ArrayList<>();
        for (int i = 0; i < inputArr.length; i++){
            String str = inputArr[i].trim();
            inputList.add(new GameCar(str));
        }
        return inputList;
    }
    private String inputCarNames(){
        System.out.println(INPUT_CAR_NAME);
        String inputCarNames = scanner.nextLine();
        if(!ValidateUtils.validateCarNames(inputCarNames)){
            System.out.println(ERROR_MSG_INPUT_CAR_NAME);
            return inputCarNames();
        }
        return inputCarNames;
    }
    private int inputNumberOfGamePlay(){
        int result = 0;
        try{
            System.out.println(INPUT_NUMBER_OF_GAME_PLAY);
            result = scanner.nextInt();
        }catch (Exception e){
            scanner.nextLine();
            System.out.println(ERROR_MSG_NUMBER_OF_GAME_PLAY);
        }
        return ( result<=0 ? inputNumberOfGamePlay() : result);
    }
}
