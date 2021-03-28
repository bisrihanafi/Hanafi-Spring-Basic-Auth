package com.hanafi.join_table.controller;

import com.hanafi.join_table.model.Mahasiswa;
import com.hanafi.join_table.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MahasiswaController {

    @Autowired
    MahasiswaService mahasiswaService;

    @PostMapping(value= "/mahasiswa")
    public List<Mahasiswa> home(@RequestBody Mahasiswa mahasiswa){
        return mahasiswaService.simpan(mahasiswa);
    }
    @GetMapping(value= "/mahasiswa")
    public List<Mahasiswa> index(){
        return mahasiswaService.lihat();
    }
    

}
