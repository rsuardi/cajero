package practice.main;


import practice.ui.Menu;

public class Cajero {

    public static void main(String [] args){


        Menu menu = new Menu();
        while (!menu.getIsMenuClosed()){
            menu.showMenu();
            menu.setMenuInput();
            menu.doSomething();
            menu.showInvoiceSummary();
        }
    }

}
