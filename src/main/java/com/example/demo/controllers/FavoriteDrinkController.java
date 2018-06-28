package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.FavoriteDrink;
import com.example.demo.models.FavoriteDrinkRepository;

@RestController
@RequestMapping("/favoriteDrink")
@CrossOrigin(origins = "http://localhost:4200")
public class FavoriteDrinkController {
@Autowired
FavoriteDrinkRepository favoriteDrinkRepository;

@GetMapping()
public List<FavoriteDrink> getFavoriteDrink(){
	return favoriteDrinkRepository.findAll();
}

@PostMapping()
public void createFavoriteDrink(@RequestBody FavoriteDrink favoriteDrink) {
	favoriteDrinkRepository.save(favoriteDrink);
	
}
@DeleteMapping("/id")
public void deleteFavoriteDrink(@PathVariable("id")int id) {
	FavoriteDrink favoriteDrinkDelete = favoriteDrinkRepository.findById(id).orElse(null);
	favoriteDrinkRepository.delete(favoriteDrinkDelete);
}
}