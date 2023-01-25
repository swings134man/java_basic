package abstract_java.basic;

/************
 * @info : 추상클래스 샘플
 * @name : CarMain
 * @date : 2023/01/25 10:09 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class CarMain {

    public static void main(String[] args) {
        Sonata sonata = new Sonata();
        Santafe santafe = new Santafe();
        System.out.println(sonata.name);
        System.out.println(santafe.name);
        System.out.println();

        sonata.type();
        santafe.type();
        sonata.speed();
        santafe.speed();


        sonata.color();
        santafe.color();
        System.out.println();

        // Car - Component
        sonata.ride();
        santafe.ride();
        sonata.stop();
        santafe.stop();
        System.out.println();

        // 자동 타입변환을 통한 기능 수행. - 가상메서드
        Car car;
        car = new Santafe();
        car.color(); // santafe 클래스에 구현된 color() 실행.

        car = new Sonata();
        car.color(); // Sonata 클래스에 구현된 color() 실행.

        // 자동 형변환.
        carSound(new Santafe());
        carSound(new Sonata());
        car.sounds();

        // 객체 비교
        System.out.println("" + (sonata instanceof Car)); // sonata < Car
        System.out.println("" + (santafe instanceof Car));// santafe < Car
        System.out.println("" + (car instanceof Santafe)); // car < Santafe
    }

    // 타입 변환 : 추상클래스 타입 변수는 추상클래스를 상속받은 실체 클래스의 타입으로 자동 형변환.
    private static void carSound(Car car) {
        car.sounds();
    }
}
