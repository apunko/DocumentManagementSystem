$(function() {
    debugger;
    setFormElements();
});

function setFormElements() {
    setMultiSelectInputs();
    setDateInputs();
}

function setMultiSelectInputs(){
    $('.multiSelect').fSelect();
    $('.fs-label').innerHTML = "Select People";
}

function setDateInputs(){
    setNewDateInputs();
    setEditDateInputs();
}

function setNewDateInputs(){
    var date = new Date();
    var dateString =  (date.getYear() + 1900) + "-0" + (date.getMonth() + 1) + "-" + date.getDate();
    $('.newDateInput').val(dateString);
}

function setEditDateInputs(){
    var dateInputs = $('.editDateInput');
    for (var i = 0; i<dateInputs.length; i++){
        var date = dateInputs[i];
        $(dateInputs[i]).val(convertDate($(date).val()));
    }
}

function convertDate(date){
    var convertedDate = date.substring(6,10) + "-" + date.substring(3,5) + "-" + date.substring(0, 2);
    return convertedDate;
}