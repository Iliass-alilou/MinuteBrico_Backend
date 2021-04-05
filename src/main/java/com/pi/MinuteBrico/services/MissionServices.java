package com.pi.MinuteBrico.services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.pi.MinuteBrico.models.Mission;
import com.pi.MinuteBrico.repository.MissionRepository;

@Service
@Transactional
public class MissionServices {

	 private final MissionRepository missionRepository;
		
		public MissionServices(MissionRepository mission) {
			this.missionRepository=mission;
		}
		
		
		public Mission savemission(Mission mission) {
			return missionRepository.save(mission);
		}
		
		
		public List<Mission> findAll(){
			return missionRepository.findAll();
		}
		
		public Optional<Mission> findById(int id) {
			return missionRepository.findById(id);
		}

		public boolean deleteById(int id) {
			try {
				missionRepository.deleteById(id);
			} catch (Exception ex) {
				return false;
			}
			return true;
		}

		public List<Mission> findByEtatMission(int etat) {
			// TODO Auto-generated method stub
			return missionRepository.findByEtatMission(etat);
		}
}
