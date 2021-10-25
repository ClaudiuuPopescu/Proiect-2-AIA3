import java.util.ArrayList;
import java.util.List;

public class GroceryList {

    private static int counter;
    private String buying;
    private List <String> groceryList;

    public GroceryList(){
        this.buying = "legume";
        counter++;
    }
    public GroceryList(String buying) {
        this.buying = buying;
        this.groceryList = new ArrayList<>();
        counter++;
    }


    // metoda de tip boolean verifica daca elementul introdus se afla sau nu deja in array, adica pe lista
    public boolean searchForItem (String name){
        boolean exists = groceryList.contains(name);
        if(exists) {
            return true;
        } else {
            return false;
        }
    }

    // metoda verifica daca elementul introdus este pe lista, prin implementarea metodei de cautare, dupa care, daca nu se afla, se adauga elementul introdus
    public boolean addItem (String name) {
        boolean checkItem = searchForItem(name);
        if (!checkItem && name != "\""){
            groceryList.add(name);
            System.out.println(name + " a fost adaugat cu succes.");
            return true;
        }
//        else {
//            System.out.println("Produsul '" + name + "' este deja pe lista.");
//            return false;
//        }
        return false;

    }

    //metoda verifica daca elementul introdus este pe lista, prin imlementarea metodei de cautare, daca este pe lista atunci va primi "remove", altfel va transmite userului ca elementul este gresit
    public boolean removeItem (String name){
        boolean checkItem = searchForItem(name);
        if(checkItem && name !=null){
            groceryList.remove(name);
            System.out.println(name + " a fost sters cu succes.");
            return true;
        }
//        else {
//            System.out.println("Produsul '" + name + "' nu este pe lista.");
        return false;
//        }
    }

    // metoda de tip boolean verifica daca indexul elementului introdus se afla sau nu deja in array, adica pe lista
    private boolean searchForIndex (int index){
        int size = groceryList.size();
        if(size>=index) {
            return true;
        } else {
            return false;
        }
    }

    //metoda modifica un elementul de la indexul specificat de catre utilizator
    public void modifyElementByIndex (int index, String name){
        boolean checkItem = searchForIndex(index + 1);
        if(checkItem){
            groceryList.set(index - 1, name);
            System.out.println("Noul produs de pe pozitia " + index + " este " + name);
        }  else {
            System.out.println("Produsul '" + name + "' nu este pe lista.");
        }
    }

    //printarea listei
    public void printList(){
        System.out.println("Ai " + groceryList.size() + " produse pe lista.");
        for(int i=0; i<groceryList.size(); i++) {
            System.out.println((i+1) + ". " + groceryList.get(i));
        }
    }

    public String printListBuffer(){
        StringBuffer str = new StringBuffer("Ai " + groceryList.size() + " produse pe lista: \n");
        for(int i=0; i<groceryList.size(); i++) {
            str.append((i+1) + ". " + groceryList.get(i) + "\n");
        }
        return str.toString();
    }

    @Override
    public String toString() {
        return "GroceryList{" +
                "buying='" + buying + '\'' +
                ", groceryList=" + groceryList +
                '}';
    }

    //metoda prin care se tine evidenta instantierilor, folosind bineinteles o variabila statica
    public static int getCounter(){
        return counter;
    }





}

