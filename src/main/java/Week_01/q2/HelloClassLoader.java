package Week_01.q2;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Function:
 *
 * @author zhangyu
 * Date: 2020/10/19 11:56
 * @since JDK 1.8
 */
public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        HelloClassLoader helloClassLoader = new HelloClassLoader();
        Class<?> aClass = helloClassLoader.findClass("Hello");
        Object o = aClass.newInstance();
        for (Method method : o.getClass().getDeclaredMethods()) {
            System.out.println(method);
        }
        Method method = o.getClass().getDeclaredMethod("hello");
        method.invoke(o);

    }

    @Override
    protected Class<?> findClass(String name) {
        try (FileInputStream in = new FileInputStream("Week_01/q2/Hello.xlass")) {
            byte[] bytes = new byte[in.available()];
            in.read(bytes);
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (255 - bytes[i]);
            }
            return defineClass(name, bytes,0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
