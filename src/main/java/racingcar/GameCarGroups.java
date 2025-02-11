package racingcar;

import java.util.Iterator;
import java.util.Map;

public class GameCarGroups {
    private final String RESULT_SUFFIX = "가 최종 우승했습니다.";
    private Map<String, String> cars;

    public GameCarGroups(Map<String, String> cars) {
        this.cars = cars;
    }

    public Iterator<String> keys(){
        return cars.keySet().iterator();
    }
    public String get(String key){
        return cars.get(key);
    }
    public String put(String key, String value){
        return cars.put(key, value);
    }

    public void whoIsWin(){
        int max = maxDistance();

        StringBuilder msg = new StringBuilder();
        Iterator<String> it = keys();
        while(it.hasNext()){
            String carName = it.next();
            msg.append(printResult(carName, max));
        }
        System.out.println(msg.substring(0, msg.lastIndexOf(","))+RESULT_SUFFIX);
    }
    private String printResult(String carName, int max){
        String distance = cars.get(carName);
        if(max == distance.length()){
            return carName+",";
        }
        return "";
    }
    private int maxDistance(){
        int max = 0;
        Iterator<String> it = keys();
        while(it.hasNext()){
            String carName = it.next();
            String distance = cars.get(carName);
            max = NumberUtils.bigger(max, distance.length());
        }
        return max;
    }


    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        Iterator<String> it = keys();
        while(it.hasNext()){
            String carName = it.next();
            String distance = get(carName);
            msg.append(carName).append(" : ").append(distance).append("\n");
        }
        return msg.toString();
    }
}
