package com.hanafi.join_table.controller;

import com.hanafi.join_table.model.Buku;
import com.hanafi.join_table.model.Mahasiswa;
import com.hanafi.join_table.service.BukuService;
import com.hanafi.join_table.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value= "/buku")
public class BukuController {
    @Autowired
    BukuService bukuService;

    @PostMapping
    public List<Buku> home(@RequestBody Buku buku){
        return bukuService.simpan(buku);
    }
    @GetMapping
    public List<Buku> index(){
        return bukuService.lihat();
    }



}
