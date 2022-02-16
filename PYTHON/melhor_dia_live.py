print("Melhor dia da semana para lives")
segunda = float(input("Informe o número de votos para realização da live na segunda-feira: "))
terca = float(input("Informe o número de votos para realização da live na terça-feira: "))
quarta = float(input("Informe o número de votos para realização da live na quarta-feira: "))
quinta = float(input("Informe o número de votos para realização da live na quinta-feira: "))
sexta = float(input("Informe o número de votos para realização da live na sexta-feira: "))
melhor_dia = max(segunda,terca,quarta,quinta,sexta)

if segunda== max(segunda,terca,quarta,quinta,sexta):
    print("Segunda-feira é o melhor dia com {} votos".format(melhor_dia))
elif terca== max(segunda, terca, quarta, quinta, sexta):
    print("Terça-feira é o melhor dia com {} votos".format(melhor_dia))
elif quarta== max(segunda, terca, quarta, quinta, sexta):
    print("Quarta-feira é o melhor dia com {} votos".format(melhor_dia))
elif quinta== max(segunda, terca, quarta, quinta, sexta):
    print("Quinta-feira é o melhor dia com {} votos".format(melhor_dia))
elif sexta== max(segunda, terca, quarta, quinta, sexta):
    print("Sexta-feira é o melhor dia com {} votos".format(melhor_dia))






