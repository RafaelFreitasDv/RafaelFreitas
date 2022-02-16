#solicitando os dados do cliente
valor_compra = input("informe o valor da compra realizada ")
cupom = input("informe o cupom de desconto ")
#realizando teste lógico
if cupom.upper() == "NIVER10":
    #CÁLCULO DE 10% DE DESCONTO
    valor_final = float(valor_compra) * 0.9
else:
    valor_final = float(valor_compra)
    print("CUPOM INVÁLIDO")
print("O valor final da compra =e {}".format(valor_final))

