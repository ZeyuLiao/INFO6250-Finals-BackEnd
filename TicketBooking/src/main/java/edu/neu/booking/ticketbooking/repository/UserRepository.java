package edu.neu.booking.ticketbooking.repository;
import edu.neu.booking.ticketbooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
