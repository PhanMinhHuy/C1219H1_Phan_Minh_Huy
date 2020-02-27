

do {
    choose = prompt(
        "1. Add New Customer \n" +
        "2. Display Information Customer \n" +
        "3. Edit Information Customer \n" +
        "4. Delete Customer \n" +
        "5. Exit");
    switch (choose) {
        case "1":
            addNewCustomer();
            break;
        case "2":
            displayCustomers();
            break;
        case "3":
            editCustomer();
            break;
        case  "4":
            deleteCustomer();
            break;
        case "5":
            break;
        default :
            alert("???");
    }
}
while (choose !== "5");