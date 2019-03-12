/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.roman.certification.jcl.swing;


/**
 * @author MAbernethy 02.03.2008
 */
class Flight                         // объект флайт  , - строка таблицы
{
    private String departure;
    private String destination;
    private int remainingTixx;
    private int flightNum;

    public boolean equals(Object o)            // сравнение объектов флайт
    {
        Flight f = (Flight) o;                       //
        return departure.equals(f.getDeparture())
                && destination.equals(f.getDestination())
                && flightNum == f.getFlightNum();
    }

    public String getDeparture()                // получить поля
    {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public int getRemainingTixx() {
        return remainingTixx;
    }

    public void setDeparture(String string) {
        departure = string;
    }

    public void setDestination(String string) {
        destination = string;
    }

    public void setRemainingTixx(int i) {
        remainingTixx = i;
    }


    public int getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(int i) {
        flightNum = i;
    }

}
