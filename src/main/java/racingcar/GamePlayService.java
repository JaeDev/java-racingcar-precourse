package racingcar;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GamePlayService {
    private final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_NUMBER_OF_GAME_PLAY = "시도할 회수는 몇 회인가요?";
    private final String ERROR_MSG_INPUT_CAR_NAME = "잘못 입력하였습니다. 자동차 이름은 5자이하, 중복 안됨.";
    private final String ERROR_MSG_NUMBER_OF_GAME_PLAY = "잘못 입력하였습니다. 숫자를 입력해주세요.";

    private static String SPLITTER = ",";
    private static String BASIC_DISTANCE = "";

    Scanner scanner;
    public GamePlayService() {
        this.scanner = new Scanner(System.in);
    }

    public GameCarGroups registerCars(String inputCarNames){
        String[] inputArr = inputCarNames.split(SPLITTER);
        Map<String, String> inputMap = new HashMap<>();
        for (int i = 0; i < inputArr.length; i++){
            String str = inputArr[i].trim();
            inputMap.put(str, BASIC_DISTANCE);
        }
        return new GameCarGroups(inputMap);
    }

    public String inputCarNames(){
        System.out.println(INPUT_CAR_NAME);
        String inputCarNames = scanner.nextLine();
        if(!ValidateUtils.validateCarNames(inputCarNames)){
            System.out.println(ERROR_MSG_INPUT_CAR_NAME);
            return inputCarNames();
        }
        return inputCarNames;
    }
    public int inputNumberOfGamePlay(){
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

    public String getDistance(String distance){
        if(RandomUtils.getRandomValue()>=4){
            distance += "-";
        }
        return distance;
    }
}
