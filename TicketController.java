package webprog.java1700oblig3tickets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TicketController {

    @Autowired
    private TicketRepository rep;

    @GetMapping("/getMovie")
    public List<Movie> getMovie() {
        return rep.getAllMovie();
    }

    @PostMapping("/purchase")
    public void purchase(Ticket ticket){
        rep.purchaseTicket(ticket);
    }

    @GetMapping("/getAllTicket")
    public List<Ticket> getAllTicket(){
        return rep.getAllTicket();
    }

    @GetMapping("/getOneTicket")
    public Ticket getOneTicket(int id){
        return rep.getOneTicket(id);
    }

    @PostMapping("/edit")
    public void edit(Ticket ticket){
        rep.editTicket(ticket);
    }

    @GetMapping("/deleteOneTicket")
    public void deleteOneTicket(int id){
        rep.deleteOneTicket(id);
    }

    @GetMapping("/deleteAll")
    public void deleteAllTicket(){
        rep.deleteAllTicket();
    }
}