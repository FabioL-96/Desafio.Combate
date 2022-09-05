package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Champion;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite os dados do primeiro campeão:");

		System.out.print("Nome: ");
		String name = sc.nextLine();
		System.out.print("Vida inicial: ");
		int life = sc.nextInt();
		System.out.print("Ataque: ");
		int attack = sc.nextInt();
		System.out.print("Armadura: ");
		int armor = sc.nextInt();

		Champion player1 = new Champion(name, life, attack, armor);

		System.out.println();
		System.out.println("Digite os dados do segundo campeão:");

		System.out.print("Nome: ");
		sc.nextLine();
		name = sc.nextLine();
		System.out.print("Vida inicial: ");
		life = sc.nextInt();
		System.out.print("Ataque: ");
		attack = sc.nextInt();
		System.out.print("Armadura: ");
		armor = sc.nextInt();

		Champion player2 = new Champion(name, life, attack, armor);

		System.out.println();
		System.out.print("Quantos turnos você deseja executar? ");
		int round = sc.nextInt();

		for (int i = 0; i < round; i++) {

			System.out.println();
			System.out.println("Resultado do turno " + (i + 1) + ":");

			player1.takeDamage(player2);
			player2.takeDamage(player1);

			System.out.println(player1.status());
			System.out.println(player2.status());

			if (player1.getLife() <= 0 || player2.getLife() <= 0) {
				System.out.println();
				System.out.println("FIM DO COMBATE");
				break;
			}

			if (i == round - 1) {
				System.out.println();
				System.out.println("FIM DO COMBATE");
			}
		}

		sc.close();
	}

}
