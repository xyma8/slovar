import java.io.*;
import java.util.HashMap;
import java.util.Map;

public abstract class Dictionary {
    private Map<String, String> slovar = new HashMap<String, String>();
    private int lengthKey;
    private int lengthValue;
    private String alphabetKey;
    private String alphabetValue;
    protected String path;

    Dictionary(String alphabetKey, String alphabetValue, int lengthKey, int lengthValue) {
        setAlphabetKey(alphabetKey);
        setAlphabetValue(alphabetValue);
        setLengthKey(lengthKey);
        setLengthValue(lengthValue);
    }

    protected int getLengthKey() {
        return lengthKey;
    }

    private void setLengthKey(int l) {
        if (l <= 0) lengthKey = 1;
        else lengthKey = l;
    }

    protected int getLengthValue() {
        return lengthValue;
    }

    private void setLengthValue(int l) {
        if (l <= 0) lengthValue = 1;
        else lengthValue = l;
    }

    protected String getAlphabetKey() {
        return alphabetKey;
    }

    private void setAlphabetKey(String a) {
        if (a != null) alphabetKey = a;
        else alphabetKey = "a";
    }

    protected String getAlphabetValue() {
        return alphabetValue;
    }

    private void setAlphabetValue(String a) {
        if (a != null) alphabetValue = a;
        else alphabetValue = "a";
    }

    protected Map<String, String> getSlovar() {
        return slovar;
    }

    protected void setSlovar(Map<String, String> s) {
        if (s != null) {
            for(int i=0;i<s.size();i++) {
                for (Map.Entry<String, String> entry : s.entrySet()) {
                    if(checkKey(entry.getKey()) && checkValue(entry.getValue())) {
                        slovar.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
    }

    protected boolean checkKey(String key) {
        String error = "";
        if (key == null) error += "Ключ является null\n";
        if (key.length() != getLengthKey()) error += "Длина ключа не " + getLengthKey() + "\n";
        if (!key.matches("[" + getAlphabetKey() + "]+")) error += "Неправильные символы ключа\n";

        if(error.isEmpty()) return true;
        else return false;
    }

    protected boolean checkValue(String value) {
        String error = "";
        if (value == null) error += "Значение равно null\n";
        if (value.length() != getLengthValue()) error += "Длина значения не " + getLengthValue() + "\n";
        if (!value.matches("[" + getAlphabetValue() + "]+")) error += "Неправильные символы значения\n";

        if(error.isEmpty()) return true;
        else return false;
    }

    protected void addWord(String key, String value) throws WordAddedException2 {
        /*
        String error = "";
        if (key == null) error += "Ключ является null\n";
        if (key.length() != getLengthKey()) error += "Длина ключа не " + getLengthKey() + "\n";
        if (!key.matches("[" + getAlphabetKey() + "]+")) error += "Неправильные символы ключа\n";
        if (value == null) error += "Значение равно null\n";
        if (value.length() != getLengthValue()) error += "Длина значения не " + getLengthValue() + "\n";
        if (!value.matches("[" + getAlphabetValue() + "]+")) error += "Неправильные символы значения\n";

        if (!error.isEmpty()) throw new WordAddedException(error);
        else {
            slovar.put(key, value);
            UpdateFile();
        }
        */
        if(checkKey(key) && checkValue(value)) {
            slovar.put(key, value);
            UpdateFile();
        }

    }

    protected void deleteWord(String key) throws KeyNotExistsException2 {
        if (keyExists(key)) {
            getSlovar().remove(key);
            UpdateFile();
        }
    }

    protected String findWordByKey(String key) throws KeyNotExistsException2 {
        if (keyExists(key)) {
            return getSlovar().get(key);
        } else return new String("");
    }

    protected String[] outputAll() {
        String[] temp = new String[slovar.size()];
        int index = 0;
        for (Map.Entry<String, String> entry : slovar.entrySet()) {
            String keyValue = entry.getKey() + "=" + entry.getValue();
            temp[index] = keyValue;
            index++;
        }
        return temp;
    }

    private boolean keyExists(String key) throws KeyNotExistsException2 {
        if (getSlovar().get(key) != null || (getSlovar().get(key) == null && getSlovar().containsKey(key))) {
            return true;
        } else {
            throw new KeyNotExistsException2("Ключ не найден");
        }
    }

    protected void LoadFile(String p) {
        path = p+".gc";
        File file = new File(path);
        if (file.exists()) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))) {
                Map<String, String> readMap = (Map<String, String>) inputStream.readObject();
                setSlovar(readMap);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    void UpdateFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            outputStream.writeObject(getSlovar());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
