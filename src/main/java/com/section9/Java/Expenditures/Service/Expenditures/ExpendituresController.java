package com.section9.Java.Expenditures.Service.Expenditures;


import com.section9.Java.Expenditures.Service.user.UserRepository;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ExpendituresController {
    private ExpendituresService expendituresService;


    public ExpendituresController(ExpendituresService expendituresService) {
        this.expendituresService=expendituresService;
        expendituresService.addRandom();
    }

    @GetMapping(value="/user/{userID}/expenditures")
    public List<Expenditure> getExpenditures(@PathVariable Integer userID){
        return expendituresService.getAllExpendituresByUserId(userID);
    }
    @GetMapping(value="/user/{userID}/expenditure/{expID}")
    public Expenditure getExpenditure(@PathVariable Integer userID, @PathVariable Integer expID){
        System.out.println(expID);
        return expendituresService.getByExpenditureID(expID);
    }

    @DeleteMapping(value="/user/{userID}/expenditure/{expID}")
    public ResponseEntity<Void> deleteExpenditure(@PathVariable Integer userID, @PathVariable Integer expID){

        return expendituresService.deleteExpenditureByID(expID);
    }


    @PostMapping(value="/add-expenditure")
    public void addExpenditure(@RequestBody Expenditure expenditure) {
        expendituresService.addExpenditure(expenditure);

    }

    @PutMapping(value = "/put-expenditure")
    public void putExpenditure(@RequestBody Expenditure expenditure){
        expendituresService.addExpenditure(expenditure);
    }






}
