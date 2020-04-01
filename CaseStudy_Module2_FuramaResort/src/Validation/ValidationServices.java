package Validation;


import java.util.Scanner;

public class ValidationServices {
    private static String regex = "";
    private static Scanner sc;

    public static String InputAndCheckValidationIdService(String typeService) {
        String idService = "";
        switch (typeService) {
            case "villa":
                System.out.println("Enter villa ID: ");
                regex = "^SVVL-\\d{4}$";
                while (true) {
                    sc = new Scanner(System.in);
                    idService = sc.nextLine();
                    if (idService.matches(regex)) {
                        break;
                    } else {
                        System.out.println("ID incorrect!! Enter again:");
                    }
                }
                break;
            case "house":
                System.out.println("Enter house ID: ");
                regex = "^SVHO-\\d{4}$";
                while (true) {
                    sc = new Scanner(System.in);
                    idService = sc.nextLine();
                    if (idService.matches(regex)) {
                        break;
                    } else {
                        System.out.println("ID incorrect!! Enter again:");
                    }
                }
                break;
            case "room":
                System.out.println("Enter room ID: ");
                regex = "^SVRO-\\d{4}$";
                while (true) {
                    sc = new Scanner(System.in);
                    idService = sc.nextLine();
                    if (idService.matches(regex)) {
                        break;
                    } else {
                        System.out.println("ID incorrect!! Enter again:");
                    }
                }
                break;
        }
        return idService;
    }

    public static String InputAndCheckValidationServiceName() {
        System.out.println("Enter Service Name: ");
        regex = "^(\\p{Lu}(\\p{Ll}{0,6}))( \\p{Lu}(\\p{Ll}{0,6}))*$";
        while (true) {
            sc = new Scanner(System.in);
            String serviceName = sc.nextLine();
            if (serviceName.matches(regex)) {
                return serviceName;
            } else {
                System.out.println("Service Name incorrect!! \nEnter again....Format: Abc Abc");
            }
        }
    }

    public static Double InputAndCheckValidationAreaUsedOrAreaPool(String usedOrPool) {
        if (usedOrPool.equals("used")) {
            System.out.println("Enter Area used: ");
        }
        if (usedOrPool.equals("pool")) {
            System.out.println("Enter Area pool: ");
        }
        while (true) {
            try {
                sc = new Scanner(System.in);
                Double area = sc.nextDouble();
                if (area > 30) {
                    return area;
                } else {
                    System.out.println("Area must be greater than 30\nEnter again:");
                }
            } catch (Exception e) {
                System.out.println("Wrong data type!!\nEnter again:");
            }
        }
    }

    public static Double InputAndCheckValidationRentalCosts() {
        System.out.println("Enter Rental costs: ");
        while (true) {
            try {
                sc = new Scanner(System.in);
                Double rentalCosts = sc.nextDouble();
                if (rentalCosts > 0) {
                    return rentalCosts;
                } else {
                    System.out.println("Area must be greater than 0\nEnter again:");
                }
            } catch (Exception e) {
                System.out.println("Wrong data type!!\nEnter again:");
            }
        }
    }

    public static Integer InputAndCheckValidationMaxPeople() {
        System.out.println("Enter Max Number Of People: ");
        while (true) {
            try {
                sc = new Scanner(System.in);
                int maxNumberOfPeople = sc.nextInt();
                if (maxNumberOfPeople > 0 && maxNumberOfPeople < 20) {
                    return maxNumberOfPeople;
                } else {
                    System.out.println("Max Number Of People must be between 0 and 30\\nEnter again:\"");
                }
            } catch (Exception e) {
                System.out.println("Wrong data type!!\nEnter again:");
            }
        }
    }

    public static String InputAndCheckValidationRentTypeOrStandardRoom(String renTypeOrStandardRoom) {
        if (renTypeOrStandardRoom.equals("rent type")) {
            System.out.println("Enter Rent type: ");
        }
        if (renTypeOrStandardRoom.equals("standard room")) {
            System.out.println("Enter Standard Room: ");
        }
        regex = "^(\\p{Lu}(\\p{Ll}{0,6}))( \\p{Lu}(\\p{Ll}{0,6}))*$";
        while (true) {
            sc = new Scanner(System.in);
            String typeRentOrRoomStandard = sc.nextLine();
            if (typeRentOrRoomStandard.matches(regex)) {
                return typeRentOrRoomStandard;
            } else {
                System.out.println("Rent Type Or Standard Room incorrect!! \nEnter again....Format: Abc Abc");
            }
        }
    }

    public static String InputAndCheckValidationServiceFree() {
        System.out.println("Enter Service Free: \n(Massage, Karaoke, Food, Drink, Car)");
        while (true) {
            sc = new Scanner(System.in);
            String serviceFree = sc.nextLine();
            switch (serviceFree) {
                case "Massage":
                case "Karaoke":
                case "Food":
                case "Drink":
                case "Car":
                    return serviceFree;
                default:
                    System.out.println("Service Free must be: Massage, Karaoke, Food, Drink or Car)\nEnter again:");
            }
        }
    }

    public static Integer inputAndCheckValidationNumberOfFloors() {
        System.out.println("Enter Number Of Floors: ");
        while (true) {
            try {
                sc = new Scanner(System.in);
                Integer numberOfFloors = sc.nextInt();
                if (numberOfFloors > 0) {
                    return numberOfFloors;
                } else {
                    System.out.println("Number Of Floors must be greater than 0\nEnter again:");
                }
            } catch (Exception e) {
                System.out.println("Wrong data type!!\nEnter again:");
            }
        }
    }

}
