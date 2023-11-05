package collections.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/************
 * @info : 
 * @name : PriorityQueue_2
 * @date : 11/5/23 11:37 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : 우선순위 큐 - 예제 -> Car 객체가 존재할때, 각 객체의 가격(price) 가 더 높은 객체를 우선적으로 출력.
 * - 만약 가격이 같다면, 등급(grade) 순서로 우선 출력
 *
 * - 가격 높은경우가 높다.
 * - 가격이 같을 경우, grade 가 더 높은 경우 우선순위가 더 높다.
 ************/
public class PriorityQueue_2 {

    public static void main(String[] args) {
        PriorityQueue<Car> pq = new PriorityQueue<>(1, new CarComparator());

        pq.offer(new Car("avante", 2000, 1));
        pq.offer(new Car("sonanta", 3000, 2));
        pq.offer(new Car("nx1", 3000, 3));
        pq.offer(new Car("grandeur", 4000, 4));

        // 전체 queue list
        // 이미 우선순위가 정해져 있기 때문에, 데이터 삽입 순서대로 출력되지 않는다.
        System.out.println("pq = " + pq);

        // 우선순위가 높은 순서대로 출력
        while (!pq.isEmpty()) {
            Car res = pq.poll();
            System.out.println(res);
        }

    }
}// main class

// Car 객체
class Car {
    private String name;
    private int price;

    private int grade;

    public Car(String name, int price, int grade) {
        this.name = name;
        this.price = price;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", grade=" + grade +
                '}';
    }
}

// class 객체의 우선순위 정의 Class
class CarComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        // price 가 높은게 우선순위, price 가 같다면 grade 가 높은게 우선순위
        return o1.getPrice() == o2.getPrice() ? o2.getGrade() - o1.getGrade() : o2.getPrice() - o1.getPrice();
    }
}//class
