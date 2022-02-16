valor_compra = float(input("Digite o valor de compra"))
forma_pagamento = int(input("1 - Dinheiro / 2 - Cartão"))

if valor_compra > 100 or forma_pagamento==1:
    valor_compra = valor_compra * 0.9
    print("Você tem direito a um desconto!")

print("o valor a pagar é {}".format(valor_compra))