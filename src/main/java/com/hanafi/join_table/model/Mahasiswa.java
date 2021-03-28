package com.hanafi.join_table.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mahasiswa")
public class Mahasiswa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;


    @Column(name = "nama", length = 30)
    private String nama;

    @Column(name = "nim", length = 10)
    private String nim;

    @OneToMany(mappedBy = "mahasiswa", targetEntity = Buku.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Buku> buku;

    public Mahasiswa() {
    }

    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }
}
