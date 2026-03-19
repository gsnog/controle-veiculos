# 🚗 API de Controle de Frota (Filtros Avançados)

O terceiro e mais complexo desafio da trilha. O foco aqui foi a implementação de **Query Parameters** e filtros dinâmicos em coleções, simulando um sistema de locadora de veículos.

## 🛠️ Endpoints e Filtros

| Método | Endpoint | Parâmetro | Descrição |
| :--- | :--- | :--- | :--- |
| **GET** | `/veiculos` | `?marca=X` | Lista todos ou filtra por marca específica. |
| **GET** | `/veiculos/ano/{ano}` | Path Variable | Retorna veículos do ano X em diante. |
| **POST** | `/veiculos` | Body | Cadastra um novo veículo na frota. |
| **PUT** | `/veiculos/{id}` | Path + Body | Atualiza placa ou valor da diária. |

## 🧠 Aprendizados
- Implementação de `@RequestParam` para filtros opcionais.
- Padronização de objetos para sistemas de inventário de ativos.
