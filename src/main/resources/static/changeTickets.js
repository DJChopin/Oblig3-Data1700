$(function(){
    fetchAllMovies();
    fetchOneTicket();
});

function fetchOneTicket(){
    const id = window.location.search.substring(1);
    const url ="/fetchOneTicket?" + id;

    $.get(url, function (ticket) {
        $("#id").val(ticket.id);
        $("#ticketAmount").val(ticket.ticketAmount);
        $("#firstName").val(ticket.firstName);
        $("#lastName").val(ticket.lastName);
        $("#phone").val(ticket.phone);
        $("#email").val(ticket.email);
        $("#movie").val(ticket.movie);
    });

}

function editTickets() {
    const ticket = {
        id : $("#id").val(),
        ticketAmount : $("#ticketAmount").val(),
        firstName : $("#firstName").val(),
        lastName : $("#lastName").val(),
        phone : $("#phone").val(),
        email : $("#email").val(),
        movie : $("#movie").val(),
    };
    $.post("/edit", ticket, function(){
    });
    window.location.href = "index.html";
}
