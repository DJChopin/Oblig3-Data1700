package webprog.java1700oblig3tickets;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.jdbc.core.BeanPropertyRowMapper;
        import org.springframework.jdbc.core.JdbcTemplate;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
public class TicketRepository {

    @Autowired
    private JdbcTemplate db;

    private Logger logger = LoggerFactory.getLogger(TicketRepository.class);

    public void purchaseTicket(Ticket t) {
        String sql = "INSERT INTO Ticket (ticketAmount,firstName,lastName,phone,email,film) VALUES(?,?,?,?,?,?)";
        db.update(sql,t.getTicketAmount(),t.getFirstName(),t.getLastName(),t.getPhone(),t.getEmail(),t.getFilm());
    }

    public List<Ticket> getAllTicket() {
        String sql = "SELECT * FROM Ticket";
        return db.query(sql,new BeanPropertyRowMapper(Ticket.class));
    }


    public Ticket getOneTicket(int id){
        String sql = "SELECT * FROM Ticket WHERE id=?";
        List<Ticket> aTicket  = db.query(sql,new BeanPropertyRowMapper(Ticket.class),id);
        return aTicket.get(0);
    }

    public void editTicket(Ticket t){
        String sql = "UPDATE Ticket SET ticketAmount=?, firstName=?,lastName=?,phone=?,email=?,film=? where id=?";
        db.update(sql, t.getTicketAmount(), t.getFirstName(), t.getLastName(),t.getPhone(),t.getEmail(),t.getFilm());
    }
    public void deleteOneTicket(int id) {
        String sql = "DELETE FROM Ticket WHERE id=?";
        db.update(sql,id);
    }

    public void deleteAllTicket () {
        String sql = "DELETE FROM Ticket";
        db.update(sql);
    }

    public List<Movie> getAllMovie(){
        String sql = "SELECT * FROM Movie";
        return db.query(sql,new BeanPropertyRowMapper(Movie.class));
    }
}