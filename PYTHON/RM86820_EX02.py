#Valores de Transação
transacao_dia = int(input("Digite quantas transações você realizou hoje: "))
transacao_total = 0.0

for x in range(1, transacao_dia + 1):
    transacao_atual = float(input("Informe o valor da transação: "))
    transacao_total = transacao_total + transacao_atual

media = transacao_total/transacao_dia

print("O valor total gasto foi de R$ {}".format(transacao_total))
print("O valor médio de transações é de {}".format(media))
