$(function(){
    getAllTicket();
});

function getAllTicket() {
    $.get( "/getAllTicket", function( tickets ) {
        formatData(tickets);
    });
}
function formatData(tickets){
    let out ="<Table class='table table-striped'><th>Amount of Tickets</th><th>First Name</th>"+
        "<th>Last Name</th><th>Phone NR</th><th>Email</th><th>Movie</th><th></th><th></th>";
    for (const Ticket of tickets){
        out += "<tr><td>" + Ticket.ticketAmount + "</td><td>"+Ticket.firstName+"</td>" + "<td>"+
            Ticket.lastName +"</td><td>"+Ticket.phone+"</td><td>"+Ticket.email+"</td><td>" + Ticket.film + "</td>"+
            "<td> <button class='btn btn-primary' onclick='edit("+Ticket.id+")'>Edit</button> </td>"+
            "<td> <button class='btn btn-primary' onclick='deleteOneTicket("+Ticket.id+")'>Delete</button> </td>"+
            "</tr>";
    }
    out += "</table>";
    $("#tickets").html(out);
}

function edit(id) {
    window.location.href = "/edit.html?"+id;
}

function deleteOneTicket(id) {
    const url = "/deleteOneTicket?id="+id;
    $.get( url, function() {
        window.location.href = "/";
    });
}

function deleteAllTickets() {
    $.get( "/deleteAll", function() {
        getAllTicket();
    });
}