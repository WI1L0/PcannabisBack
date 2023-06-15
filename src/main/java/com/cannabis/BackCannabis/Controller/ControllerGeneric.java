package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Services.GenericServicesImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ControllerGeneric <T> {
        @Autowired
        private GenericServicesImpl<T, Integer> repository;


        @GetMapping("/")
        public List<T> getAll() {
            return repository.findByAll();
        }

        @GetMapping("/{id}")
        public T getById(@PathVariable Integer id) {
            T t = repository.findById(id);
            if (t != null) {
                return t;
            } else {
                return null;
            }
        }

        @PostMapping("/")
        public T create(@RequestBody T entity) {
            return repository.save(entity);
        }

        @PutMapping("/{id}")
        public T update(@PathVariable Integer id, @RequestBody T entity) {
            T existingEntity = repository.findById(id);
            if (existingEntity != null) {
                BeanUtils.copyProperties(entity, existingEntity, "id");
                return repository.save(existingEntity);
            }
            return null;
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable Integer id) {
            repository.delete(id);
        }
}
