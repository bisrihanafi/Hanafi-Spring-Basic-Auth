package com.hanafi.join_table.config;

import com.hanafi.join_table.model.Buku;
import com.hanafi.join_table.model.Mahasiswa;
import com.hanafi.join_table.repository.BukuRepo;
import com.hanafi.join_table.repository.MahasiswaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBInit implements CommandLineRunner {

    @Autowired
    private BukuRepo bukuRepo;
    @Autowired
    private MahasiswaRepo mahasiswaRepo;
    //Inisisalizer
    Mahasiswa m1=new Mahasiswa("Nafi","10001");
    Mahasiswa m2=new Mahasiswa("UY","10002");
    Mahasiswa m3=new Mahasiswa("VF","10003");
    public  void iniBuku(){
        this.bukuRepo.saveAll(Arrays.asList(
                new Buku("1", "Buku 1",m1),
                new Buku("2", "Buku 2",m2),
                new Buku("3", "Buku 3",m1)
                )
        );
    }
    public  void iniMahasiswa(){
        this.mahasiswaRepo.saveAll(Arrays.asList(
                m1,
                m2,
                m3
                )
        );
    }





    public void run(String... args) throws Exception {
        iniMahasiswa();
        iniBuku();

    }
}
