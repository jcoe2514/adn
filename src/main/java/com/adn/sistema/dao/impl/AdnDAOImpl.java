package com.adn.sistema.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adn.sistema.dao.AdnDAO;
import com.adn.sistema.entity.Adn;
import com.adn.sistema.repository.AdnRepository;

@Repository
public class AdnDAOImpl implements AdnDAO {

	@Autowired
	private AdnRepository adnRepository;
	boolean isMutation = false;

	@Override
	public void save(Adn adn) {
		char[][] matrix = this.loadMatrix(adn.getAdnOrigin());
		adn.setLastAdn(matrix);
		adn.setMutation(isMutation);
		adnRepository.save(adn);

	}

	@Override
	public boolean validateMutation(Adn adn) {
		char[][] matrix = this.loadMatrix(adn.getAdnOrigin());
		contar(matrix);
		char[][] matrixRotate = this.rotateMatrix(matrix);
		contar(matrixRotate);
		recordDiagonalUp(matrix);
		recordDiagonalDown(matrix);
		this.save(adn);

		return isMutation;
	}

	private char[][] loadMatrix(String[] adn) {
		char[][] matrix = new char[adn.length][adn[0].length()];

		for (int i = 0; i < adn.length; i++) {
			for (int j = 0; j < adn.length; j++) {
				matrix[i][j] = adn[i].charAt(j);
				System.out.print(matrix[i][j]);

				if (j == adn.length - 1) {
					System.out.println();
				}
			}
		}
		return matrix;
	}

	private char[][] contar(char[][] matrix) {
		int contador = 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (j > 0) {
					if (matrix[i][j - 1] == (matrix[i][j])) {
						contador++;
						if (contador == 4) {
							isMutation = true;
						}

					} else {
						contador = 1;
					}
				}
			}

		}
		return matrix;
	}

	private char[][] rotateMatrix(char[][] matrix) {
		int tamanho = matrix.length;
		char[][] novaMatrix = new char[tamanho][matrix[0].length];

		for (int i = 0, j = tamanho - 1; i < tamanho && j >= 0; i++, j--) {
			for (int k = 0; k < tamanho; k++) {
				novaMatrix[k][j] = matrix[i][k];
				System.out.print(matrix[k][j]);

				if (k == matrix.length - 1) {
					System.out.println();
				}
			}
		}
		return novaMatrix;
	}

	private char[][] recordDiagonalUp(char[][] matrix) {
		char[] aux = new char[matrix.length];
		int index = 2;
		int countX = index;
		int countY = 0;
		int count = 1;
		int position = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				aux[position] = matrix[countY][countX];
				System.out.println(aux[position]);
				if (position > 0) {
					if (aux[position - 1] == matrix[countY][countX]) {
						count++;
						if (count == 4)
							isMutation = true;

					} else {
						count = 1;
					}

				}
				position++;
				countY++;
				countX++;
				if (countX == matrix.length) {
					position = countY = 0;
					count = 1;
					countX = index - i - 1;
					if (countX < 0) {
						countY = Math.abs(countX);
						countX = j - index;

					}
				}
				if (i >= 3 && (countY > countX) & j == 1) {
					countX = 0;
					countY = i - 1;
					position = 0;

				}

				if (matrix.length - (i + 1) == 2)
					break;

			}
			if (matrix.length - (i + 1) == 2)
				break;

		}
		return matrix;
	}

	private char[][] recordDiagonalDown(char[][] matrix) {
		char[] aux = new char[matrix.length];
		int index = 3;
		int countX = index;
		int countY = 0;
		int count = 1;
		int position = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				aux[position] = matrix[countY][countX];
				System.out.println(aux[position]);
				if (position > 0) {
					if (aux[position - 1] == matrix[countY][countX]) {
						count++;
						if (count == 4)
							isMutation = true;

					} else {
						count = 1;
					}

				}
				position++;
				countY++;
				countX--;
				if (countX < 0) {
					position = 0;
					countY = 0;
					count = 1;
					countX = index + i + 1;
					if (countX == matrix.length) {
						countY = 1;
						countX = matrix.length - 1;

					}

				}
				if (countY == matrix.length && countX == 0) {
					countY = index - 1;
					countX = matrix.length - 1;
					position = 0;
				}
				if (i >= 4 && (countY > countX) & j == 0) {
					countX = i - 1;
					countY = index - 1;
					position = 0;

				}

				if ((matrix.length - 1) - i == 2)
					break;

			}
			if ((matrix.length - 1) - i == 2)
				break;

		}
		return matrix;
	}

//	public String[][] recordDiagonal(String[][] matrix) {
//
//		int contador = 1;
//		int contadorSecond = 1;
//		String[] diagonalPrincipal = new String[matrix.length];
//		String[] diagoSecundaria = new String[matrix.length];
//		for (int i = 0; i < matrix.length; i++) {
//			for (int j = 0; j < matrix[i].length; j++) {
//				if (i == j) {
//					diagonalPrincipal[i] = matrix[i][j];
//					contador++;
//					if (diagonalPrincipal[i - j].equals(diagonalPrincipal[i])) {
//						if (contador == 4) {
//							System.out.println("mutacion PRIMERA DIAGONAL");
//						}
//					} else {
//						contador = 1;
//					}
//				}
//
//				if (i + j == matrix.length - 1) {
//					diagoSecundaria[i] = matrix[i][j];
//					contadorSecond++;
//					System.out.print(diagoSecundaria[i]);
//					if (contadorSecond == 4) {
//						System.out.println("mutacion");
//					}
//				} else {
//					contadorSecond = 1;
//				}
//			}
//			System.out.println();
//		}
//
//		return matrix;
//
//	}

//	public String[][] recordDiagonalInferior(String[][] matrix) {
//
//		for (int i = 0; i < matrix.length; i++) {
//			for (int j = 0; j <= i; j++) {
//				System.out.print("posicion i - j:" + (i - j) + " Posicion j: " + j + " ");
//				System.out.print(matrix[matrix.length - j - 1][j + i + 1]);
//			}
//			System.out.println();
//		}
//
//		return matrix;
//
//	}

}
