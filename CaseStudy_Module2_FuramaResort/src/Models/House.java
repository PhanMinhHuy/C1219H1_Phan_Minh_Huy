package Models;

import Validation.ValidationServices;

import java.util.Scanner;

public class House extends Services {
    private String standardRoom;
    private String convenientDescription;
    private int numberOfFloors;
    private Scanner sc = new Scanner(System.in);

    public House() {
    }

    public House(String id, String serviceName, double areaUsed, double rentalCosts, int maxPeople, String rentType, String standardRoom, String convenientDescription, int numberOfFloors) {
        super(id, serviceName, areaUsed, rentalCosts, maxPeople, rentType);
        this.standardRoom = standardRoom;
        this.convenientDescription = convenientDescription;
        this.numberOfFloors = numberOfFloors;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getConvenientDescription() {
        return convenientDescription;
    }

    public void setConvenientDescription(String convenientDescription) {
        this.convenientDescription = convenientDescription;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public void showInfor() {
        System.out.println(
                "Service Id: " + this.getId() +
                        "\nService Name: " + this.getServiceName() +
                        "\nArea used: " + this.getAreaUsed() +
                        "\nRental costs: " + this.getRentalCosts() +
                        "\nMax people: " + this.getMaxPeople() +
                        "\nRent type: " + this.getRentType() +
                        "\nStandard Room: " + this.getStandardRoom() +
                        "\nConvenient Description: " + this.getConvenientDescription() +
                        "\nNumber Of Floors: " + this.getNumberOfFloors());
    }

    public void addListHouseService() {
        this.setId(ValidationServices.InputAndCheckValidationIdService("house"));
        this.setServiceName(ValidationServices.InputAndCheckValidationServiceName());
        this.setAreaUsed(ValidationServices.InputAndCheckValidationAreaUsedOrAreaPool("used"));
        this.setRentalCosts(ValidationServices.InputAndCheckValidationRentalCosts());
        this.setMaxPeople(ValidationServices.InputAndCheckValidationMaxPeople());
        this.setRentType(ValidationServices.InputAndCheckValidationRentTypeOrStandardRoom("rent type"));
        this.setStandardRoom(ValidationServices.InputAndCheckValidationRentTypeOrStandardRoom("standard room"));
        System.out.println("Enter Convenient Description:");
        this.setConvenientDescription(sc.nextLine());
        this.setNumberOfFloors(ValidationServices.inputAndCheckValidationNumberOfFloors());
    }
}
