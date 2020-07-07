package com.gp.learn.awardservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gp.learn.awardservice.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
