package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Koala;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/koalas")
public class KoalaController {
  Map<Integer, Koala> koalas;

  public KoalaController() {  }

  @PostConstruct
  public void init() {
    koalas = new HashMap<>();
  }

  @GetMapping
  public List<Koala> getAllKoalas() {
    return new ArrayList<>(koalas.values());
  }

  @GetMapping("/{id}")
  public Koala getKoalaById(@PathVariable int id) {
    return koalas.get(id);
  }

  @PostMapping
  public Koala addKoala(@RequestBody Koala newKoala) {
    koalas.put(newKoala.getId(), newKoala);
    return newKoala;
  }

  @PutMapping("/{id}")
  public Koala updateKoala(@PathVariable int id, @RequestBody Koala updatedKoala) {
    koalas.put(id, updatedKoala);
    return updatedKoala;
  }

  @DeleteMapping("/{id}")
  public Koala deleteKoala(@PathVariable int id) {
    Koala deletedKoala = koalas.get(id);
    koalas.remove(id);
    return deletedKoala;
  }
}
