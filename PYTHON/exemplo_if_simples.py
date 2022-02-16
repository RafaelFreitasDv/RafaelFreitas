rm = input("Insira seu RM ")
idade = input("Insira a sua idade ")
if int(idade) >= 18:
    print("Sua participação foi autorizada, aluno de RM {}!".format(rm))
    print("Mais informações serão enviadas para o seu e-mail cadastrado!")
else:
    autorizado = input("Você possui autorização dos reponsáveis para participar? S-SIM ou N-NÃO")
    if autorizado == 'S':
        print("Sua participação foi autorizada, aluno de RM{}".format(rm))
        print("Mais informações serão enviadas para o e-mail dos resposáveis!")
    else:
        print("sua participação não foi autorizada por causa de sua idade")
