package com.section9.Java.Expenditures.Service.Expenditures;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExpendituresRepository extends JpaRepository<Expenditure,Integer> {
    List<Expenditure> findExpendituresByUserId(Integer userID);
    public Optional<Expenditure> findById(Integer id);


}
