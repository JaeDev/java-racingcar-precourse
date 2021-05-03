package racingcar;

import java.util.Scanner;

public class GamePlay {
    private final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_NUMBER_OF_GAME_PLAY = "시도할 회수는 몇 회인가요?";
    private final String ERROR_MSG_NUMBER_OF_GAME_PLAY = "잘못 입력하였습니다. 숫자를 입력해주세요.";


    Scanner scanner;

    public GamePlay() {
        this.scanner = new Scanner(System.in);
    }

    public void play() {
        System.out.println(INPUT_CAR_NAME);
        String inputCarNames = scanner.nextLine();
        int numberOfGamePlay = 0;
        if(!ValidateUtils.validateCarNames(inputCarNames)){
            play();
            return;
        }

        numberOfGamePlay = inputNumberOfGamePlay();


        System.out.println("끝");
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
        if(result==0){
            return inputNumberOfGamePlay();
        }
        return result;
    }
}
