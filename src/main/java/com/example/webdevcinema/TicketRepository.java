package com.example.webdevcinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketRepository {

    @Autowired
    private JdbcTemplate db;
    public List<Ticket> fetchAllTicket(){
        String sql = "SELECT * FROM Ticket";
        return db.query(sql,new  BeanPropertyRowMapper<>(Ticket.class));
    }
    public List<Movie> fetchAllMovie(){
        String sql = "SELECT * FROM Movie";
        return db.query(sql,new  BeanPropertyRowMapper<>(Movie.class));
    }
    public Ticket fetchOneTicket(int id) {
        String sql = "SELECT * FROM Ticket WHERE id=?";
        List<Ticket> oneTicket  = db.query(sql,new BeanPropertyRowMapper<>(Ticket.class),id);
        return oneTicket.get(0);
    }
    public void deleteAll(){
        String sql = "DELETE FROM Ticket";
        db.update(sql);
    }
    public void deleteOneTicket(long id){
        String sql = "DELETE FROM Ticket Where id=?";
        db.update(sql,id);
    }
    public void editTicket(Ticket ticket) {
        String sql = "UPDATE Ticket SET movie=?,ticketAmount=? , firstName=? ,lastName=? , phone=? , email=? where id=?";
        db.update(sql,ticket.getMovie(),ticket.getTicketAmount(),ticket.getFirstName(),ticket.getLastName(),ticket.getPhone(),ticket.getEmail());
    }

    public void purchase(Ticket innTicket){
        String sql = "INSERT INTO Ticket(movie, ticketAmount, firstName,lastName, phone, email) VALUES(?,?,?,?,?,?)";
        db.update(sql, innTicket.getMovie(), innTicket.getTicketAmount(), innTicket.getFirstName(), innTicket.getLastName(), innTicket.getPhone(), innTicket.getEmail());
    }

}
