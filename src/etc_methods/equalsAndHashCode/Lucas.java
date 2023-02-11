package etc_methods.equalsAndHashCode;


import java.util.Objects;

/************
 * @info : Equals And HashCode 비교를 위한 class - Override(equalse())
 * @name : Lucas
 * @date : 2023/02/09 1:48 AM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : Field + Getter/Setter Only
 ************/
public class Lucas {

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // equals() Override
//    @Override
//    public boolean equals(Object obj) {
//
//        // null check
//        if(obj == null) {
//            return false;
//        }
//
//        // Class
//        if(this.getClass() != obj.getClass()) {
//            return false;
//        }
//
//        // obj
//        if(this == obj) {
//            System.out.println("obj is same By Lucas.class");
//            return true;
//        }
//
//        // 비교 Object
//        Lucas that = (Lucas)obj;
//
//        // name - null
//        if(this.name == null && that.name == null) {
//            return false;
//        }
//
//        // true Equals
//        if(this.age == that.age && this.name.equals(that.name)) {
//            System.out.println("this Obj is value Same");
//            return true;
//        }
//
//        return false;
//    } // equals

    // equals() - Refactoring
    @Override
    public boolean equals(Object obj) {
        if(this == obj) {return true;}
        if(!(obj instanceof Lucas)){return false;}

        Lucas that = (Lucas)obj;
        return age == that.age &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name); // age, name이 같은 값을 가지게 된다면 Object는 같은 Hash 값을 갖게된다.
    }
}
