package com.hanafi.join_table.repository;

import com.hanafi.join_table.model.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MahasiswaRepo extends JpaRepository<Mahasiswa, Integer> {

}
