package wtf.Wh3L1nuxXaa.transformers.ectasy;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class EctasyTransformer {

    public static boolean check(String file) {
        String targetClassName = "net.md_5.bungee.api.chat.TranslatableComponentDeserializer";
        boolean found = false;

        try (JarFile jarFile = new JarFile(file)) {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                String className;
                JarEntry entry = entries.nextElement();
                if (!entry.getName().endsWith(".class")) continue;

                className = entry.getName().replaceAll("/", ".").substring(0, entry.getName().length() - 6);
                if (className.equals(targetClassName)) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return found;
    }
}
