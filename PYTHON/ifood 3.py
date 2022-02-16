

Kibon = dict()
Kibon = {4.9, 6.99}

Makis = dict()
Makis = {4.7, 7.99}

Sukiya = dict()
Sukiya = {4.6, 7.99}

Ranking = [Kibon, Makis, Sukiya]

for avaliacao,frete in Ranking:
    if avaliacao <= 5 and frete >= 1:
        print("avaliação {} frete {}".format(avaliacao, frete))

#Obervação do exercício: Tive dificuldados em conseguir colocar o nome do Restaurante na frente do print


