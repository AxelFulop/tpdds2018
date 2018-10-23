$(document).ready(function(){
    var URLactual = window.location.pathname; //utilizada para detemrinar que tab del menu activar

    URLactual = URLactual.split('/').pop();
    URLactual = URLactual.split('.');

    $('.' + URLactual[0] ).addClass('active');

});