import java.io.*;
import java.util.Map;

public class DigitDictionary extends Dictionary{
    //String path = "digit.gc";
    public DigitDictionary() {
        super(new String("1234567890"),
                new String("абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"), 5, 4);

        //File file = new File("digit.pc");
        //LoadFile(file);
    }
}
