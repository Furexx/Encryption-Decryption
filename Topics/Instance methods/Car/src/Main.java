class Car {

    int yearModel;
    String make;
    int speed;

    public void accelerate(){
        this.speed = this.speed + 5 ;
    }

    public void brake(){
        if(this.speed < 4){
            this.speed = 0;
        }else {
            this.speed = this.speed - 5;
        }
    }
}

class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.speed = 100 ;
        System.out.println(car.speed);
        car.accelerate();
        System.out.println(car.speed);
        car.brake();
        System.out.println(car.speed);
    }
}