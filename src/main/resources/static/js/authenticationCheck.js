function validateForm() {
    alert("Hello");
    let password =  document.getElementById("password").value;
    if (password.length > 16) {
        alert("Пароль не може бути більше 16 символів");
        return false;
    }
    return true;
}