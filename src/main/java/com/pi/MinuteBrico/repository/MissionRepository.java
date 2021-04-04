package com.pi.MinuteBrico.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.MinuteBrico.models.Mission;


public interface MissionRepository extends JpaRepository<Mission, Integer> {

	List<Mission> findByEtatMission(int etatMission);
}
