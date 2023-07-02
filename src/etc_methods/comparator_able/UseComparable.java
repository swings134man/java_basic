package etc_methods.comparator_able;

import java.util.ArrayList;
import java.util.List;


/************
 * @info : 
 * @name : UseComparator
 * @date : 2023/07/02 1:19 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : Compareable Class
 *
 * - Comparable 는 객체의 기본 정렬 순서를 정의하는데에 사용된다.
 * - 해당 interface를 구현한 class는 정렬 가능한 객체로 간주 된다. -> 객체간의 비교 및 정렬 작업에 사용된다.
 * - compareTo() 메서드를 필수로 정의, 재정의 해야한다.
 *   - 비교 대상객체와 비교 대상 동일 = 0
 *   - 비교 대상객체가 작다면 = 음수
 *   - 비교 대상객체가 크다면 = 양수
 * - Comparable 인터페이스를 구현한 클래스는 Collections.sort()를 이용하여 정렬할 수 있다.
 * - Comparable을 사용하면 Java 정렬 알고리즘을 통해 객체를 정렬 할 수 있다.
 ************/
public class UseComparable {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player("김씨", 30));
        players.add(new Player("강씨", 10));
        players.add(new Player("이씨", 20));
        players.add(new Player("박씨", 50));
        System.out.println("before = " + players);

        players.sort(Player::compareTo);
        System.out.println("after = " + players);

        Player p = new Player();
        int res = new Player("김씨", 30).compareTo(players.get(0));
        System.out.println(res);
    }
}


// 정렬 대상 클래스
class Player implements Comparable<Player> {

    @Override
    public int compareTo(Player o) {
        return o.age - getAge();
    }

    public Player() {
    }

    public Player(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}