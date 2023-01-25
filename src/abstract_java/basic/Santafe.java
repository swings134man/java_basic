package abstract_java.basic;

/************
 * @info : Car Abstract class - 상속받은 실체 클래스
 * @name : Santafe
 * @date : 2023/01/25 10:08 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class Santafe extends Car{

    public static final int maxSpeed = Car.MAX_SPEED; // 상수

    public Santafe() {
        this.name = "Santafe";
        this.speed = 90;
        super.engineStart();// 객체 호출시, Car 클래스의 engineStart() 메서드 실행
    }

    // 다형성 - 하나의 Method가 여러가지 다른형태를 가질 수 있음,
    @Override
    public void color() {
        System.out.println("Black");
    }

    @Override
    public void type() {
        System.out.println("SUV");
    }

    @Override
    public void sounds() {
        System.out.println("빵빵!!!");
    }

    private void frame() {
        System.out.println("합금");
    }

    public void speed() {
        System.out.println(maxSpeed);
    }
}
