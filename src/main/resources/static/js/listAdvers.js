function clearInputs() {
        var form = document.querySelector('.form');
        var inputs = form.querySelectorAll('input');
        var selects = form.querySelectorAll('select');

        // Скидаємо значення полів до значень за замовчуванням
        for (var i = 0; i < inputs.length; i++) {
            var input = inputs[i];
            if (input.type !== 'submit' && input.type !== 'button') {
                input.value = input.defaultValue;
                input.checked = false; // Знімаємо вибір з чекбоксів
            }
        }

        // Скидаємо значення вибраних елементів <select> до значень за замовчуванням
        for (var j = 0; j < selects.length; j++) {
            var select = selects[j];
            select.value = select.defaultValue;
        }
    
}

function validateForm() {
    let city = document.getElementById("city").value;
    let street = document.getElementById("street").value;

    if (city.length > 40 || street.length > 40) {
        alert("Поля адреси не більше 40 символів");
        return false;
    }
    return true;

}
