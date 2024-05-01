$(function(){
    fetchAllMovie();
});

function fetchAllMovie() {
    $.get("/fetchAllMovie", function(movie) {
        populateDropdown(movie);
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
        dropdown.append($('<option></option>').attr('value', movie.movie).text(movie.movie));
    });
}

function purchaseTickets() {
    const Ticket = {
        ticketAmount : $("#ticketAmount").val(),
        firstName : $("#firstName").val(),
        lastName : $("#lastName").val(),
        phone : $("#phone").val(),
        email : $("#email").val(),
        movie : $("#movie").val(),
    };
    $.post("/purchase", Ticket, function(){
        fetchAllTickets();
    });

    window.location.href = "/";
}
