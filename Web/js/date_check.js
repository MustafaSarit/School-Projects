function checkPattern(id) {                       
    if (! $(id).val().match($(id).attr("pattern"))) {
        alert("Invalid input entered: " + $(id).val());
        return false;
    }
}

function checkTime(id) {
    var pattern="(0?[0-9]|1[0-9]|2[0-3])(:[0-5]?[0-9]){1,2}";
    var val=$(id).val();
    if (val.length > 0 && !val.match(pattern)) {
        alert("Invalid time entered: " + $(id).val());
        return false;
    }
    return true;
}

function checkDate(id) {
    var val=$(id).val();
    var pattern="[0-9]{1,4}[-/][0-9]{1,2}[-/][0-9]{1,4}";
    if (val.length > 0 && (!val.match(pattern) || isNaN(Date.parse(val)))) {
        alert("Invalid date entered: " + $(id).val());
        return false;
    }
    return true;
}                    
