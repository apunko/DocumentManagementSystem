$(function() {
    debugger;
    setFormElements();
    setFooter();
    $('.needConfirmation').click(function(){
        return confirm("Are you sure?");
    })
});

function setFooter(){
    if ($(document).height() > $(window).height()) {
        $("#footer").removeClass("navbar-fixed-bottom");
    }
    else {
        $("#footer").addClass("navbar-fixed-bottom");
    }
}

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
    debugger;
    var date = new Date();
    var dateString =  (date.getYear() + 1900) + "-0" + (date.getMonth() + 1) + "-0" + date.getDate();
    var dateInputs = $(".newDateInput");
    for (var i = 0; i<dateInputs.length; i++){
        debugger;
        var date = dateInputs[i];
        var value = $(dateInputs[i]).attr("date-value");
        if (value == "") {
            value = dateString;
        }
        $(dateInputs).val(value);
    }
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