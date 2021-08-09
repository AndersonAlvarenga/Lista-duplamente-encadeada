package pacotes;

public class main {
    public static void main(String[] args){
        listaDuplaEncadeada<String> lista = new listaDuplaEncadeada<String>();
        lista.add("teste1");
        lista.add("teste2");
        lista.add("teste3");
        lista.add("teste4");
        lista.add("teste5");

        System.out.println(lista);

        lista.add("teset6",4);
        System.out.println(lista);

        lista.remove(2);
System.out.println(lista);
    }
}
