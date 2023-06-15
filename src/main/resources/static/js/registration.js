function validateForm() {
    let firstPassword = document.getElementById("password").value;
    let secondPassword = document.getElementById("passwordAgain").value;
    let name = document.getElementById("name").value;
    let surname = document.getElementById("surname").value;
    let fatherName = document.getElementById("fatherName").value;
    let cardCvv = document.getElementById("cardCvv").value;

    if (firstPassword != secondPassword) {
        alert("Не правильно введені паролі");
        return false;
    } else if (name.length > 30 || surname.length > 30 || fatherName.length > 30) {
        alert(" Поля: Ім'я, прізвище, по-батькові не більше 30 символів");
        return false;
    } else if (cardCvv != 3) {
        alert("CVV має бути 3 символа");
        return false;
    }
    return true;
}