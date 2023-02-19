package ru.simbirsoft.BookGo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.simbirsoft.BookGo.entity.User;
import ru.simbirsoft.BookGo.security.VerificationToken;

public interface TokenRepository extends JpaRepository<VerificationToken, Long> {
    VerificationToken findByToken(String token);
    VerificationToken findByUser(User user);
}