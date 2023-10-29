package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private final List<Car> carList;

    public CarList(List<Car> carList) {
        this.carList = carList;
    }

    public void moveRandomEachCars() {
        for (Car car : carList) {
            int power = RacingUtil.generateRandomPower();
            car.move(power);
        }
    }

    public int findMaxPosition() {
        int max = carList.get(0).getPosition();
        for (Car car : carList) {
            if (max < car.getPosition()) {
                max = car.getPosition();
            }
        }
        return max;
    }

    public List<Car> findWinners() {
        List<Car> winners = new ArrayList<>();
        int max = findMaxPosition();

        return carList.stream()
                .filter(car -> car.getPosition() == max)
                .toList();
    }

    public List<Car> getCarList() {
        return carList;
    }

    public boolean contains(Car car) {
        return carList.contains(car);
    }

    public int size() {
        return carList.size();
    }
}
