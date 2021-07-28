package Ejercicio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.Properties;

public class MiFactory {

   // Metodos
   public static Object getInstance(String objName) throws IOException {
      String rootPath = new File ("MiFactory.properties").getAbsolutePath();
      Properties properties = new Properties();
      properties.load(new FileInputStream(new File(rootPath)));

      Class clazz;
      Constructor ctor;
      Object object = null;

      try {
         clazz = Class.forName(properties.getProperty(objName));
         ctor = clazz.getConstructor();
         object = ctor.newInstance();
      } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
         e.printStackTrace();
      }

      return object;
   }
}
