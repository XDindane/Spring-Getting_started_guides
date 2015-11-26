package hello;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

//JDBC-based service
public class BookingService {

    private final static Logger log = LoggerFactory.getLogger(BookingService.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional // meaning that any failure causes the entire operation to roll back to its previous state, and to re-throw the original exception. 
    public void book(String... persons) {
        for (String person : persons) {
            log.info("Booking " + person + " in a seat...");
            jdbcTemplate.update("INSERT into BOOKINGS (FIRST_NAME) values (?)", person);
        }

    }

    ;
    
    
    public List<String> findAllBookings() {
        // Each row fetched from the database is converted into a String and then assembled into a List.
        return jdbcTemplate.query("SELECT FIRST_NAME from BOOKINGS", new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("FIRST_NAME");
            }
        });
    }

}
