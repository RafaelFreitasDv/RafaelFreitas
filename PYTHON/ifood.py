d = {}
d["kibon_sorveteria"] = [4.9, 6.99]
d["sukiya"] = [4.6, 7.99]
d["a_feijoada"] = [4.4, 9,90]
d["makis_place"] = [4.7, 7,99]
d["giraffas"] = [4.4, 5.99]
d["Viena"] = [4.4, 12.49]


def ranking():
    ranking_final = {}
    for avaliacao, frete in d:
        resultado = max(avaliacao) and min(frete)


