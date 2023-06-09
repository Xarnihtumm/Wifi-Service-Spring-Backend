package com.hostmdy.wifiservice.repository;




import org.springframework.data.repository.CrudRepository;

import com.hostmdy.wifiservice.domain.Speed;

public interface SpeedRepository  extends CrudRepository<Speed, Long>{
	//Optional<Speed> findBySpeedId(Long id);
//	Optional<Speed>  findBySpeed(Integer speed);

}
