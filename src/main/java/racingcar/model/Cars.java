package racingcar.model;

import racingcar.RacingUtil;
import racingcar.model.Car;

import java.util.*;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> carList) {
        validateCarNamesUnique(carList);
        this.cars = carList;
    }

    public void moveRandomEachCars() {
        for (Car car : cars) {
            int power = RacingUtil.generateRandomPower();
            car.move(power);
        }
    }

    public Map<String, Integer> getCarsStatus() {
        Map<String, Integer> status = new HashMap<>();
        for (Car car : cars) {
            status.put(car.getName(), car.getPosition());
        }
        return status;
    }

    public int findMaxPosition() {
        int max = cars.get(0).getPosition();
        for (Car car : cars) {
            if (max < car.getPosition()) {
                max = car.getPosition();
            }
        }
        return max;
    }

    public List<String> findMaxPositionCarNames() {
        List<String> names = new ArrayList<>();
        int max = findMaxPosition();
        for (Car car : cars) {
            if (car.getPosition() == max) {
                names.add(car.getName());
            }
        }
        return names;
    }

    private void validateCarNamesUnique(List<Car> carList) {
        Set<String> seen = new HashSet<>();
        for (Car car : carList) {
            if (!seen.add(car.getName())) {
                throw new IllegalArgumentException();
            }
        }
    }

}
