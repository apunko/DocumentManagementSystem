$(function() {
    debugger;
    var date = new Date();
    var dateString =  (date.getYear() + 1900) + "-0" + (date.getMonth() + 1) + "-" + date.getDate();
    $('.newDateInput').val(dateString);
});