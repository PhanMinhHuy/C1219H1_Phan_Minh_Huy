package Controllers;

import Commons.FuncFileCSV;
import Models.*;
import Sort.NameCustomerComparator;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class MainController {
    private static ArrayList<Villa> listVilla = new ArrayList<>();
    private static ArrayList<House> listHouse = new ArrayList<>();
    private static ArrayList<Room> listRoom = new ArrayList<>();
    private static ArrayList<Customer> listCustomer = new ArrayList<>();
    private static ArrayList<Customer> listBooking = new ArrayList<>();
    private static ArrayList<Employee> listEmployee = new ArrayList<>();
    private static Queue<Customer> customerQueue = new LinkedList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        System.out.println("--^-^-- Main menu --^-^--");
        System.out.println(
                "1. Add new services" +
                        "\n2. Show services" +
                        "\n3. Add new customer" +
                        "\n4. Show information of customer" +
                        "\n5. Add new booking" +
                        "\n6. Show information of employee" +
                        "\n7. Add booking cinema 4D" +
                        "\n8. Show booking cinema 4D" +
                        "\n9. Search Filing Cabinets of Employee" +
                        "\n10. Exit");
        String choose = sc.nextLine();
        switch (choose) {
            case "1":
                addNewServices();
                break;
            case "2":
                showServices();
                break;
            case "3":
                addNewCustomer();
                break;
            case "4":
                showInforOfCusromer();
                break;
            case "5":
                addNewBooking();
                break;
            case "6":
                showInforOfEmployee();
                break;
            case "7": {
                addBookingCinema();
                break;
            }
            case "8": {
                showBookingCinema();
                break;
            }
            case "9": {
                searchFilingCabinetsOfEmployee();
                break;
            }
            case "10":
                System.exit(0);
                break;
            default:
                System.out.println("Fail!!! Choose again....\n Enter to continue");
                sc.nextLine();
                displayMainMenu();
                break;
        }
    }

    private static void addNewServices() {
        System.out.println(
                "1. Add new Villa" +
                        "\n2. Add new House" +
                        "\n3. Add new Room" +
                        "\n4. Back to menu" +
                        "\n5. Exit");

        String choose = sc.nextLine();
        switch (choose) {
            case "1":
                listVilla = FuncFileCSV.readVillaCsvToListVilla();
                System.out.println("Enter number of villa you want add: ");
                int length = sc.nextInt();
                for (int i = 0; i < length; i++) {
                    System.out.println("---------Villa " + (i + 1) + "---------");
                    Villa villa = new Villa();
                    villa.addListVillaService();
                    listVilla.add(villa);
                }
                FuncFileCSV.writeVillaToFileCSV(listVilla);
                break;
            case "2":
                listHouse = FuncFileCSV.readHouseCsvToListHouse();
                System.out.println("Enter number of house you want add: ");
                length = sc.nextInt();
                for (int i = 0; i < length; i++) {
                    System.out.println("---------House " + (i + 1) + "---------");
                    House house = new House();
                    house.addListHouseService();
                    listHouse.add(house);
                }
                FuncFileCSV.writeHouseToFileCSV(listHouse);
                break;
            case "3":
                listRoom = FuncFileCSV.readRoomCsvToListRoom();
                System.out.println("Enter number of room you want add: ");
                length = sc.nextInt();
                for (int i = 0; i < length; i++) {
                    System.out.println("---------Room " + (i + 1) + "---------");
                    Room room = new Room();
                    room.addListRoomService();
                    listRoom.add(room);
                }
                FuncFileCSV.writeRoomToFileCSV(listRoom);
                break;
            case "4":
                displayMainMenu();
                break;
            case "5":
                System.exit(0);
                break;
            default:
                System.out.println("Fail!!! Choose again....\n Enter to continue");
                sc.nextLine();
                addNewServices();
                break;
        }
        displayMainMenu();
    }

    private static void showServices() {
        System.out.println(
                "1. Show all Villa" +
                        "\n2. Show all House" +
                        "\n3. Show all Room" +
                        "\n4. Show All Name Villa Not Duplicate" +
                        "\n5. Show All Name House Not Duplicate" +
                        "\n6. Show All Name Room Not Duplicate" +
                        "\n7. Back to menu" +
                        "\n8. Exit");

        String choose = sc.nextLine();
        switch (choose) {
            case "1":
                listVilla = FuncFileCSV.readVillaCsvToListVilla();
                for (Villa villa : listVilla) {
                    System.out.println("----------____----------\n");
                    villa.showInfor();
                }
                break;
            case "2":
                listHouse = FuncFileCSV.readHouseCsvToListHouse();
                for (House house : listHouse) {
                    System.out.println("----------____----------\n");
                    house.showInfor();
                }
                break;
            case "3":
                listRoom = FuncFileCSV.readRoomCsvToListRoom();
                for (Room room : listRoom) {
                    System.out.println("----------____----------\n");
                    room.showInfor();
                }
                break;
            case "4":
                TreeSet<String> villaTreeSet = FuncFileCSV.readAllNameServiceFromCSV(FuncFileCSV.CSV_FILE_VILLA);
                for (String str : villaTreeSet) {
                    System.out.println("----------____----------\n");
                    System.out.println(str);
                }
                break;
            case "5":
                TreeSet<String> houseTreeSet = FuncFileCSV.readAllNameServiceFromCSV(FuncFileCSV.CSV_FILE_HOUSE);
                for (String str : houseTreeSet) {
                    System.out.println("----------____----------\n");
                    System.out.println(str);
                }
                break;
            case "6":
                TreeSet<String> roomTreeSet = FuncFileCSV.readAllNameServiceFromCSV(FuncFileCSV.CSV_FILE_ROOM);
                for (String str : roomTreeSet) {
                    System.out.println("----------____----------\n");
                    System.out.println(str);
                }
                break;
            case "7":
                displayMainMenu();
                break;
            case "8":
                System.exit(0);
                break;
            default:
                System.out.println("Fail!!! Choose again....\n Enter to continue");
                sc.nextLine();
                showServices();
                break;
        }
        System.out.println("Enter to continue");
        sc.nextLine();
        displayMainMenu();
    }

    private static void addNewCustomer() {
        listCustomer = FuncFileCSV.readCustomerCsvToListCustomer();
        System.out.println("Enter number of customer you want add: ");
        int length = sc.nextInt();
        for (int i = 0; i < length; i++) {
            System.out.println("---------Customer " + (i + 1) + "---------");
            Customer customer = new Customer();
            customer.addNewCustomer();
            listCustomer.add(customer);
        }
        FuncFileCSV.writeCustomerToFileCSV(listCustomer);
        displayMainMenu();
    }

    private static void showInforOfCusromer() {
        listCustomer = FuncFileCSV.readCustomerCsvToListCustomer();
        Collections.sort(listCustomer, new NameCustomerComparator());
        for (Customer customer : listCustomer) {
            System.out.println("----------____----------\n");
            customer.showInforCustomer();
        }
        System.out.println("Enter to continue");
        sc.nextLine();
        displayMainMenu();
    }

    private static void addNewBooking() {
        listCustomer = FuncFileCSV.readCustomerCsvToListCustomer();
        Collections.sort(listCustomer, new NameCustomerComparator());
        for (int i = 0; i < listCustomer.size(); i++) {
            System.out.println("---------- " + "Customer" + (i + 1) + " ----------\n");
            listCustomer.get(i).showInforCustomer();
        }
        System.out.print("Enter your choice: ");
        int choiceCustomer = sc.nextInt();
        while (choiceCustomer < 1 || choiceCustomer > listCustomer.size()) {
            System.out.println("Size of list Customer: " + listCustomer.size() + ", choice: " + choiceCustomer);
            System.out.print("Enter your choice: ");
            choiceCustomer = sc.nextInt();
        }

        Customer customer = listCustomer.get(choiceCustomer - 1);
        System.out.println("1. Booking Villa" +
                "\n2. Booking House " +
                "\n3. Booking Room");
        int choiceBooking = sc.nextInt();
        while (choiceBooking < 1 || choiceBooking > 3) {
            System.out.println("Error!");
            System.out.println();
            System.out.println("1. Booking Villa" +
                    "\n2. Booking House " +
                    "\n3. Booking Room");
            choiceBooking = sc.nextInt();
        }
        switch (choiceBooking) {
            case 1: {
                listVilla = FuncFileCSV.readVillaCsvToListVilla();
                for (int i = 0; i < listVilla.size(); i++) {
                    System.out.println("---------- " + "Villa" + (i + 1) + " ----------\n");
                    listVilla.get(i).showInfor();
                }
                System.out.print("Enter choice booking Villa:");
                Villa villa = listVilla.get(sc.nextInt() - 1);
                customer.setService(villa);
                break;
            }
            case 2: {
                listHouse = FuncFileCSV.readHouseCsvToListHouse();
                for (int i = 0; i < listHouse.size(); i++) {
                    System.out.println("---------- " + "House" + (i + 1) + " ----------\n");
                    listHouse.get(i).showInfor();
                }
                System.out.print("Enter choice booking house:");
                House house = listHouse.get(sc.nextInt() - 1);
                customer.setService(house);
                break;
            }
            case 3: {
                listRoom = FuncFileCSV.readRoomCsvToListRoom();
                for (int i = 0; i < listRoom.size(); i++) {
                    System.out.println("---------- " + "Room" + (i + 1) + " ----------\n");
                    listRoom.get(i).showInfor();
                }
                System.out.print("Enter choice booking room:");
                Room room = listRoom.get(sc.nextInt() - 1);
                customer.setService(room);
                break;
            }
            default: {
                displayMainMenu();
            }
        }
        listBooking = FuncFileCSV.readBookingCustomerCsvToListCustomer();
        listBooking.add(customer);
        FuncFileCSV.writeBookingCustomerToFileCSV(listBooking);

        System.out.println("Enter to continue");
        sc.nextLine();
        displayMainMenu();
    }

    private static void showInforOfEmployee() {
        Map<String, Employee> employeeMap = new HashMap<>();
        listEmployee = FuncFileCSV.readEmployeeCsvToListEmployee();
        for (Employee employee : listEmployee) {
            employeeMap.put(employee.getIdEmployee(), employee);
        }
        for (Map.Entry<String, Employee> entry : employeeMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().toString());
            System.out.println("----------____----------\n");
        }
        System.out.println("Enter to continue");
        sc.nextLine();
        displayMainMenu();
    }

    private static void addBookingCinema() {
        System.out.println("Enter number ticket: ");
        int numberTicket = sc.nextInt();
        while (numberTicket < 1) {
            System.out.println("Number ticket must > 0");
        }
        for (int i = 0; i < numberTicket; i++) {
            Customer customer = new Customer();
            customer.addNewCustomer();
            customerQueue.add(customer);
        }
        System.out.println("Enter to continue");
        sc.nextLine();
        displayMainMenu();
    }

    private static void showBookingCinema() {
        while (true) {
            Customer customer = customerQueue.poll();
            if (customer == null) {
                break;
            } else {
                customer.showInforCustomer();
            }
        }
        System.out.println("Enter to continue");
        sc.nextLine();
        displayMainMenu();
    }

    private static void searchFilingCabinetsOfEmployee() {
        Stack<Employee> employeeStack = new Stack<>();
        listEmployee = FuncFileCSV.readEmployeeCsvToListEmployee();
        for (Employee employee : listEmployee) {
            employeeStack.push(employee);
        }
        System.out.print("Enter id of Employee: ");
        String idEmployee = sc.nextLine();
        while (true) {
            Employee employee = employeeStack.pop();
            if (employee == null) {
                System.out.println("Not found employee");
                break;
            }
            if (idEmployee.equals(employee.getIdEmployee())) {
                System.out.println("----------____----------\n");
                System.out.println(employee);
                System.out.println("----------____----------\n");
                break;
            }
        }
        System.out.println("Enter to continue");
        sc.nextLine();
        displayMainMenu();
    }
}
