package racingcar;


public class GameCar {
    private String name;
    private String distance;

    public GameCar(String name) {
        this.name = name;
        this.distance = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return name+" : "+distance;
    }
}
