package com.cannabis.BackCannabis.Controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ControllerGeneric <T> {
        @Autowired
        private JpaRepository<T, Integer> repository;


        @GetMapping("/")
        public List<T> getAll() {
            return repository.findAll();
        }

        @GetMapping("/{id}")
        public T getById(@PathVariable Integer id) {
            return repository.findById(id).orElse(null);
        }

        @PostMapping("/")
        public T create(@RequestBody T entity) {
            return repository.save(entity);
        }

        @PutMapping("/{id}")
        public T update(@PathVariable Integer id, @RequestBody T entity) {
            T existingEntity = repository.findById(id).orElse(null);
            if (existingEntity != null) {
                BeanUtils.copyProperties(entity, existingEntity, "id");
                return repository.save(existingEntity);
            }
            return null;
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable Integer id) {
            repository.deleteById(id);
        }
}
