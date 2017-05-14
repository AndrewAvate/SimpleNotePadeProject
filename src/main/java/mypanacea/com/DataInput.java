package mypanacea.com;

import java.io.InputStreamReader;
import java.nio.file.FileSystemNotFoundException;
import java.util.*;
import java.util.Map;

/**
 * Created by mypan on 14.05.2017.
 */
public class DataInput {
    private String names;
    private Integer value;
    private  Map<String, Integer> map;

    private void userInput() {
        map = new HashMap<String, Integer>();
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Введите имя: в формате get name для поиска существующего контакта");
                System.out.println("Введите имя: в формате add name для добавления контакта");
                String s = scanner.next();
                if (s.contains("add")) {
                    names = scanner.next();
                    System.out.println("Введите номер телефона");
                    value = scanner.nextInt();
                    map.put(names, value);
                    names = null;
                    value = 0;

                } else if (s.contains("get")) {
                    names = scanner.next();
                    if (map.containsKey(names)) {
                        System.out.println("телефон абонента " + names + " " +  map.get(names));
                    }
                    else{
                        System.out.println("Запись не найдена");
                    }


                }
                else if(s.contains("end")){
                    break;

                }
                else {
                    System.out.println("Неправильный формат ввода");
                }


            }

        }  catch (Exception e){
            e.printStackTrace();

        }
    }




    public static void main(String...args){
        DataInput dataInput = new DataInput();
        dataInput.userInput();
    }

}
