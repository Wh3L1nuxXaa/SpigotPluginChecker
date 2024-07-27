package wtf.Wh3L1nuxXaa.transformers.antihack;

import static wtf.Wh3L1nuxXaa.Library.methodExistsInJar;

public class AntiHackTransformer {

    public static boolean check(String jarPath, String className) {
        for (String methodName : methodsToCheck) {
            boolean exists = methodExistsInJar(jarPath, className, methodName);
            if (exists == true)
                return true;

            if (exists == false)
                return false;
        }
        return false;
    }

    static String[] methodsToCheck = {
            "downloadFile",
            "unbanPlayer",
            "onAsyncPlayerPreLogin",
            "onPlayerKick",
            "onChat"
    };
}
