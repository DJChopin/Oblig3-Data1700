function validTicketAmount(){
    const ticketAmount = $("#ticketAmount").val();
    const regexp=  /^[0-9]{1,2}$/;
    const ok = regexp.test(ticketAmount);

    if (!ok){
        $("#wrongTicketAmount").html("You must have have a valid amount of tickets");
        return false;
    } else {
        $("#wrongTicketAmount").html("");
        return true;
    }
}

function validFirstName(){
    const firstName = $("#firstName").val();
    const regexp= /^[a-zA-Z]{1,20}$/;
    const ok = regexp.test(firstName);

    if (!ok){
        $("#wrongFirstName").html("Please enter a valid first name");
        return false;
    } else {
        $("#wrongFirstName").html("");
        return true;
    }
}

function validLastName(){
    const lastName = $("#lastName").val();
    const regexp= /^[a-zA-ZøæåØÆÅ]{1,20}$/;
    const ok = regexp.test(lastName);

    if (!ok){
        $("#wrongLastName").html("Please enter a valid last name");
        return false;
    } else {
        $("#wrongLastName").html("");
        return true;
    }
}

function validPhone(){
    const phone = $("#phone").val();
    const regexp= /^\d{1,12}$/;
    const ok = regexp.test(phone);

    if (!ok){
        $("#wrongPhone").html("Please enter a valid 10-digit phone number");
        return false;
    } else {
        $("#wrongPhone").html("");
        return true;
    }
}

function validEmail(){
    const email = $("#email").val();
    const regexp= /^[\w-]+@([\w-]+\.)+[\w-]{1,4}$/;
    const ok = regexp.test(email);

    if (!ok){
        $("#wrongEmail").html("Please enter a valid email address");
        return false;
    } else {
        $("#wrongEmail").html("");
        return true;
    }
}

function allValid(){
    return( validTicketAmount() && validFirstName() && validLastName() && validPhone() && validEmail() );
}
