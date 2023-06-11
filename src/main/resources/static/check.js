function validateForm() {
            // Валідація полів форми за допомогою JavaScript
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;

            // Приклад валідації: перевірка, що поля не є порожніми
            if (username === "" || password === "") {
                alert("Будь ласка, заповніть всі поля!");
                return false;
            }

            // Всі поля пройшли валідацію, можна відправляти дані на сервер
            return true;
        }