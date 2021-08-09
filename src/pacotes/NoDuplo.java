package pacotes;

public class NoDuplo<T> {
    private T dado;
    private NoDuplo<T> noPosterior;
    private NoDuplo<T> noAnterior;

    public NoDuplo(T dado) {
        this.dado = dado;
        this.noPosterior = null;
        this.noAnterior = null;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public NoDuplo<T> getNoPosterior() {
        return noPosterior;
    }

    public void setNoPosterior(NoDuplo noPosterior) {
        this.noPosterior = noPosterior;
    }

    public NoDuplo<T> getNoAnterior() {
        return noAnterior;
    }

    public void setNoAnterior(NoDuplo noAnterior) {
        this.noAnterior = noAnterior;
    }

    @Override
    public String toString() {
        return "NoDuplo{" +
                "dado=" + dado +
                '}';
    }


}
