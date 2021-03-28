package com.hanafi.join_table.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "buku")
public class Buku {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nomer_buku", length = 10)
    private String nomer;

    @Column(name = "judul", length = 30)
    private String judul;

    @ManyToOne
    private Mahasiswa mahasiswa;
    public Buku() {
    }

    public Buku(String nomer, String judul, Mahasiswa mahasiswa) {
        this.nomer = nomer;
        this.judul = judul;
        this.mahasiswa = mahasiswa;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }
}
