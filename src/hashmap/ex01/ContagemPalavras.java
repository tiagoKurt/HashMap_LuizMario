package hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContagemPalavras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma frase:");
        String frase = scanner.nextLine();
        scanner.close();

        Map<String, Integer> contagem = new HashMap<>();

        String[] palavras = frase.split("\\s+"); // Divide a frase em palavras, considerando espaços em branco como separadores

        for (String palavra : palavras) {
            // Verifica se a palavra já está no mapa
            if (contagem.containsKey(palavra)) {
                // Se estiver, incrementa o contador
                int contador = contagem.get(palavra);
                contagem.put(palavra, contador + 1);
            } else {
                // Se não estiver, adiciona a palavra ao mapa com contador 1
                contagem.put(palavra, 1);
            }
        }

        // Imprime o resultado
        for (Map.Entry<String, Integer> entrada : contagem.entrySet()) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue());
        }
    }
}






