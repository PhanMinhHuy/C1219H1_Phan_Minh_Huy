package Commons;

import Models.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FuncFileCSV {
    public static final String COMMA_DELIMITER = ",";
    public static final String NEW_LINE_SEPARATOR = "\n";
    public static final String CSV_FILE_VILLA = "src/data/Villa.csv";
    public static final String CSV_FILE_HOUSE = "src/data/House.csv";
    public static final String CSV_FILE_ROOM = "src/data/Room.csv";
    public static final String CSV_FILE_CUSTOMER = "src/data/Customer.csv";
    public static final String CSV_FILE_BOOKING = "src/data/Booking.csv";

    //CSV file Header
    public static final String[] FILE_VILLA_HEADER = {"ID", "Service Name", "Area Used", "Rental Costs", "Max People", "Rent Type", "Standard Room", "Convenient Description", "Area Pool", "Number Of Floors"};
    public static final String[] FILE_HOUSE_HEADER = {"ID", "Service Name", "Area Used", "Rental Costs", "Max People", "Rent Type", "Standard Room", "Convenient Description", "Number Of Floors"};
    public static final String[] FILE_ROOM_HEADER = {"ID", "Service Name", "Area Used", "Rental Costs", "Max People", "Rent Type", "Service Free"};
    public static final String[] FILE_CUSTOMER_HEADER = {"Name Customer", "Birthday", "Gender", "ID Card", "Phone Number", "Email", "Type Customer", "Address"};
    public static final String[] FILE_BOOKING_HEADER = {"Name Customer", "Birthday", "Gender", "ID Card", "Phone Number", "Email", "Type Customer", "Address", "Id", "Service Name", "Area Used", "Rental Costs", "Max People", "Rent Type"};

    public static void writeVillaToFileCSV(ArrayList<Villa> listVilla) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(CSV_FILE_VILLA);
            fileWriter.append(Arrays.toString(FILE_VILLA_HEADER));
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (Villa villa : listVilla) {
                fileWriter.append(villa.getId());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getServiceName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getAreaUsed()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getRentalCosts()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getMaxPeople()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getRentType());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getStandardRoom());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getConvenientDescription());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getAreaPool()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getNumberOfFloors()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("CSV file was created successfully !!!");
        } catch (Exception e) {
            System.out.println("Error in CSVFileWriter!!");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                System.out.println("Error when flush or close!!");
            }
        }
    }

    public static ArrayList<Villa> readVillaCsvToListVilla() {
        BufferedReader br = null;
        ArrayList<Villa> listVilla = new ArrayList<>();
        Path path = Paths.get(CSV_FILE_VILLA);
        if (!Files.exists(path)) {
            try {
                FileWriter writer = new FileWriter(CSV_FILE_VILLA);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            br = new BufferedReader(new FileReader(CSV_FILE_VILLA));
            String line;

            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("[ID"))
                    continue;
                Villa villa = new Villa();
                villa.setId(splitData[0]);
                villa.setServiceName(splitData[1]);
                villa.setAreaUsed(Double.parseDouble(splitData[2]));
                villa.setRentalCosts(Double.parseDouble(splitData[3]));
                villa.setMaxPeople(Integer.parseInt(splitData[4]));
                villa.setRentType(splitData[5]);
                villa.setStandardRoom(splitData[6]);
                villa.setConvenientDescription(splitData[7]);
                villa.setAreaPool(Double.parseDouble(splitData[8]));
                villa.setNumberOfFloors(Integer.parseInt(splitData[9]));
                listVilla.add(villa);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return listVilla;
    }

    public static void writeHouseToFileCSV(ArrayList<House> listHouse) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(CSV_FILE_HOUSE);
            fileWriter.append(Arrays.toString(FILE_HOUSE_HEADER));
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (House house : listHouse) {
                fileWriter.append(house.getId());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getServiceName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(house.getAreaUsed()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(house.getRentalCosts()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(house.getMaxPeople()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getRentType());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getStandardRoom());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getConvenientDescription());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(house.getNumberOfFloors()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("CSV file was created successfully !!!");
        } catch (Exception e) {
            System.out.println("Error in CSVFileWriter!!");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                System.out.println("Error when flush or close!!");
            }
        }
    }

    public static ArrayList<House> readHouseCsvToListHouse() {
        BufferedReader br = null;
        ArrayList<House> listHouse = new ArrayList<>();
        Path path = Paths.get(CSV_FILE_HOUSE);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(CSV_FILE_HOUSE);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            br = new BufferedReader(new FileReader(CSV_FILE_HOUSE));
            String line;

            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("[ID"))
                    continue;
                House house = new House();
                house.setId(splitData[0]);
                house.setServiceName(splitData[1]);
                house.setAreaUsed(Double.parseDouble(splitData[2]));
                house.setRentalCosts(Double.parseDouble(splitData[3]));
                house.setMaxPeople(Integer.parseInt(splitData[4]));
                house.setRentType(splitData[5]);
                house.setStandardRoom(splitData[6]);
                house.setConvenientDescription(splitData[7]);
                house.setNumberOfFloors(Integer.parseInt(splitData[8]));
                listHouse.add(house);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return listHouse;
    }

    public static void writeRoomToFileCSV(ArrayList<Room> listRoom) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(CSV_FILE_ROOM);
            fileWriter.append(Arrays.toString(FILE_ROOM_HEADER));
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (Room room : listRoom) {
                fileWriter.append(room.getId());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(room.getServiceName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(room.getAreaUsed()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(room.getRentalCosts()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(room.getMaxPeople()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(room.getRentType());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(room.getServiceFree());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("CSV file was created successfully !!!");
        } catch (Exception e) {
            System.out.println("Error in CSVFileWriter!!");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                System.out.println("Error when flush or close!!");
            }
        }
    }

    public static ArrayList<Room> readRoomCsvToListRoom() {
        BufferedReader br = null;
        ArrayList<Room> listRoom = new ArrayList<>();
        Path path = Paths.get(CSV_FILE_ROOM);
        if (!Files.exists(path)) {
            try {
                FileWriter writer = new FileWriter(CSV_FILE_ROOM);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            br = new BufferedReader(new FileReader(CSV_FILE_ROOM));
            String line;

            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("[ID"))
                    continue;
                Room room = new Room();
                room.setId(splitData[0]);
                room.setServiceName(splitData[1]);
                room.setAreaUsed(Double.parseDouble(splitData[2]));
                room.setRentalCosts(Double.parseDouble(splitData[3]));
                room.setMaxPeople(Integer.parseInt(splitData[4]));
                room.setRentType(splitData[5]);
                room.setServiceFree(splitData[6]);
                listRoom.add(room);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return listRoom;
    }

    public static void writeCustomerToFileCSV(ArrayList<Customer> listCustomer) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(CSV_FILE_CUSTOMER);
            fileWriter.append(Arrays.toString(FILE_CUSTOMER_HEADER));
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (Customer customer : listCustomer) {
                fileWriter.append(customer.getNameCustomer());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getBirthday());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getGender());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getIdCard());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getPhoneNumber());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getEmail());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getTypeCustomer());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getAddress());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("CSV file was created successfully !!!");
        } catch (Exception e) {
            System.out.println("Error in CSVFileWriter!!");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                System.out.println("Error when flush or close!!");
            }
        }
    }

    public static ArrayList<Customer> readCustomerCsvToListCustomer() {
        BufferedReader br = null;
        ArrayList<Customer> listCustomer = new ArrayList<>();
        Path path = Paths.get(CSV_FILE_CUSTOMER);
        if (!Files.exists(path)) {
            try {
                FileWriter writer = new FileWriter(CSV_FILE_CUSTOMER);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            br = new BufferedReader(new FileReader(CSV_FILE_CUSTOMER));
            String line;

            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("[Name Customer"))
                    continue;
                Customer customer = new Customer();
                customer.setNameCustomer(splitData[0]);
                customer.setBirthday(splitData[1]);
                customer.setGender(splitData[2]);
                customer.setIdCard(splitData[3]);
                customer.setPhoneNumber(splitData[4]);
                customer.setEmail(splitData[5]);
                customer.setTypeCustomer(splitData[6]);
                customer.setAddress(splitData[7]);

                listCustomer.add(customer);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return listCustomer;
    }

    public static void writeBookingCustomerToFileCSV(ArrayList<Customer> listBooking) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(CSV_FILE_BOOKING);
            fileWriter.append(Arrays.toString(FILE_BOOKING_HEADER));
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (Customer customer : listBooking) {
                fileWriter.append(customer.getNameCustomer());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getBirthday());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getGender());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getIdCard());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getPhoneNumber());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getEmail());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getTypeCustomer());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getAddress());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getService().getId());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getService().getServiceName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(customer.getService().getAreaUsed()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(customer.getService().getRentalCosts()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(customer.getService().getMaxPeople()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getService().getRentType());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("CSV file was created successfully !!!");
        } catch (Exception e) {
            System.out.println("Error in CSVFileWriter!!");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                System.out.println("Error when flush or close!!");
            }
        }
    }

    public static ArrayList<Customer> readBookingCustomerCsvToListCustomer() {
        BufferedReader br = null;
        ArrayList<Customer> listCustomer = new ArrayList<>();
        Path path = Paths.get(CSV_FILE_BOOKING);
        if (!Files.exists(path)) {
            try {
                FileWriter writer = new FileWriter(CSV_FILE_BOOKING);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            br = new BufferedReader(new FileReader(CSV_FILE_BOOKING));
            String line;

            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("[Name Customer"))
                    continue;
                Customer customer = new Customer();
                customer.setNameCustomer(splitData[0]);
                customer.setBirthday(splitData[1]);
                customer.setGender(splitData[2]);
                customer.setIdCard(splitData[3]);
                customer.setPhoneNumber(splitData[4]);
                customer.setIdCard(splitData[5]);
                customer.setTypeCustomer(splitData[6]);
                customer.setAddress(splitData[7]);
                customer.getService().setId(splitData[8]);
                customer.getService().setServiceName(splitData[9]);
                customer.getService().setAreaUsed(Double.parseDouble(splitData[10]));
                customer.getService().setRentalCosts(Double.parseDouble(splitData[11]));
                customer.getService().setMaxPeople(Integer.parseInt(splitData[12]));
                customer.getService().setRentType(splitData[13]);
                listCustomer.add(customer);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return listCustomer;
    }

    public static TreeSet<String> readAllNameServiceFromCSV(String path) {
        BufferedReader br = null;
        TreeSet<String> result = new TreeSet();
        try {
            String line;
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                if (getNameServiceFromFile(line).equals(" Service Name")) {
                    continue;
                }
                result.add(getNameServiceFromFile(line));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (br != null) br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }

    public static String getNameServiceFromFile(String csvLine) {
        String name = "";
        if (csvLine != null) {
            String[] splitData = csvLine.split(",");
            name = splitData[1];
        }
        return name;
    }

    public static ArrayList<Employee> readEmployeeCsvToListEmployee() {
        BufferedReader br = null;
        ArrayList<Employee> listEmployee = new ArrayList<>();
        Path path = Paths.get("src/data/Employee.csv");
        if (!Files.exists(path)) {
            try {
                FileWriter writer = new FileWriter("src/data/Employee.csv");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            br = new BufferedReader(new FileReader("src/data/Employee.csv"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("[ID Employee"))
                    continue;
                Employee employee = new Employee();
                employee.setIdEmployee(splitData[0]);
                employee.setNameEmployee(splitData[1]);
                employee.setAge(Integer.parseInt(splitData[2]));
                employee.setAddress(splitData[3]);
                listEmployee.add(employee);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return listEmployee;
    }


}

