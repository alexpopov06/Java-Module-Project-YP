import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        for (int i = 1; i < 4; i++) {
            System.out.println("Введите название машины №" + i);
            String carName = scanner.next();
            int carSpeed = 0;


            while (true) {
                System.out.println("Введите скорость машины " + i);

                if (scanner.hasNextInt()) {
                    carSpeed = scanner.nextInt();
                    if (carSpeed > 0 && carSpeed <= 250) {
                        Car car = new Car(carName, carSpeed);
                        race.Racing(carName, carSpeed);
                        break;
                    } else {
                        System.out.println("Неверная скорость.");
                    }
                } else {
                    System.out.println("Неверный ввод. Пожалуйста, введите целое число для скорости.");
                    scanner.next();
                }
            }
        }

        System.out.println("Самая быстрая машина " + race.Winner());
    }
}

class Car {
    String carName;
    int carSpeed;

    public Car(String carName, int carSpeed) {
        this.carName = carName;
        this.carSpeed = carSpeed;
    }
}

class Race {
    int distance = 0;
    String carNameq = "";

    public void Racing(String carName, int carSpeed) {
        if (carSpeed * 24 > distance) {
            carNameq = carName;
            distance = carSpeed * 24;
        }
    }

    public String Winner() {
        return carNameq;
    }
}