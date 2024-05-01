$(function(){
    fetchAllMovies();
});

function fetchAllMovies() {
    $.get("/fetchAllMovies", function(movies) {
        populateDropdown(movies);
    })
        .fail(function(jqXHR) {
            const json = $.parseJSON(jqXHR.responseText);
            $("#error").html(json.message);
        });
}

function populateDropdown(movies){
    let dropdown = $("#movie");
    dropdown.empty();
    dropdown.append('<option selected="" disabled>Choose movie</option>');
    $.each(movies, function(index, movie) {
        dropdown.append($('<option></option>').attr('value', movie.title).text(movie.title));
    });
}

function purchaseTickets() {
    const Tickets = {
        ticketAmount : $("#ticketAmount").val(),
        firstName : $("#firstName").val(),
        lastName : $("#lastName").val(),
        phone : $("#phone").val(),
        email : $("#email").val(),
        movie : $("#movie").val(),
    };
    $.post("/purchase", Tickets, function(){
        fetchAllTickets();
    });
    window.location.href = "/";
}
