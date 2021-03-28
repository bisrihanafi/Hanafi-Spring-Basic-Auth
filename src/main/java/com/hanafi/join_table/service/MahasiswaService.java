package com.hanafi.join_table.service;

import com.hanafi.join_table.model.Mahasiswa;
import com.hanafi.join_table.repository.MahasiswaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MahasiswaService {

    private MahasiswaRepo mahasiswaRepo;

    public MahasiswaService(MahasiswaRepo mahasiswaRepo) {
        this.mahasiswaRepo = mahasiswaRepo;
    }

    public List<Mahasiswa> simpan(Mahasiswa mahasiswa){
        this.mahasiswaRepo.save(mahasiswa);
        return this.mahasiswaRepo.findAll();
    }
    public List<Mahasiswa> lihat(){
        return this.mahasiswaRepo.findAll();
    }

}
