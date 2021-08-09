package pacotes;

public class listaDuplaEncadeada<T> {

    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;
    private int tamanholista;


    public listaDuplaEncadeada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanholista = 0;
    }

    public void remove(int index) {
        validadorIndex(index);
        if (size() == 1) {
            this.primeiroNo = null;
            this.ultimoNo = null;
        } else {
            NoDuplo<T> noAnterior = getNo(index).getNoAnterior();
            NoDuplo<T> noPosterior = getNo(index).getNoPosterior();
            if (index == 0) {
                //primeiro da fila
                primeiroNo = noPosterior;
                noPosterior.setNoAnterior(null);
            } else {
                if (index == size()) {
                    //ultimo da lista
                    ultimoNo = noAnterior;
                    noAnterior.setNoPosterior(null);
                } else {
                    noAnterior.setNoPosterior(noPosterior);
                    noPosterior.setNoAnterior(noAnterior);
                }
            }
        }
        tamanholista--;

    }

    public void add(T conteudo, int index) {
        validadorIndex(index);
        NoDuplo<T> noRef = getNo(index);
        NoDuplo<T> novoNo = new NoDuplo<T>(conteudo);
        if (noRef.getNoPosterior() != null && noRef.getNoAnterior() != null) {
            novoNo.setNoPosterior(noRef);
            novoNo.setNoAnterior(noRef.getNoAnterior());
            noRef.getNoAnterior().setNoPosterior(novoNo);

            tamanholista+=1;
            return;
        }

        if (noRef.getNoAnterior() == null && noRef.getNoPosterior() != null) {
            novoNo.setNoPosterior(noRef);
            novoNo.setNoAnterior(null);
            noRef.setNoAnterior(novoNo);
            this.primeiroNo=novoNo;
            tamanholista+=1;
            return;
        }
        this.add(conteudo);
    }

    public void add(T conteudo) {
        NoDuplo novoNo = new NoDuplo(conteudo);
        if (size() == 0) {
            primeiroNo = novoNo;
            ultimoNo = novoNo;
            tamanholista += 1;
            return;
        }
        novoNo.setNoAnterior(ultimoNo);
        ultimoNo.setNoPosterior(novoNo);
        ultimoNo = novoNo;
        tamanholista += 1;
    }

    public T get(int index) {
        return this.getNo(index).getDado();
    }

    private NoDuplo<T> getNo(int index) {
        this.validadorIndex(index);
        if (index == 0) {
            return this.primeiroNo;
        }
        NoDuplo<T> noAux = primeiroNo;
        for (int i = 0; (i < index) || (noAux == null); i++) {
            noAux = noAux.getNoPosterior();
        }
        return noAux;
    }

    private void validadorIndex(int index) {
        if (index > size()-1) {
            throw new IndexOutOfBoundsException("Index maior que o tamanho da lista");
        }
    }

    public int size() {
        return tamanholista;
    }

    @Override
    public String toString() {
        String srt = "";
        NoDuplo<T> noAux = primeiroNo;
        for (int i = 0; i < size(); i++) {
            srt+="Conteudo: "+noAux.getDado()+"-------->";
            noAux=noAux.getNoPosterior();
        }
        srt+="null";
        return srt;
    }

}
