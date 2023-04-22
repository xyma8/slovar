public class OneDictionary extends Dictionary{
    public OneDictionary() {
        super(new String("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"),
            new String("абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"), 5);


    }

    protected void UpdateFile() {
        System.out.println("updated");
    }


}
