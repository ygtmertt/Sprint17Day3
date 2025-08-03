package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kangaroos")  // So that every address will have /workintech + /kangaroos = /workintech/kangaroos
public class KangarooController {
  Map<Integer, Kangaroo> kangaroos;

  KangarooController() {  }

  @PostConstruct
  public void init() {
    kangaroos = new HashMap<>();
  }

  @GetMapping
  public List<Kangaroo> getAllKangaroos() {
    return new ArrayList<>(kangaroos.values());
  }

  @GetMapping("/{id}")
  public Kangaroo getKangarooById(@PathVariable int id) {
    return kangaroos.get(id);
  }

  @PostMapping
  public Kangaroo addKangaroo(@RequestBody Kangaroo newKangaroo) {
    kangaroos.put(newKangaroo.getId(), newKangaroo);
    return newKangaroo;
  }

  @PutMapping("/{id}")
  public Kangaroo updateKangaroo(@PathVariable int id, @RequestBody Kangaroo updatedKangaroo) {
    kangaroos.put(id, updatedKangaroo);
    return kangaroos.get(id);
  }

  @DeleteMapping("/{id}")
  public Kangaroo deleteKangaroo(@PathVariable int id) {
    Kangaroo deletedKangaroo = kangaroos.get(id);
    kangaroos.remove(id);
    return deletedKangaroo;
  }
}
