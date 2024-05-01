package com.example.webdevcinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
public class TicketController {

    @Autowired
    private TicketRepository rep;

    @GetMapping("/fetchAllMovie")
    public List<Movie> fetchAllMovie() {return  rep.fetchAllMovie(); }

    @GetMapping("/fetchAllTickets")
    public List<Ticket> fetchAllTickets(){
        return rep.fetchAllTickets();
    }


    @GetMapping("/fetchOneTicket")
    public Ticket fetchOneTicket(int id){
        return rep.fetchOneTicket(id);
    }

    @GetMapping("/deleteAll")
    public void deleteAll(){
        rep.deleteAll();
    }

    @DeleteMapping("/deleteTicket")
    public ResponseEntity<String> deleteOneTicket(@RequestParam("id") int id) {
        try {
            rep.deleteOneTicket(id);
            return ResponseEntity.ok("Ticket deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete ticket: " + e.getMessage());
        }
    }

    @PostMapping("/edit")
    public void edit(Ticket ticket){
        rep.editTicket(ticket);
    }

    @PostMapping("/purchase")
    public ResponseEntity<String> purchaseTicket(Ticket innTicket) {
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
        //  email format validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    private boolean isValidPhoneNumber(String phone) {
        //  phone number format validation
        String phoneRegex = "^\\+(?:[0-9] ?){6,14}[0-9]$";
        return phone.matches(phoneRegex);
    }
}
