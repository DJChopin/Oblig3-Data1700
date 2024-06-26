$(function(){
    getOneTicket();
    getMovies();
});
function getMovies() {
    $.get("/getMovie", function(movies) {
        populateDropdown(movies);
    });
}

function populateDropdown(movies) {
    const dropdown = $("#movie");
    dropdown.empty(); // Clear existing options

    // Add each movie as an option in the dropdown
    $.each(movies, function(index, movie) {
        dropdown.append($('<option>').text(movie.film).val(movie.film));
    });
}
getMovies();

function getOneTicket(){
    const id = window.location.search.substring(1);
    const url = "/getOneTicket?id="+id;
    $.get( url, function(aTicket) {
        $("#id").val(aTicket.id);
        $("#ticketAmount").val(aTicket.ticketAmount);
        $("#firstName").val(aTicket.firstName);
        $("#lastName").val(aTicket.lastName);
        $("#phone").val(aTicket.phone);
        $("#email").val(aTicket.email);
        $("#film").val(aTicket.film);
    });
}

function editTicket() {
    const filmValue = $("#movie").val();
    if (!filmValue) {
        console.error("Film value cannot be empty");
        return;
    }
    const tickets = {
        id: $("#id").val(),
        ticketAmount: $("#ticketAmount").val(),
        firstName: $("#firstName").val(),
        lastName: $("#lastName").val(),
        phone: $("#phone").val(),
        email: $("#email").val(),
        film: filmValue,
    };
    if (allValid()){
    $.post("/edit", tickets, function () {
    })
        .done(function () {
            window.location.href = "index.html";
        })
        .fail(function (error) {
            console.error("Error updating ticket:", error);
        });
    }
}