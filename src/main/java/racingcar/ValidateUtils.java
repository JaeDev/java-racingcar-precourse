package racingcar;

public class ValidateUtils {
    public static boolean validateCarNames(String input) {
        String[] inputArr = input.split(",");
        if(inputArr.length<=1){
            return false;
        }

        for (int i = 0; i < inputArr.length; i++){
            String str = inputArr[i].trim();
            if(str.length()>5 || str.equals("")){
                return false;
            }
        }
        return true;
    }
}
