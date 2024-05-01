$(function(){
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

function purchase() {
    const ticket = {
        ticketAmount : $("#ticketAmount").val(),
        firstName : $("#firstName").val(),
        lastName : $("#lastName").val(),
        phone : $("#phone").val(),
        email : $("#email").val(),
        film : $("#movie").val(),
    };
    $.post("/purchase", ticket, function(){
        getAllTicket();
    });

    window.location.href="/";
}