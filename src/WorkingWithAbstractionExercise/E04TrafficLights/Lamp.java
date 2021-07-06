package WorkingWithAbstractionExercise.E04TrafficLights;

public class Lamp {
    private TrafficLight trafficLight;

    public Lamp (TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    public void changeColor () {
        switch (trafficLight) {
            case RED:
                trafficLight = TrafficLight.GREEN;
                break;
            case GREEN:
                trafficLight = TrafficLight.YELLOW;
                break;
            case YELLOW:
                trafficLight = TrafficLight.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return trafficLight.name();
    }
}
