import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Dictionary dct;
    static Scanner scanner = new Scanner(new InputStreamReader(System.in));
    public static void main(String[] args){
        dct = new EngDictionary();
        int menu = -1;
        System.out.println("Меню:");
        changeDictionary();
        loadFile();
        while(menu != 0) {
            System.out.println();
            System.out.println("1 - Сменить словарь");
            System.out.println("2 - Чтение списка пар из словаря");
            System.out.println("3 - Удаление записи по ключу");
            System.out.println("4 - Поиск записи по ключу");
            System.out.println("5 - Добавить запись");
            System.out.println("6 - Информация о словаре");
            System.out.println("7 - Изменить путь к файлу");
            System.out.println("0 - Выход");
            String str = scanner.next();
            try {
                menu = Integer.parseInt(str);
            } catch (Exception e) {
                System.out.println("Введено неправильное значение");
            }
            if(menu==1) changeDictionary();
            if(menu==2) readFromSlovar();
            if(menu==3) deleteEntry();
            if(menu==4) findEntryByKey();
            if(menu==5) addEntry();
            if(menu==6) infoDictionary();
            if(menu==7) loadFile();
        }
    }

    private static void changeDictionary() {
        int menu = -1;
        System.out.println("Выбор словаря:");
        while (menu != 0) {
            System.out.println("1 - Латинские буквы");
            System.out.println("2 - Цифры");
            System.out.println("0 - Выход в меню");
            String str = scanner.next();
            try {
                menu = Integer.parseInt(str);
            } catch (Exception e) {
                System.out.println("Введено неправильное значение");
            }
            if (menu == 1) {
                dct = new EngDictionary();
                break;
            }
            if (menu == 2) {
                dct = new DigitDictionary();
                break;
            }
        }
        infoDictionary();
    }

    private static void loadFile() {
        System.out.println("Введите путь к файлу словаря");
        String str = scanner.next();
        dct.LoadFile(str);
    }

    private static void readFromSlovar() {
        String[] spisok = dct.outputAll();
        if(spisok.length==0) System.out.println("Список пуст");
        for(int i=0;i<spisok.length;i++) {
            System.out.println(spisok[i]);
        }
    }

    private static void deleteEntry() {
        System.out.println("Введите ключ:");
        String key = scanner.next();
        try{
            dct.deleteWord(key);
            System.out.println(key+" удалено");
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    private static void findEntryByKey() {
        System.out.println("Введите ключ:");
        String key = scanner.next();
        try{
            String value = dct.findWordByKey(key);
            System.out.println("По ключу "+key+" значение - "+value);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    private static void addEntry() {
        boolean r = false;
        while(!r) {
        System.out.println("Введите ключ:");
        String key = scanner.next();
        System.out.println("Введите значение");
        String value = scanner.next();
            try {
                dct.addWord(key, value);
                r = true;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private static void infoDictionary() {
        System.out.println("Алфавит ключа: "+dct.getAlphabetKey());
        System.out.println("Алфавит значения: "+dct.getAlphabetValue());
        System.out.println("Длина ключа: "+dct.getLengthKey());
        System.out.println("Длина значения: "+dct.getLengthValue());
    }
}