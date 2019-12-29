function convert()
{
    let amount = document.getElementById("amount").value;
    let from = document.getElementById("from").value;
    let to = document.getElementById("to").value;
    let result = document.getElementById("result").value;
    if (from == "VND" && to = "USD")
        {
            result.innerText = amount / 23000
        }

}
