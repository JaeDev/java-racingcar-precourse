package racingcar;

import java.util.ArrayList;
import java.util.List;

public class ValidateUtils {
    public static boolean validateCarNames(String input) {
        String[] inputArr = input.split(",");
        if(inputArr.length<=1){
            return false;
        }
        List<String> inputList = new ArrayList<>();
        for (int i = 0; i < inputArr.length; i++){
            String str = inputArr[i].trim();
            if(str.length()>5 || str.equals("")){
                return false;
            }
            if(inputList.contains(str)){
               return false;
            }
            inputList.add(str);
        }


        return true;
    }
}
