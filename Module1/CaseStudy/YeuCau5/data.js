let arrListCustomers = [[],[]];
let numberOfCustomer = 0;
function addNewCustomer() {
    let numCustomer = parseInt(prompt("How many new customer ??"));
    for (let i = 0; i < numCustomer; i++) {
        alert("Customer " + (i + 1));
        addInformation(i);
    }
    numberOfCustomer += numCustomer;
}

function addInformation(i) {
    arrListCustomers [numberOfCustomer + i][0] = prompt("Enter name: ");
    arrListCustomers [numberOfCustomer + i][0] = chuanHoa(arrListCustomers[numberOfCustomer + i][0]);
    arrListCustomers [numberOfCustomer + i][1]  = prompt(" Enter Id: ");
    let regexId = /^\d{9}$/g;
    while (regexId.test(arrListCustomers[numberOfCustomer + i][1]) === false)
        arrListCustomers [numberOfCustomer + i][1] = prompt("Failed !!\nEnter Id again: ");
    arrListCustomers [numberOfCustomer + i][2]  = prompt(" Enter birthday: " + "\n" + "(MM/DD/YYYY)");
    let regexBirthday = /^\d\d\/\d\d\/\d\d\d\d$/g;
    while (regexBirthday.test(arrListCustomers [numberOfCustomer + i][2]) === false)
        arrListCustomers [numberOfCustomer + i][2] = prompt("Failed !!\nEnter birthday again:        (MM/DD/YYYY)");
    arrListCustomers [numberOfCustomer + i][3]  = prompt(" Enter email: ");
    let regexEmail = /^([a-zA-Z0-9_\.])+@([a-zA-Z0-9])+(\.([a-z0-9])+)+$/g;
    while (regexEmail.test(arrListCustomers [numberOfCustomer + i][3]) === false)
        arrListCustomers [numberOfCustomer + i][3] = prompt("Failed !!\nEnter Email again: ");
    arrListCustomers [numberOfCustomer + i][4]  = prompt(" Enter address: ");
    arrListCustomers [numberOfCustomer + i][5]  = prompt(" Enter type: \n (Diamond, Platinum, Gold, Silver, Member) ");
    arrListCustomers [numberOfCustomer + i][6]  = parseFloat(prompt(" Enter discount: "));
    arrListCustomers [numberOfCustomer + i][7]  = parseInt(prompt(" Enter number of guests: "));
    arrListCustomers [numberOfCustomer + i][8]  = parseInt(prompt(" Enter rent days: "));
    arrListCustomers [numberOfCustomer + i][9]  = prompt(" Enter type Room: \n (Villa, House, Room) ");
    arrListCustomers [numberOfCustomer + i][10]  = prompt(" Enter type Servise: \n (Vip, Business,  Normal) ");
}

function chuanHoa(str) {
    let strStrandard = "";
    str = str.trim().toLocaleLowerCase();
    for (let i = 0; i < str.length; i++) {
        if (str.charAt(i) === " " && str.charAt(i + 1) === " ") {
            continue;
        }
        if (i === 0 || str.charAt(i - 1) === " ") {
            strStrandard += str.charAt(i).toUpperCase();
            continue;
        }
        strStrandard += str.charAt(i);
    }
    return strStrandard;
}

function displayCustomers() {
    let display = "Customer: ";
    for (let i = 0; i < numberOfCustomer; i++){
        display += "\n" + (i + 1) + ". " + "Name: " + arrListCustomers[i][0] + " ID: " + arrListCustomers[i][1]
    }
    display += "\n" + (numberOfCustomer + 1) + ". " + "Back" ;
    let choose = parseInt(prompt(display));
    if (choose <= numberOfCustomer) {
        displayInformationCustomer((choose -1));
    }
}

function displayInformationCustomer(i) {
    alert("Information of customer: " + (i+1) +
        "\nName: " + arrListCustomers[i][0] +
        "\nId: " + arrListCustomers[i][1] +
        "\nBirthday: " + arrListCustomers[i][2] +
        "\nEmail: " + arrListCustomers[i][3] +
        "\nAddress: " + arrListCustomers[i][4] +
        "\nType: " + arrListCustomers[i][5] +
        "\nDiscount: " + arrListCustomers[i][6] +
        "\nNumber Of Guests: " + arrListCustomers[i][7] +
        "\nRent Day: " + arrListCustomers[i][8] +
        "\nType Room: " + arrListCustomers[i][9] +
        "\nType Service: " + arrListCustomers[i][10] );
}

function editCustomer() {
    let display = "Choose customer edit: ";
    for (let i = 0; i < numberOfCustomer; i++){
        display += "\n" + (i + 1) + ". " + "Name: " + arrListCustomers[i][0] + " ID: " + arrListCustomers[i][1]
    }
    display += "\n" + (numberOfCustomer + 1) + ". " + "Back" ;
    let choose = parseInt(prompt(display));
    if (choose <= numberOfCustomer) {
        chooseEdit = parseInt( prompt("Information of customer: " + (choose) +
            "\n1. Name: " + arrListCustomers[choose - 1][0] +
            "\n2. Id: " + arrListCustomers[choose - 1][1] +
            "\n3. Birthday: " + arrListCustomers[choose - 1][2] +
            "\n4. Email: " + arrListCustomers[choose - 1][3] +
            "\n5. Address: " + arrListCustomers[choose - 1][4] +
            "\n6. Type: " + arrListCustomers[choose - 1][5] +
            "\n7. Discount: " + arrListCustomers[choose - 1][6] +
            "\n8. Number Of Guests: " + arrListCustomers[choose - 1][7] +
            "\n9. Rent Day: " + arrListCustomers[choose - 1][8] +
            "\n10. Type Room: " + arrListCustomers[choose - 1][9] +
            "\n11. Type Service: " + arrListCustomers[choose - 1][10] +
            "\n12. Back"));
        switch (chooseEdit) {
            case 1:
                arrListCustomers [choose - 1][0] = prompt("Enter name: ");
                arrListCustomers [choose - 1][0] = chuanHoa(arrListCustomers[choose - 1][0]);
                break;
            case  2:
                arrListCustomers [choose - 1][1]  = prompt(" Enter Id: ");
                let regexId = /^\d{9}$/g;
                while (regexId.test(arrListCustomers[choose - 1][1]) === false)
                    arrListCustomers [choose - 1][1] = prompt("Failed !!\nEnter Id again: ");
                break ;
            case 3:
                arrListCustomers [choose - 1][2]  = prompt(" Enter birthday: " + "\n" + "(MM/DD/YYYY)");
                let regexBirthday = /^\d\d\/\d\d\/\d\d\d\d$/g;
                while (regexBirthday.test(arrListCustomers [choose - 1][2]) === false)
                    arrListCustomers [choose - 1][2] = prompt("Failed !!\nEnter birthday again:        (MM/DD/YYYY)");
                break;
            case  4:
                arrListCustomers [choose - 1][3]  = prompt(" Enter email: ");
                let regexEmail = /^([a-zA-Z0-9_\.])+@([a-zA-Z0-9])+(\.([a-z0-9])+)+$/g;
                while (regexEmail.test(arrListCustomers [choose - 1][3]) === false)
                    arrListCustomers [choose - 1][3] = prompt("Failed !!\nEnter Email again: ");
                break;
            case  5:
                arrListCustomers [choose - 1][4]  = prompt(" Enter address: ");
                break;
            case  6:
                arrListCustomers [choose - 1][5]  = prompt(" Enter type: \n (Diamond, Platinum, Gold, Silver, Member) ");
                break;
            case 7:
                arrListCustomers [choose - 1][6]  = parseFloat(prompt(" Enter discount: "));
                break;
            case 8:
                arrListCustomers [choose - 1][7]  = parseInt(prompt(" Enter number of guests: "));
                break;
            case 9:
                arrListCustomers [choose - 1][8]  = parseInt(prompt(" Enter rent days: "));
                break;
            case 10:
                arrListCustomers [choose - 1][9]  = prompt(" Enter type Room: \n (Villa, House, Room) ");
                break;
            case 11:
                arrListCustomers [choose - 1][10]  = prompt(" Enter type Servise: \n (Vip, Business,  Normal) ");
                break;
            case 12:
                editCustomer();
                break;
            default:
                alert("???");
                break;
        }
    }
}

function deleteCustomer() {
    let display = "Choose customer delete: ";
    for (let i = 0; i < numberOfCustomer; i++){
        display += "\n" + (i + 1) + ". " + "Name: " + arrListCustomers[i][0] + " ID: " + arrListCustomers[i][1]
    }
    display += "\n" + (numberOfCustomer + 1) + ". " + "Back" ;
    let choose = parseInt(prompt(display));
    if (choose <= numberOfCustomer) {
        confimDelete = parseInt(prompt("Are you sure delete customer: \n" +
            "Name: " + arrListCustomers[i][0] + " ID: " + arrListCustomers[i][1] +
            "\n1. Yes\n2. No"));
        
    }
}