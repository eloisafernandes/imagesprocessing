# 🧵 Images Processing Concurrent

## 📘 Descrição

O programa realiza o download e o processamento de imagens concorrentemente, utilizando threads em Java para gerenciar múltiplas tarefas ao mesmo tempo.

O programa:
1. Gera automaticamente um arquivo `imagesUrls.txt` contendo várias URLs de imagens.
2. Faz o **download** de todas as imagens a partir dessas URLs.
3. Após o download, converte todas as imagens para **tons de cinza (grayscale)** — também de forma concorrente.
4. Exibe o tempo total de processamento.

## ⚙️ Requisitos

- **Java 11** ou superior  
- Conexão com a Internet (as imagens são baixadas da API [Picsum Photos](https://picsum.photos/))

---

## 🚀 Execução

### 1. Compilar o código

No diretório raiz do projeto (`imagesprocessing/`), execute:

```bash
javac src/src/*.java
```
e para executar o programa
```bash
java -cp src src.Main
```
