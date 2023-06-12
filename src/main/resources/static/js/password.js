function validateForm() {
    let firstPassword = document.getElementById("password").value;
    let secondPassword = document.getElementById("passwordAgain").value;
    if (firstPassword != secondPassword) {
        alert("Не правильно введені паролі");
        return false;
    }
    return true;
}