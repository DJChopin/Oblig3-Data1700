package webprog.java1700oblig3tickets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController {

    @Autowired
    private TicketRepository rep;

    @GetMapping("/getMovie")
    public ResponseEntity<List<Movie>> getMovie() {
        try {
            List<Movie> movies = rep.getAllMovie();
            return ResponseEntity.ok(movies);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/purchase")
    public ResponseEntity<Void> purchase(Ticket tickets){
        try {
            rep.purchaseTicket(tickets);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getAllTicket")
    public ResponseEntity<List<Ticket>> getAllTicket(){
        try {
            List<Ticket> tickets = rep.getAllTicket();
            return ResponseEntity.ok(tickets);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/getOneTicket")
    public ResponseEntity<Ticket> getOneTicket(int id){
        try {
            Ticket ticket = rep.getOneTicket(id);
            return ResponseEntity.ok(ticket);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/edit")
    public ResponseEntity<Void> editTicket(Ticket tickets){
        try {
            rep.editTicket(tickets);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/deleteOneTicket")
    public ResponseEntity<Void> deleteOneTicket(int id){
        try {
            rep.deleteOneTicket(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/deleteAll")
    public ResponseEntity<Void> deleteAllTicket(){
        try {
            rep.deleteAllTicket();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
