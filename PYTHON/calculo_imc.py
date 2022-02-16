# Cálculo do IMC
nome = input("Informe seu nome completo")
peso = float(input("Informe o seu peso: "))
altura = float(input("Informe a sua altura em metros: "))
imc = peso / (altura * altura)
print(nome)
print("Seu IMC é: {:.2f}".format(imc))
if imc < 16:
    print("Baixo peso grau III")
elif imc < 16.99:
    print("Baixo peso Grau II")
elif imc < 18.49:
    print("Baixo peso grau I")
elif imc < 24.99:
    print("Peso ideal")
elif imc < 29.99:
    print("Sobrepeso")
elif imc < 34.99:
    print("Obesidade Grau I")
elif imc < 39.99:
    print("Obesidade Grau II")
elif imc > 40:
    print("Obesidade Grau III")
