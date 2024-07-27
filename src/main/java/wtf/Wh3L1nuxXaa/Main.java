package wtf.Wh3L1nuxXaa;

import wtf.Wh3L1nuxXaa.transformers.antihack.AntiHackTransformer;
import wtf.Wh3L1nuxXaa.transformers.ectasy.EctasyTransformer;
import wtf.Wh3L1nuxXaa.transformers.thiccindustries.ThiccTransformer;
import wtf.Wh3L1nuxXaa.transformers.zavet.ZavetTransformer;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static wtf.Wh3L1nuxXaa.Library.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите имя .jar файла");
        Scanner sc = new Scanner(System.in);
        String jarfile = sc.nextLine();
        File pluginFile = new File(jarfile);
        String mainClass = getPluginMainClass(jarfile);
        String pluginName = getPluginName(jarfile);
        Path input = Paths.get(jarfile);

        if (!input.toFile().exists()) {
            System.out.println(" Input file: " + input.getFileName() + " does not exist.");
            System.exit(-1);
        }

        if (checkPackageExists(pluginFile, ThiccTransformer.ThiccCheckTransformer))
            System.out.println("[" + pluginName + "] Найден Thicc Industries");

        if (EctasyTransformer.check(jarfile) == true)
            System.out.println("[" + pluginName + "] Найден Ectasy");

        if (ZavetTransformer.checkClass1(jarfile) && ZavetTransformer.checkClass2(jarfile) && ZavetTransformer.checkClass3(jarfile) && ZavetTransformer.checkClass4(jarfile) && ZavetTransformer.checkClass5(jarfile) && ZavetTransformer.checkClass6(jarfile) && ZavetTransformer.checkClass7(jarfile) && ZavetTransformer.checkClass8(jarfile) && ZavetTransformer.checkClass9(jarfile) && ZavetTransformer.checkClass10(jarfile) && ZavetTransformer.checkClass11(jarfile) && ZavetTransformer.checkClass12(jarfile) && ZavetTransformer.checkClass13(jarfile) && ZavetTransformer.checkClass14(jarfile) && ZavetTransformer.checkClass15(jarfile) && ZavetTransformer.checkClass15(jarfile) && ZavetTransformer.checkClass16(jarfile))
            System.out.println(("[" + pluginName + "] Найден Zavet"));

        if (AntiHackTransformer.check(jarfile, mainClass) == true)
            System.out.println("[" + pluginName + "] Найден AntiHackBackdoor");
    }
}
