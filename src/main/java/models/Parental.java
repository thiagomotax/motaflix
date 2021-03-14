/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author T-Gamer
 */
public class Parental
{
    private String key;
    private Integer value;

    public Parental(String key, Integer value)
    {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString()
    {
        return key;
    }

    public String getKey()
    {
        return key;
    }

    public Integer getValue()
    {
        return value;
    }
}