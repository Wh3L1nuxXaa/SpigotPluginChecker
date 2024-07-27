package wtf.Wh3L1nuxXaa;

import javassist.*;
import org.yaml.snakeyaml.Yaml;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.io.InputStream;
import java.util.Map;

public class Library {
    public static String getPluginMainClass(String pluginJar) {
        String Prefix = "BDSystem " + "> ";
        try (JarFile jarFile = new JarFile(pluginJar)) {
            JarEntry entry = jarFile.getJarEntry("plugin.yml");
            if (entry != null) {
                try (InputStream is = jarFile.getInputStream(entry)) {
                    Yaml yaml = new Yaml();
                    Map<String, Object> yamlData = yaml.load(is);
                    String mainClass = (String) yamlData.get("main");
                    return mainClass;

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(Prefix + "файл не является spigot плагином");
                System.exit(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Fail!";
    }

    public static boolean classFileExistsInJar(String jarPath, String className) {
        String classPath = className.replace('.', '/') + ".class";
        try (JarFile jarFile = new JarFile(jarPath)) {
            JarEntry entry = jarFile.getJarEntry(classPath);
            return entry != null;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean methodExistsInJar(String jarPath, String className, String methodName) {
        try (JarFile jarFile = new JarFile(jarPath)) {
            JarEntry entry = jarFile.getJarEntry(className.replace('.', '/') + ".class");
            if (entry == null) {
                return false;
            }
            try (InputStream inputStream = jarFile.getInputStream(entry)) {
                ClassPool classPool = ClassPool.getDefault();
                CtClass ctClass = classPool.makeClass(inputStream);
                for (CtMethod method : ctClass.getDeclaredMethods()) {
                    if (method.getName().equals(methodName)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static boolean checkPackageExists(File jarFile, String packageName) {
        try (JarFile jar = new JarFile(jarFile)) {
            Enumeration<JarEntry> entries = jar.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                String entryName = entry.getName();
                if (entryName.endsWith(".class")) {
                    String className = entryName.replace('/', '.').replace(".class", "");
                    if (className.startsWith(packageName)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getPluginName(String pluginJar) {
        String Prefix = Color.MAGENTA + "BDSystem " + Color.WHITE + "> ";
        try (JarFile jarFile = new JarFile(pluginJar)) {
            JarEntry entry = jarFile.getJarEntry("plugin.yml");

            if (entry != null) {
                try (InputStream is = jarFile.getInputStream(entry)) {
                    Yaml yaml = new Yaml();
                    Map<String, Object> yamlData = yaml.load(is);
                    String name = (String) yamlData.get("name");
                    return name;
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
            } else {
                System.out.println(Prefix + "файл не является spigot плагином");
                System.exit(-1);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return "Fail!";
    }
}