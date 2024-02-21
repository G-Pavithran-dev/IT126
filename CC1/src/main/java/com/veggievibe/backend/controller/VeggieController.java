package com.veggievibe.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import com.veggievibe.backend.model.DairyDetails;
import com.veggievibe.backend.model.FruitDetails;
import com.veggievibe.backend.model.VegetableDetails;
import com.veggievibe.backend.services.VeggieServices;

@RestController
public class VeggieController {

    @Autowired
    private VeggieServices veggieServices;

    @PostMapping("/addVeggie")
    public VegetableDetails addVegetable(@RequestBody VegetableDetails vegetableDetails)
    {
        veggieServices.saveVegeteable(vegetableDetails);
        return vegetableDetails;
    }

    @PostMapping("/addFruite")
    public FruitDetails addFruit(@RequestBody FruitDetails fruitDetails)
    {
        veggieServices.saveFruits(fruitDetails);
        return fruitDetails;
    }

    @PostMapping("/addDairy")
    public DairyDetails addDairy(@RequestBody DairyDetails dairyDetails)
    {
        veggieServices.saveDairy(dairyDetails);
        return dairyDetails;
    }

    @GetMapping("/getVeggies")
    public List<VegetableDetails> getVeggie()
    {
        return veggieServices.getVegetables();
    }

    @GetMapping("/getFruites")
    public List<FruitDetails> getFruite()
    {
        return veggieServices.getFruits();
    }

    @GetMapping("/getDairy")
    public List<DairyDetails> getDairy()
    {
        return veggieServices.getDairies();
    }

    @GetMapping("/veggie/{id}")
    public VegetableDetails searchVeggieById(@PathVariable int id){
        return veggieServices.searchVeggieById(id);
    }

    @GetMapping("/fruite/{id}")
    public FruitDetails searchFruiteById(@PathVariable int id)
    {
        return veggieServices.searchFruiteById(id);
    }

    @GetMapping("/dairy/{id}")
    public DairyDetails searchDairyById(@PathVariable int id)
    {
        return veggieServices.searchDairyById(id);
    }

    @GetMapping("/veggieByName/{name}")
    public ResponseEntity<List<VegetableDetails>> getVeggieByName(@PathVariable String name)
    {
        List<VegetableDetails> vegetables = veggieServices.searchVeggieByName(name);
        if(vegetables.isEmpty())
        {
            return new ResponseEntity<List<VegetableDetails>>(HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<List<VegetableDetails>>(vegetables, HttpStatus.OK);
        }
    } 

    @GetMapping("/fruiteByName/{name}")
    public ResponseEntity<List<FruitDetails>> getFruiteByName(@PathVariable String name)
    {
        List<FruitDetails> fruits = veggieServices.searchFruiteByName(name);
        if(fruits.isEmpty())
        {
            return new ResponseEntity<List<FruitDetails>>(HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<List<FruitDetails>>(fruits, HttpStatus.OK);
        }
    }

    @GetMapping("/dairyByName/{name}")
    public ResponseEntity<List<DairyDetails>> getDairyByName(@PathVariable String name)
    {
        List<DairyDetails> dairy = veggieServices.searchDairyDetails(name);
        if(dairy.isEmpty())
        {
            return new ResponseEntity<List<DairyDetails>>(HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<List<DairyDetails>>(dairy, HttpStatus.OK);
        }
    }

    @PutMapping("/editVeggie/{id}")
    public ResponseEntity<String> editVeggie(@PathVariable int id, @RequestBody VegetableDetails vegetableDetails)
    {
        if(veggieServices.updateVeggie(id, vegetableDetails))
        {
            return new ResponseEntity<String>("Update Successful",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<String>("Update Unsuccessful ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editFruite/{id}")
    public ResponseEntity<String> editFruite(@PathVariable int id,@RequestBody FruitDetails fruitDetails)
    {
        if(veggieServices.updateFruite(id, fruitDetails))
        {
            return new ResponseEntity<String>("Update Successful", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("Update Unsuccessful", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("editDairy/{id}")
    public ResponseEntity<String> editDairy(@PathVariable int id,@RequestBody DairyDetails dairyDetails)
    {
        if(veggieServices.updateDairy(id, dairyDetails))
        {
            return new ResponseEntity<String>("Update Successful", HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<String>("Update Unsuccessful", HttpStatus.NOT_FOUND);
        }
    } 

    @DeleteMapping("/deleteVeggie/{id}")
    public ResponseEntity<String> deleteVeggie(@PathVariable int id)
    {
        if(veggieServices.deleteVeggie(id))
        {
            return new ResponseEntity<String>("Delete Successful",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<String>("Delete Unsuccessful ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteFruite/{id}")
    public ResponseEntity<String> deleteFruite(@PathVariable int id)
    {
        if(veggieServices.deleteFruite(id))
        {
            return new ResponseEntity<String>("Delete Successful", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("Delete Unsuccessful", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("deleteDairy/{id}")
    public ResponseEntity<String> deleteDairy(@PathVariable int id)
    {
        if(veggieServices.deleteDairy(id))
        {
            return new ResponseEntity<String>("Delete Successful", HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<String>("Delete Unsuccessful", HttpStatus.NOT_FOUND);
        }
    } 

    @GetMapping("/sortVeggieByPriceAsc")
    public List<VegetableDetails> sortVeggieByPriceAsc()
    {
        return veggieServices.SortVeggieByPriceAsc();
    }

    @GetMapping("/sortVeggieByPriceDesc")
    public List<VegetableDetails> sortVeggieByPriceDesc()
    {
        return veggieServices.SortVeggieByPriceDesc();
    }

    @GetMapping("/sortFruiteByPriceAsc")
    public List<FruitDetails> sortFruiteByPriceAsc()
    {
        return veggieServices.SortFruiteByPriceAsc();
    }

    @GetMapping("/sortFruiteByPriceDesc")
    public List<FruitDetails> sortFruiteByPriceDesc()
    {
        return veggieServices.SortFruiteByPriceDesc();
    }

    @GetMapping("/sortDairyByPriceAsc")
    public List<DairyDetails> sortDairyByPriceAsc()
    {
        return veggieServices.SortDairyByPriceAsc();
    }

    @GetMapping("/sortDairyByPriceDesc")
    public List<DairyDetails> sortDairyByPriceDesc()
    {
        return veggieServices.SortDairyByPriceDesc();
    }

    @GetMapping("/sortVeggieByNameAsc")
    public List<VegetableDetails> sortVeggieByNameAsc()
    {
        return veggieServices.SortVeggieByNameAsc();
    }

    @GetMapping("/sortVeggieByNameDesc")
    public List<VegetableDetails> sortVeggieByNameDesc()
    {
        return veggieServices.SortVeggieByNameDesc();
    }

    @GetMapping("/sortFruiteByNameAsc")
    public List<FruitDetails> sortFruiteByNameAsc()
    {
        return veggieServices.SortFruiteByNameAsc();
    }

    @GetMapping("/sortFruiteByNameDesc")
    public List<FruitDetails> sortFruiteByNameDesc()
    {
        return veggieServices.SortFruiteByNameDesc();
    }

    @GetMapping("/sortDairyByNameAsc")
    public List<DairyDetails> sortDairyByNameAsc()
    {
        return veggieServices.SortDairyByNameAsc();
    }

    @GetMapping("/sortDairyByNameDesc")
    public List<DairyDetails> sortDairyByNameDesc()
    {
        return veggieServices.SortDairyByNameDesc();
    }
}