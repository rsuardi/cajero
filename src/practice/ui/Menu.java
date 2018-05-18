package practice.ui;

import practice.util.Util;

import java.util.*;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private int menuInput = 0;
    private int userInput = 0;
    private boolean isMenuClosed = false;
    private boolean isOpen = false;
    private int multiple = 100;
    private int resultado = 0;
    private HashMap<Integer, Integer> list;

    public Menu() {
        list = new HashMap<>();
    }

    public  void showMenu(){

        System.out.println("Bienvenido a tu cajero favorito");
        System.out.println("--Seleccione una opción del menú");
        System.out.println("-- 1 Retirar dinero");
        System.out.println("-- 2 Salir");
        System.out.println("\033[3mDigite una opcion para continuar...\033[3m");
    }

    private int getMenuInput() {
        return menuInput;
    }

    public void setMenuInput() {

        String menuEntry = scanner.next();

        if(Util.isNumber(menuEntry)){
            menuInput = Integer.parseInt(menuEntry);
        }
        else {
            menuInput = 0;
        }
    }

    public void showMenuInput(){

        System.out.println(getMenuInput());
    }

    private int getUserInput() {

        return userInput;
    }

    private void setUserInput() {

        String userEntry = scanner.next();

        if(Util.isNumber(userEntry)){
            userInput = Integer.parseInt(userEntry);
        }
        else {
            menuInput = 0;
        }
    }

    public void showUserInput(){
        System.out.println(getUserInput());
    }

    public boolean getIsMenuClosed(){
        return isMenuClosed;
    }

    private void setIsMenuClosed(boolean value) {
        isMenuClosed = value;
    }

    private void exitMenu() {
        setIsMenuClosed(true);
        System.out.println("Vuelva pronto!");
        System.exit(0);

    }

    private boolean isValidUserInput(){
        return (getUserInput() >= 100 && Util.isMultipleOf(getUserInput(), multiple)) && (getUserInput() <= 10000 && Util.isMultipleOf(getUserInput(), multiple));
    }

    public void doSomething(){

        int input = getMenuInput();

        switch (input){
            case 0:
                System.out.println("Sólo se aceptan números.");
                break;
            case 1:
                System.out.println("Que monto quiere retirar?");
                setUserInput();
                if(!isValidUserInput()) System.out.println("No se puede retirar el monto digitado.");
                else SendMoney();
                break;
            case 2:
                exitMenu();
                break;
            default:
                System.out.println("Debe elegir una opcion de las 2 que aparecen en el menú.");
                break;
        }
    }

    private void SendMoney() {
        System.out.println("Enviando el dinero...");

        isOpen = true;
        int entrada = getUserInput();

        while (isOpen) {
            if (resultado == entrada) {
                isOpen = false;
            } else if (resultado == 0) {
                cero();
            } else {
                biggerThanCero();
            }
        }
        printBills();
        reInit();
    }

    private void cero() {

        int cantidad = getUserInput();

        if (cantidad >= 2000) {
            resultado += 2000;
            incrementQuantity(2000, 1);
        } else if (cantidad >= 1000) {
            resultado += 1000;
            incrementQuantity(1000, 1);
        } else if (cantidad >= 500) {
            resultado += 500;
            incrementQuantity(500, 1);
        } else if (cantidad >= 200) {
            resultado += 200;
            incrementQuantity(200, 1);
        } else {
            resultado += 100;
            incrementQuantity(100, 1);
        }
    }

    private void biggerThanCero() {

        int cantidad = getUserInput();

        if ((resultado + 2000) <= cantidad) {
            resultado += 2000;
            incrementQuantity(2000, 1);
        } else if ((resultado + 1000) <= cantidad) {
            resultado += 1000;
            incrementQuantity(1000, 1);
        } else if ((resultado + 500) <= cantidad) {
            resultado += 500;
            incrementQuantity(500, 1);
        } else if ((resultado + 200) <= cantidad) {
            resultado += 200;
            incrementQuantity(200, 1);
        } else {
            resultado += 100;
            incrementQuantity(100, 1);
        }
    }

    private void printBills() {

        for (int key : list.keySet()) {
            System.out.printf("ENVIANDO %d PAPELETAS DE %d = %d%n", list.get(key), key, (list.get(key) * key));
        }
    }

    private void incrementQuantity(int ballot, int quantity) {

        if (!list.containsKey(ballot)) list.put(ballot, quantity);
        else list.put(ballot, list.get(ballot) + quantity);

    }

    private void reInit(){
        isOpen = true;
        resultado = 0;
        list.clear();
    }
}
