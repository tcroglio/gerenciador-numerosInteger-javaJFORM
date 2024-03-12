package br.ulbra.entity;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 * @author www.tiagoroglio.com.br
 */
public class Numero {

    public ArrayList<Integer> numerosAL;

    public Numero() {
        numerosAL = new ArrayList();
    }

    // MÉTODO PARA ADICIONAR NÚMERO NO ARRAY
    public void adicionar(int numero) {
        numerosAL.add(numero);
    }

    /* MÉTODO PARA ADICIONAR NÚMEROS NA LISTA
            Este método altera a lista. Adiciona um novo número, inserido no campo 
            de nome (edAddNome) e ao clicar no botão de ADICIONAR (btnAdicionar).
     */
    public String listarNumeros() {
        String lista = "Lista de números: \n";

        if (!numerosAL.isEmpty()) { // verificando se o meu ArrayList não está vazio
            for (int i = 0; i < numerosAL.size(); i++) { // percorrendo todos as casas do meu array e adicionando o número novo na lista
                lista += "Cód " + (i + 1) + " - " + numerosAL.get(i) + "\n";
            }
        } else { // lista vazia, atribui mensagem de erro para minha lista
            lista = "A lista de números se encontra vazia";
        }

        // retorna a lista já editada
        return lista;
    }

    /* MÉTODO PARA ALTERAR UM NÚMERO POR CÓDIGO
            Este método altera a lista. Altera o número correspondente ao código inserido
            no campo código (edCodAlterar), para um novo número, inserido no campo Novo Número
           (edNovoNumero) e ao clicar no botão ALTERAR (btnAlterar).
     */
    public String alterar(int codigo, int novoNumero) { // método com parâmetros (os dois campos do formulário)
        String lista = "Lista de números: \n";

        if (!numerosAL.isEmpty()) { // verificando se o meu ArrayList não está vazio

            if ((codigo - 1) >= 0 && (codigo - 1) <= numerosAL.size()) { // verifica se o código inserido é um código válido e seta o novo número correspondente ao código 
                numerosAL.set((codigo - 1), novoNumero);
                JOptionPane.showMessageDialog(null, "Código " + codigo + " foi alterado com sucesso!");

            } else { // se cair aqui, é porque não encontrou o código que foi inserido
                JOptionPane.showMessageDialog(null, "Este código ainda não foi cadastrado");
            }

        } else { // lista vazia, atribui mensagem de erro para minha lista
            lista = "A lista de números se encontra vazia";
        }

        // retorna a lista já editada
        return lista;
    }

    /* MÉTODO PARA DELETAR E SOBREESCREVER NÚMERO DO CÓDIGO
            Este método SOBREESCREVE o número do ArrayList no que o código foi informado.
            Ao ativar este método, a casa do array é DELETADA e sobreescrita pelo próximo número,
            removendo um dos itens da lista e diminuindo 1 no valor total dos códigos
     */
    public String deletar(int codigo) {
        String lista = "Lista de números: \n";

        if (!numerosAL.isEmpty()) { // verificando se o meu array não está vazio
            if ((codigo - 1) >= 0 && (codigo - 1) <= numerosAL.size()) { // verifica se o código inserido é um código válido e remove o número referente ao código informado
                numerosAL.remove(codigo - 1);
                JOptionPane.showMessageDialog(null, "Código " + codigo + " foi deletado com sucesso!");

            } else { // se cair aqui, é porque não encontrou o código que foi inserido
                JOptionPane.showMessageDialog(null, "Este código ainda não foi cadastrado");
            }
        } else { // lista vazia, atribui mensagem de erro para minha lista
            lista = "A lista de números se encontra vazia";
        }

        // retorna a lista já editada
        return lista;
    }

    /* MÉTODO PARA BUSCAR POR CÓDIGO
            Este método realiza uma busca no ArrayList. Ao inserir o código de um número,
            ele busca o número que está nessa posição de acordo com o índice e retorna o valor
            inserido neste local do ArrayList.
     */
    public void buscar(int codigo) {
        int buscar = 0;

        if (!numerosAL.isEmpty()) { // verificando se o meu array não está vazio
            if ((codigo - 1) >= 0 && (codigo - 1) <= numerosAL.size()) { // verifica se o código inserido é um código válido
                buscar = numerosAL.get(codigo - 1);
                JOptionPane.showMessageDialog(null, "Busca por código: \nO número presente no código " + codigo + " é: " + buscar);

            } else { // se cair aqui, é porque não encontrou o código que foi inserido
                JOptionPane.showMessageDialog(null, "Este código ainda não foi cadastrado");
            }
        }
    }

    /* MÉTODO PARA LISTAR ÍMPARES
        Este método instancia uma String "listaImpares" e atribui à ela o ArrayList, porém apenas
        seus números ímpares.
        Em seguida, printa na tela para o usuário utilizando o "return.
     */
    public String listarNumerosImpares() {
        String listaImpares = "Lista de números ímpares: \n"; // atribuindo a variável lista

        if (!numerosAL.isEmpty()) { // verificando se o meu array não está vazio
            for (int i = 0; i < numerosAL.size(); i++) { // percorrendo todos as "casas" do meu array
                if (numerosAL.get(i) % 2 != 0) {
                    listaImpares += "Cód " + (i + 1) + " - " + numerosAL.get(i) + "\n";
                }
            }
        } else { // lista vazia, atribui mensagem para minha lista
            listaImpares = "A lista de números se encontra vazia";
        }

        return listaImpares;
    }

    /* MÉTODO PARA LISTAR PARES
        Este método instancia uma String "listarPares" e atribui à ela o ArrayList, porém apenas
        seus números pares.
        Em seguida, printa na tela para o usuário utilizando o "return.
     */
    public String listarNumerosPares() {
        String listaPares = "Lista de números ímpares: \n"; // atribuindo a variável lista

        if (!numerosAL.isEmpty()) { // verificando se o meu array não está vazio
            for (int i = 0; i < numerosAL.size(); i++) { // percorrendo todos as "casas" do meu array
                if (numerosAL.get(i) % 2 == 0) {
                    listaPares += "Cód " + (i + 1) + " - " + numerosAL.get(i) + "\n";
                }
            }
        } else { // lista vazia, atribui mensagem para minha lista
            listaPares = "A lista de números se encontra vazia";
        }

        return listaPares;
    }

    /* MÉTODO PARA EXIBIR MÉDIA
        Este método cria uma variável acumuladora que percorre o ArrayList recolhendo e somando
        todos os números deste ArrayList, salvando em um total (media). Após recolher todos estes
        números, ele divide pelo número de itens no ArrayList (i).
     */
    public void exibirMedia() {
        int media = 0, total = 0;

        if (!numerosAL.isEmpty()) { // verificando se o meu array não está vazio
            for (int i = 0; i < numerosAL.size(); i++) { // percorrendo todos as "casas" do meu array
                total += numerosAL.get(i);
            }
            media = total / numerosAL.size();
            JOptionPane.showMessageDialog(null, "Média dos números: " + media);
        } else {
            JOptionPane.showMessageDialog(null, "A lista de números se encontra vazia");
        }
    }

    /* MÉTODO PARA LISTAR EM ORDEM DECRESCENTE 
            Este método cria um novo ArrayList idêntico ao original digitado pelo usuário
            e em seguida ordena o ArrayList de "backup", ALTERANDO o ArrayList. Foi criado um
            novo ArrayList, para que o ArrayList original, digitada pelo usuário, não seja perdido.    
     */
    public String ordenarListaCrescente() {
        ArrayList<Integer> backupPAlterar = new ArrayList();
        String lista = "Lista de números: \n"; // atribuindo a variável lista

        if (!numerosAL.isEmpty()) { // verificando se o meu array não está vazio
            for (int i = 0; i < numerosAL.size(); i++) { // percorrendo todos as casas do meu array
                backupPAlterar.add(numerosAL.get(i)); // fazendo a cópia do meu array
            }

            Collections.sort(backupPAlterar); // ordenando meu array copiado

            for (int i = 0; i < backupPAlterar.size(); i++) { // percorrendo todos as "casas" do meu array
                lista += "Cód " + (i + 1) + " - " + backupPAlterar.get(i) + "\n"; // atribui minha nova lista ordenada 
            }

        } else { // lista vazia, atribui mensagem para minha lista
            lista = "A lista de números se encontra vazia"; // atribui mensagem vazia
        }

        return lista; // retorna minha lista ordenada OU minha lista com mensagem vazia
    }

    /* MÉTODO PARA LISTAR EM ORDEM DECRESCENTE -> 
            Este método cria um novo ArrayList idêntico ao original digitado pelo usuário
            e em seguida ordena o ArrayList de "backup", ALTERANDO o ArrayList. Foi criado um
            novo ArrayList, para que o ArrayList original, digitada pelo usuário, não seja perdido.    
     */
    public String ordenarListaDescrescente() {
        ArrayList<Integer> backupPAlterar = new ArrayList(); // cria meu array novo para fazer backup
        String lista = "Lista de números: \n"; // atribuindo a variável lista

        if (!numerosAL.isEmpty()) { // verificando se o meu array não está vazio
            for (int i = 0; i < numerosAL.size(); i++) { // percorrendo todos as "casas" do meu array
                backupPAlterar.add(numerosAL.get(i)); // fazendo a cópia do meu array
            }

            Collections.sort(backupPAlterar, Collections.reverseOrder()); // ordenando meu array copiado

            for (int i = 0; i < backupPAlterar.size(); i++) { // percorrendo todos as "casas" do meu array
                lista += "Cód " + (i + 1) + " - " + backupPAlterar.get(i) + "\n"; // atribui minha nova lista ordenada 
            }

        } else {
            lista = "A lista de números se encontra vazia"; // atribui mensagem vazia
        }
        return lista; // retorna minha lista ordenada OU minha lista com mensagem vazia
    }

    /* MÉTODO PARA EXIBIR MAIOR NÚMERO
        Este método instancia uma variável (maiorNum) que de cara recebe a primeira posição do 
        ArrayList. Em seguida, ele compara a primeira posição com a segunda, depois com a terceira
        e assim por diante. Caso seja maior, ele guarda a informação, caso não seja maior, ele
        continua percorrendo o ArrayList até o final. No fim, chama um JOptionPane.showMessageDialog
        que imprime na tela o resultado.
     */
    public void exibirMaiorNumero() {
        int maiorNum = numerosAL.get(0);

        if (!numerosAL.isEmpty()) { // verificando se o meu array não está vazio
            for (int i = 0; i < numerosAL.size(); i++) {

                // aqui se for maior
                if (numerosAL.get(i) > maiorNum) {
                    maiorNum = numerosAL.get(i);
                }
            }
            JOptionPane.showMessageDialog(null, "MAIOR NÚMERO: \n\n" + maiorNum);
        }
    }

    /* MÉTODO PARA EXIBIR MENOR NÚMERO
        Este método instancia uma variável (menorNum) que de cara recebe a primeira posição do 
        ArrayList. Em seguida, ele compara a primeira posição com a segunda, depois com a terceira
        e assim por diante. Caso seja menor, ele guarda a informação, caso não seja menor, ele
        continua percorrendo o ArrayList até o final. No fim, chama um JOptionPane.showMessageDialog
        que imprime na tela o resultado.
     */
    public void exibirMenorNumero() {
        int menorNum = numerosAL.get(0);

        if (!numerosAL.isEmpty()) { // verificando se o meu array não está vazio
            for (int i = 0; i < numerosAL.size(); i++) {

                // aqui se for menor
                if (numerosAL.get(i) < menorNum) {
                    menorNum = numerosAL.get(i);
                }
            }
            JOptionPane.showMessageDialog(null, "MENOR NÚMERO: \n\n" + menorNum);
        }
    }

    /* MÉTODO PARA APAGAR A LISTA 
        Este método simplesmente varre todo o ArrayList, excluindo todo e qualquer dado 
        que já existiu nele algum dia.
        Após realizar isso, é possível adicionar novos itens à este ArrayList sem problemas.
     */
    public void apagarLista() {
        numerosAL.clear();
        JOptionPane.showMessageDialog(null, "Lista apagada com sucesso!");
    }
}
