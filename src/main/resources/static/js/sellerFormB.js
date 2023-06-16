document.querySelector('.menu').addEventListener('click', function() {
    var dropdownContent = this.nextElementSibling;
    dropdownContent.style.display = dropdownContent.style.display === 'block' ? 'none' : 'block';
});