package com.adn.sistema.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adn.sistema.dao.AdnDAO;
import com.adn.sistema.entity.Adn;
import com.adn.sistema.entity.CountMutation;
import com.adn.sistema.repository.AdnRepository;
import com.adn.sistema.repository.CountMutationRepository;

@Repository
public class AdnDAOImpl implements AdnDAO {

	int countMutation = 0;
	int countNoMutation = 0;

	@Autowired
	private AdnRepository adnRepository;
	@Autowired
	private CountMutationRepository countMutationRepository;
	boolean isMutation = false;

	@Override
	public void save(Adn adn) {
		char[][] matrix = this.loadMatrix(adn.getAdnOrigin());
		adn.setLastAdn(matrix);
		adn.setMutation(isMutation);
		adnRepository.save(adn);
		CountMutation mutation = new CountMutation();
		mutation.setCountMutations(countMutation);
		mutation.setCountNoMutation(countNoMutation);
		Double ratio = (double) (countMutation/ countNoMutation);
		mutation.setRatio(ratio);
		countMutationRepository.save(mutation);

	}

	@Override
	public boolean validateMutation(Adn adn) {
		char[][] matrix = this.loadMatrix(adn.getAdnOrigin());
		contar(matrix);
		char[][] matrixRotate = this.rotateMatrix(matrix);
		contar(matrixRotate);
		rotateMatrixOblicua1(matrix);
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
							countMutation++;
							isMutation = true;
						}

					} else {
						countNoMutation++;
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
			}
		}
		return novaMatrix;
	}

	private char[][] rotateMatrixOblicua1(char[][] matrix) {
		int tamanho = matrix.length + matrix[0].length - 1;
		char[][] matrixRotate = new char[tamanho][matrix[0].length];
		char[] aux = null;
		System.out.println("length matriz:: " + matrixRotate.length);
		int index = 0;
		int count = 1;
		;
		for (int i = 0, m = 0, j = 0; i < tamanho; i++, m++, j++) {
			if (i >= matrix.length) {
				index = index - 2;
			}
			aux = new char[index + 1];
			if (i == tamanho - 1)
				break;
			for (int k = 0, l = 0, n = 0; k <= index || n <= index; k++, l++, n++) {
				if (i >= matrix.length) {
					j = i;
					k = i - matrix.length + n;
					k++;
					l = i - matrix.length;

				}

				matrixRotate[m][l] = matrix[j - k][k];
				aux[n] = matrixRotate[m][l];
				if (n > 0) {
					if (aux[n - 1] == aux[n]) {
						if (count == 4) {
							countMutation++;
						}
						count++;
					} else {
						countNoMutation++;
						count = 1;
					}

				}

				if (n == index) {
					System.out.println();
				}

			}
			index++;
		}
		return matrixRotate;

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
							countMutation++;
							isMutation = true;

					} else {
						countNoMutation++;
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

	@Override
	public CountMutation findById(Integer id) {
		
		return this.countMutationRepository.findFirstById(id);
	}

}
