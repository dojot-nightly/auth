package br.com.cpqd.platiot.user.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "senhaativa", schema = "cpqdplatiot")
public class ActivePasswordVO implements Serializable {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "senhaativa_id_seq", sequenceName = "cpqdplatiot.senhaativa_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "senhaativa_id_seq")
    private Integer id;
    @Column(name = "hash")
    private String hash;
    @Column(name = "salt")
    private byte[] salt;
    @ManyToOne
    @JoinColumn(name = "usuario")
    private UserVO user;
    @Column(name = "data")
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}