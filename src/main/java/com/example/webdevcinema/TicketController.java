package com.example.webdevcinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
public class TicketController {

    @Autowired
    private TicketRepository rep;

    @GetMapping("/fetchAllMovies")
    public List<Movie> fetchAllMovie() {return  rep.fetchAllMovie(); }

    @GetMapping("/fetchAllTickets")
    public List<Ticket> fetchAllTickets(){
        return rep.fetchAllTicket();
    }


    @GetMapping("/fetchOneTicket")
    public Ticket fetchOneTicket(int id){
        return rep.fetchOneTicket(id);
    }

    @GetMapping("/deleteAll")
    public void deleteAll(){
        rep.deleteAll();
    }

    @GetMapping("/deleteOneTicket")
    public void deleteOneTicket(long id){
        rep.deleteOneTicket(id);
    }

    @PostMapping("/edit")
    public void edit(Ticket ticket){
        rep.editTicket(ticket);
    }

    @PostMapping("/purchase")
    public ResponseEntity<String> purchaseTicket(@RequestBody Ticket innTicket) {
        if (innTicket == null || innTicket.getMovie() == null || innTicket.getMovie().isEmpty() ||
                innTicket.getTicketAmount() <= 0 || innTicket.getFirstName() == null || innTicket.getFirstName().isEmpty() ||
                innTicket.getLastName() == null || innTicket.getLastName().isEmpty() ||
                innTicket.getPhone() == null || innTicket.getPhone().isEmpty() ||
                innTicket.getEmail() == null || innTicket.getEmail().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please provide all required information.");
        }

        if (!isValidEmail(innTicket.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid email address.");
        }

        if (!isValidPhoneNumber(innTicket.getPhone())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid phone number.");
        }

        rep.purchase(innTicket);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ticket purchased successfully.");
    }

    private boolean isValidEmail(String email) {
        // Basic email format validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    private boolean isValidPhoneNumber(String phone) {
        // Basic phone number format validation
        String phoneRegex = "^\\+(?:[0-9] ?){6,14}[0-9]$";
        return phone.matches(phoneRegex);
    }
}
