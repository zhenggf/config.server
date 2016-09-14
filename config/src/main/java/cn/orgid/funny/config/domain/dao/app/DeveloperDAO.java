package cn.orgid.funny.config.domain.dao.app;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.orgid.funny.config.domain.model.app.Developer;

public interface DeveloperDAO extends JpaRepository<Developer, Long> {

}
