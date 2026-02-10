# 📊 Sistema de Leitura de CSV e Geração de Relatório Operacional – Java

Projeto desenvolvido em **Java puro** com o objetivo de simular a leitura de dados em formato CSV, processar as informações e gerar um **relatório operacional com indicadores (KPIs)**, exibido no terminal **e exportado para arquivo `.txt`**.

O sistema foi construído com foco em **Programação Orientada a Objetos (POO)**, organização de código e regras de negócio, utilizando uma estrutura profissional de pastas no VS Code.

---

## 🎯 Funcionalidades

- Leitura de dados simulados em formato CSV
- Conversão e tratamento de dados
- **Filtro de registros por período (datas)**
- Geração de KPIs operacionais:
  - Total de registros
  - Valor total
  - Valor médio
  - Maior e menor valor
- Detalhamento completo das operações
- **Agrupamento por tipo de operação** (ex: Abastecimento, Frete, Manutenção)
- Formatação monetária no padrão brasileiro (R$)
- **Exportação do relatório para arquivo `.txt`**
- Exibição do relatório no terminal

---

## 🗂️ Estrutura do Projeto
sistema-relatorio-csv-java
├── src
│ ├── Main.java
│ ├── model
│ │ └── Registro.java
│ ├── service
│ │ └── RelatorioService.java
│ └── util
│ ├── CsvReader.java
│ └── ArquivoUtil.java
├── relatorio.txt
└── README.md

---

## 🛠️ Tecnologias e Conceitos Utilizados

- Java (Java SE)
- Programação Orientada a Objetos (POO)
- Collections (`List`, `Map`)
- `LocalDate` e `DateTimeFormatter`
- Regras de negócio
- Separação de responsabilidades (`model`, `service`, `util`)
- Manipulação de strings e dados
- Escrita de arquivos (`FileWriter`)
- Formatação monetária com `DecimalFormat`

---

## ▶️ Exemplo de Saída no Terminal
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

## 📄 Exportação do Relatório

Além da exibição no terminal, o sistema gera automaticamente um arquivo:
relatorio.txt

Esse arquivo contém exatamente o mesmo conteúdo exibido no console, simulando um cenário real de geração de relatórios operacionais.

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
- Java JDK 17 ou superior
- VS Code (ou outra IDE Java)

### Execução
1. Clone o repositório
2. Abra a pasta no VS Code
3. Execute o arquivo `Main.java`

Ou via terminal:
```bash
javac src/**/*.java
java -cp src Main```
