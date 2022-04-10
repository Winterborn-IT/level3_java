package lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

public class RunTest {
    public static void run(Class myTestClass) {
        List<Method> methodList = new ArrayList<>();

        List<Method> list = new ArrayList();
        Collections.addAll(list, myTestClass.getDeclaredMethods());

        for (Method m : list) {
            if (m.isAnnotationPresent(Test.class)) {
                methodList.add(m);
            }
        }

       methodList.sort(Comparator.comparingInt((ToIntFunction<Method>) i ->
               i.getAnnotation(Test.class).priority()).reversed());

        for (Method m : list) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                if (methodList.get(0).isAnnotationPresent(BeforeSuite.class)) {
                    throw new RuntimeException("@BeforeSuite is already declare");
                }
                methodList.add(0, m);
            }
        }

        for (Method m : list) {
            if (m.isAnnotationPresent(AfterSuite.class)) {
                if (methodList.get(methodList.size() - 1).isAnnotationPresent(AfterSuite.class)) {
                    throw new RuntimeException("@AfterSuite is already declare");
                }
                methodList.add(m);
            }
        }

        for (Method method : methodList) {
            try {
                method.invoke(null);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }
}
