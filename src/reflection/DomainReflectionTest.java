package reflection;

import reflection.domain.Item;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DomainReflectionTest {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Item item = new Item();
        Class<?> targetClass = getTargetClass(item);

        Object object = dataSetToList(targetClass);
        System.out.println("object = " + object);
    }


    // Target Class Get
    public static Class<?> getTargetClass(Object targetClass) {
        Class<?> clazz = targetClass.getClass();
        System.out.println("clazz = " + clazz);
        System.out.println("clazz.fileds" + Arrays.toString(clazz.getDeclaredFields())); // private Field 또한 출력

        return clazz;
    }

    public static Object dataSetToList(Class<?> targetClass) throws InstantiationException, IllegalAccessException {
        List<?> list = new ArrayList<>();

        // get target class instance
        Object o = targetClass.newInstance();

        Field[] declaredFields = targetClass.getDeclaredFields();// 전체 Fields
        for(Field field: declaredFields) {
            field.setAccessible(true);

            // Field Type 따라 값 설정?
            if (field.getType() == Long.class || field.getType() == long.class) {
                field.set(o, 1L);
            } else if (field.getType() == String.class) {
                field.set(o, "Sample Value");
            } else if (field.getType() == int.class) {
                field.set(o, 100);
            }
        }

        return o;
    }
}//class
