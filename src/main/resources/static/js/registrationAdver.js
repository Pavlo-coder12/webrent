function updatePrice() {
    let selectElement = document.getElementById('priceHouse');
    let priceElement = document.getElementById('generalPrice');
    priceElement.value = 0;

    if (selectElement.value != null) {
      let selectValue = parseInt(selectElement.value);
      priceElement.value = (selectValue / 10) + selectValue;

    } 
  }

  function validateForm() {
    let numberRoom = document.getElementById('rooms');
    let region = document.getElementById('region');
    let areaPlace = document.getElementById('area_place');
    let city = document.getElementById('city');
    let street = document.getElementById('street');
    let ownCom = document.getElementById('message');

    if (numberRoom.value.length > 40 || region.value.length > 40 || areaPlace > 40 ||
        city.value.length > 40 || street > 40) {
          alert("Поля адреси мають містити не більше 40 символів");
          return false;
    } else if (ownCom > 250) {
          alert("Власний коментар не більше 250 символів");
          return false;
    }

    return true;
  }