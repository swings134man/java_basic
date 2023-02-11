package etc.equalsAndHashCode.example;


import java.util.Objects;

/************
 * @info : Equals And Hash Code - DTO 2
 * @name : person
 * @date : 2023/02/11 5:40 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 *
 *  - Clone 메서드를 Override 할 경우 Cloneable 라는 interface 를 implements 받아야 한다.
 *      -> clone 메서드를 사용한다는 의미이다.
 ************/
public class Person implements Cloneable{

    private String name;
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    // Clone : 객체의 원본을 복제. -> 원본 객체가 완전하게 복제된다.
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
