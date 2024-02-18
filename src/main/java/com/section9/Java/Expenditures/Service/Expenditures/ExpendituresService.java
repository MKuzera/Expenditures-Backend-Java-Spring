package com.section9.Java.Expenditures.Service.Expenditures;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpendituresService {
    private ExpendituresRepository expendituresRepository;

    public ExpendituresService(ExpendituresRepository expendituresRepository) {
        this.expendituresRepository = expendituresRepository;
    }

    public List<Expenditure> getAllExpendituresByUserId(Integer userId){
        return expendituresRepository.findExpendituresByUserId(userId);
    }

    public Expenditure getByExpenditureID(Integer id){
        return expendituresRepository.findById(id).orElseThrow();
    }

    public ResponseEntity<Void> deleteExpenditureByID(Integer id){
        expendituresRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    public Expenditure addExpenditure(Expenditure expenditure){
        return expendituresRepository.save(expenditure);
    }
    public void addRandom(){
        Expenditure expenditure1 = new Expenditure("Jeden1","t",30.0 , LocalDate.now(),1);
        Expenditure expenditure2 = new Expenditure("Jede2","t",30.0 , LocalDate.now(),2);
        Expenditure expenditure3 = new Expenditure("Jeden3","t",30.0 , LocalDate.now(),2);

        expendituresRepository.save(expenditure1);
        expendituresRepository.save(expenditure2);
        expendituresRepository.save(expenditure3);
    }



}
