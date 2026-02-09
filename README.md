# 📊 Sistema de Leitura de CSV e Geração de Relatório – Java

Projeto desenvolvido em **Java puro** com o objetivo de simular a leitura de dados em formato CSV, processar as informações e gerar um **relatório operacional com indicadores (KPIs)**.

O sistema foi pensado para demonstrar lógica de programação, boas práticas de organização de código e conceitos de **Programação Orientada a Objetos (POO)**, mesmo em um ambiente simples (arquivo único).

---

## 🎯 Funcionalidades

- Leitura de dados simulados em formato CSV
- Conversão e tratamento de dados
- Filtro de registros por **período (datas)**
- Geração de KPIs:
  - Total de registros
  - Valor total
  - Valor médio
  - Maior e menor valor
- Detalhamento completo das operações
- **Agrupamento por tipo de operação** (ex: Abastecimento, Frete, Manutenção)
- Formatação monetária no padrão brasileiro (R$)

---

## 🛠️ Tecnologias e Conceitos Utilizados

- Java (Java SE)
- Programação Orientada a Objetos (POO)
- Collections (`List`, `Map`)
- `LocalDate` e `DateTimeFormatter`
- Regras de negócio
- Organização e separação de responsabilidades
- Simulação de leitura de CSV

---

## ▶️ Exemplo de Saída

```text
===== RELATÓRIO OPERACIONAL =====
Total de registros: 3
Valor total: R$ 3.501,25
Valor médio: R$ 1.167,08
Maior valor: R$ 1.500,50
Menor valor: R$ 800,00

Detalhamento:
2024-01-05 | Abastecimento | R$ 1.500,50
2024-01-10 | Manutencao | R$ 800,00
2024-01-15 | Frete | R$ 1.200,75

Resumo por tipo:
Frete: R$ 1.200,75
Manutencao: R$ 800,00
Abastecimento: R$ 1.500,50

---

👤 Autor

Projeto desenvolvido por João Victor
🔗 GitHub: [perfil](https://github.com/joaodddev)
🔗 LinkedIn: [perfil](https://www.linkedin.com/in/joao-victor-macedo-neves/)
