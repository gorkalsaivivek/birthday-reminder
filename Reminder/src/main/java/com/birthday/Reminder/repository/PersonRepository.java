package com.birthday.Reminder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.birthday.Reminder.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
