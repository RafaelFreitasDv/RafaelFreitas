#solicitando os dados do aluno
email_aluno = input("Digite o seu e-mail")
nota_aluno = input("Digite a sua nota")
nota_aluno = float(nota_aluno)
if nota_aluno > 8.5:
    print("ENVIANDO E-MAIL PARA {}".format(email_aluno))
elif nota_aluno <= 8.5:
    print("Você não está apto")
