package com.menucalc.ans;

/**
 * Created by Reza on 11/05/2016.
 */
public class Menu {

    private int nolist;
    private String menulist;
    private int hargalist;

    public Menu() {

    }

    public Menu(String menulist, int hargalist) {
        this.menulist = menulist;
        this.hargalist = hargalist;
    }

    public Menu(int nolist, String menulist, int hargalist) {
        this.nolist = nolist;
        this.menulist = menulist;
        this.hargalist = hargalist;
    }

    public String getMenulist() {
        return menulist;
    }

    public int getHargalist() {
        return hargalist;
    }

    public int getNolist() {
        return nolist;
    }

    public void setNolist(int nolist) {
        this.nolist = nolist;
    }

    public void setMenulist(String menulist) {
        this.menulist = menulist;
    }

    public void setHargalist(int hargalist) {
        this.hargalist = hargalist;
    }

    public void setNilai(int nolist, String menulist, int hargalist) {
        this.nolist = nolist;
        this.menulist = menulist;
        this.hargalist = hargalist;
    }
    
}