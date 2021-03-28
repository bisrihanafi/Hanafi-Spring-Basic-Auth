package com.hanafi.join_table.repository;

import com.hanafi.join_table.model.Buku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BukuRepo extends JpaRepository<Buku, Integer> {
}
