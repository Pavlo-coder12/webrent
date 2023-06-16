function updatePrice() {
    var selectElement = document.getElementById('date');
    var priceElement = document.getElementById('price');

    if (selectElement.value === 'month') {
      priceElement.value = 800;
    } else if (selectElement.value === 'half-year') {
      priceElement.value = 4200;
    }
  }