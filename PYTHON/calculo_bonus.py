# Cálculo de bônus
ano_faturamento = float(input("informe o seu faturamento anual: "))
print("Informe o seu plano: ")
tipo_assinatura = int(input("1 - Basic / 2 - Silver / 3 - Gold / 4 - Platinum: "))

# Basic 30%
if ano_faturamento > 1 and tipo_assinatura==1:
    bonus = ano_faturamento * 0.3
    print("O valor a pagar é de: R$ {}".format(bonus))
# Silver 20%
elif ano_faturamento > 1 and tipo_assinatura==2:
    bonus = ano_faturamento * 0.2
    print("O valor a pagar é de: R$ {}".format(bonus))
# Gold 10%
elif ano_faturamento > 1 and tipo_assinatura==3:
    bonus = ano_faturamento * 0.1
    print("O valor a pagar é de: R$ {}".format(bonus))
# PLatinum 5%
elif ano_faturamento > 1 and tipo_assinatura ==4:
    bonus = ano_faturamento * 0.05
    print("O valor a pagar é de: R$ {}".format(bonus))

