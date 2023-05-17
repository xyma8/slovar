import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.*;
import java.util.Map;

public class EngDictionary extends Dictionary{
    public EngDictionary() {
        super(new String("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"),
                new String("абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"), 4, 5);

        //File file = new File("eng.gc");
        //LoadFile(file);
    }


}
