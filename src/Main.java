import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Map<String, String> slovar1 = new HashMap<String, String>();
        Map<String, String> slovar2 = new HashMap<String, String>();
        int menu = 0;
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
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

    }

    private static void findEntryByKey() {

    }

    private static void addEntry() {

    }
}