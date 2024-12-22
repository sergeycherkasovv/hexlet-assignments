package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class Validator {
    public static List<String> validate(Object obj) throws NoSuchFieldException, IllegalAccessException {
        List<String> list = new ArrayList<>();
        Class<?> aClass = obj.getClass();
        Field[] declaredFiled = aClass.getDeclaredFields();

        for (var filed : declaredFiled) {
            Field pole = aClass.getField(filed.getName());
            Object instance = new Object();

            try {
                if(filed.isAnnotationPresent(NotNull.class) && pole.get(instance) == null) {
                    list.add(String.valueOf(pole));
                }
            } catch (IllegalArgumentException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }
}
// END
