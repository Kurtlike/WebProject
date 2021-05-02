package com.kurtlike.webserv.scp.DAOs;

import com.kurtlike.webserv.scp.entitysPOJO.Anomaly;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AnomalyDAO extends JpaRepository<Anomaly,String> {
}
