import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        Elfo legolas = new Elfo("Legolas", 150, 30);
        Humano aragorn = new Humano("Aragorn", 150, 50);
        Humano boromir = new Humano("Boromir", 100, 60);
        Humano gandalf = new Humano("Gandalf", 300, 30);
        Hobbit frodo = new Hobbit("Frodo", 20, 10);

        Orque lurtz = new Orque("Lurtz", 200, 60);
        Orque shagrat = new Orque("Shagrat", 220, 50);
        Troll ugluk = new Troll("Uglúk", 120, 30);
        Troll mauhur = new Troll("Mauhúr", 100, 30);


        Heroi[] herois = {legolas, aragorn, boromir, gandalf, frodo};
        Besta[] bestas = {lurtz, shagrat, ugluk, mauhur};

        /*Todas as listas dinâmicas a seguir têm por função guardar os valores iniciais dos arrays de herois e de bestas definidos acima.
        Optei por seguir a nomenclatura dos arrays fixos, acrescentando o sufixo "Din", para indicar que a lista é dinâmica.

        - "heroisDin" e "bestasDin" são usados quando o tamanho inicial definido para os exércitos de herois e bestas é igual.
        - "heroisCombateDin" e "bestasCombateDin" são usados para indicar, respectivamente, os herois e bestas que estão em combate quando o efetivo de um exército é inicialmente maior do que o de outro.
        - "heroisReservaDin" e "bestasReservaDin" contêm, respectivamente, as listas de herois e bestas que só começam a ocupar as linhas de combate quando há perda de algum membro dos exércitos.*/


        ArrayList<Heroi> heroisDin = new ArrayList<Heroi>(); // Lista de herois.
        ArrayList<Besta> bestasDin = new ArrayList<Besta>(); // Lista de bestas.
        ArrayList<Heroi> heroisCombateDin = new ArrayList<Heroi>(); // Lista de herois no combate.
        ArrayList<Heroi> heroisReservaDin = new ArrayList<Heroi>(); // Lista de herois na reserva.
        ArrayList<Besta> bestasCombateDin = new ArrayList<Besta>(); // Lista de bestas no combate.
        ArrayList<Besta> bestasReservaDin = new ArrayList<Besta>(); // Lista de bestas na reserva.

        int turno = 0; //Indica o turno do combate.


        if (herois.length > bestas.length) {

            Heroi[] heroisCombate = new Heroi[bestas.length];
            Heroi[] heroisReserva = new Heroi[herois.length - bestas.length];

            for (int i = 0; i < heroisCombate.length; i++) {
                heroisCombate[i] = herois[i]; // Popula o array de herois na fila de combate.
            }
            for (int i = 0; i < heroisCombate.length; i++) {
                heroisCombateDin.add(heroisCombate[i]); // Popula a lista de herois no combate.
            }

            for (int i = 0; i < (herois.length - bestas.length); i++) {
                heroisReserva[i] = herois[i + (bestas.length)]; // Popula o array de herois na "reserva".
            }

            for (int i = 0; i < heroisReserva.length; i++) {
                heroisReservaDin.add(heroisReserva[i]); // Popula a lista de herois na "reserva".
            }

            for (int i = 0; i < bestas.length; i++) {
                bestasCombateDin.add(bestas[i]); // Popula a lista de bestas no combate.
            }


            outer:
            while (heroisCombateDin.size() != 0 || bestasCombateDin.size() != 0) { // É a própria condição para que haja combates. O loop corre enquanto houver efetivo em um dos exércitos.

                int potenciaDano = 0;
                System.out.println(" ");
                System.out.println("===============================");
                System.out.println("Turno " + ++turno + ":");
                System.out.println("===============================");

                for (int i = 0; i < heroisCombateDin.size() && i < bestasCombateDin.size(); i++) {

                    System.out.println(" ");
                    System.out.println("- Luta entre " + heroisCombateDin.get(i).getNome() + " (Vida = " + heroisCombateDin.get(i).getHp() + " Armadura = " + heroisCombateDin.get(i).getResist() + ")" + " e " + bestasCombateDin.get(i).getNome() + " (Vida = " + bestasCombateDin.get(i).getHp() + " Armadura  = " + bestasCombateDin.get(i).getResist() + ")");
                    System.out.println(" ");

                    heroisCombateDin.get(i).atacar();

                    if (heroisCombateDin.get(i).getClass() == Elfo.class && bestasCombateDin.get(i).getClass() == Orque.class) {
                        heroisCombateDin.get(i).setPotenciaAtaque(heroisCombateDin.get(i).getPotenciaAtaque() + 10); // Aumenta em 10 a potência do ataque quando um Elfo luta contra um Orque.
                    } else if (heroisCombateDin.get(i).getClass() == Hobbit.class && bestasCombateDin.get(i).getClass() == Troll.class) {
                        heroisCombateDin.get(i).setPotenciaAtaque(heroisCombateDin.get(i).getPotenciaAtaque() - 5); // Diminui em 5 a potência do ataque de um Hobbit que luta contra um Troll.
                    }

                    if (heroisCombateDin.get(i).getPotenciaAtaque() > bestasCombateDin.get(i).getResist()) { //Se a potência do ataque do heroi for maior do que a resistência (armadura) da besta...
                        potenciaDano = heroisCombateDin.get(i).getPotenciaAtaque() - bestasCombateDin.get(i).getResist();
                        bestasCombateDin.get(i).setHp(bestasCombateDin.get(i).getHp() - potenciaDano);
                        System.out.println(heroisCombateDin.get(i).getNome() + " saca " + heroisCombateDin.get(i).getPotenciaAtaque() + " e tira " + potenciaDano + " de " + bestasCombateDin.get(i).getNome());

                        if (bestasCombateDin.get(i).getHp() <= 0) {
                            System.out.println("Morre o " + bestasCombateDin.get(i).getClass().getSimpleName() + " " + bestasCombateDin.get(i).getNome() + "!!");
                            bestasCombateDin.remove(i);

                            if (bestasCombateDin.size() == 0) {
                                break outer;
                            }

                            break;


                        }
                    } else {
                        System.out.println(heroisCombateDin.get(i).getNome() + " saca " + heroisCombateDin.get(i).getPotenciaAtaque() + " e tira " + 0 + " de " + bestasCombateDin.get(i).getNome());
                    }

                    bestasCombateDin.get(i).atacar();
                    int armaduraRestaurada = (heroisCombateDin.get(i).getResist()); // Será usada para restaurar o valor inicial da armadura de um heroi após o ataque de um Orque.

                    if (bestasCombateDin.get(i).getClass() == Orque.class) {
                        heroisCombateDin.get(i).setResist(heroisCombateDin.get(i).getResist() - (heroisCombateDin.get(i).getResist() / 10)); // Ataque de Orque reduz a armadura do heroi em 10% do seu valor inicial.
                    }

                    //System.out.println("Armadura do heroi " + heroisCombateDin.get(i).getNome() + " = " + heroisCombateDin.get(i).getResist());
                    //Descomentar a linha acima para verificar que o ataque do orque reduz a armadura do heroi.

                    if (bestasCombateDin.get(i).getPotenciaAtaque() > heroisCombateDin.get(i).getResist()) {
                        potenciaDano = bestasCombateDin.get(i).getPotenciaAtaque() - heroisCombateDin.get(i).getResist();
                        heroisCombateDin.get(i).setHp(heroisCombateDin.get(i).getHp() - potenciaDano);
                        System.out.println(bestasCombateDin.get(i).getNome() + " saca " + bestasCombateDin.get(i).getPotenciaAtaque() + " e tira " + potenciaDano + " de " + heroisCombateDin.get(i).getNome());

                        if (heroisCombateDin.get(i).getHp() <= 0) {
                            System.out.println("Morre o " + heroisCombateDin.get(i).getClass().getSimpleName() + " " + heroisCombateDin.get(i).getNome() + "!!");
                            heroisCombateDin.remove(i);

                            if (heroisReservaDin.size() != 0) {

                                heroisCombateDin.add(heroisReservaDin.get(0));
                                heroisReservaDin.remove(0);
                                break;
                            }

                            if (heroisCombateDin.size() == 0) {

                                break outer;

                            }

                            break;

                        }


                    } else {
                        System.out.println(bestasCombateDin.get(i).getNome() + " saca " + bestasCombateDin.get(i).getPotenciaAtaque() + " e tira " + 0 + " de " + heroisCombateDin.get(i).getNome());
                    }

                    heroisCombateDin.get(i).setResist(armaduraRestaurada);
                    //System.out.println("Armadura do heroi " + heroisCombateDin.get(i).getNome() + " restaurada para " + heroisCombateDin.get(i).getResist());
                    //Descomentar linha acima para verificar que o valor inicial da armadura do heroi é restaurado após o turno de batalha.


                }

            }


            if (heroisCombateDin.size() != 0) {
                System.out.println(" ");
                System.out.println("......................");
                System.out.println("OS HEROIS GANHARAM!!");
                System.out.println("......................");
            } else {
                System.out.println(" ");
                System.out.println("......................");
                System.out.println("AS BESTAS GANHARAM!!");
                System.out.println("......................");
            }


        } else if (bestas.length > herois.length) {

            Besta[] bestasCombate = new Besta[herois.length];
            Besta[] bestasReserva = new Besta[bestas.length - herois.length];

            for (int i = 0; i < bestasCombate.length; i++) {
                bestasCombate[i] = bestas[i];
            }
            for (int i = 0; i < bestasCombate.length; i++) {
                bestasCombateDin.add(bestasCombate[i]);
            }

            for (int i = 0; i < (bestas.length - herois.length); i++) {
                bestasReserva[i] = bestas[i + (herois.length)];
            }

            for (int i = 0; i < bestasReserva.length; i++) {
                bestasReservaDin.add(bestasReserva[i]);
            }

            for (int i = 0; i < herois.length; i++) {
                heroisCombateDin.add(herois[i]);
            }

            outer:
            while (bestasCombateDin.size() != 0 || heroisCombateDin.size() != 0) {

                int potenciaDano = 0;
                System.out.println(" ");
                System.out.println("===============================");
                System.out.println("Turno " + ++turno + ":");
                System.out.println("===============================");

                for (int i = 0; i < bestasCombateDin.size() && i < heroisCombateDin.size(); i++) {

                    System.out.println(" ");
                    System.out.println("- Luta entre " + heroisCombateDin.get(i).getNome() + " (Vida = " + heroisCombateDin.get(i).getHp() + " Armadura = " + heroisCombateDin.get(i).getResist() + ")" + " e " + bestasCombateDin.get(i).getNome() + " (Vida = " + bestasCombateDin.get(i).getHp() + " Armadura  = " + bestasCombateDin.get(i).getResist() + ")");
                    System.out.println(" ");

                    heroisCombateDin.get(i).atacar();

                    if (heroisCombateDin.get(i).getClass() == Elfo.class && bestasCombateDin.get(i).getClass() == Orque.class) {
                        heroisCombateDin.get(i).setPotenciaAtaque(heroisCombateDin.get(i).getPotenciaAtaque() + 10);
                    } else if (heroisCombateDin.get(i).getClass() == Hobbit.class && bestasCombateDin.get(i).getClass() == Troll.class) {
                        heroisCombateDin.get(i).setPotenciaAtaque(heroisCombateDin.get(i).getPotenciaAtaque() - 5);
                    }

                    if (heroisCombateDin.get(i).getPotenciaAtaque() > bestasCombateDin.get(i).getResist()) {
                        potenciaDano = heroisCombateDin.get(i).getPotenciaAtaque() - bestasCombateDin.get(i).getResist();
                        bestasCombateDin.get(i).setHp(bestasCombateDin.get(i).getHp() - potenciaDano);
                        System.out.println(heroisCombateDin.get(i).getNome() + " saca " + heroisCombateDin.get(i).getPotenciaAtaque() + " e tira " + potenciaDano + " de " + bestasCombateDin.get(i).getNome());

                        if (bestasCombateDin.get(i).getHp() <= 0) {

                            System.out.println("Morre o " + bestasCombateDin.get(i).getClass().getSimpleName() + " " + bestasCombateDin.get(i).getNome() + "!!");
                            bestasCombateDin.remove(bestasCombateDin.get(i));

                            if (bestasReservaDin.size() != 0) {

                                bestasCombateDin.add(bestasReservaDin.get(0));
                                bestasReservaDin.remove(0);
                                break;

                            }

                            if (bestasCombateDin.size() == 0) {
                                break outer;
                            }

                            break;


                        }

                    } else {
                        System.out.println(heroisCombateDin.get(i).getNome() + " saca " + heroisCombateDin.get(i).getPotenciaAtaque() + " e tira " + 0 + " de " + bestasCombateDin.get(i).getNome());
                    }

                    bestasCombateDin.get(i).atacar();

                    int armaduraRestaurada = (heroisCombateDin.get(i).getResist());

                    if (bestasCombateDin.get(i).getClass() == Orque.class) {
                        heroisCombateDin.get(i).setResist(heroisCombateDin.get(i).getResist() - (heroisCombateDin.get(i).getResist() / 10));
                    }
                    //System.out.println("Armadura do heroi " + heroisCombateDin.get(i).getNome() + " = " + heroisCombateDin.get(i).getResist());

                    if (bestasCombateDin.get(i).getPotenciaAtaque() > heroisCombateDin.get(i).getResist()) {
                        potenciaDano = bestasCombateDin.get(i).getPotenciaAtaque() - heroisCombateDin.get(i).getResist();
                        heroisCombateDin.get(i).setHp(heroisCombateDin.get(i).getHp() - potenciaDano);
                        System.out.println(bestasCombateDin.get(i).getNome() + " saca " + bestasCombateDin.get(i).getPotenciaAtaque() + " e tira " + potenciaDano + " de " + heroisCombateDin.get(i).getNome());

                        if (heroisCombateDin.get(i).getHp() <= 0) {

                            System.out.println("Morre o " + heroisCombateDin.get(i).getClass().getSimpleName() + " " + heroisCombateDin.get(i).getNome() + "!!");
                            heroisCombateDin.remove(i);

                            if (heroisCombateDin.size() == 0) {
                                break outer;
                            }
                            break;
                        }


                    } else {
                        System.out.println(bestasCombateDin.get(i).getNome() + " saca " + bestasCombateDin.get(i).getPotenciaAtaque() + " e tira " + 0 + " de " + heroisCombateDin.get(i).getNome());
                    }

                    heroisCombateDin.get(i).setResist(armaduraRestaurada);
                    //System.out.println("Armadura do heroi " + heroisCombateDin.get(i).getNome() + " restaurada para " + heroisCombateDin.get(i).getResist());
                }

            }

            if (heroisCombateDin.size() != 0) {
                System.out.println(" ");
                System.out.println("........................");
                System.out.println("OS HEROIS GANHARAM!!");
                System.out.println("........................");
            } else {
                System.out.println(" ");
                System.out.println("........................");
                System.out.println("AS BESTAS GANHARAM!!");
                System.out.println("........................");
            }


        } else {

            for (int i = 0; i < herois.length; i++) {

                heroisDin.add(herois[i]);
                bestasDin.add(bestas[i]);

            }

            outer:
            while (heroisDin.size() != 0 || bestasDin.size() != 0) {
                int potenciaDano = 0;

                System.out.println(" ");
                System.out.println("===============================");
                System.out.println("Turno " + ++turno + ":");
                System.out.println("===============================");

                for (int i = 0; i < heroisDin.size() && i < bestasDin.size(); i++) {

                    System.out.println(" ");
                    System.out.println("- Luta entre " + heroisDin.get(i).getNome() + " (Vida = " + heroisDin.get(i).getHp() + " Armadura = " + heroisDin.get(i).getResist() + ")" + " e " + bestasDin.get(i).getNome() + " (Vida = " + bestasDin.get(i).getHp() + " Armadura  = " + bestasDin.get(i).getResist() + ")");
                    System.out.println(" ");

                    heroisDin.get(i).atacar();

                    if (heroisDin.get(i).getClass() == Elfo.class && bestasDin.get(i).getClass() == Orque.class) {
                        heroisDin.get(i).setPotenciaAtaque(heroisDin.get(i).getPotenciaAtaque() + 10);
                    } else if (heroisDin.get(i).getClass() == Hobbit.class && bestasDin.get(i).getClass() == Troll.class) {
                        heroisDin.get(i).setPotenciaAtaque(heroisDin.get(i).getPotenciaAtaque() - 5);
                    }

                    if (heroisDin.get(i).getPotenciaAtaque() > bestasDin.get(i).getResist()) {

                        potenciaDano = (heroisDin.get(i).getPotenciaAtaque() - bestasDin.get(i).getResist());
                        bestasDin.get(i).setHp(bestasDin.get(i).getHp() - potenciaDano);
                        System.out.println(heroisDin.get(i).getNome() + " saca " + heroisDin.get(i).getPotenciaAtaque() + " e tira " + potenciaDano + " de " + bestasDin.get(i).getNome());

                        if (bestasDin.get(i).getHp() <= 0) {

                            System.out.println("Morre o " + bestasDin.get(i).getClass().getSimpleName() + " " + bestasDin.get(i).getNome() + "!!");
                            bestasDin.remove(bestasDin.get(i));

                            if (bestasDin.size() == 0) {
                                break outer;
                            }
                            break;

                        }


                    } else {
                        System.out.println(heroisDin.get(i).getNome() + " saca " + heroisDin.get(i).getPotenciaAtaque() + " e tira " + 0 + " de " + bestasDin.get(i).getNome());
                    }

                    bestasDin.get(i).atacar();

                    int armaduraRestaurada = (heroisDin.get(i).getResist());

                    if (bestasDin.get(i).getClass() == Orque.class) {
                        heroisDin.get(i).setResist(heroisDin.get(i).getResist() - (heroisDin.get(i).getResist() / 10));
                    }

                    //System.out.println("Armadura do " + heroisDin.get(i).getNome() + " reduzida para " + heroisDin.get(i).getResist());

                    if (bestasDin.get(i).getPotenciaAtaque() > heroisDin.get(i).getResist()) {
                        potenciaDano = (bestasDin.get(i).getPotenciaAtaque() - heroisDin.get(i).getResist());
                        heroisDin.get(i).setHp(heroisDin.get(i).getHp() - potenciaDano);
                        System.out.println(bestasDin.get(i).getNome() + " saca " + bestasDin.get(i).getPotenciaAtaque() + " e tira " + potenciaDano + " de " + heroisDin.get(i).getNome());

                        if (heroisDin.get(i).getHp() <= 0) {

                            System.out.println("Morre o " + heroisDin.get(i).getClass().getSimpleName() + " " + heroisDin.get(i).getNome() + "!!");
                            heroisDin.remove(i);

                            if (heroisDin.size() == 0) {
                                break outer;
                            }

                            break;
                        }

                    } else {
                        System.out.println(bestasDin.get(i).getNome() + " saca " + bestasDin.get(i).getPotenciaAtaque() + " e tira " + 0 + " de " + heroisDin.get(i).getNome());
                    }

                    heroisDin.get(i).setResist(armaduraRestaurada);
                    //System.out.println("Armadura do " + heroisDin.get(i).getNome() + " restaurada para " + heroisDin.get(i).getResist());
                }
            }

            if (heroisDin.size() != 0) {
                System.out.println(" ");
                System.out.println("......................");
                System.out.println("OS HEROIS GANHARAM!!");
                System.out.println("......................");
            } else {
                System.out.println(" ");
                System.out.println("......................");
                System.out.println("AS BESTAS GANHARAM!!");
                System.out.println("......................");
            }

        }


    }
}

