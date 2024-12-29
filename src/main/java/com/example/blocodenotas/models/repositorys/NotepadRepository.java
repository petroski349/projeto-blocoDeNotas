package com.example.blocodenotas.models.repositorys;

import com.example.blocodenotas.models.entitys.Notepad;
import com.example.blocodenotas.models.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NotepadRepository extends JpaRepository<Notepad, Long> {
    List<Notepad> findAllByUser(Long user);

    @Query("SELECT n FROM Notepad n WHERE :userId = n.user AND n.criationDate >= :startDate AND n.criationDate <= :endDate ORDER BY n.criationDate ASC")
    List<Notepad> findByIdFilterAsc(
            @Param("userId") Long userId,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);

    @Query("SELECT n FROM Notepad n WHERE :userId = n.user AND n.criationDate >= :startDate AND n.criationDate <= :endDate ORDER BY n.criationDate DESC")
    List<Notepad> findByIdFilterDesc(
            @Param("userId") Long userId,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);



}
