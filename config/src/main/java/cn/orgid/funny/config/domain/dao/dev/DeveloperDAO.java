package cn.orgid.funny.config.domain.dao.dev;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.orgid.funny.config.domain.model.dev.Developer;

public interface DeveloperDAO extends JpaRepository<Developer, Long> {

}
