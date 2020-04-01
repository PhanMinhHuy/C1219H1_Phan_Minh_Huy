package Exception;

import java.time.LocalDate;
import java.util.Scanner;

public class ExceptionCustomer {
    private static String regex = "";
    private static Scanner sc;

    public static String NameException(String name) throws Exception {
        regex = "^(\\p{Lu}(\\p{Ll}{0,6}))( \\p{Lu}(\\p{Ll}{0,6}))*$";
        if (name.matches(regex)) {
            return name;
        } else {
            throw new Exception("Name error!!");
        }
    }

    public static String EmailException(String email) throws Exception {
        regex = "^([a-zA-Z0-9\\_\\.])+\\@([a-zA-Z0-9])+(\\.([a-z0-9])+)+$";
        if (email.matches(regex)) {
            return email;
        } else {
            throw new Exception("Email error!!");
        }
    }

    public static String GenderException(String gender) throws Exception {
        regex = "^male$|^female$|^Unknow$";
        gender = gender.toLowerCase();
        if (gender.matches(regex)) {
            char[] characters = gender.toCharArray();
            characters[0] = Character.toUpperCase(characters[0]);
            gender = new String(characters);
            return gender;
        } else {
            throw new Exception("Gender error!!");
        }
    }

    public static String IdCardException(String idCard) throws Exception {
        regex = "^\\d{3}(\\s\\d{3}){2}$";
        if (idCard.matches(regex)) {
            return idCard;
        } else {
            throw new Exception("ID Card error");
        }
    }

    public static String BirthdayException(String birthday) throws Exception {
        regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
        LocalDate date = LocalDate.now();
        if (birthday.matches(regex)) {
            String temp = "";
            for (int i = birthday.length() - 4; i < birthday.length(); i++) {
                temp += birthday.charAt(i);
            }
            Integer year = new Integer(temp);
            if (date.getYear() - year >= 18 && year > 1900) {
                return birthday;
            } else {
                throw new Exception("Birthday > 1900 và nhỏ hơn năm hiện tại 18 năm.");
            }
        } else {
            throw new Exception("Birthday error!!");
        }
    }
}


