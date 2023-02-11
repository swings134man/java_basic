package etc_methods.equalsAndHashCode;


/************
 * @info : Java - EqualsAndHashCode Test Class - main
 * @name : EqualsAndHash_main
 * @date : 2023/02/09 1:43 AM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 *
 * - equals()를 Override 하면, hashCode() 또한 Override 해야한다.
 *      1. HashSet 과 같은 Hash 를 사용시 문제가 발생한다. -> 객체는 equals(같다) 지만, 주소값이 다르기 때문에, Set 에서 중복 add가 되기 때문.
 *      2. 이유: equals를 Overriding 하는 이유는 두 객체의 동일성 보장을위한 것인데, hashCode가 다르다면? 두 객체가 완전히 동일하다고 볼 수없기 떄문이다.
 *      ---> equals()만 Overriding 하는 경우 hashCode() 또한 Overriding 하라는 Warning 문구가 출력된다.
 *      3. JAVA 의 규칙 : equals()의 결과가 true 이면, hashCode의 값도 같아야 한다는것이다.
 *
 *  - equals(), hashCode() 의 동작 순서.
 *      1. hashCode() Return Value -> (두 객체가 같으면) -> equals() 리턴값 -> (같으면) -> 동일 객체
 *      2. hashCode() Return Value -> (다르면) -> 다른 객체.
 *      3. hashCode() Return Value -> (같으면) -> equals() -> (다르면) -> 다른 객체.
 *
 *
 *  - equals() : 두 객체의 참조값(주소값) 이 같은지 확인 (true/false)
 *      1. 논리적으로 비교한다. -> 참조값이 다르다 하더라도, 객체 내부의 Value 가 같으면 같다고 판단한다.
 *      2. 대표적으로 String Class 가 있다. -> String Class는 내부적으로 equals()를 @Override 해서 주소값 비교가 아닌, 값을 비교 한다.
 *
 *      3. (중요!!!!!!) @Override 하지 않으면 해당 Class의 인스턴스는 오직 자기 자신과만 같다.
 *
 *  - hashCode()
 *      1. Object Class : native 키워드를 갖고 있음, native 키워드는 OS 가 갖고있는 메소드를 뜻하며, C나 저수준 언어로 작성된 native 코드를 JVM에 적재한다.
 *      2. 적재하는 역할을 JNI 가 하게 된다. (Java Native Interface) -> 저수준언어를 JVM에 적재 및 실행을 담당함.
 *      3.
 *
 ************/
public class EqualsAndHash_main {

    public static void main(String[] args) {
        EqualsAndHash_main eq = new EqualsAndHash_main();
        eq.forEquals();
    } // main


    public void forEquals() {

        /*
            equals() 는 단순하게 Object == Object 비교한다. -> 즉 객체가 같은지 비교하는것이다.
         */

        // 아래의 Class 비교는 객체가 같은지 비교 하지만, 당연히 다르다.
        // 두 객체가 같다는것을 판단하려면 equals() 를 Override 해서 사용해야 한다.
        Lucas lu = new Lucas();
        lu.setAge(27);
        lu.setName("kang");

        Lucas lu2 = new Lucas();
        lu2.setAge(27);
        lu2.setName("kang");

        System.out.println("Lucas Class is Equals = " + lu.equals(lu2)); // if Override is available = true
        System.out.println("Lucas Hash = " + lu.hashCode() + "  lu2: " + lu2.hashCode()); // equals() override시, HashCode 또한 override 해야함. -> hashCode 재정의 안할시, HashSet 과 같이 Hash 사용시 문제발생.
        System.out.println("Lucas Obj is same?  " +  (lu.hashCode() == lu2.hashCode()));
        System.out.println();




        // 2 - false 예제
        David d1 = new David();
        d1.setAge(10);
        d1.setName("david");

        David d2 = new David();
        d2.setAge(10);
        d2.setName("david");

        System.out.println("David Class is Equals = " + d1.equals(d2));
        System.out.println("David Class Hashs : " + d1.hashCode() + "  d2 :" + d2.hashCode());




        System.out.println();
        // -------------------------- String Class Equals --------------------------
        String s1 = new String("string1");
        String s2 = new String("string2");
        System.out.println("String equals : " + s1.equals(s2));
    }


}//class
