package Models;

import Validation.ValidationServices;

import java.util.Scanner;

public class Room extends Services {
    private String serviceFree;
    private Scanner sc = new Scanner(System.in);


    public Room() {
    }

    public String getServiceFree() {
        return serviceFree;
    }

    public void setServiceFree(String serviceFree) {
        this.serviceFree = serviceFree;
    }

    public Room(String id, String serviceName, double areaUsed, double rentalCosts, int maxPeople, String rentType, String serviceFree) {
        super(id, serviceName, areaUsed, rentalCosts, maxPeople, rentType);
        this.serviceFree = serviceFree;
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
                        "\nService Free: " + this.getServiceFree());
    }

    public void addListRoomService() {
        this.setId(ValidationServices.InputAndCheckValidationIdService("room"));
        this.setServiceName(ValidationServices.InputAndCheckValidationServiceName());
        this.setAreaUsed(ValidationServices.InputAndCheckValidationAreaUsedOrAreaPool("used"));
        this.setRentalCosts(ValidationServices.InputAndCheckValidationRentalCosts());
        this.setMaxPeople(ValidationServices.InputAndCheckValidationMaxPeople());
        this.setRentType(ValidationServices.InputAndCheckValidationRentTypeOrStandardRoom("rent type"));
        this.setServiceFree(ValidationServices.InputAndCheckValidationServiceFree());
    }
}
