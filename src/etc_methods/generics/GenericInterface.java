package etc_methods.generics;

/************
 * @info : Generic Interface Test Class
 * @name : GenericInterface
 * @date : 2023/02/12 1:56 AM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public interface GenericInterface <T, E>{

    String NAME = "G Interface";

    T getType(T type); // Type Get

    E getElement(E element); // Elemenet get

    T getT();
    E getE();
}
