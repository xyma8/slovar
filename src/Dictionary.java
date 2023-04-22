import java.util.HashMap;
import java.util.Map;

public abstract class Dictionary {
    private Map<String, String> slovar = new HashMap<String, String>();
    private int lengthKey;
    private String alphabetKey;
    private String alphabetValue;

    Dictionary(String alphabetKey, String alphabetValue, int lengthKey) {
        setAlphabetKey(alphabetKey);
        setAlphabetValue(alphabetValue);
        setLengthKey(lengthKey);
    }

    protected int getLengthKey() {
        return lengthKey;
    }

    protected void setLengthKey(int l) {
        if(l<=0) lengthKey = 1;
        else lengthKey = l;
    }

    protected String getAlphabetKey() {
        return alphabetKey;
    }

    protected void setAlphabetKey(String a) {
        if(a != null) alphabetKey = a;
        else alphabetKey = "a";
    }

    protected String getAlphabetValue() {
        return alphabetValue;
    }

    protected void setAlphabetValue(String a) {
        if(a != null) alphabetValue = a;
        else alphabetValue = "a";
    }

    protected Map<String, String> getSlovar() {
        return slovar;
    }

    protected void setSlovar(Map<String, String> s) {
        if(s != null) slovar = s;
    }

    protected void addWord(String key, String value) throws WordNotAdded {
        if((key != null && key.length() == getLengthKey() && key.matches("["+getAlphabetKey()+"]+"))
        && (value != null && value.matches("["+getAlphabetValue()+"]+"))) {
            slovar.put(key, value);
            UpdateFile();
        }
        else throw new WordNotAdded("Слово не добавлено");
    }
    
    protected void deleteWord(String key) throws KeyNotExistsException {
        if(keyExists(key)) {
            getSlovar().remove(key);
            UpdateFile();
        }
    }

    protected String findWordByKey(String key) throws KeyNotExistsException {
        if(keyExists(key)) {
            return getSlovar().get(key);
        }
        else return new String("");
    }

    private boolean keyExists(String key) throws KeyNotExistsException {
        if(getSlovar().get(key) != null || (getSlovar().get(key) == null && getSlovar().containsKey(key))) {
            return true;
        }
        else  {
            throw new KeyNotExistsException("Ключ не найден");         
        }
    }

    protected abstract void UpdateFile();

}
