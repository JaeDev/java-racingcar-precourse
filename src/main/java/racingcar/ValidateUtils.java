package racingcar;

import java.util.ArrayList;
import java.util.List;

public class ValidateUtils {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final String CAR_NAME_BLANK = "";
    private static final String SPLITTER = ",";

    public static boolean validateCarNames(String input) {
        String[] inputArr = input.split(SPLITTER);
        if(inputArr.length<=1) return false;

        if(!checkDuplicateName(inputArr)) return false;

        return checkNameLength(inputArr);
    }
    public static boolean checkDuplicateName(String[] inputArr){
        int duplicateCount = 0;
        List<String> inputList = new ArrayList<>();
        for (String input:inputArr) {
            String str = input.trim();
            duplicateCount += logicDuplicateName(inputList, str);
            inputList.add(str);
        }

        return duplicateCount <= 0;
    }
    public static int logicDuplicateName(List<String> inputList, String str){
        if(inputList.contains(str)){
            return 1;
        }
        return 0;
    }
    public static boolean checkNameLength(String[] inputArr){
        int overLengthCount = 0;
        for(String input: inputArr){
            String str = input.trim();
            overLengthCount += logicNameLength(str);
        }
        return overLengthCount <= 0;
    }
    public static int logicNameLength(String str){
        if(str.length()>CAR_NAME_MAX_LENGTH || str.equals(CAR_NAME_BLANK)){
            return 1;
        }
        return 0;
    }

}
