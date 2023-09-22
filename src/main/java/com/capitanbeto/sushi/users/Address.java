package com.capitanbeto.sushi.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String street;
    private String zipcode;
    private int number;

/*    @OneToOne(mappedBy = "address")
    private Users users;*/

    public Address() {
    }

    public Address(Long id, String city, String street, String zipcode, int number) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.number = number;
    }

    public Address(String city, String street, String zipcode, int number) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
