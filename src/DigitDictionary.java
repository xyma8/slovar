import java.io.*;
import java.util.Map;

public class DigitDictionary extends Dictionary{
    final String PATH = "digit.txt";
    public DigitDictionary() {
        super(new String("1234567890"),
                new String("абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"), 4);

        File file = new File(PATH);
        LoadFile(file);
    }


    protected void LoadFile(File file) {
        if(file.exists()) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(PATH))) {
                Map<String, String> readMap = (Map<String, String>) inputStream.readObject();
                setSlovar(readMap);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    protected void UpdateFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(PATH))) {
            outputStream.writeObject(getSlovar());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Записано в TXT");
    }
}
