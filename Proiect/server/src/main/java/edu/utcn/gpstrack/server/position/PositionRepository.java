package edu.utcn.gpstrack.server.position;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position, Integer> {
   // @Query("SELECT * FROM gpstrack30142.position WHERE terminal_id = ?1 AND creation_date BETWEEN ?2 and ?3;")
  //  List<Position> findByTerminalAndDate(String terminalId, String date1, String date2);

}
