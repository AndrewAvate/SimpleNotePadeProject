package mypanacea.com;

import java.util.*;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mypan on 14.05.2017.
 */
public class DataInput {

    private String names;
    private String value;
    private  Map<String, String> map;
    private Pattern p;
    private Matcher m;


    private void go() {

        map = new HashMap<String, String>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("add + name, для добавления контакта:");
                Thread.sleep(500);
                System.out.println(" |//////////////////<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>/////////////////|");
                Thread.sleep(500);
                System.out.println("get + name, для поиска контакта:");

                String s = scanner.next();

                names = null;
                value = null;

                if (checkAdd(s)) {
                    names = scanner.next();
                    System.out.println("Введите номер контакта:");
                    String z = scanner.next();
                    if (checkPhoneNumber(z)) {
                        value = z;
                        writeData(names, value);
                    } else {
                        System.out.println("Неверный формат ввода:");
                    }




                } else if (checkGet(s)) {
                    names = scanner.next();
                    if (checkContains(names)) {
                        System.out.println("Номер абонента " + " " +  names + " - " + map.get(names));
                    } else {
                        System.out.println("Номер не найден!");
                    }
                } else {
                    System.out.println("Неверный формат ввода:");
                }




            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    private boolean checkAdd(String userAdd){
        Pattern p = Pattern.compile("^add");
        Matcher m = p.matcher(userAdd);
        return m.lookingAt();
    }

    private   boolean checkGet(String userGet){
        Pattern p = Pattern.compile("^get");
        Matcher m = p.matcher(userGet);
        return m.lookingAt();
    }
    private   boolean checkPhoneNumber(String userPhoneNumber){
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(userPhoneNumber);
        return m.matches();
    }

    private boolean checkContains(String args){
        return map.containsKey(args);
    }

    private void writeData (String args1, String args2){
        if(checkContains(args1)){
            System.out.println("Номер уже существует");
        }
        else {map.put(args1, args2);}
    }



    public static void main(String...args){

        DataInput dataInput = new DataInput();
        dataInput.go();





    }

}
