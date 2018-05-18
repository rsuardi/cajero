package practice.ui;
import java.util.Scanner;
import practice.util.Util;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private int menuInput = 0;
    private int userInput = 0;
    private boolean isMenuClosed = false;
    private int multiple = 100;

    public  void showMenu(){

        System.out.println("Bienvenido a tu cajero favorito");
        System.out.println("--Seleccione una opción del menú");
        System.out.println("-- 1 Retirar dinero");
        System.out.println("-- 2 Salir");
        System.out.println("\033[3mDigite una opcion para continuar...\033[3m");
    }

    public int getMenuInput() {
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

    public int getUserInput(){

        return userInput;
    }

    public void setUserInput() {

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

    public  void setIsMenuClosed(boolean value){
        isMenuClosed = value;
    }

    public void exitMenu(){
        setIsMenuClosed(true);
        System.exit(0);
        System.out.println("Vuelva pronto!");
    }

    private boolean isValidUserInput(){
        if((getUserInput() >= 100 && Util.isMultipleOf(getUserInput(), multiple))&& (getUserInput() <= 10000 && Util.isMultipleOf(getUserInput(), multiple))) return true;
        return false;
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

    public void SendMoney(){
        System.out.println("Enviando el dinero...");


    }

    public void showInvoiceSummary(){

    }
}
