public class Heroi extends Personagem {

    private int lance1;
    private int lance2;
    private int potenciaAtaque;

    public Heroi(String nome, int hp, int resist){
        super(nome, hp, resist);
    }

    public int getLance1() {
        return lance1;
    }

    public void setLance1(int lance1) {
        this.lance1 = lance1;
    }

    public int getLance2() {
        return lance2;
    }

    public void setLance2(int lance2) {
        this.lance2 = lance2;
    }

    public int getPotenciaAtaque() {
        return potenciaAtaque;
    }

    public void setPotenciaAtaque(int potenciaAtaque) {
        this.potenciaAtaque = potenciaAtaque;
    }

    public void atacar(){
        setLance1((int) (Math.random()*100));
        setLance2((int) (Math.random()*100));

        if(getLance1() > getLance2()){
            setPotenciaAtaque(getLance1());
        } else {
            setPotenciaAtaque(getLance2());
        }
    }


}
