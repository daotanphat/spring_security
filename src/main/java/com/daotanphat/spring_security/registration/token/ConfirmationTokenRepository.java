package com.daotanphat.spring_security.registration.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {
    Optional<ConfirmationToken> findByToken(String token);

    @Transactional
    @Modifying
    @Query(
            "Update ConfirmationToken c " +
                    " SET c.confirmedAt = ?2" +
                    " Where c.token = ?1"
    )
    int updateConfirmedAt(String token, LocalDateTime confirmedAt);
}
