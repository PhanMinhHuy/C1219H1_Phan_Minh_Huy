package Models;


import Validation.ValidationServices;

import java.util.Scanner;

public class Villa extends Services {
    private String standardRoom;
    private String convenientDescription;
    private double areaPool;
    private int numberOfFloors;
    private Scanner sc = new Scanner(System.in);

    public Villa() {
    }

    public Villa(String id, String serviceName, double areaUsed, double rentalCosts, int maxPeople, String rentType, String standardRoom, String convenientDescription, double areaPool, int numberOfFloors) {
        super(id, serviceName, areaUsed, rentalCosts, maxPeople, rentType);
        this.standardRoom = standardRoom;
        this.convenientDescription = convenientDescription;
        this.areaPool = areaPool;
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

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
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
                        "\nArea Pool: " + this.getAreaPool() +
                        "\nNumber Of Floors: " + this.getNumberOfFloors());
    }

    public void addListVillaService() {
        this.setId(ValidationServices.InputAndCheckValidationIdService("villa"));
        this.setServiceName(ValidationServices.InputAndCheckValidationServiceName());
        this.setAreaUsed(ValidationServices.InputAndCheckValidationAreaUsedOrAreaPool("used"));
        this.setRentalCosts(ValidationServices.InputAndCheckValidationRentalCosts());
        this.setMaxPeople(ValidationServices.InputAndCheckValidationMaxPeople());
        this.setRentType(ValidationServices.InputAndCheckValidationRentTypeOrStandardRoom("rent type"));
        this.setStandardRoom(ValidationServices.InputAndCheckValidationRentTypeOrStandardRoom("standard room"));
        System.out.println("Enter Convenient Description:");
        this.setConvenientDescription(sc.nextLine());
        this.setAreaPool(ValidationServices.InputAndCheckValidationAreaUsedOrAreaPool("pool"));
        this.setNumberOfFloors(ValidationServices.inputAndCheckValidationNumberOfFloors());
    }

}
