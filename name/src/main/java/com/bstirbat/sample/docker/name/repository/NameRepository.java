package com.bstirbat.sample.docker.name.repository;

import com.bstirbat.sample.docker.name.entity.Name;
import org.springframework.data.repository.CrudRepository;

public interface NameRepository extends CrudRepository<Name, Long> {
}
