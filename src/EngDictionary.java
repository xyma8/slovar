import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.*;
import java.util.Map;

public class EngDictionary extends Dictionary{
    public EngDictionary() {
        super(new String("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"),
            new String("абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"), 5);

        File file = new File("eng.txt");

        if(file.exists()) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("eng.txt"))) {
                Map<String, String> readMap = (Map<String, String>) inputStream.readObject();
                setSlovar(readMap);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    protected void UpdateFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("eng.txt"))) {
            outputStream.writeObject(getSlovar());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Записано в TXT");
    }


}
