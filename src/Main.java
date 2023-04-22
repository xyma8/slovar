import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static Dictionary eng = new EngDictionary();
    static Scanner scanner = new Scanner(new InputStreamReader(System.in));
    public static void main(String[] args){
        int menu = 0;
        System.out.println("Меню:");
        while(menu != 5) {
            System.out.println("1 - чтение списка пар из файла");
            System.out.println("2 - удаление записи по ключу");
            System.out.println("3 - поиск записи по ключу");
            System.out.println("4 - добавить запись");
            System.out.println("5 - vihod");
            String str = scanner.next();
            try {
                menu = Integer.parseInt(str);
            } catch (Exception e) {
                System.out.println("Введено неправильное значение");
            }

            if(menu==1) readFromSlovar();
            if(menu==2) deleteEntry();
            if(menu==3) findEntryByKey();
            if(menu==4) addEntry();
        }
    }

    private static void readFromSlovar() {       

    }

    private static void deleteEntry() {
        System.out.println("Введите ключ:");
        String key = scanner.next();
        try{
            eng.deleteWord(key);
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
            String value = eng.findWordByKey(key);
            System.out.println("По ключу "+key+" значение - "+value);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    private static void addEntry() {
        System.out.println("Введите ключ:");
        String key = scanner.next();
        System.out.println("Введите значение");
        String value = scanner.next();
        try {
            eng.addWord(key, value);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}