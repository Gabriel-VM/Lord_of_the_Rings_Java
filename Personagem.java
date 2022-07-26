public class Personagem {

    private String nome;
    private int hp; // pontos de vida.
    private int resist; // pontos de resistência da armadura.

    public Personagem(String nome, int hp, int resist) {
        this.nome = nome;
        this.hp = hp;
        this.resist = resist;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getResist() {
        return resist;
    }

    public void setResist(int resist) {
        this.resist = resist;
    }
}
