package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static final Properties properties = new Properties(); //Crea un objeto Properties, una estructura clave-valor (como un Map) usada para cargar archivos .properties

    static {
        String env = System.getProperty("env", "qa"); // valor por defecto: qa
        String path = "src/test/resources/config-" + env + ".properties"; //Forma el path del archivo a leer
        try (FileInputStream input = new FileInputStream(path)) { //lee el archivo en el path
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo cargar el archivo de configuración: " + path);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
