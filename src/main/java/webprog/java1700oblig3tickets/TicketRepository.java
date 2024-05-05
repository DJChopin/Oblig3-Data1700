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
        try {
            String sql = "INSERT INTO Ticket (ticketAmount,firstName,lastName,phone,email,film) VALUES(?,?,?,?,?,?)";
            db.update(sql, t.getTicketAmount(), t.getFirstName(), t.getLastName(), t.getPhone(), t.getEmail(), t.getFilm());
        } catch (Exception e) {
            logger.error("Error purchasing ticket: " + e.getMessage());
            throw new RuntimeException("Error purchasing ticket");
        }
    }

    public List<Ticket> getAllTicket() {
        try {
            String sql = "SELECT * FROM Ticket";
            return db.query(sql, new BeanPropertyRowMapper(Ticket.class));
        } catch (Exception e) {
            logger.error("Error getting all tickets: " + e.getMessage());
            throw new RuntimeException("Error getting all tickets");
        }
    }

    public Ticket getOneTicket(int id){
        try {
            String sql = "SELECT * FROM Ticket WHERE id=?";
            List<Ticket> aTicket  = db.query(sql, new BeanPropertyRowMapper(Ticket.class), id);
            return aTicket.isEmpty() ? null : aTicket.get(0);
        } catch (Exception e) {
            logger.error("Error getting one ticket: " + e.getMessage());
            throw new RuntimeException("Error getting one ticket");
        }
    }

    public boolean editTicket(Ticket t){
        try {
            String sql = "UPDATE Ticket SET ticketAmount=?, firstName=?,lastName=?,phone=?,email=?,film=? where id=?";
            db.update(sql, t.getTicketAmount(), t.getFirstName(), t.getLastName(), t.getPhone(), t.getEmail(), t.getFilm(), t.getId());
            return true;
        } catch (Exception e) {
            logger.error("Error editing ticket: " + e.getMessage());
            throw new RuntimeException("Error editing ticket");
        }
    }

    public void deleteOneTicket(int id) {
        try {
            String sql = "DELETE FROM Ticket WHERE id=?";
            db.update(sql, id);
        } catch (Exception e) {
            logger.error("Error deleting ticket: " + e.getMessage());
            throw new RuntimeException("Error deleting ticket");
        }
    }

    public void deleteAllTicket () {
        try {
            String sql = "DELETE FROM Ticket";
            db.update(sql);
        } catch (Exception e) {
            logger.error("Error deleting all tickets: " + e.getMessage());
            throw new RuntimeException("Error deleting all tickets");
        }
    }

    public List<Movie> getAllMovie(){
        try {
            String sql = "SELECT * FROM Movie";
            return db.query(sql, new BeanPropertyRowMapper(Movie.class));
        } catch (Exception e) {
            logger.error("Error getting all movies: " + e.getMessage());
            throw new RuntimeException("Error getting all movies");
        }
    }
}
