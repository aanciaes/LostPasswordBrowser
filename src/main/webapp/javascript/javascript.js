
function validateDate() {
    var initDate = document.getElementById("initDate").value;
    var finalDate = document.getElementById("finalDate").value;

    if (auxValidateDate(initDate) && auxValidateDate(finalDate))
        return true;
    else {
        var errorText = document.getElementById("DateFormatError");
        errorText.hidden = false;
        return false;
    }
}

function auxValidateDate(date) {
    if (date !== "") {
        return moment(date, 'YYYY-MM-DD', true).isValid();
    }
    return true;
}
