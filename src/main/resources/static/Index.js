$(function(){  // run when the script is loaded
    fetchAllTickets();
});

function fetchAllTickets() {
    $.get( "/fetchAllTickets", function(Tickets) {
        formatData(Tickets);
    })
        .fail(function(jqXHR) {
            const json = $.parseJSON(jqXHR.responseText);
            $("#error").html(json.message);
        });
}
function formatData(Tickets){
    let out ="<Table class='table table-striped'><th>Amount of Tickets</th><th>First Name</th>"+
        "<th>Last Name</th><th>Phone NR</th><th>Email</th><th>Movie</th><th></th><th></th>";
    for (const Ticket of Tickets){
        out += "<tr><td>" + Ticket.ticketAmount + "</td><td>"+Ticket.firstName+"</td>" + "<td>"+
            Ticket.lastName +"</td><td>"+Ticket.phone+"</td><td>"+Ticket.email+"</td><td>" + Ticket.movie + "</td>"+
            "<td> <button class='btn btn-primary' onclick='idChangeTicket("+Ticket.id+")'>Edit</button> </td>"+
            "<td> <button class='btn btn-primary' onclick='deleteTicket("+Ticket.id+")'>Delete</button> </td>"+
            "</tr>";
    }
    out += "</table>";
    $("#Tickets").html(out);
}
function idChangeTicket(id) {
    window.location.href = "/change.html?"+id;
}
function deleteTicket(id) {
    const url = "/deleteTicket?id=" + id;
    $.ajax({
        url: url,
        type: "DELETE",
        success: function() {
            fetchAllTickets();
        },
        error: function(xhr, status, error) {
            console.error("Error deleting ticket:", error);
        }
    });
}
function deleteAll() {
    $.get( "/deleteAll", function() {
        fetchAllTickets();
    });
}
