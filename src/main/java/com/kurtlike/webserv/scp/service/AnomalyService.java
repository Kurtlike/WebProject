package com.kurtlike.webserv.scp.service;

import com.kurtlike.webserv.scp.DAOs.AnomalyDAO;
import com.kurtlike.webserv.scp.entitysPOJO.Anomaly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Service
public class AnomalyService {
    @Autowired
    AnomalyDAO anomalyDAO;

    @Bean
    @SessionScope
    public AnomalyService sessionScopedBean() {
        return new AnomalyService();
    }
    @Transactional
    public List<Anomaly> getAllAnomalies(){
        return this.anomalyDAO.findAll();
    }
    @Transactional
    public Anomaly addAnomaly(Anomaly points){
        return this.anomalyDAO.save(points);
    }
    @Transactional
    public Anomaly getByName(String name){
        return  this.anomalyDAO.findAll().stream().filter(anomaly -> name.equals(anomaly.getName())).findFirst().orElse(null);
    }
}
