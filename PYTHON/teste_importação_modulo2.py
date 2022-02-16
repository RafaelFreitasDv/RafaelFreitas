#importação de funções específica do módulo calc.py
#para impantar todas as funções, utilizar "*"
from calc import somar, subtrair
#solicitando valores ao usuário
valor1 = input("Digite um valor: ")
valor2 = input("Digite outro valor: ")
#armazenando a soma
soma = somar(valor1, valor2)
#exibindo a soma
print("A soma é {}".format(soma))