package Models;

import Exception.ExceptionCustomer;

import java.util.Scanner;

public class Customer {
    private String nameCustomer;
    private String birthday;
    private String gender;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String typeCustomer;
    private String address;
    private Services service;


    public Customer() {
    }

    public Customer(String nameCustomer, String birthday, String gender, String idCard, String phoneNumber, String email, String typeCustomer, String address, Services service) {
        this.nameCustomer = nameCustomer;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.typeCustomer = typeCustomer;
        this.address = address;
        this.service = service;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    public int getYearBirthday() {
        String temp = "";
        for (int i = birthday.length() - 4; i < birthday.length(); i++) {
            temp += birthday.charAt(i);
        }
        return new Integer(temp);
    }

    public void showInforCustomer() {
        System.out.println("NameCustomer: " + nameCustomer + "\n" +
                "Birthday: " + birthday + "\n" +
                "Gender: " + gender + "\n" +
                "IdCard: " + idCard + "\n" +
                "PhoneNumber: " + phoneNumber + "\n" +
                "Email: " + email + "\n" +
                "TypeCustomer: " + typeCustomer + "\n" +
                "Address: " + address + "\n");
    }

    public void addNewCustomer() {
        Scanner sc;

        while (true) {
            try {
                sc = new Scanner(System.in);
                System.out.print("Enter Name Customer (Format Abc Abc): ");
                String nameCustomer = ExceptionCustomer.NameException(sc.nextLine());
                this.setNameCustomer(nameCustomer);
                break;
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        while (true) {
            try {
                System.out.print("Enter Birthday Customer (Format dd/MM/yyyy): ");
                String birthdayCustomer = ExceptionCustomer.BirthdayException(sc.nextLine());
                this.setBirthday(birthdayCustomer);
                break;
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        while (true) {
            try {
                System.out.print("Enter Gender (male, female, unknown): ");
                String genderCustomer = ExceptionCustomer.GenderException(sc.nextLine());
                this.setGender(genderCustomer);
                break;
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        while (true) {
            try {
                System.out.print("Enter Id Card (Format XXX XXX XXX): ");
                String idCard = ExceptionCustomer.IdCardException(sc.nextLine());
                this.setIdCard(idCard);
                break;
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        System.out.print("Enter Phone number: ");
        this.setPhoneNumber(sc.nextLine());

        while (true) {
            try {
                System.out.print("Enter Email (Format abc@abc.abc): ");
                String emailCustomer = ExceptionCustomer.EmailException(sc.nextLine());
                this.setEmail(emailCustomer);
                break;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.print("Enter Type Customer: ");
        this.setTypeCustomer(sc.nextLine());

        System.out.print("Enter Address: ");
        this.setAddress(sc.nextLine());
    }
}
