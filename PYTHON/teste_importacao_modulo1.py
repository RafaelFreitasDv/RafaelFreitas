#importação do módulo calc.py
import calc
#solicitando valores do usuário
valor1 = input("Digite um valor: ")
valor2 = input("Digite outro valor: ")

soma = calc.somar(valor1, valor2)

print("A soma é {}".format(soma))