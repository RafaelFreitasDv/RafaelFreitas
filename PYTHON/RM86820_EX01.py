#CONTROLE DE CALORIAS

op = -1
caloria_total = 0.0

while op != 2:
    print("Adicionar um alimento à lista?")
    print("1 - Sim")
    print("2 - Não")

    op = int(input("Informe sua opção: "))

    if op == 1:

        nome_alimento = input("Informe o nome do alimento: ")
        caloria_atual = float(input("Informe a quantidade de calorias do alimento: "))
        caloria_total = caloria_atual + caloria_total

    elif op == 2:
        print("Você ingeriu um total de {} calorias hoje!".format(caloria_total))

