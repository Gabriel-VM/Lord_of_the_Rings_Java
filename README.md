# Java_Projects

Objetivo e especificações do projeto
 
O programa conta com  várias classes que permitem a implementação de um jogo simples baseado na história fantástica do livro do Senhor dos Anéis. 

Existem diversas personagens, classificadas em duas categorias: Heróis e Bestas. 
Na parte dos heróis, são três tipos: Elfos, Hobbits e Humanos, enquanto na parte das bestas há Orques e Trolls. 

O objetivo do projeto é a criação de dois exércitos de personagens, um de heróis e outro de bestas, que se enfrentam mutuamente, mediante um sistema de turnos, até que um deles consiga a vitória. 
Para isso, cada personagem está caracterizada por um nome, pontos de vida e um nível de resistência da sua armadura. 
Em cada turno, uma personagem ataca um adversário, tendo em conta as seguintes peculiaridades: 

Heróis: o seu ataque está baseado no lançamento de dois dados com valores entre 0 e 100, o valor maior será o do ataque, que irá determinar a potência ofensiva do ataque no turno atual. 

Bestas: a potência do seu ataque em cada turno está baseada no lançamento de um único dado com valores entre 0 e 90. 

Uma vez calculada a potência ofensiva, calcula-se o dano feito ao adversário em função do seu nível de armadura. 
Apenas haverá dano ao adversário se a potência ofensiva do atacante for superior ao nível de armadura do defensor. 
Quando isso ocorre, o dano produzido é a diferença entre a potência de ataque e o nível de armadura do oponente. 
Além disso, em cada ataque entram em cena os seguintes supostos particulares de cada tipo de personagem: 

Elfos: odeiam principalmente os Orques, então terão um nível de raiva superior no seu ataque unicamente contra eles, o que aumenta a potência ofensiva do elfo, calculada no lançamento de dados, em 10 unidades. 

Hobbits: têm um medo especial dos Trolls, então perdem 5 unidades na sua potência ofensiva sempre que enfrentam um deles. 

Orques: possuem uma força desmedida e sempre que realizam um ataque o nível de armadura que possui o seu oponente é reduzido em 10% (o nível de armadura não se reduz de forma permanente, mas apenas para o turno atual). 

Processo de batalha:

 O sistema é baseado em turnos, em que cada personagem de um exército ataca um único adversário do exército oponente.
 Enfrentam-se sempre as personagens situadas na mesma posição de cada exército.
 Se algum dos exércitos dispõe de mais efetivos que o contrário, as restantes personagens não participam nesse turno de batalha. 
 Em cada turno acontecem todos os confrontos e diminui a vida de cada personagem, segundo as instruções mencionadas anteriormente. 
 No momento em que uma personagem chega a um nível de vida igual ou inferior a zero, acontece a sua morte e é eliminada da sua posição, deslocando-se todos os seus companheiros em posições posteriores para cobrir a baixa. 
 Dessa forma, alguma das personagens inativas pode participar na batalha nos seguintes turnos.

O exército que derrotar todas as personagens adversárias vence o jogo!
