package com.kurtlike.webserv.DAOs;

import com.kurtlike.webserv.entitysPOJO.Anomaly;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AnomalyDAO extends JpaRepository<Anomaly,String> {
}
