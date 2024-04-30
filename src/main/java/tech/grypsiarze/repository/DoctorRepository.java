package tech.grypsiarze.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.grypsiarze.model.Doctor;

interface DoctorRepository extends JpaRepository<Doctor, Long> {

}