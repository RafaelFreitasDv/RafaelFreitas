
op = -1

while op != 2:

    print("1 - Exibir ranking de restaurantes")
    print("2 - Sair do programa")
    op = int(input("Informe sua opção: "))

    if op == 1:
        # O que ocorrerá se a opção 1 for selecionada
        Kibon = dict()
        Kibon = {4.9, 6.99}

        Makis = dict()
        Makis = {4.7, 7.99}

        Sukiya = dict()
        Sukiya = {4.6, 7.99}

        Ranking = [Kibon, Makis, Sukiya]

        for avaliacao, frete in Ranking:
            if avaliacao <= 5 and frete >= 1:
                print("avaliação {} frete {}".format(avaliacao, frete))

    elif op == 2:
        print("Obrigado!")


print("Programa encerrado!")
# Obervação do exercício: Tive dificuldados em conseguir colocar o nome do Restaurante na frente do print. Então tirei esta parte do código.