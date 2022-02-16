anterior = 0
proxima = 1
soma = 1
n = int(input("Digite um número que esteja dentro da sequência Fibonacci: "))

while proxima < n:
    soma = proxima + anterior
    anterior = proxima
    proxima = soma
if proxima == n:
    print("Ação bem sucedida")
else:
    print("A ação falhou")