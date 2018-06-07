package com.example.springboot.dataservice2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.dataservice2.entity.Coins;
@Repository
public interface CoinRepository extends JpaRepository<Coins,String>  {

}
