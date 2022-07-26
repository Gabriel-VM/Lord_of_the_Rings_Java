public class Besta extends Personagem {

    private int lance;
    private int potenciaAtaque;

    public Besta(String nome, int hp, int resist){
        super(nome, hp, resist);
    }

    public int getLance() {
        return lance;
    }

    public void setLance(int lance) {
        this.lance = lance;
    }

    public int getPotenciaAtaque() {
        return potenciaAtaque;
    }

    public void setPotenciaAtaque(int potenciaAtaque) {
        this.potenciaAtaque = potenciaAtaque;
    }

    public void atacar(){
        setLance((int) (Math.random()*90));
        setPotenciaAtaque(getLance());
    }
}
