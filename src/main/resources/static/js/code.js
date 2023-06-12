function validateForm() {
    let digits = document.getElementById("code").value;
    if (digits.length != 4) {
        alert("Код має складатися із 4 цифр");
        return false;
    }
    return true;
}