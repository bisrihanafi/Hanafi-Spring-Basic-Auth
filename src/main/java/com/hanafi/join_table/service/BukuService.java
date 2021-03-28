package com.hanafi.join_table.service;

import com.hanafi.join_table.model.Buku;
import com.hanafi.join_table.repository.BukuRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BukuService {

    private BukuRepo bukuRepo;

    public BukuService(BukuRepo bukuRepo) {
        this.bukuRepo = bukuRepo;
    }

    public List<Buku> simpan(Buku buku){
        this.bukuRepo.save(buku);
        return this.bukuRepo.findAll();
    }
    public List<Buku> lihat(){
        return this.bukuRepo.findAll();
    }
}
