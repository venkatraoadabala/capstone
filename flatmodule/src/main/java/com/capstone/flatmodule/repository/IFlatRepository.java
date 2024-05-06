package com.capstone.flatmodule.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.flatmodule.entity.Flat;

public interface IFlatRepository extends JpaRepository<Flat,Integer>{


}
